/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.noname.database;

import com.noname.model.Country;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DBCountry {

    DB db = new DB();

    public List<Country> GetCountries() {
        List<Map<String, Object>> ls = db.Query("SELECT * FROM country");
        List<Country> list = new ArrayList<>();
        for (Map<String, Object> ele : ls) {
            Country c = new Country();
            c.setId(Integer.parseInt(String.valueOf(ele.get("id"))));
            c.setName(String.valueOf(ele.get("name")));
            list.add(c);
        }
        return list;
    }

    public Country GetCountry(int id) {
        List<Map<String, Object>> ls = db.Query("SELECT * FROM country WHERE id = " + id);
        for (Map<String, Object> ele : ls) {
            Country c = new Country();
            c.setId(Integer.parseInt(String.valueOf(ele.get("id"))));
            c.setName(String.valueOf(ele.get("name")));
            return c;
        }
        return null;
    }

    public boolean InsertCountry(Country country) {
        String[] params = new String[]{country.getName()};
        return db.Update("INSERT INTO country(name) VALUES(?)", params) > 0;
    }

    public boolean UpdateCountry(Country country) {
        String[] params = new String[]{country.getName(), String.valueOf(country.getId())};
        return db.Update("UPDATE country SET name = ? WHERE id = ?", params) > 0;
    }

    public boolean DeleteCountry(int id) {
        return db.Update("DELETE FROM country WHERE id = " + id) > 0;
    }

}
