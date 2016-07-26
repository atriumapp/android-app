package com.atrium.event.pojo;

import java.util.Date;

/**
 * Created by A613792 on 07/07/2016.
 */
public class Event {
    private String club = null;
    private String description = null;
    private String end_date = null;
    private String facebook_id = null;
    private String name = null;
    private Place place = null;
    private String poster = null;
    private String start_date = null;

    public Event() {
    }

    public Event(String club, String description, String end_date, String facebook_id, String name, Place place, String poster, String start_date) {
        this.club = club;
        this.description = description;
        this.end_date = end_date;
        this.facebook_id = facebook_id;
        this.name = name;
        this.place = place;
        this.poster = poster;
        this.start_date = start_date;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFacebook_id() {
        return facebook_id;
    }

    public void setFacebook_id(String facebook_id) {
        this.facebook_id = facebook_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }
}
