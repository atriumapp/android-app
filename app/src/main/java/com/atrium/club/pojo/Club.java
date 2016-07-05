package com.atrium.club.pojo;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by romain on 05/07/2016.
 */
public class Club {
    private FacebookPublish facebook_publish = new FacebookPublish();
    private String name = "";
    List<Member> members = new LinkedList<>();
    private String logo = "";
    private String description = "";
    private String facebook_page = "";
    private String id = "";
    private String slug = "";

    public Club() {
    }

    public Club(FacebookPublish facebook_publish, String name, List<Member> members, String logo, String description, String facebook_page, String id, String slug) {
        this.facebook_publish = facebook_publish;
        this.name = name;
        this.members = members;
        this.logo = logo;
        this.description = description;
        this.facebook_page = facebook_page;
        this.id = id;
        this.slug = slug;
    }

    public FacebookPublish getFacebook_publish() {
        return facebook_publish;
    }

    public void setFacebook_publish(FacebookPublish facebook_publish) {
        this.facebook_publish = facebook_publish;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
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
