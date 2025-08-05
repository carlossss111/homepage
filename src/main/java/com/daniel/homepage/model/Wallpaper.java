package com.daniel.homepage.model;

import java.net.URI;

public class Wallpaper {
    private static final String baseUrl = "/images/backgrounds/";
    private URI imageUrl;

    public Wallpaper(String imageUrl){
        this.imageUrl = URI.create(baseUrl + imageUrl);
    }

    public URI getImageUrl(){
        return imageUrl;
    }
}
