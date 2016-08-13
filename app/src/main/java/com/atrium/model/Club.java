package com.atrium.model;

import java.util.List;

/**
 * Created by romain on 05/07/2016.
 */
public class Club {
    private String name = "";
    private String logo = "";
    private String description = "";
    private String facebook_page = "";
    private String id = "";
    private String slug = "";

    public Club() {
    }

    public Club(String name, String logo, String description, String facebook_page, String id, String slug) {
        this.name = name;
        this.logo = logo;
        this.description = description;
        this.facebook_page = facebook_page;
        this.id = id;
        this.slug = slug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFacebook_page() {
        return facebook_page;
    }

    public void setFacebook_page(String facebook_page) {
        this.facebook_page = facebook_page;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }
}
