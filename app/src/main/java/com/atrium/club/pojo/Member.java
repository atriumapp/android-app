package com.atrium.club.pojo;

/**
 * Created by romain on 05/07/2016.
 */
public class Member {

    private String birthday = "";
    private String first_name = "";
    private String last_name = "";
    private String user = "";
    private String facebook_id = "";
    private String photo = "";
    private String id = "";
    private String biography = "";
    private String twitter_id = "";

    public Member() {
    }

    public Member(String birthday, String first_name, String last_name, String user, String facebook_id, String photo, String id, String biography, String twitter_id) {
        this.birthday = birthday;
        this.first_name = first_name;
        this.last_name = last_name;
        this.user = user;
        this.facebook_id = facebook_id;
        this.photo = photo;
        this.id = id;
        this.biography = biography;
        this.twitter_id = twitter_id;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getFacebook_id() {
        return facebook_id;
    }

    public void setFacebook_id(String facebook_id) {
        this.facebook_id = facebook_id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getTwitter_id() {
        return twitter_id;
    }

    public void setTwitter_id(String twitter_id) {
        this.twitter_id = twitter_id;
    }
}
