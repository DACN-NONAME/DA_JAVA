/*
             * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
             * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.noname.database;

import com.noname.config.Utils;
import com.noname.model.Booking;
import com.noname.model.Booking_detail;
import com.noname.model.Category;
import com.noname.model.Country;
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

}
