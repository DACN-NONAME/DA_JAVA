/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.noname.database;

import com.noname.config.Utils;
import com.noname.model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DBUser {

    DB db = new DB();

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

    public List<User> GetUsers() {
        List<Map<String, Object>> ls = db.Query("SELECT * FROM user ORDER BY id DESC");
        List<User> list = new ArrayList<>();
        for (Map<String, Object> ele : ls) {
            User s = new User();
            s.setId(Integer.parseInt(String.valueOf(ele.get("id"))));
            s.setFull_name(String.valueOf(ele.get("full_name")));
            s.setEmail(String.valueOf(ele.get("email")));
            s.setPhone(String.valueOf(ele.get("phone")));
            s.setCreated_at(String.valueOf(ele.get("created_at")).split("T")[0]);
            list.add(s);
        }
        return list;
    }

    public boolean UpdateUser(User user) {
        String[] params = new String[]{user.getFull_name(), user.getPhone(), user.getAddress(), String.valueOf(user.getId())};
        return db.Update("UPDATE user SET full_name = ?, phone = ?, address = ? WHERE id = ?", params) > 0;
    }

    public int GetCountUsers() {
        List<Map<String, Object>> ls = db.Query("SELECT COUNT(id) AS total FROM user");
        try {
            for (Map<String, Object> ele : ls) {
                return Integer.parseInt(String.valueOf(ele.get("total")));
            }
        } catch (NumberFormatException ex) {
            System.out.println("error get count users: " + ex.toString());
        }
        return 0;
    }
}
