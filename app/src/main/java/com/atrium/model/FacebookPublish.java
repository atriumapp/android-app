package com.atrium.model;

/**
 * Created by romain on 05/07/2016.
 */
public class FacebookPublish {

    private String id = "";
    private String name = "";

    public FacebookPublish() {
    }

    public FacebookPublish(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
