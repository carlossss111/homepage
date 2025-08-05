package com.daniel.homepage.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "shortcut")
@Configuration
public class ShortcutConfig {
    private String[] images;
    private String[] urls;
    private String[] alts;

    public void setImages(String[] images) {
        this.images = images;
    }

    public void setUrls(String[] urls) {
        this.urls = urls;
    }

    public void setAlts(String[] alts) {
        this.alts = alts;
    }

    public String getImage(int index) {
        return images[index];
    }

    public String getUrl(int index) {
        return urls[index];
    }

    public String getAlt(int index) {
        return alts[index];
    }

    public int getLength() throws Exception{
        if (images.length != urls.length){
            throw new Exception("Shortcut image length != Shortcut url length. They cannot be zipped together.");
        }
        return images.length;
    }
}
