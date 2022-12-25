package com.example.menu.modelss;

public class NewslLetterModel {
    String name, img, date , link;

    public NewslLetterModel() {

    }

    public NewslLetterModel(String name, String img, String date, String link) {
        this.name = name;
        this.img = img;
        this.date = date;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}
