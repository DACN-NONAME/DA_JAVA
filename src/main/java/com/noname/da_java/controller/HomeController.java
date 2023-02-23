/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.noname.da_java.controller;

import com.noname.database.DBQuery;
import com.noname.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author phatv
 */
@Controller
public class HomeController {

    private DBQuery dbq = new DBQuery();

    @RequestMapping(value = "/")
    public String index(Model model) {
//        model.addAttribute("message", "Welcome to our Website!");
        model.addAttribute("films", dbq.GetFilms());
        return "index";
    }
}
