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

}
