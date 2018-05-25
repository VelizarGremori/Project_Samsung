package com.example.nata.project_samsung;


import android.graphics.Bitmap;

public class Showplace {

    long id;
    String description;
    String title;
    String address;
    String url;
    int markPlace;
    String image;
    Bitmap bitmap;
    double lat, lng;

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Showplace(long id, String title, String description, String address, String url, int markPlace, String image, double lat, double lng) {
        this.id = id;
        this.description = description;
        this.title = title;
        this.address = address;
        this.url = url;
        this.markPlace = markPlace;
        this.image = image;
        this.lat = lat;
        this.lng = lng;

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

    public int getMarkPlace() {
        return markPlace;
    }

    public void setMarkPlace(int markPlace) {
        this.markPlace = markPlace;
    }
}
