/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.noname.model;

/**
 *
 * @author Minh
 */
public class Category_film {

    private int category_id;
    private int film_id;

    public int getCategoryId() {
        return category_id;
    }

    public void setCategoryId(int category_id) {
        this.category_id = category_id;
    }

    public int getFilmId() {
        return this.film_id;
    }

    public void setFilmId(int film_id) {
        this.film_id = film_id;
    }
}
