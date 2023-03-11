/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.noname.database;

import com.noname.model.Room;
import com.noname.model.Schedule;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DBSchedule {

    DB db = new DB();

    public List<Schedule> GetSchedulesByFilmIdByDate(int film_id, String date) {
        List<Map<String, Object>> ls = db.Query("SELECT S.*, C.name AS cinema_name, C.address AS cinema_address, R.name AS room_name FROM schedule S LEFT JOIN cinema C ON S.cinema_id = C.id LEFT JOIN room R ON S.room_id = R.id WHERE S.film_id = " + film_id + "  AND DATE(S.start_time) = ? ORDER BY TIME(S.start_time) ASC", new String[]{date});
        List<Schedule> list = new ArrayList<>();
        for (Map<String, Object> ele : ls) {
            Schedule s = new Schedule();
            s.setId(Integer.parseInt(String.valueOf(ele.get("id"))));
            s.setFilm_id(film_id);
            s.setCinema_id(Integer.parseInt(String.valueOf(ele.get("cinema_id"))));
            s.setCinema_name(String.valueOf(ele.get("cinema_name")));
            s.setCinema_address(String.valueOf(ele.get("cinema_address")));

            Room r = new Room();
            r.setId(Integer.parseInt(String.valueOf(ele.get("room_id"))));
            r.setName(String.valueOf(ele.get("room_name")));
            String[] start_time = String.valueOf(ele.get("start_time")).split("T")[1].split(":");
            r.setStart_time(start_time[0] + ":" + start_time[1]);
            // add temp if first
            List<Room> tempR = new ArrayList<>();
            tempR.add(r);
            s.setRooms(tempR);

            boolean isNew = true;
            int i = 0;
            for (Schedule ele2 : list) {
                if (ele2.getCinema_id() == s.getCinema_id()) {
                    isNew = false;
                    tempR = ele2.getRooms();
                    tempR.add(r);
                    list.get(i).setRooms(tempR);
                    break;
                }
                i++;
            }
            if (isNew) {
                list.add(s);
            }
        }
        return list;
    }

    public Schedule GetSchedule(int id) {
        List<Map<String, Object>> ls = db.Query("SELECT S.*, C.name AS cinema_name, C.address AS cinema_address, R.name AS room_name FROM schedule S LEFT JOIN cinema C ON S.cinema_id = C.id LEFT JOIN room R ON S.room_id = R.id WHERE S.id = " + id);
        for (Map<String, Object> ele : ls) {
            Schedule s = new Schedule();
            s.setId(Integer.parseInt(String.valueOf(ele.get("id"))));
            s.setFilm_id(Integer.parseInt(String.valueOf(ele.get("film_id"))));
            s.setCinema_id(Integer.parseInt(String.valueOf(ele.get("cinema_id"))));
            s.setCinema_name(String.valueOf(ele.get("cinema_name")));
            s.setCinema_address(String.valueOf(ele.get("cinema_address")));
            s.setRoom_id(Integer.parseInt(String.valueOf(ele.get("room_id"))));
            s.setRoom_name(String.valueOf(ele.get("room_name")));
            String[] start_time = String.valueOf(ele.get("start_time")).replace("T", " ").split(":");
            s.setStart_time(start_time[0] + ":" + start_time[1]);
            return s;
        }
        return null;
    }

    public List<Schedule> GetSchedules() {
        List<Map<String, Object>> ls = db.Query("SELECT S.*, F.name AS film_name, F.poster AS film_poster, C.name AS cinema_name, C.address AS cinema_address, R.name AS room_name FROM schedule S LEFT JOIN cinema C ON S.cinema_id = C.id LEFT JOIN room R ON S.room_id = R.id LEFT JOIN film F ON S.film_id = F.id ORDER BY S.id DESC");
        List<Schedule> list = new ArrayList<>();
        for (Map<String, Object> ele : ls) {
            Schedule s = new Schedule();
            s.setId(Integer.parseInt(String.valueOf(ele.get("id"))));
            s.setFilm_id(Integer.parseInt(String.valueOf(ele.get("film_id"))));
            s.setFilm_name(String.valueOf(ele.get("film_name")));
            s.setFilm_poster(String.valueOf(ele.get("film_poster")));
            s.setCinema_id(Integer.parseInt(String.valueOf(ele.get("cinema_id"))));
            s.setCinema_name(String.valueOf(ele.get("cinema_name")));
            s.setCinema_address(String.valueOf(ele.get("cinema_address")));
            s.setRoom_id(Integer.parseInt(String.valueOf(ele.get("room_id"))));
            s.setRoom_name(String.valueOf(ele.get("room_name")));
            String[] start_time = String.valueOf(ele.get("start_time")).replace("T", " ").split(":");
            s.setStart_time(start_time[0] + ":" + start_time[1]);
            list.add(s);
        }
        return list;
    }

}
