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
public class Booking_detail {

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
     * @return the booking_id
     */
    public int getBooking_id() {
        return booking_id;
    }

    /**
     * @param booking_id the booking_id to set
     */
    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }

    /**
     * @return the ticket_id
     */
    public int getTicket_id() {
        return ticket_id;
    }

    /**
     * @param ticket_id the ticket_id to set
     */
    public void setTicket_id(int ticket_id) {
        this.ticket_id = ticket_id;
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
     * @return the seat
     */
    public String getSeat() {
        return seat;
    }

    /**
     * @param seat the seat to set
     */
    public void setSeat(String seat) {
        this.seat = seat;
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }

    private int id;
    private int booking_id;
    private int ticket_id;
    private int schedule_id;
    private String seat;
    private int price;
}
