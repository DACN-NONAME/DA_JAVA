/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.noname.da_java.controller;

import com.noname.database.DBQuery;
import com.noname.model.Booking;
import com.noname.model.Booking_detail;
import com.noname.model.Film;
import com.noname.model.Ticket;
import com.noname.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author phatv
 */
@Controller
public class UserController {

    DBQuery dbq = new DBQuery();

    @RequestMapping(value = "/profile")
    public String Profile(HttpSession session, Model model) {
        if (session.getAttribute("user") == null) {
            return "redirect:/";
        }
        return "profile";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public String UpdateProfile(HttpSession session, @ModelAttribute() User user, Model model) {
        if (session.getAttribute("user") == null) {
            return "redirect:/";
        }
        User u = (User) session.getAttribute("user");
        user.setId(u.getId());
        user.setEmail(u.getEmail());
        if (dbq.UpdateUser(user)) {
            session.setAttribute("user", user);
        }
        return "profile";
    }

    @RequestMapping(value = "/logout")
    public String Logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @RequestMapping(value = "/history")
    public String History(HttpSession session, Model model) {
        if (session.getAttribute("user") == null) {
            return "redirect:/";
        }
        User u = (User) session.getAttribute("user");
        model.addAttribute("bookings", dbq.GetBookingsByUserId(u.getId()));

        return "history";
    }

    @RequestMapping(value = "/booking-detail")
    public String BookingDetail(@RequestParam(required = false) String id, Model model) {
        try {
            int bid = Integer.parseInt(id);
            Booking b = dbq.GetBooking(bid);
            if (b == null) {
                return "redirect:/";
            }
            Film f = dbq.GetFilm(b.getFilm_id());
            model.addAttribute("title", "Thanh toán vé phim " + f.getName());
            model.addAttribute("film", f);
            model.addAttribute("schedule", dbq.GetSchedule(b.getSchedule_id()));

            List<Ticket> tickets = dbq.GetTickets();
            List<Booking_detail> listSeats = dbq.GetBookingDetailsByBookingId(bid);
            List<Ticket> listSeat1 = new ArrayList<>();
            List<Ticket> listSeat2 = new ArrayList<>();
            List<Ticket> listSeat3 = new ArrayList<>();
            int total_price = 0;
            for (Booking_detail ele : listSeats) {
                Ticket t = new Ticket();
                String code_seat = ele.getSeat();
                t.setSeat(code_seat);
                char c_row = code_seat.charAt(0);
                if ('A' <= c_row && c_row <= 'D') {
                    total_price += tickets.get(0).getPrice();
                    listSeat1.add(t);
                } else if ('E' <= c_row && c_row <= 'H') {
                    total_price += tickets.get(1).getPrice();
                    listSeat2.add(t);
                } else if (c_row == 'J') {
                    total_price += tickets.get(2).getPrice();
                    listSeat3.add(t);
                }
            }
            model.addAttribute("tickets", tickets);
            model.addAttribute("seats1", listSeat1);
            model.addAttribute("seats2", listSeat2);
            model.addAttribute("seats3", listSeat3);
            model.addAttribute("total_price", String.format("%,d", total_price) + " đ");

            return "booking-detail";
        } catch (NumberFormatException ex) {
            return "redirect:/";
        }
    }
}
