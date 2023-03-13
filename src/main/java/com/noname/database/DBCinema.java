/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.noname.database;

import com.noname.model.Cinema;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DBCinema {

    DB db = new DB();

    public List<Cinema> GetCinemas() {
        List<Map<String, Object>> ls = db.Query("SELECT * FROM cinema ORDER BY id DESC");
        List<Cinema> list = new ArrayList<>();
        for (Map<String, Object> ele : ls) {
            Cinema c = new Cinema();
            c.setId(Integer.parseInt(String.valueOf(ele.get("id"))));
            c.setName(String.valueOf(ele.get("name")));
            c.setAddress(String.valueOf(ele.get("address")));
            list.add(c);
        }
        return list;
    }

    public Cinema GetCinema(int id) {
        List<Map<String, Object>> ls = db.Query("SELECT * FROM cinema WHERE id = " + id);
        for (Map<String, Object> ele : ls) {
            Cinema c = new Cinema();
            c.setId(Integer.parseInt(String.valueOf(ele.get("id"))));
            c.setName(String.valueOf(ele.get("name")));
            c.setAddress(String.valueOf(ele.get("address")));
            return c;
        }
        return null;
    }

    public boolean InsertCinema(Cinema cinema) {
        String[] params = new String[]{cinema.getName(), cinema.getAddress()};
        return db.Update("INSERT INTO cinema(name, address) VALUES(?, ?)", params) > 0;
    }

    public boolean UpdateCinema(Cinema cinema) {
        String[] params = new String[]{cinema.getName(), cinema.getAddress(), String.valueOf(cinema.getId())};
        return db.Update("UPDATE cinema SET name = ?, address = ? WHERE id = ?", params) > 0;
    }

    public boolean DeleteCinema(int id) {
        return db.Update("DELETE FROM cinema WHERE id = " + id) > 0;
    }
}
