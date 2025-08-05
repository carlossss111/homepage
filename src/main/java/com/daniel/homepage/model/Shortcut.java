package com.daniel.homepage.model;

import java.net.URI;

import org.springframework.lang.Nullable;

public class Shortcut {
    private static final String imageBaseUrl = "/images/shortcuts/";
    private URI imageurl;
    private URI hyperlinkurl;
    @Nullable private String alttext;

    public Shortcut(String shortcutUrl, String imageUrl, String altText){
        this.hyperlinkurl= URI.create(shortcutUrl);
        this.imageurl = URI.create(imageBaseUrl + imageUrl);
        this.alttext = altText;
    }

    public void setImageurl(URI imageUrl) {
        this.imageurl = imageUrl;
    }

    public void setHyperlinkurl(URI hyperlinkUrl) {
        this.hyperlinkurl = hyperlinkUrl;
    }

    public void setAlttext(String alttext) {
        this.alttext = alttext;
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

    public String getAlttext() {
        return alttext;
    }
}
