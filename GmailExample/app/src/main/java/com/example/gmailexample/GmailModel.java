package com.example.gmailexample;

public class GmailModel {
    String title;
    String description;
    String time;
    boolean isFavorite;
    String color;

    public GmailModel(String title, String description, String time, boolean isFavorite, String color) {
        this.title = title;
        this.description = description;
        this.time = time;
        this.isFavorite = isFavorite;
        this.color = color;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
