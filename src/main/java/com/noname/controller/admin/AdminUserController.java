/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.noname.controller.admin;

import com.noname.database.DBUser;
import com.noname.model.User;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminUserController {

    Session ss = new Session();
    DBUser dbUser = new DBUser();

    @RequestMapping(value = "/admin/users")
    public String Users(HttpSession session, Model model) {
        if (ss.isLoggedIn(session)) {
            model.addAttribute("users", dbUser.GetUsers());
            return "admin/users";
        }
        return "redirect:/admin/login";
    }

    @RequestMapping(value = "/admin/user")
    public String Users(HttpSession session, @RequestParam(required = false) String id, Model model) {
        if (ss.isLoggedIn(session)) {
            User u = null;
            try {
                u = dbUser.GetUser(Integer.parseInt(id));
            } catch (NumberFormatException ex) {
            }
            if (u != null) {
                model.addAttribute("user", u);
                return "admin/user";
            } else {
                return "redirect:/admin/users";
            }
        }
        return "redirect:/admin/login";
    }
}
