/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.noname.controller.admin;

import com.noname.model.User;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminAuthenticationController {

    Session ss = new Session();

    @RequestMapping(value = "/admin/login")
    public String Login() {
        return "admin/login";
    }

    @RequestMapping(value = "/admin/login", method = RequestMethod.POST)
    public String LoginProcess(HttpSession session, User user) {
        if (ss.Login(session, user.getEmail(), user.getPassword())) {
            return "redirect:/admin";
        }
        return "admin/login";
    }

    @RequestMapping(value = "/admin/logout")
    public String Logout(HttpSession session) {
        ss.Logout(session);
        return "redirect:/admin/login";
    }
}
