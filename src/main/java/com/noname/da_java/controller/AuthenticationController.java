/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.noname.da_java.controller;

import com.noname.database.DBQuery;
import com.noname.model.User;
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
public class AuthenticationController {

    DBQuery dbq = new DBQuery();

    @RequestMapping(value = "/sign-in")
    public String SignIn(Model model) {
        return "sign-in";
    }

    @RequestMapping(value = "/sign-in", method = RequestMethod.POST)
    public String SignInProcess(@ModelAttribute() User user, Model model) {
        System.out.println("user: " + user.getEmail());
        return "sign-in";
    }

    @RequestMapping(value = "/sign-up")
    public String SignUp(Model model) {
        return "sign-up";
    }

    @RequestMapping(value = "/sign-up", method = RequestMethod.POST)
    public String SignUpProcess(@ModelAttribute() User user, @RequestParam("password2") String password2, Model model) {
        System.out.println("user: " + user.getEmail());
        int is_reg = dbq.Register(user);
        if (is_reg == 1) {

            return "redirect:/";
        }
        model.addAttribute("msg", is_reg == 0 ? "Email đã tồn tại!" : "Có lỗi xảy ra, vui lòng thử lại!");
        return "sign-up";
    }
}
