package com.daniel.homepage.model;

import java.net.URI;
import java.time.LocalDateTime;

import org.springframework.lang.NonNull;

import com.daniel.homepage.adapter.WeatherDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = WeatherDeserializer.class)
public class Weather {
    private LocalDateTime timeCreated;
    private String descriptor;
    private String summary;
    private String adjective = "";
    private String icon = "10d";
    private URI iconUrl;
    private double temp;
    private double feelsLike;
    private double maxTemp;
    private double minTemp;
    private int pressure;
    private int humidity;
    private double windSpeedKph;
    private double windDirectionDeg;
    private int cloudCover;
    private LocalDateTime sunrise;
    private LocalDateTime sunset;
    private double lat;
    private double lon;
    private String locationName;

    public Weather(){
        this.timeCreated = LocalDateTime.now();
    }

    public void setAdjective(@NonNull String adjective){
        if (adjective != null){
            this.adjective = adjective.toLowerCase();
        }
    }

    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setIconUrl(String prefix, String icon, String suffix) {
        this.iconUrl = URI.create(prefix + icon + suffix);
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public void setFeelsLike(double feelsLike) {
        this.feelsLike = feelsLike;
    }

    public void setMaxTemp(double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public void setMinTemp(double minTemp) {
        this.minTemp = minTemp;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public void setWindSpeedKph(double windSpeed) {
        this.windSpeedKph = windSpeed;
    }

    public void setWindSpeedKphFromMps(double windSpeed) {
        this.windSpeedKph = windSpeed * 3.6;
    }

    public void setWindDirectionDeg(double windDirectionDeg) {
        this.windDirectionDeg = windDirectionDeg;
    }

    public void setCloudCover(int cloudCover) {
        this.cloudCover = cloudCover;
    }

    public void setSunrise(LocalDateTime sunrise) {
        this.sunrise = sunrise;
    }

    public void setSunset(LocalDateTime sunset) {
        this.sunset = sunset;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getAdjective(){
        if (adjective != null)
            return adjective;
        return "";
    }

    public String getDescriptor() {
        return descriptor;
    }

    public String getSummary() {
        return summary;
    }

    public double getTemp() {
        return temp;
    }

    public double getFeelsLike() {
        return feelsLike;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public int getPressure() {
        return pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public double getWindSpeedKph() {
        return windSpeedKph;
    }

    public double getWindDirectionDeg() {
        return windDirectionDeg;
    }

    public int getCloudCover() {
        return cloudCover;
    }

    public LocalDateTime getSunrise() {
        return sunrise;
    }

    public LocalDateTime getSunset() {
        return sunset;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public String getLocationName() {
        return locationName;
    }

    public LocalDateTime getTimeCreated(){
        return timeCreated;
    }

    public String getIcon() {
        return icon;
    }

    public URI getIconUrl() {
        return iconUrl;
    }

    @Override
    public String toString(){
        return String.format("[%s]<timeCreated=%s, adjective=%s, descriptor=%s, summary=%s, temp=%f"
            + ", feelsLike=%f, maxTemp=%f, minTemp=%f, pressure=%d, humidity=%d, windSpeed=%f, windDirectionDeg=%f"
            + ", cloudCover=%d, sunrise=%s, sunset=%s, lat=%f, lon=%f, location=%s>",
            super.toString(), timeCreated.toString(), adjective, descriptor, summary, temp, feelsLike, maxTemp, minTemp, pressure,
            humidity, windSpeedKph, windDirectionDeg, cloudCover, sunrise.toString(), sunset.toString(),
            lat, lon, locationName);
    }

}
