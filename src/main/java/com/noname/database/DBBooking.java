/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.noname.database;

import com.noname.model.Booking;
import com.noname.model.Booking_detail;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DBBooking {

    DB db = new DB();

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

    public List<Booking> GetBookings() {
        List<Map<String, Object>> ls = db.Query("SELECT B.*, U.full_name AS user_full_name, S.start_time AS schedule_start_time, F.id AS film_id, F.name AS film_name, F.poster AS film_poster FROM booking B LEFT JOIN schedule S ON B.schedule_id = S.id LEFT JOIN film F ON S.film_id = F.id LEFT JOIN user U ON B.user_id = U.id ORDER BY B.id DESC");
        List<Booking> list = new ArrayList<>();
        for (Map<String, Object> ele : ls) {
            Booking b = new Booking();
            b.setId(Integer.parseInt(String.valueOf(ele.get("id"))));
            b.setUser_id(Integer.parseInt(String.valueOf(ele.get("user_id"))));
            b.setUser_full_name(String.valueOf(ele.get("user_full_name")));
            b.setSchedule_id(Integer.parseInt(String.valueOf(ele.get("schedule_id"))));
            b.setSchedule_start_time(String.valueOf(ele.get("schedule_start_time")).replace("T", " "));
            b.setTotal_price(Integer.parseInt(String.valueOf(ele.get("total_price"))));
            b.setCreated_at(String.valueOf(ele.get("created_at")).split("T")[0]);
            b.setFilm_id(Integer.parseInt(String.valueOf(ele.get("film_id"))));
            b.setFilm_name(String.valueOf(ele.get("film_name")));
            b.setFilm_poster(String.valueOf(ele.get("film_poster")));
            list.add(b);
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

    public int GetCountBookings() {
        List<Map<String, Object>> ls = db.Query("SELECT COUNT(id) AS total FROM booking");
        try {
            for (Map<String, Object> ele : ls) {
                return Integer.parseInt(String.valueOf(ele.get("total")));
            }
        } catch (NumberFormatException ex) {
            System.out.println("error get count bookings: " + ex.toString());
        }
        return 0;
    }

}
