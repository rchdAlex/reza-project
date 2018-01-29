package com.example.alexrichard.reza.Model;

import java.util.Date;

/**
 * Created by alex.richard on 17/01/2018.
 */

public class Booking {

    private Room room;
    private Date date;

    public Booking(Room room, Date date) {
        this.room = room;
        this.date = date;
    }

    public Room getRoom() {
        return room;
    }

    public Booking setRoom(Room room) {
        this.room = room;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public Booking setDate(Date date) {
        this.date = date;
        return this;
    }
}
