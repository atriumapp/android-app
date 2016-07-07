package com.atrium.event.pojo;

/**
 * Created by A613792 on 07/07/2016.
 */
public class Place {
    private String address = null;
    private String name = null;

    public Place() {
    }

    public Place(String address, String name) {
        this.address = address;
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
