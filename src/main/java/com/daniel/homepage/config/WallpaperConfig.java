package com.daniel.homepage.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "wallpaper")
@Configuration
public class WallpaperConfig {
    private String snow;
    private String thunder;
    private String rain;
    private String mist;
    private String clouds;
    private String belowZero;
    private String veryHighHeat;
    private String highHeat;
    private String highHumidity;
    private String wind;
    private String clear;

    public void setSnow(String snow) {
        this.snow = snow;
    }

    public void setThunder(String thunder) {
        this.thunder = thunder;
    }

    public void setRain(String rain) {
        this.rain = rain;
    }

    public void setMist(String mist) {
        this.mist = mist;
    }

    public void setClouds(String clouds) {
        this.clouds = clouds;
    }

    public void setBelowZero(String belowZero) {
        this.belowZero = belowZero;
    }

    public void setVeryHighHeat(String veryHighHeat) {
        this.veryHighHeat = veryHighHeat;
    }

    public void setHighHeat(String highHeat) {
        this.highHeat = highHeat;
    }

    public void setHighHumidity(String highHumidity) {
        this.highHumidity = highHumidity;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public void setClear(String clear) {
        this.clear = clear;
    }

    public String getSnow() {
        return snow;
    }

    public String getThunder() {
        return thunder;
    }

    public String getRain() {
        return rain;
    }

    public String getMist() {
        return mist;
    }

    public String getClouds() {
        return clouds;
    }

    public String getBelowZero() {
        return belowZero;
    }

    public String getVeryHighHeat() {
        return veryHighHeat;
    }

    public String getHighHeat() {
        return highHeat;
    }

    public String getHighHumidity() {
        return highHumidity;
    }

    public String getWind() {
        return wind;
    }

    public String getClear() {
        return clear;
    }
}
    