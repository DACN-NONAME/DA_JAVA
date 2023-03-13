/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.noname.database;

import com.noname.model.Room;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DBRoom {

    DB db = new DB();

    public List<Room> GetRooms() {
        List<Map<String, Object>> ls = db.Query("SELECT * FROM room");
        List<Room> list = new ArrayList<>();
        for (Map<String, Object> ele : ls) {
            Room r = new Room();
            r.setId(Integer.parseInt(String.valueOf(ele.get("id"))));
            r.setName(String.valueOf(ele.get("name")));
            list.add(r);
        }
        return list;
    }

}
