package com.atrium.model;

/**
 * Created by A613792 on 07/07/2016.
 */
public class Media {
    private String name = null;
    private String url = null;

    public Media() {
    }

    public Media(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
