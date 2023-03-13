/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.noname.controller.admin;

import com.noname.database.DBCategory;
import com.noname.database.DBCountry;
import com.noname.database.DBFilm;
import com.noname.database.DBQuery;
import com.noname.model.Film;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminFilmController {

    Session ss = new Session();
    DBQuery dbq = new DBQuery();
    DBCategory dbCategory = new DBCategory();
    DBCountry dbCountry = new DBCountry();
    DBFilm dbFilm = new DBFilm();

    @RequestMapping(value = "/admin/films")
    public String Films(HttpSession session, Model model) {
        if (ss.isLoggedIn(session)) {
            model.addAttribute("films", dbFilm.GetFilms());
            return "admin/films";
        }
        return "redirect:/admin/login";
    }

    @RequestMapping(value = "/admin/film")
    public String Film(HttpSession session, @RequestParam(required = false) String id, Model model) {
        if (ss.isLoggedIn(session)) {
            Film f = null;
            try {
                f = dbFilm.GetFilm(Integer.parseInt(id));
            } catch (NumberFormatException ex) {
            }
            if (f != null) {
                model.addAttribute("main_title", "Chỉnh sửa Phim #" + f.getId());
            } else {
                f = new Film();
                f.setId(0);
                model.addAttribute("main_title", "Thêm mới Phim");
            }
            model.addAttribute("film", f);
            model.addAttribute("countries", dbCountry.GetCountries());
            model.addAttribute("categories", dbCategory.GetCategories());
            model.addAttribute("categories_selected", dbCategory.GetCategoriesByFilmId(f.getId()));
            model.addAttribute("list_rated", dbq.GetListRated());
            return "admin/film";
        }
        return "redirect:/admin/login";
    }

    @RequestMapping(value = "/admin/film", method = RequestMethod.POST)
    public String FilmProcess(HttpSession session, Film film, @RequestParam(value = "categories_s") ArrayList<String> categories_s, Model model) {
        if (ss.isLoggedIn(session)) {
            if (film.getId() == 0) {
                dbFilm.InsertFilm(film, categories_s);
            } else {
                dbFilm.UpdateFilm(film);
                dbFilm.UpdateFilmCategories(film.getId(), categories_s);
                return "redirect:/admin/film?id=" + film.getId();
            }
            return "redirect:/admin/films";
        }
        return "redirect:/admin/login";
    }

    @RequestMapping(value = "/admin/film/delete")
    public String FilmDelete(HttpSession session, @RequestParam(required = false) String id, Model model) {
        if (ss.isLoggedIn(session)) {
            Film f = null;
            try {
                f = dbFilm.GetFilm(Integer.parseInt(id));
            } catch (NumberFormatException ex) {
            }
            if (f != null) {
                dbFilm.DeleteFilm(f.getId());
            }
            return "redirect:/admin/films";
        }
        return "redirect:/admin/login";
    }
}
