/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.noname.model;

import java.util.List;

/**
 *
 * @author Minh
 */
public class Schedule {

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

    /**
     * @return the cinema_id
     */
    public int getCinema_id() {
        return cinema_id;
    }

    /**
     * @param cinema_id the cinema_id to set
     */
    public void setCinema_id(int cinema_id) {
        this.cinema_id = cinema_id;
    }

    /**
     * @return the cinema_name
     */
    public String getCinema_name() {
        return cinema_name;
    }

    /**
     * @param cinema_name the cinema_name to set
     */
    public void setCinema_name(String cinema_name) {
        this.cinema_name = cinema_name;
    }

    /**
     * @return the cinema_address
     */
    public String getCinema_address() {
        return cinema_address;
    }

    /**
     * @param cinema_address the cinema_address to set
     */
    public void setCinema_address(String cinema_address) {
        this.cinema_address = cinema_address;
    }

    /**
     * @return the rooms
     */
    public List<Room> getRooms() {
        return rooms;
    }

    /**
     * @param rooms the rooms to set
     */
    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    /**
     * @return the room_id
     */
    public int getRoom_id() {
        return room_id;
    }

    /**
     * @param room_id the room_id to set
     */
    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    /**
     * @return the room_name
     */
    public String getRoom_name() {
        return room_name;
    }

    /**
     * @param room_name the room_name to set
     */
    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    /**
     * @return the start_time
     */
    public String getStart_time() {
        return start_time;
    }

    /**
     * @param start_time the start_time to set
     */
    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    private int id;
    private int film_id;
    private String film_name;
    private String film_poster;
    private int cinema_id;
    private String cinema_name;
    private String cinema_address;
    private List<Room> rooms;
    private int room_id;
    private String room_name;
    private String start_time;
}
