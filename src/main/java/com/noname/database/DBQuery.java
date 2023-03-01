/*
             * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
             * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.noname.database;

import com.noname.config.Utils;
import com.noname.model.Category;
import com.noname.model.Film;
import com.noname.model.User;
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

    public List<Film> GetFilms(int page) {
        ResultSet rs = db.Query("SELECT F.*, C.name AS country_name, R.name AS rated_name FROM film F LEFT JOIN country C ON F.country_id = C.id LEFT JOIN rated R ON F.rated_id = R.id ORDER BY F.id DESC " + Utils.Offset(page));
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

    public List<Film> GetFilms() {
        return GetFilms(1);
    }

    public List<Film> GetFilmsByCategoryId(int page, int category_id) {
        ResultSet rs = db.Query("SELECT F.*, C.name AS country_name, R.name AS rated_name FROM category_film CF LEFT JOIN film F ON CF.film_id = F.id LEFT JOIN country C ON F.country_id = C.id LEFT JOIN rated R ON F.rated_id = R.id WHERE CF.category_id = " + category_id + " ORDER BY F.id DESC " + Utils.Offset(page));
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

    public Film GetFilm(int id) {
        ResultSet rs = db.Query("SELECT F.*, C.name AS country_name, R.name AS rated_name FROM film F LEFT JOIN country C ON F.country_id = C.id LEFT JOIN rated R ON F.rated_id = R.id WHERE F.id = " + id);
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
                    return f;
                }
            } catch (SQLException ex) {
                System.out.println("error get film: " + ex.toString());
            }
        }
        return null;
    }

    public int getCountFilms() {
        ResultSet rs = db.Query("SELECT COUNT(id) AS total FROM film");
        if (rs != null) {
            try {
                while (rs.next()) {
                    return rs.getInt("total");
                }
            } catch (SQLException ex) {
                System.out.println("error get count films: " + ex.toString());
            }
        }
        return 0;
    }

    public List<Category> GetCategories() {
        ResultSet rs = db.Query("SELECT * FROM category");
        List<Category> list = new ArrayList<>();
        if (rs != null) {
            try {
                while (rs.next()) {
                    Category c = new Category();
                    c.setId(rs.getInt("id"));
                    c.setName(rs.getString("name"));
                    list.add(c);
                }
            } catch (SQLException ex) {
            }
        }
        return list;
    }

    public List<Category> GetCategoriesByFilmId(int film_id) {
        ResultSet rs = db.Query("SELECT C.* FROM category_film CF LEFT JOIN category C ON CF.category_id = C.id LEFT JOIN film F ON CF.film_id = F.id WHERE F.id = " + film_id);
        List<Category> list = new ArrayList<>();
        if (rs != null) {
            try {
                while (rs.next()) {
                    Category c = new Category();
                    c.setId(rs.getInt("id"));
                    c.setName(rs.getString("name"));
                    list.add(c);
                }
            } catch (SQLException ex) {
            }
        }
        return list;
    }

    public boolean Login(String email, String password) {
        password = Utils.SHA1(password);
        ResultSet rs = db.Query("SELECT * FROM user WHERE email = ? AND password = ?", new String[]{email, password});
        if (rs != null) {
            try {
                while (rs.next()) {
                    return true;
                }
            } catch (SQLException ex) {
            }
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
        ResultSet rs = db.Query("SELECT * FROM user WHERE email = ?", new String[]{email});
        if (rs != null) {
            try {
                while (rs.next()) {
                    User u = new User();
                    u.setId(rs.getInt("id"));
                    u.setFull_name(rs.getString("full_name"));
                    u.setEmail(rs.getString("email"));
                    u.setPhone(rs.getString("phone"));
                    u.setAddress(rs.getString("address"));
                    return u;
                }
            } catch (SQLException ex) {
            }
        }
        return null;
    }

    public boolean UpdateUser(User user) {
        String[] params = new String[]{user.getFull_name(), user.getPhone(), user.getAddress(), String.valueOf(user.getId())};
        return db.Update("UPDATE user SET full_name = ?, phone = ?, address = ? WHERE id = ?", params) > 0;
    }
}
