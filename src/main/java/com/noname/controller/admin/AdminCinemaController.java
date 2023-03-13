/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.noname.controller.admin;

import com.noname.database.DBCinema;
import com.noname.model.Cinema;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminCinemaController {

    Session ss = new Session();
    DBCinema dbCinema = new DBCinema();

    @RequestMapping(value = "/admin/cinemas")
    public String Cinemas(HttpSession session, Model model) {
        if (ss.isLoggedIn(session)) {
            model.addAttribute("cinemas", dbCinema.GetCinemas());
            return "admin/cinemas";
        }
        return "redirect:/admin/login";
    }

    @RequestMapping(value = "/admin/cinema")
    public String Cinema(HttpSession session, @RequestParam(required = false) String id, Model model) {
        if (ss.isLoggedIn(session)) {
            Cinema c = null;
            try {
                c = dbCinema.GetCinema(Integer.parseInt(id));
            } catch (NumberFormatException ex) {
            }
            if (c != null) {
                model.addAttribute("main_title", "Chỉnh sửa Rạp #" + c.getId());
            } else {
                c = new Cinema();
                c.setId(0);
                model.addAttribute("main_title", "Thêm mới Rạp");
            }
            model.addAttribute("cinema", c);
            return "admin/cinema";
        }
        return "redirect:/admin/login";
    }

    @RequestMapping(value = "/admin/cinema", method = RequestMethod.POST)
    public String CinemaProcess(HttpSession session, Cinema cinema, Model model) {
        if (ss.isLoggedIn(session)) {
            if (cinema.getId() == 0) {
                dbCinema.InsertCinema(cinema);
            } else {
                dbCinema.UpdateCinema(cinema);
                return "redirect:/admin/cinema?id=" + cinema.getId();
            }
            return "redirect:/admin/cinemas";
        }
        return "redirect:/admin/login";
    }

    @RequestMapping(value = "/admin/cinema/delete")
    public String CinemaDelete(HttpSession session, @RequestParam(required = false) String id, Model model) {
        if (ss.isLoggedIn(session)) {
            Cinema c = null;
            try {
                c = dbCinema.GetCinema(Integer.parseInt(id));
            } catch (NumberFormatException ex) {
            }
            if (c != null) {
                dbCinema.DeleteCinema(c.getId());
            }
            return "redirect:/admin/cinemas";
        }
        return "redirect:/admin/login";
    }
}
