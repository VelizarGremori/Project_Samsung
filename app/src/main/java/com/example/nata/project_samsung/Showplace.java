package com.example.nata.project_samsung;


public class Showplace {

    long id;
    String description;
    String title;
    String address;
    String url;
    String markPlace;

    public Showplace(long id, String description, String title, String address, String url, String markPlace) {
        this.id = id;
        this.description = description;
        this.title = title;
        this.address = address;
        this.url = url;
        this.markPlace = markPlace;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMarkPlace() {
        return markPlace;
    }

    public void setMarkPlace(String markPlace) {
        this.markPlace = markPlace;
    }
}
