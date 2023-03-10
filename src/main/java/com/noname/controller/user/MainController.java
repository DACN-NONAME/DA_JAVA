/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.noname.controller.user;

import com.noname.database.DBFilm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author phatv
 */
@Controller
public class MainController {

    DBFilm dbFilm = new DBFilm();

    @RequestMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("films", dbFilm.GetFilms());
        return "index";
    }
}
