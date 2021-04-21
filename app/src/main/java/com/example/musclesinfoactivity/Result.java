package com.example.musclesinfoactivity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Result {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("is_front")
    @Expose
    private Boolean isFront;
    @SerializedName("image_url_main")
    @Expose
    private String imageUrlMain;
    @SerializedName("image_url_secondary")
    @Expose
    private String imageUrlSecondary;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsFront() {
        return isFront;
    }

    public void setIsFront(Boolean isFront) {
        this.isFront = isFront;
    }

    public String getImageUrlMain() {
        return imageUrlMain;
    }

    public void setImageUrlMain(String imageUrlMain) {
        this.imageUrlMain = imageUrlMain;
    }

    public String getImageUrlSecondary() {
        return imageUrlSecondary;
    }

    public void setImageUrlSecondary(String imageUrlSecondary) {
        this.imageUrlSecondary = imageUrlSecondary;
    }

}