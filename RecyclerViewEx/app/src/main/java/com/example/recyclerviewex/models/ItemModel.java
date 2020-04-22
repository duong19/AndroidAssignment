package com.example.recyclerviewex.models;

import java.util.Random;



public class ItemModel {
    String title;
    String description;
    String time;
    boolean isFavorite;
    int color;

    public ItemModel(String title, String description, String time) {
        this.title = title;
        this.description = description;
        this.time = time;
        this.isFavorite = false;
        Random random = new Random();
        color = random.nextInt();

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

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
