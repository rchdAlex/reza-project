package com.example.alexrichard.reza.Model;

import java.util.ArrayList;
import java.util.List;


public class Room
{
    private String name;
    private int number;
    private ArrayList<List> listeResa;

    /**
     * @param name
     * @param number
     */
    public Room(String name, int number){
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    /**
     * @param name
     * @return
     */
    public Room setName(String name) {
        this.name = name;
        return this;
    }

    public int getNumber() {
        return number;
    }

    public Room setNumber(int number) {
        this.number = number;
        return this;
    }

}
