/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.noname.controller.admin;

import com.noname.database.DBQuery;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminMainController {

    DBQuery dbq = new DBQuery();
    Session ss = new Session();

    @RequestMapping(value = "/admin")
    public String Index(HttpSession session, Model model) {
        if (ss.isLoggedIn(session)) {
            model.addAttribute("count_users", dbq.GetCountUsers());
            model.addAttribute("count_bookings", dbq.GetCountBookings());
            model.addAttribute("profit", dbq.GetProfit());

            return "admin/index";
        }
        return "redirect:/admin/login";
    }

    @RequestMapping(value = "/admin/countries")
    public String Country(HttpSession session, Model model) {
        if (ss.isLoggedIn(session)) {
            model.addAttribute("countries", dbq.GetCountries());
            return "admin/countries";
        }
        return "redirect:/admin/login";
    }

    @RequestMapping(value = "/admin/categories")
    public String Category(HttpSession session, Model model) {
        if (ss.isLoggedIn(session)) {
            model.addAttribute("categories", dbq.GetCategories());
            return "admin/categories";
        }
        return "redirect:/admin/login";
    }

    @RequestMapping(value = "/admin/films")
    public String Film(HttpSession session, Model model) {
        if (ss.isLoggedIn(session)) {
            model.addAttribute("films", dbq.GetFilms());
            return "admin/films";
        }
        return "redirect:/admin/login";
    }

    @RequestMapping(value = "/admin/schedules")
    public String Schedule(HttpSession session, Model model) {
        if (ss.isLoggedIn(session)) {
            model.addAttribute("schedules", dbq.GetSchedules());
            return "admin/schedules";
        }
        return "redirect:/admin/login";
    }

    @RequestMapping(value = "/admin/tickets")
    public String Ticket(HttpSession session, Model model) {
        if (ss.isLoggedIn(session)) {
            model.addAttribute("tickets", dbq.GetTickets());
            return "admin/tickets";
        }
        return "redirect:/admin/login";
    }

    @RequestMapping(value = "/admin/users")
    public String User(HttpSession session, Model model) {
        if (ss.isLoggedIn(session)) {
            model.addAttribute("users", dbq.GetUsers());
            return "admin/users";
        }
        return "redirect:/admin/login";
    }

    @RequestMapping(value = "/admin/bookings")
    public String Booking(HttpSession session, Model model) {
        if (ss.isLoggedIn(session)) {
            model.addAttribute("bookings", dbq.GetBookings());
            return "admin/bookings";
        }
        return "redirect:/admin/login";
    }
}
