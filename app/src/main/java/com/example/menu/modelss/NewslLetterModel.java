package com.example.menu.modelss;

public class NewslLetterModel {
    String name, img, date;

    public NewslLetterModel() {

    }

    public NewslLetterModel(String name, String img, String date) {
        this.name = name;
        this.img = img;
        this.date = date;

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
