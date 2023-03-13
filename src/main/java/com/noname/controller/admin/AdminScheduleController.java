/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.noname.controller.admin;

import com.noname.database.DBCinema;
import com.noname.database.DBFilm;
import com.noname.database.DBRoom;
import com.noname.database.DBSchedule;
import com.noname.model.Film;
import com.noname.model.Schedule;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminScheduleController {

    Session ss = new Session();
    DBCinema dbCinema = new DBCinema();
    DBFilm dbFilm = new DBFilm();
    DBRoom dbRoom = new DBRoom();
    DBSchedule dbSchedule = new DBSchedule();

    @RequestMapping(value = "/admin/schedules")
    public String Schedules(HttpSession session, Model model) {
        if (ss.isLoggedIn(session)) {
            model.addAttribute("schedules", dbSchedule.GetSchedules());
            return "admin/schedules";
        }
        return "redirect:/admin/login";
    }

    @RequestMapping(value = "/admin/schedule")
    public String Schedule(HttpSession session, @RequestParam(required = false) String film_id, @RequestParam(required = false) String id, Model model) {
        if (ss.isLoggedIn(session)) {
            Film f = null;
            Schedule s = null;
            String date = "", time = "";
            try {
                f = dbFilm.GetFilm(Integer.parseInt(film_id));
            } catch (NumberFormatException ex) {
            }
            if (f == null) {
                try {
                    s = dbSchedule.GetSchedule(Integer.parseInt(id));
                } catch (NumberFormatException ex) {
                }
                if (s != null) {
                    f = dbFilm.GetFilm(s.getFilm_id());
                    date = s.getStart_time().split(" ")[0];
                    time = s.getStart_time().split(" ")[1];
                    model.addAttribute("main_title", "Chỉnh sửa Lịch chiếu #" + s.getId() + " #" + f.getName());
                } else {
                    return "redirect:/admin/schedules";
                }
            } else {
                s = new Schedule();
                model.addAttribute("main_title", "Thêm Lịch chiếu Phim #" + f.getName());
            }
            model.addAttribute("film", f);
            model.addAttribute("cinemas", dbCinema.GetCinemas());
            model.addAttribute("rooms", dbRoom.GetRooms());
            model.addAttribute("schedule", s);
            model.addAttribute("date", date);
            model.addAttribute("time", time);
            return "admin/schedule";
        }
        return "redirect:/admin/login";
    }

    @RequestMapping(value = "/admin/schedule", method = RequestMethod.POST)
    public String ScheduleProcess(HttpSession session, Schedule schedule, @RequestParam(value = "date") String date, @RequestParam(value = "time") String time, Model model) {
        if (ss.isLoggedIn(session)) {
            schedule.setStart_time(date + " " + time + ":00");
            if (schedule.getId() == 0) {
                dbSchedule.InsertSchedule(schedule);
            } else {
                dbSchedule.UpdateSchedule(schedule);
                return "redirect:/admin/schedule?id=" + schedule.getId();
            }
            return "redirect:/admin/schedules";
        }
        return "redirect:/admin/login";
    }

    @RequestMapping(value = "/admin/schedule/delete")
    public String ScheduleDelete(HttpSession session, @RequestParam(required = false) String id, Model model) {
        if (ss.isLoggedIn(session)) {
            Schedule s = null;
            try {
                s = dbSchedule.GetSchedule(Integer.parseInt(id));
            } catch (NumberFormatException ex) {
            }
            if (s != null) {
                dbSchedule.DeleteSchedule(s.getId());
            }
            return "redirect:/admin/schedules";
        }
        return "redirect:/admin/login";
    }
}
