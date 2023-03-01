/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.noname.da_java.controller;

import com.noname.config.Utils;
import com.noname.database.DBQuery;
import com.noname.model.Film;
import com.noname.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author phatv
 */
@Controller
public class FilmController {

    DBQuery dbq = new DBQuery();

    @RequestMapping(value = "/films")
    public String Films(HttpSession session, @RequestParam(required = false) String page, @RequestParam(required = false) String category_id, Model model) {
        int page_id = Utils.Page(page);
        List<Film> films;
        try {
            int cid = Integer.parseInt(category_id);
            films = dbq.GetFilmsByCategoryId(page_id, cid);
        } catch (NumberFormatException ex) {
            films = dbq.GetFilms(page_id);
        }
        model.addAttribute("films", films);
        return "films";
    }

    @RequestMapping(value = "/film-detail")
    public String FilmDetail(@RequestParam String id, Model model) {
        try {
            int film_id = Integer.parseInt(id);
            Film f = dbq.GetFilm(film_id);
            if (f == null) {
                return "redirect:/";
            }
            model.addAttribute("title", f.getName());
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
        } catch (NumberFormatException ex) {
            return "redirect:/";
        }
    }
}
