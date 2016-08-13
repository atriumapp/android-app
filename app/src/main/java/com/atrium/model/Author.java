package com.atrium.model;

import java.util.Date;

/**
 * Created by A613792 on 07/07/2016.
 */
public class Author {
    private String biography = null;
    private Date birthday = null;
    private String facebook_id = null;
    private String first_name = null;
    private String id = null;
    private String last_name = null;
    private String photo = null;
    private String twitter_id = null;
    private String user = null;

    public Author() {
    }

    public Author(String biography, Date birthday, String facebook_id, String first_name, String id, String last_name, String photo, String twitter_id, String user) {
        this.biography = biography;
        this.birthday = birthday;
        this.facebook_id = facebook_id;
        this.first_name = first_name;
        this.id = id;
        this.last_name = last_name;
        this.photo = photo;
        this.twitter_id = twitter_id;
        this.user = user;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getFacebook_id() {
        return facebook_id;
    }

    public void setFacebook_id(String facebook_id) {
        this.facebook_id = facebook_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getTwitter_id() {
        return twitter_id;
    }

    public void setTwitter_id(String twitter_id) {
        this.twitter_id = twitter_id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getName(){
        return String.format("%s %s", this.last_name, this.first_name);
    }
}
