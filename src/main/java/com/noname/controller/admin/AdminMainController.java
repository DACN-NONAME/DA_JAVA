/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.noname.controller.admin;

import com.noname.database.DBBooking;
import com.noname.database.DBCategory;
import com.noname.database.DBFilm;
import com.noname.database.DBQuery;
import com.noname.database.DBSchedule;
import com.noname.database.DBTicket;
import com.noname.database.DBUser;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminMainController {

    DBQuery dbq = new DBQuery();
    DBBooking dbBooking = new DBBooking();
    DBCategory dbCategory = new DBCategory();
    DBFilm dbFilm = new DBFilm();
    DBSchedule dbSchedule = new DBSchedule();
    DBTicket dbTicket = new DBTicket();
    DBUser dbUser = new DBUser();
    Session ss = new Session();

    @RequestMapping(value = "/admin")
    public String Index(HttpSession session, Model model) {
        if (ss.isLoggedIn(session)) {
            model.addAttribute("count_users", dbUser.GetCountUsers());
            model.addAttribute("count_bookings", dbBooking.GetCountBookings());
            model.addAttribute("profit", dbq.GetProfit());

            return "admin/index";
        }
        return "redirect:/admin/login";
    }

    @RequestMapping(value = "/admin/categories")
    public String Categories(HttpSession session, Model model) {
        if (ss.isLoggedIn(session)) {
            model.addAttribute("categories", dbCategory.GetCategories());
            return "admin/categories";
        }
        return "redirect:/admin/login";
    }

    @RequestMapping(value = "/admin/films")
    public String Films(HttpSession session, Model model) {
        if (ss.isLoggedIn(session)) {
            model.addAttribute("films", dbFilm.GetFilms());
            return "admin/films";
        }
        return "redirect:/admin/login";
    }

    @RequestMapping(value = "/admin/schedules")
    public String Schedules(HttpSession session, Model model) {
        if (ss.isLoggedIn(session)) {
            model.addAttribute("schedules", dbSchedule.GetSchedules());
            return "admin/schedules";
        }
        return "redirect:/admin/login";
    }

    @RequestMapping(value = "/admin/tickets")
    public String Tickets(HttpSession session, Model model) {
        if (ss.isLoggedIn(session)) {
            model.addAttribute("tickets", dbTicket.GetTickets());
            return "admin/tickets";
        }
        return "redirect:/admin/login";
    }

    @RequestMapping(value = "/admin/users")
    public String Users(HttpSession session, Model model) {
        if (ss.isLoggedIn(session)) {
            model.addAttribute("users", dbUser.GetUsers());
            return "admin/users";
        }
        return "redirect:/admin/login";
    }

    @RequestMapping(value = "/admin/bookings")
    public String Bookings(HttpSession session, Model model) {
        if (ss.isLoggedIn(session)) {
            model.addAttribute("bookings", dbBooking.GetBookings());
            return "admin/bookings";
        }
        return "redirect:/admin/login";
    }
}
