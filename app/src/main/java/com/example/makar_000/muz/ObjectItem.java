package com.example.makar_000.muz;

/**
 * Created by makar_000 on 13.04.2017.
 */

import android.graphics.drawable.Drawable;

import java.util.Date;

public class ObjectItem {

    private Integer id;

    public ObjectItem(Integer id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    private String title;
    private String description;
    private Drawable image;

//    public ObjectItem(String title, String date, Drawable image) {
//        this.title = date;
//        this.description = title;
//        this.image = image;
//    }

    public String getDate() {
        return title;
    }

    public void setDate(String date) {
        this.title = date;
    }

    public String getTitle() {
        return description;
    }

    public void setTitle(String title) {
        this.description = title;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }
}

