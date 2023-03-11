/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.noname.database;

import com.noname.model.Category;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DBCategory {

    DB db = new DB();

    public List<Category> GetCategories() {
        List<Map<String, Object>> ls = db.Query("SELECT * FROM category");
        List<Category> list = new ArrayList<>();
        for (Map<String, Object> ele : ls) {
            Category c = new Category();
            c.setId(Integer.parseInt(String.valueOf(ele.get("id"))));
            c.setName(String.valueOf(ele.get("name")));
            list.add(c);
        }
        return list;
    }

    public List<Category> GetCategoriesByFilmId(int film_id) {
        List<Map<String, Object>> ls = db.Query("SELECT C.* FROM category_film CF LEFT JOIN category C ON CF.category_id = C.id LEFT JOIN film F ON CF.film_id = F.id WHERE F.id = " + film_id);
        List<Category> list = new ArrayList<>();
        for (Map<String, Object> ele : ls) {
            Category c = new Category();
            c.setId(Integer.parseInt(String.valueOf(ele.get("id"))));
            c.setName(String.valueOf(ele.get("name")));
            list.add(c);
        }
        return list;
    }

}
