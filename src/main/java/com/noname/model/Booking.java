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
public class Booking {

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the user_id
     */
    public int getUser_id() {
        return user_id;
    }

    /**
     * @param user_id the user_id to set
     */
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    /**
     * @return the schedule_id
     */
    public int getSchedule_id() {
        return schedule_id;
    }

    /**
     * @param schedule_id the schedule_id to set
     */
    public void setSchedule_id(int schedule_id) {
        this.schedule_id = schedule_id;
    }

    /**
     * @return the total_price
     */
    public int getTotal_price() {
        return total_price;
    }

    /**
     * @param total_price the total_price to set
     */
    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }

    /**
     * @return the created_at
     */
    public String getCreated_at() {
        return created_at;
    }

    /**
     * @param created_at the created_at to set
     */
    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    /**
     * @return the updated_at
     */
    public String getUpdated_at() {
        return updated_at;
    }

    /**
     * @param updated_at the updated_at to set
     */
    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    /**
     * @return the film_id
     */
    public int getFilm_id() {
        return film_id;
    }

    /**
     * @param film_id the film_id to set
     */
    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    /**
     * @return the film_name
     */
    public String getFilm_name() {
        return film_name;
    }

    /**
     * @param film_name the film_name to set
     */
    public void setFilm_name(String film_name) {
        this.film_name = film_name;
    }

    /**
     * @return the film_poster
     */
    public String getFilm_poster() {
        return film_poster;
    }

    /**
     * @param film_poster the film_poster to set
     */
    public void setFilm_poster(String film_poster) {
        this.film_poster = film_poster;
    }

    private int id;
    private int user_id;
    private int schedule_id;
    private int total_price;
    private String created_at;
    private String updated_at;
    private int film_id;
    private String film_name;
    private String film_poster;
}
