/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.noname.database;

import com.noname.model.Ticket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DBTicket {

    DB db = new DB();

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

    public Ticket GetTicket(int id) {
        List<Map<String, Object>> ls = db.Query("SELECT * FROM ticket WHERE id = " + id);
        for (Map<String, Object> ele : ls) {
            Ticket t = new Ticket();
            t.setId(Integer.parseInt(String.valueOf(ele.get("id"))));
            t.setPrice(Integer.parseInt(String.valueOf(ele.get("price"))));
            t.setType(String.valueOf(ele.get("type")));
            return t;
        }
        return null;
    }

    public boolean UpdateTicket(Ticket ticket) {
        String[] params = new String[]{String.valueOf(ticket.getPrice()), String.valueOf(ticket.getId())};
        return db.Update("UPDATE ticket SET price = ? WHERE id = ?", params) > 0;
    }
}
