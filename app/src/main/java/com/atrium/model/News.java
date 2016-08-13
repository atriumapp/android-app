package com.atrium.model;

import java.util.List;

/**
 * Created by A613792 on 07/07/2016.
 */
public class News {
    private Author author = null;
    private String club = null;
    private String content = null;
    private String date = null;
    private Boolean draft = null;
    private String headline = null;
    private String id = null;
    private List<Media> medias = null;
    private String name = null;

    public News() {
    }

    public News(Author author, String club, String content, String date, Boolean draft, String headline, String id, List<Media> medias, String name) {
        this.author = author;
        this.club = club;
        this.content = content;
        this.date = date;
        this.draft = draft;
        this.headline = headline;
        this.id = id;
        this.medias = medias;
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean getDraft() {
        return draft;
    }

    public void setDraft(Boolean draft) {
        this.draft = draft;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Media> getMedias() {
        return medias;
    }

    public void setMedias(List<Media> medias) {
        this.medias = medias;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
