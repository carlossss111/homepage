package com.daniel.homepage.model;

import java.net.URI;

public class Shortcut {
    private static final String imageBaseUrl = "/images/shortcuts/";
    private URI imageurl;
    private URI hyperlinkurl;

    public Shortcut(String shortcutUrl, String imageUrl){
        this.hyperlinkurl= URI.create(shortcutUrl);
        this.imageurl = URI.create(imageBaseUrl + imageUrl);
    }

    public void setImageurl(URI imageUrl) {
        this.imageurl = imageUrl;
    }

    public void setHyperlinkurl(URI hyperlinkUrl) {
        this.hyperlinkurl = hyperlinkUrl;
    }

    public static String getImagebaseurl() {
        return imageBaseUrl;
    }

    public URI getImageurl() {
        return imageurl;
    }

    public URI getHyperlinkurl() {
        return hyperlinkurl;
    }
}
