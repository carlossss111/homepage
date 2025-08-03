package com.daniel.homepage.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "weather")
public class WeatherConfig {
    private String refreshCron;
    private int httpTimeoutS;
    private String baseUrl;
    private double latitude;
    private double longitude;
    private String units;
    private String apiKey;
    private int freezingTemp;
    private int highTemp;
    private int veryHighTemp;
    private int highHumidity;
    private int highWindspeed; 

    public void setRefreshCron(String refreshCron) {
        this.refreshCron = refreshCron;
    }

    public void setHttpTimeoutS(int httpTimeoutS) {
        this.httpTimeoutS = httpTimeoutS;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public void setFreezingTemp(int freezingTemp) {
        this.freezingTemp = freezingTemp;
    }

    public void setHighTemp(int highTemp) {
        this.highTemp = highTemp;
    }

    public void setVeryHighTemp(int veryHighTemp) {
        this.veryHighTemp = veryHighTemp;
    }

    public void setHighHumidity(int highHumidity) {
        this.highHumidity = highHumidity;
    }

    public void setHighWindspeed(int highWindspeed) {
        this.highWindspeed = highWindspeed;
    }

    public String getRefreshCron(){
        return refreshCron;
    }

    public int getHttpTimeoutS() {
        return httpTimeoutS;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getUnits() {
        return units;
    }

    public String getApiKey() {
        return apiKey;
    }

    public int getFreezingTemp() {
        return freezingTemp;
    }

    public int getHighTemp() {
        return highTemp;
    }

    public int getVeryHighTemp() {
        return veryHighTemp;
    }

    public int getHighHumidity() {
        return highHumidity;
    }

    public int getHighWindspeed() {
        return highWindspeed;
    }
    
}
