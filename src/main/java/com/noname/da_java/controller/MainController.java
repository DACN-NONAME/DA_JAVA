/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.noname.da_java.controller;

import com.noname.database.DBQuery;
import com.noname.model.Film;
import com.noname.model.User;
import java.util.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author phatv
 */
@Controller
public class MainController {

    private final DBQuery dbq = new DBQuery();

    @RequestMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("films", dbq.GetFilms());
        return "index";
    }

    @RequestMapping(value = "/film-detail")
    public String FilmDetail(@RequestParam String id, Model model) {
        int film_id = 0;
        try {
            film_id = Integer.parseInt(id);
        } catch (NumberFormatException ex) {
        }
        if (film_id == 0) {
            return "redirect:/";
        }
        Film f = dbq.GetFilm(film_id);
        if (f == null) {
            return "redirect:/";
        }
        model.addAttribute("film", f);
        model.addAttribute("categories", dbq.GetCategoriesByFilmId(film_id));

        List<User> actors = new ArrayList<>();
        String strActors[] = f.getActor().split(",");
        for (String el : strActors) {
            User u = new User();
            u.setFull_name(el.trim());
            actors.add(u);
        }
        model.addAttribute("actors", actors);

        return "film-detail";
    }
}
