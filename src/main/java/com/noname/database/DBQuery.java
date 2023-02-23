/*
             * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
             * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.noname.database;

import com.noname.model.Film;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author phatv
 */
public class DBQuery {

    DB db = new DB();

    public List<Film> GetFilms() {
        ResultSet rs = db.Query("SELECT F.*, C.name AS country_name, R.name AS rated_name FROM film F LEFT JOIN country C ON F.country_id = C.id LEFT JOIN rated R ON F.rated_id = R.id ORDER BY F.id DESC");
        List<Film> list = new ArrayList<>();
        if (rs != null) {
            try {
                while (rs.next()) {
                    Film f = new Film();
                    f.setId(rs.getInt("id"));
                    f.setName(rs.getString("name"));
                    f.setPoster(rs.getString("poster"));
                    f.setTrailer(rs.getString("trailer"));
                    f.setDirector(rs.getString("director"));
                    f.setProducer(rs.getString("producer"));
                    f.setActor(rs.getString("actor"));
                    f.setOpening_day(rs.getString("opening_day"));
                    f.setDescription(rs.getString("description"));
                    f.setDuration(rs.getInt("duration"));
                    f.setCountry_id(rs.getInt("country_id"));
                    f.setCountry_name(rs.getString("country_name"));
                    f.setRated_id(rs.getInt("rated_id"));
                    f.setRated_name(rs.getString("rated_name"));
                    list.add(f);
                }
            } catch (SQLException ex) {
                System.out.println("error get films: " + ex.toString());
            }
        }
        return list;
    }
}
