package com.daniel.homepage.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.lang.Nullable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.daniel.homepage.config.MessageConfig;
import com.daniel.homepage.config.WeatherConfig;
import com.daniel.homepage.model.Weather;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.annotation.PostConstruct;

@Service
@EnableScheduling
@EnableConfigurationProperties(WeatherConfig.class)
public class WeatherService {

    @Autowired
    private WeatherConfig weatherConfig;

    @Autowired
    private MessageConfig messageConfig;

    private Weather currentWeather = null;

    private String decideAdjective(final Weather weather){
        String descriptor = weather.descriptor.toLowerCase();

        Map<String, String> adjectiveMap = Map.of(
            "snow", messageConfig.getSnow(),
            "thunderstorm", messageConfig.getThunder(),
            "rain", messageConfig.getRain(),
            "drizzle", messageConfig.getRain(),
            "mist", messageConfig.getMist(),
            "clouds", messageConfig.getClouds()
        );

        if(descriptor.matches("snow|thunderstorm|rain|drizzle|mist"))
            return adjectiveMap.get(descriptor);

        if(weather.temp <= weatherConfig.getFreezingTemp())
            return messageConfig.getBelowZero();

        if(weather.temp >= weatherConfig.getVeryHighTemp())
            return messageConfig.getVeryHighHeat();
            
        if(weather.temp >= weatherConfig.getHighTemp())
            return messageConfig.getHighHeat();

        if(weather.humidity >= weatherConfig.getHighHumidity())
            return messageConfig.getHighHumidity();

        if(weather.windSpeed >= weatherConfig.getHighWindspeed())
            return messageConfig.getWind();

        if(adjectiveMap.get(descriptor) != null) // 'clouds' should be the only value left
            return adjectiveMap.get(descriptor);

        return messageConfig.getClear();
    }

    @PostConstruct
    @Scheduled(cron = "${weather.refresh_cron}")
    public void setWeather() {
        HttpClient httpClient = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(weatherConfig.getHttpTimeoutS()))
            .build();

        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(String.format(
                "%s?lat=%f&lon=%f&units=%s&appid=%s",
                weatherConfig.getBaseUrl(), 
                weatherConfig.getLatitude(), 
                weatherConfig.getLongitude(), 
                weatherConfig.getUnits(), 
                weatherConfig.getApiKey()
            )))
            .build();

        try{
            HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());
            System.out.println("Request: " + response);

            currentWeather = new ObjectMapper().readValue(response.body(), Weather.class);
            System.out.println("Weather model: " + currentWeather);
            
            currentWeather.setAdjective(decideAdjective(currentWeather));
            System.out.println("Adjective chosen: " + currentWeather.adjective);
        }
        catch (JsonProcessingException e){
            System.out.println("Failed to read the weather json! " + e);
        }
        catch (IOException |  InterruptedException e){
            System.out.println("Failed to request the weather! " + e);
        }
    }
    
    @Nullable
    public Weather getWeather() {
        return currentWeather;
    }
    
}
