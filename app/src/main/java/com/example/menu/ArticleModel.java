package com.example.menu;

public class ArticleModel {
    String img, time, title, name, description;

    public ArticleModel() {

    }

    public ArticleModel(String img, String time, String title, String name, String description) {
        this.img = img;
        this.time = time;
        this.title = title;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}