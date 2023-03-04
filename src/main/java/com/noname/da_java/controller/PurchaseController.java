/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.noname.da_java.controller;

import com.noname.config.Utils;
import com.noname.database.DBQuery;
import com.noname.model.Film;
import com.noname.model.Schedule;
import com.noname.model.Ticket;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
