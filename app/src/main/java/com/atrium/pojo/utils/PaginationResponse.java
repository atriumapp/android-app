package com.atrium.pojo.utils;

import java.util.List;

/**
 * Created by A613792 on 07/07/2016.
 */
public class PaginationResponse<T> {
    private int pages = 0;
    private int next_page = 0;
    private int previous_page = 0;
    private List<T> results;

    public PaginationResponse() {
    }

    public PaginationResponse(int pages, int next_page, int previous_page, List<T> results) {
        this.pages = pages;
        this.next_page = next_page;
        this.previous_page = previous_page;
        this.results = results;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getNext_page() {
        return next_page;
    }

    public void setNext_page(int next_page) {
        this.next_page = next_page;
    }

    public int getPrevious_page() {
        return previous_page;
    }

    public void setPrevious_page(int previous_page) {
        this.previous_page = previous_page;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }
}
