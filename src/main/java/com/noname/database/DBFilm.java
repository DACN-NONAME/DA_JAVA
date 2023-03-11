/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.noname.database;

import com.noname.config.Utils;
import com.noname.model.Film;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DBFilm {

    DB db = new DB();

    public List<Film> GetFilms(int page, String keyword) {
        if (!keyword.equals("")) {
            keyword = "WHERE MATCH(F.name) AGAINST('" + keyword + "')";
        } else {
            keyword = "";
        }
        List<Map<String, Object>> ls = db.Query("SELECT F.*, C.name AS country_name, R.name AS rated_name FROM film F LEFT JOIN country C ON F.country_id = C.id LEFT JOIN rated R ON F.rated_id = R.id " + keyword + " ORDER BY F.id DESC " + Utils.Offset(page));
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

    public List<Film> GetFilms(int page) {
        return GetFilms(page, "");
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

    public int GetCountFilms() {
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

}
