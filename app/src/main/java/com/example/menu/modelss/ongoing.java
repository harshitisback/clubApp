package com.example.menu.modelss;

public class ongoing {

    String name;
    String mode;
    String date;
    String urlImg;
    String link;

    public ongoing() {

    }

    public ongoing(String name, String mode, String date, String urlImg, String link) {
        this.name = name;
        this.mode = mode;
        this.date = date;
        this.urlImg = urlImg;
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }
}
