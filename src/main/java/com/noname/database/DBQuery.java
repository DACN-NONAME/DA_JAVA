/*
             * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
             * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.noname.database;

import com.noname.model.Rated;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author phatv
 */
public class DBQuery {

    DB db = new DB();

    public int GetProfit() {
        List<Map<String, Object>> ls = db.Query("SELECT SUM(total_price) AS total FROM booking");
        try {
            for (Map<String, Object> ele : ls) {
                return Integer.parseInt(String.valueOf(ele.get("total")));
            }
        } catch (NumberFormatException ex) {
            System.out.println("error get profit: " + ex.toString());
        }
        return 0;
    }

    public List<Rated> GetListRated() {
        List<Map<String, Object>> ls = db.Query("SELECT * FROM rated");
        List<Rated> list = new ArrayList<>();
        for (Map<String, Object> ele : ls) {
            Rated r = new Rated();
            r.setId(Integer.parseInt(String.valueOf(ele.get("id"))));
            r.setName(String.valueOf(ele.get("name")));
            list.add(r);
        }
        return list;
    }

}
