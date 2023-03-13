/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.noname.controller.admin;

import com.noname.database.DBBooking;
import com.noname.database.DBSchedule;
import com.noname.database.DBUser;
import com.noname.model.Booking;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminBookingController {

    Session ss = new Session();
    DBBooking dbBooking = new DBBooking();
    DBSchedule dbSchedule = new DBSchedule();
    DBUser dbUser = new DBUser();

    @RequestMapping(value = "/admin/bookings")
    public String Bookings(HttpSession session, Model model) {
        if (ss.isLoggedIn(session)) {
            model.addAttribute("bookings", dbBooking.GetBookings());
            return "admin/bookings";
        }
        return "redirect:/admin/login";
    }

    @RequestMapping(value = "/admin/booking")
    public String Users(HttpSession session, @RequestParam(required = false) String id, Model model) {
        if (ss.isLoggedIn(session)) {
            Booking b = null;
            try {
                b = dbBooking.GetBooking(Integer.parseInt(id));
            } catch (NumberFormatException ex) {
            }
            if (b != null) {
                model.addAttribute("booking", b);
                model.addAttribute("user", dbUser.GetUser(b.getUser_id()));
                model.addAttribute("schedule", dbSchedule.GetSchedule(b.getSchedule_id()));
                model.addAttribute("booking_details", dbBooking.GetBookingDetailsByBookingId(b.getId()));
                return "admin/booking";
            } else {
                return "redirect:/admin/bookings";
            }
        }
        return "redirect:/admin/login";
    }
}
