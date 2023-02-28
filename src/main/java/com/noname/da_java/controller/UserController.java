/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.noname.da_java.controller;

import com.noname.database.DBQuery;
import com.noname.model.User;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}
