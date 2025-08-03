package com.daniel.homepage.model;

import java.time.LocalDateTime;

import com.daniel.homepage.adapter.WeatherDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = WeatherDeserializer.class)
public class Weather {
    public String descriptor;
    public String summary;
    public double temp;
    public double feelsLike;
    public double maxTemp;
    public double minTemp;
    public int pressure;
    public int humidity;
    public double windSpeed;
    public double windDirectionDeg;
    public int cloudCover;
    public LocalDateTime sunrise;
    public LocalDateTime sunset;
    public double lat;
    public double lon;
    public String locationName;

    @Override
    public String toString(){
        return String.format("[%s]<descriptor=%s, summary=%s, temp=%f, feelsLike=%f, maxTemp=%f, minTemp=%f"
            + ", pressure=%d, humidity=%d, windSpeed=%f, windDirectionDeg=%f, cloudCover=%d, "
            + "sunrise=%s, sunset=%s, lat=%f, lon=%f, location=%s>",
            super.toString(), descriptor, summary, temp, feelsLike, maxTemp, minTemp, pressure,
            humidity, windSpeed, windDirectionDeg, cloudCover, sunrise.toString(), sunset.toString(),
            lat, lon, locationName);
    }
}
