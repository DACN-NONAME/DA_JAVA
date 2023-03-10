/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.noname.controller.user;

import com.noname.config.Utils;
import com.noname.database.DBCategory;
import com.noname.database.DBFilm;
import com.noname.model.Film;
import com.noname.model.User;
import java.time.LocalDate;
import java.time.ZoneId;
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

    DBCategory dbCategory = new DBCategory();
    DBFilm dbFilm = new DBFilm();

    @RequestMapping(value = "/films")
    public String Films(HttpSession session, @RequestParam(required = false) String page, @RequestParam(required = false) String category_id, @RequestParam(required = false) String keyword, Model model) {
        if (keyword == null) {
            keyword = "";
        }
        int page_id = Utils.Page(page);
        List<Film> films;
        try {
            int cid = Integer.parseInt(category_id);
            films = dbFilm.GetFilmsByCategoryId(page_id, cid);
        } catch (NumberFormatException ex) {
            films = dbFilm.GetFilms(page_id, keyword);
        }
        model.addAttribute("keyword", keyword);
        model.addAttribute("films", films);
        return "films";
    }

    @RequestMapping(value = "/film-detail")
    public String FilmDetail(@RequestParam(required = false) String id, Model model) {
        try {
            int film_id = Integer.parseInt(id);
            Film f = dbFilm.GetFilm(film_id);
            if (f == null) {
                return "redirect:/";
            }
            model.addAttribute("title", f.getName());
            model.addAttribute("film", f);
            model.addAttribute("categories", dbCategory.GetCategoriesByFilmId(film_id));

            List<User> actors = new ArrayList<>();
            String strActors[] = f.getActor().split(",");
            for (String el : strActors) {
                User u = new User();
                u.setFull_name(el.trim());
                actors.add(u);
            }
            model.addAttribute("actors", actors);

            LocalDate today = LocalDate.now(ZoneId.of(Utils.TZ));
            model.addAttribute("date", today);

            return "film-detail";
        } catch (NumberFormatException ex) {
            return "redirect:/";
        }
    }
}
