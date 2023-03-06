/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.noname.da_java.controller;

import com.noname.config.Utils;
import com.noname.database.DBQuery;
import com.noname.database.Transaction;
import com.noname.model.Booking_detail;
import com.noname.model.Film;
import com.noname.model.Schedule;
import com.noname.model.Ticket;
import com.noname.model.User;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author phatv
 */
@Controller
public class PurchaseController {

    DBQuery dbq = new DBQuery();

    @RequestMapping(value = "/tickets")
    public String Tickets(@RequestParam(required = false) String film_id, @RequestParam(required = false) String date, Model model) {
        try {
            int fid = Integer.parseInt(film_id);
            Film f = dbq.GetFilm(fid);
            if (f == null) {
                return "redirect:/";
            }
            model.addAttribute("title", "Chọn lịch phim " + f.getName());
            model.addAttribute("film", f);
            model.addAttribute("categories", dbq.GetCategoriesByFilmId(fid));
            model.addAttribute("schedules", dbq.GetSchedulesByFilmIdByDate(fid, date));

            LocalDate today = LocalDate.now(ZoneId.of(Utils.TZ));
            List<String> dates = new ArrayList<>();
            for (LocalDate ele : today.datesUntil(today.plusWeeks(2)).toList()) {
                dates.add(ele.toString());
            }
            model.addAttribute("dates", dates);

            return "tickets";
        } catch (NumberFormatException ex) {
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/seats")
    public String Seats(@RequestParam(required = false) String id, Model model) {
        try {
            int sid = Integer.parseInt(id);
            Schedule s = dbq.GetSchedule(sid);
            if (s == null) {
                return "redirect:/";
            }
            Film f = dbq.GetFilm(s.getFilm_id());
            model.addAttribute("title", "Chọn vị trí ngồi phim " + f.getName());
            model.addAttribute("film", f);
            model.addAttribute("schedule", s);
            model.addAttribute("tickets", dbq.GetTickets());

            HashMap<String, String> booking_details = new HashMap<>();
            for (Booking_detail ele : dbq.GetBookingDetailsByScheduleId(sid)) {
                booking_details.put(ele.getSeat(), ele.getSeat());
            }
            model.addAttribute("booking_details", booking_details);

            return "seats";
        } catch (NumberFormatException ex) {
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/purchase")
    public String Purchase(@RequestParam(required = false) String schedule_id, @RequestParam(required = false) String seats, Model model) {
        try {
            int sid = Integer.parseInt(schedule_id);
            Schedule s = dbq.GetSchedule(sid);
            if (s == null) {
                return "redirect:/";
            }
            Film f = dbq.GetFilm(s.getFilm_id());
            model.addAttribute("title", "Thanh toán vé phim " + f.getName());
            model.addAttribute("film", f);
            model.addAttribute("schedule", s);

            List<Ticket> tickets = dbq.GetTickets();
            String[] listSeats = seats.split(",");
            List<Ticket> listSeat1 = new ArrayList<>();
            List<Ticket> listSeat2 = new ArrayList<>();
            List<Ticket> listSeat3 = new ArrayList<>();
            int total_price = 0;
            for (String ele : listSeats) {
                try {
                    String bin = Utils.DecToBin(Integer.parseInt(ele));
                    String row = "", col = "";
                    for (int i = bin.length() - 1; i >= 0; i--) {
                        if (i >= 7) {
                            col = bin.charAt(i) + col;
                        } else {
                            row = bin.charAt(i) + row;
                        }
                    }
                    int n_col = Utils.BinToDec(col);
                    char c_row = (char) Utils.BinToDec(row);
//                    System.out.println("seat: " + bin + " - " + row + n_col);
                    Ticket t = new Ticket();
                    t.setSeat(String.valueOf(c_row) + n_col);
                    if ('A' <= c_row && c_row <= 'D') {
                        total_price += tickets.get(0).getPrice();
                        listSeat1.add(t);
                    } else if ('E' <= c_row && c_row <= 'H') {
                        total_price += tickets.get(1).getPrice();
                        listSeat2.add(t);
                    } else if (c_row == 'J') {
                        t.setSeat(String.valueOf(c_row) + n_col + " " + String.valueOf(c_row) + (n_col + 1));
                        total_price += tickets.get(2).getPrice();
                        listSeat3.add(t);
                    }
                } catch (NumberFormatException ex) {
                }
            }
            model.addAttribute("tickets", tickets);
            model.addAttribute("seats1", listSeat1);
            model.addAttribute("seats2", listSeat2);
            model.addAttribute("seats3", listSeat3);
            model.addAttribute("total_price", String.format("%,d", total_price) + " đ");

            return "purchase";
        } catch (NumberFormatException ex) {
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/purchase", method = RequestMethod.POST)
    public String PurchaseProcess(HttpServletRequest req, HttpSession session, @RequestParam(required = false) String schedule_id, @RequestParam(required = false) String seats, Model model) {
        if (session.getAttribute("user") == null) {
            return "redirect:/sign-in?url=" + Utils.URLEncode(req.getRequestURL() + (req.getQueryString() != null ? "?" + req.getQueryString() : ""));
        }
        User user = (User) session.getAttribute("user");

        try {
            int sid = Integer.parseInt(schedule_id);
            Schedule s = dbq.GetSchedule(sid);
            if (s == null) {
                return "redirect:/";
            }

            HashMap<String, String> booking_details = new HashMap<>();
            for (Booking_detail ele : dbq.GetBookingDetailsByScheduleId(sid)) {
                booking_details.put(ele.getSeat(), ele.getSeat());
            }

            List<Ticket> tickets = dbq.GetTickets();
            String[] listSeats = seats.split(",");
            int total_price = 0;
            Transaction dbTrans = new Transaction();
            String msg = "Thất bại.";
            try {
                dbTrans.begin();
                LocalDate today = LocalDate.now(ZoneId.of(Utils.TZ));
                dbTrans.UpdatePstmt("INSERT INTO booking(user_id, schedule_id, total_price, created_at) VALUES(?, ?, ?, ?)", new String[]{String.valueOf(user.getId()), schedule_id, "0", today.toString()});
                int booking_id = dbTrans.GetIdByPstmt();
                if (booking_id == 0) {
                    throw new SQLException("Last inserted ID invalid.");
                }
                for (String ele : listSeats) {
                    try {
                        String bin = Utils.DecToBin(Integer.parseInt(ele));
                        String row = "", col = "";
                        for (int i = bin.length() - 1; i >= 0; i--) {
                            if (i >= 7) {
                                col = bin.charAt(i) + col;
                            } else {
                                row = bin.charAt(i) + row;
                            }
                        }
                        int n_col = Utils.BinToDec(col);
                        char c_row = (char) Utils.BinToDec(row);
//                    System.out.println("seat: " + bin + " - " + row + n_col);

                        Ticket t = new Ticket();
                        t.setSeat(String.valueOf(c_row) + n_col);
                        if (!booking_details.get(t.getSeat()).equals("")) {
                            msg = "Có chỗ ngồi đã được đặt.";
                            throw new SQLException(msg);
                        }
                        t.setPrice(0);
                        if ('A' <= c_row && c_row <= 'D') {
                            t.setId(1);
                            t.setPrice(tickets.get(0).getPrice());
                        } else if ('E' <= c_row && c_row <= 'H') {
                            t.setId(2);
                            t.setPrice(tickets.get(1).getPrice());
                        } else if (c_row == 'J') {
                            t.setId(3);
                            t.setSeat(String.valueOf(c_row) + n_col + " " + String.valueOf(c_row) + (n_col + 1));
                            t.setPrice(tickets.get(2).getPrice());
                        }
                        if (t.getPrice() > 0) {
                            dbTrans.Update("INSERT INTO booking_detail(booking_id, ticket_id, seat, price) VALUES(?, ?, ?, ?)", new String[]{String.valueOf(booking_id), String.valueOf(t.getId()), t.getSeat(), String.valueOf(t.getPrice())});
                            total_price += t.getPrice();
                        }
                    } catch (NumberFormatException ex) {
                    }
                }

                if (total_price > 0) {
                    dbTrans.Update("UPDATE booking SET total_price = " + total_price + " WHERE id = " + booking_id);
                    dbTrans.commit();
                    msg = "Thành công.";
                } else {
                    dbTrans.rollback();
                }
            } catch (SQLException ex) {
                dbTrans.rollback();
                System.out.println("error transaction: " + ex);
            } finally {
                dbTrans.finish();
            }

            model.addAttribute("msg", msg);
            return "test";
        } catch (NumberFormatException ex) {
            return "redirect:/";
        }
    }
}
