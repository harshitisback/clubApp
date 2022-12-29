package com.example.menu;

public class BlogModel {
String img, time, title, date, description;

    public BlogModel() {

    }

    public BlogModel(String img, String time, String title, String date, String description) {
        this.img = img;
        this.time = time;
        this.title = title;
        this.date = date;
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
