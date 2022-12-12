package com.example.menu.modelss;

public class UserModel {
    String email;
    String imageUrl;
    String name;

    UserModel(){

    }

    public UserModel(String email, String imageUrl, String name) {
        this.email = email;
        this.imageUrl = imageUrl;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
