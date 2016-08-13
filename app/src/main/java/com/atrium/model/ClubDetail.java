package com.atrium.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by A613792 on 06/07/2016.
 */
public class ClubDetail extends Club{
    private FacebookPublish facebook_publish = new FacebookPublish();
    List<Author> members = new LinkedList<>();


    public ClubDetail() {
    }

    public ClubDetail(FacebookPublish facebook_publish, String name, List<Author> members, String logo, String description, String facebook_page, String id, String slug) {
        super(name, logo, description, facebook_page, id, slug);
        this.facebook_publish = facebook_publish;
        this.members = members;
    }

    public FacebookPublish getFacebook_publish() {
        return facebook_publish;
    }

    public void setFacebook_publish(FacebookPublish facebook_publish) {
        this.facebook_publish = facebook_publish;
    }

}
