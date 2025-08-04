package com.daniel.homepage.model;

public class Wallpaper {
    private static final String baseUrl = "/images/";

    private String imageUrl;
        public Wallpaper(String imageUrl){
        this.imageUrl = baseUrl + imageUrl;
    }

    public String getImageUrl(){
        return imageUrl;
    }
}
