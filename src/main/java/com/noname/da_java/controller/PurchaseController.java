/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.noname.da_java.controller;

import com.noname.config.Utils;
import com.noname.database.DBQuery;
import com.noname.model.Film;
import com.noname.model.Schedule;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author phatv
 */
@Controller
public class PurchaseController {

    DBQuery dbq = new DBQuery();

    @RequestMapping(value = "/tickets")
    public String Tickets(@RequestParam(required = false) String film_id, @RequestParam(required = false) String date, Model model) {
        try {
            int fid = Integer.parseInt(film_id);
            Film f = dbq.GetFilm(fid);
            if (f == null) {
                return "redirect:/";
            }
            model.addAttribute("title", "Chọn lịch phim " + f.getName());
            model.addAttribute("film", f);
            model.addAttribute("categories", dbq.GetCategoriesByFilmId(fid));
            model.addAttribute("schedules", dbq.GetSchedulesByFilmIdByDate(fid, date));

            LocalDate today = LocalDate.now(ZoneId.of(Utils.TZ));
            List<String> dates = new ArrayList<>();
            for (LocalDate ele : today.datesUntil(today.plusWeeks(2)).toList()) {
                dates.add(ele.toString());
            }
            model.addAttribute("dates", dates);

            return "tickets";
        } catch (NumberFormatException ex) {
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/seats")
    public String Seats(@RequestParam(required = false) String id, Model model) {
        try {
            int sid = Integer.parseInt(id);
            Schedule s = dbq.GetSchedule(sid);
            if (s == null) {
                return "redirect:/";
            }
            Film f = dbq.GetFilm(s.getFilm_id());
            model.addAttribute("title", "Chọn vị trí ngồi phim " + f.getName());
            model.addAttribute("film", f);
            model.addAttribute("schedule", s);
            model.addAttribute("tickets", dbq.GetTickets());

            return "seats";
        } catch (NumberFormatException ex) {
            return "redirect:/";
        }
    }
}
