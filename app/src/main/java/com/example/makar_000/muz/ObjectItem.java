package com.example.makar_000.muz;


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
