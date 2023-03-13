/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.noname.controller.admin;

import com.noname.database.DBBooking;
import com.noname.database.DBQuery;
import com.noname.database.DBUser;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminMainController {

    DBQuery dbq = new DBQuery();
    DBBooking dbBooking = new DBBooking();
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
}
