package com.example.makar_000.muz;

/**
 * Created by makar_000 on 13.04.2017.
 */

import android.graphics.drawable.Drawable;

import java.util.Date;
import java.util.Map;

public class ObjectItem {

    private String id;
    private String title;
    private String description;
    private String date;
    private String category;
    private String image;


    public ObjectItem(String id, String title, String category, String description, String image) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.description = description;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String date) {
        this.title = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String title) {
        this.description = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
//public class Example {
//
//    private String id;
//    private String title;
//    private String description;
//    private String date;
//    private String category;
//    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getDate() {
//        return date;
//    }
//
//    public void setDate(String date) {
//        this.date = date;
//    }
//
//    public String getCategory() {
//        return category;
//    }
//
//    public void setCategory(String category) {
//        this.category = category;
//    }
//
//    public Map<String, Object> getAdditionalProperties() {
//        return this.additionalProperties;
//    }
//
//    public void setAdditionalProperty(String name, Object value) {
//        this.additionalProperties.put(name, value);
//    }
//
//}
