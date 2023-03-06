/*
             * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
             * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.noname.database;

import com.noname.config.Utils;
import com.noname.model.Booking;
import com.noname.model.Booking_detail;
import com.noname.model.Category;
import com.noname.model.Film;
import com.noname.model.Room;
import com.noname.model.Schedule;
import com.noname.model.Ticket;
import com.noname.model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author phatv
 */
public class DBQuery {

    DB db = new DB();

    public List<Film> GetFilms(int page) {
        List<Map<String, Object>> ls = db.Query("SELECT F.*, C.name AS country_name, R.name AS rated_name FROM film F LEFT JOIN country C ON F.country_id = C.id LEFT JOIN rated R ON F.rated_id = R.id ORDER BY F.id DESC " + Utils.Offset(page));
        List<Film> list = new ArrayList<>();
        for (Map<String, Object> ele : ls) {
//            for (Map.Entry<String, Object> entry : ele.entrySet()) {
//                System.out.println(entry.getKey() + ": " + entry.getValue());
//            }
            Film f = new Film();
            f.setId(Integer.parseInt(ele.get("id").toString()));
            f.setName(ele.get("name").toString());
            f.setPoster(ele.get("poster").toString());
            f.setTrailer(ele.get("trailer").toString());
            f.setDirector(ele.get("director").toString());
            f.setProducer(String.valueOf(ele.get("producer")));
            f.setActor(ele.get("actor").toString());
            f.setOpening_day(ele.get("opening_day").toString());
            f.setDescription(ele.get("description").toString());
            f.setDuration(Integer.parseInt(ele.get("duration").toString()));
            f.setCountry_id(Integer.parseInt(ele.get("country_id").toString()));
            f.setCountry_name(String.valueOf(ele.get("country_name")));
            f.setRated_id(Integer.parseInt(ele.get("rated_id").toString()));
            f.setRated_name(String.valueOf(ele.get("rated_name")));
            list.add(f);
        }
        return list;
    }

    public List<Film> GetFilms() {
        return GetFilms(1);
    }

    public List<Film> GetFilmsByCategoryId(int page, int category_id) {
        List<Map<String, Object>> ls = db.Query("SELECT F.*, C.name AS country_name, R.name AS rated_name FROM category_film CF LEFT JOIN film F ON CF.film_id = F.id LEFT JOIN country C ON F.country_id = C.id LEFT JOIN rated R ON F.rated_id = R.id WHERE CF.category_id = " + category_id + " ORDER BY F.id DESC " + Utils.Offset(page));
        List<Film> list = new ArrayList<>();
        for (Map<String, Object> ele : ls) {
            Film f = new Film();
            f.setId(Integer.parseInt(ele.get("id").toString()));
            f.setName(ele.get("name").toString());
            f.setPoster(ele.get("poster").toString());
            f.setTrailer(ele.get("trailer").toString());
            f.setDirector(ele.get("director").toString());
            f.setProducer(String.valueOf(ele.get("producer")));
            f.setActor(ele.get("actor").toString());
            f.setOpening_day(ele.get("opening_day").toString());
            f.setDescription(ele.get("description").toString());
            f.setDuration(Integer.parseInt(ele.get("duration").toString()));
            f.setCountry_id(Integer.parseInt(ele.get("country_id").toString()));
            f.setCountry_name(String.valueOf(ele.get("country_name")));
            f.setRated_id(Integer.parseInt(ele.get("rated_id").toString()));
            f.setRated_name(String.valueOf(ele.get("rated_name")));
            list.add(f);
        }
        return list;
    }

    public Film GetFilm(int id) {
        List<Map<String, Object>> ls = db.Query("SELECT F.*, C.name AS country_name, R.name AS rated_name FROM film F LEFT JOIN country C ON F.country_id = C.id LEFT JOIN rated R ON F.rated_id = R.id WHERE F.id = " + id);
        for (Map<String, Object> ele : ls) {
            Film f = new Film();
            f.setId(Integer.parseInt(ele.get("id").toString()));
            f.setName(ele.get("name").toString());
            f.setPoster(ele.get("poster").toString());
            f.setTrailer(ele.get("trailer").toString());
            f.setDirector(ele.get("director").toString());
            f.setProducer(String.valueOf(ele.get("producer")));
            f.setActor(ele.get("actor").toString());
            f.setOpening_day(ele.get("opening_day").toString());
            f.setDescription(ele.get("description").toString());
            f.setDuration(Integer.parseInt(ele.get("duration").toString()));
            f.setCountry_id(Integer.parseInt(ele.get("country_id").toString()));
            f.setCountry_name(String.valueOf(ele.get("country_name")));
            f.setRated_id(Integer.parseInt(ele.get("rated_id").toString()));
            f.setRated_name(String.valueOf(ele.get("rated_name")));
            return f;
        }
        return null;
    }

    public int getCountFilms() {
        List<Map<String, Object>> ls = db.Query("SELECT COUNT(id) AS total FROM film");
        try {
            for (Map<String, Object> ele : ls) {
                return Integer.parseInt(String.valueOf(ele.get("total")));
            }
        } catch (NumberFormatException ex) {
            System.out.println("error get count films: " + ex.toString());
        }
        return 0;
    }

    public List<Category> GetCategories() {
        List<Map<String, Object>> ls = db.Query("SELECT * FROM category");
        List<Category> list = new ArrayList<>();
        for (Map<String, Object> ele : ls) {
            Category c = new Category();
            c.setId(Integer.parseInt(String.valueOf(ele.get("id"))));
            c.setName(String.valueOf(ele.get("name")));
            list.add(c);
        }
        return list;
    }

    public List<Category> GetCategoriesByFilmId(int film_id) {
        List<Map<String, Object>> ls = db.Query("SELECT C.* FROM category_film CF LEFT JOIN category C ON CF.category_id = C.id LEFT JOIN film F ON CF.film_id = F.id WHERE F.id = " + film_id);
        List<Category> list = new ArrayList<>();
        for (Map<String, Object> ele : ls) {
            Category c = new Category();
            c.setId(Integer.parseInt(String.valueOf(ele.get("id"))));
            c.setName(String.valueOf(ele.get("name")));
            list.add(c);
        }
        return list;
    }

    public boolean Login(String email, String password) {
        password = Utils.SHA1(password);
        List<Map<String, Object>> ls = db.Query("SELECT * FROM user WHERE email = ? AND password = ?", new String[]{email, password});
        for (Map<String, Object> ele : ls) {
            return true;
        }
        return false;
    }

    public int Register(User user) {
        String created_at = Utils.StrDate("yyyy-MM-dd");
        String[] params = new String[]{user.getFull_name(), user.getEmail(), Utils.SHA1(user.getPassword()), user.getPhone(), created_at};
        if (GetUserByEmail(user.getEmail()) == null) {
            if (db.Update("INSERT INTO user(full_name, email, password, phone, created_at) VALUES (?, ?, ?, ?, ?)", params) > 0) {
                return 1;
            } else {
                return -1;
            }
        } else {
            return 0;
        }
    }

    public User GetUserByEmail(String email) {
        List<Map<String, Object>> ls = db.Query("SELECT * FROM user WHERE email = ?", new String[]{email});
        for (Map<String, Object> ele : ls) {
            User u = new User();
            u.setId(Integer.parseInt(String.valueOf(ele.get("id"))));
            u.setFull_name(String.valueOf(ele.get("full_name")));
            u.setEmail(String.valueOf(ele.get("email")));
            u.setPhone(String.valueOf(ele.get("phone")));
            u.setAddress(String.valueOf(ele.get("address")));
            return u;
        }
        return null;
    }

    public boolean UpdateUser(User user) {
        String[] params = new String[]{user.getFull_name(), user.getPhone(), user.getAddress(), String.valueOf(user.getId())};
        return db.Update("UPDATE user SET full_name = ?, phone = ?, address = ? WHERE id = ?", params) > 0;
    }

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

    public List<Ticket> GetTickets() {
        List<Map<String, Object>> ls = db.Query("SELECT * FROM ticket");
        List<Ticket> list = new ArrayList<>();
        for (Map<String, Object> ele : ls) {
            Ticket t = new Ticket();
            t.setId(Integer.parseInt(String.valueOf(ele.get("id"))));
            t.setPrice(Integer.parseInt(String.valueOf(ele.get("price"))));
            t.setType(String.valueOf(ele.get("type")));
            list.add(t);
        }
        return list;
    }

    public List<Booking_detail> GetBookingDetailsByScheduleId(int sid) {
        List<Map<String, Object>> ls = db.Query("SELECT BD.* FROM booking_detail BD LEFT JOIN booking B ON BD.booking_id = B.id WHERE B.schedule_id = " + sid);
        List<Booking_detail> list = new ArrayList<>();
        for (Map<String, Object> ele : ls) {
            Booking_detail bd = new Booking_detail();
            bd.setId(Integer.parseInt(String.valueOf(ele.get("id"))));
            bd.setBooking_id(Integer.parseInt(String.valueOf(ele.get("booking_id"))));
            bd.setTicket_id(Integer.parseInt(String.valueOf(ele.get("ticket_id"))));
            bd.setSeat(String.valueOf(ele.get("seat")));
            bd.setPrice(Integer.parseInt(String.valueOf(ele.get("price"))));
            list.add(bd);
        }
        return list;
    }

    public List<Booking> GetBookingsByUserId(int uid) {
        List<Map<String, Object>> ls = db.Query("SELECT B.*, F.id AS film_id, F.name AS film_name, F.poster AS film_poster FROM booking B LEFT JOIN schedule S ON B.schedule_id = S.id LEFT JOIN film F ON S.film_id = F.id WHERE B.user_id = " + uid);
        List<Booking> list = new ArrayList<>();
        for (Map<String, Object> ele : ls) {
            Booking b = new Booking();
            b.setId(Integer.parseInt(String.valueOf(ele.get("id"))));
            b.setUser_id(Integer.parseInt(String.valueOf(ele.get("user_id"))));
            b.setSchedule_id(Integer.parseInt(String.valueOf(ele.get("schedule_id"))));
            b.setTotal_price(Integer.parseInt(String.valueOf(ele.get("total_price"))));
            b.setCreated_at(String.valueOf(ele.get("created_at")).split("T")[0]);
            b.setFilm_id(Integer.parseInt(String.valueOf(ele.get("film_id"))));
            b.setFilm_name(String.valueOf(ele.get("film_name")));
            b.setFilm_poster(String.valueOf(ele.get("film_poster")));
            list.add(b);
        }
        return list;
    }

    public Booking GetBooking(int id) {
        List<Map<String, Object>> ls = db.Query("SELECT B.*, F.id AS film_id, F.name AS film_name, F.poster AS film_poster FROM booking B LEFT JOIN schedule S ON B.schedule_id = S.id LEFT JOIN film F ON S.film_id = F.id WHERE B.id = " + id);
        for (Map<String, Object> ele : ls) {
            Booking b = new Booking();
            b.setId(Integer.parseInt(String.valueOf(ele.get("id"))));
            b.setUser_id(Integer.parseInt(String.valueOf(ele.get("user_id"))));
            b.setSchedule_id(Integer.parseInt(String.valueOf(ele.get("schedule_id"))));
            b.setTotal_price(Integer.parseInt(String.valueOf(ele.get("total_price"))));
            b.setCreated_at(String.valueOf(ele.get("created_at")));
            b.setFilm_id(Integer.parseInt(String.valueOf(ele.get("film_id"))));
            b.setFilm_name(String.valueOf(ele.get("film_name")));
            b.setFilm_poster(String.valueOf(ele.get("film_poster")));
            return b;
        }
        return null;
    }

    public List<Booking_detail> GetBookingDetailsByBookingId(int sid) {
        List<Map<String, Object>> ls = db.Query("SELECT * FROM booking_detail WHERE booking_id = " + sid);
        List<Booking_detail> list = new ArrayList<>();
        for (Map<String, Object> ele : ls) {
            Booking_detail bd = new Booking_detail();
            bd.setId(Integer.parseInt(String.valueOf(ele.get("id"))));
            bd.setBooking_id(Integer.parseInt(String.valueOf(ele.get("booking_id"))));
            bd.setTicket_id(Integer.parseInt(String.valueOf(ele.get("ticket_id"))));
            bd.setSeat(String.valueOf(ele.get("seat")));
            bd.setPrice(Integer.parseInt(String.valueOf(ele.get("price"))));
            list.add(bd);
        }
        return list;
    }
}
