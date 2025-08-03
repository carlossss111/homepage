package com.daniel.homepage.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.lang.Nullable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

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
    private WeatherConfig mConfig;

    private Weather mCurrentWeather = null;

    @PostConstruct
    @Scheduled(cron = "${weather.refresh_cron}")
    public void setWeather() {
        HttpClient httpClient = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(mConfig.getHttpTimeoutS()))
            .build();

        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(String.format(
                "%s?lat=%f&lon=%f&units=%s&appid=%s",
                mConfig.getBaseUrl(), 
                mConfig.getLatitude(), 
                mConfig.getLongitude(), 
                mConfig.getUnits(), 
                mConfig.getApiKey()
            )))
            .build();

        try{
            HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());
            System.out.println("Request: " + response);

            mCurrentWeather = new ObjectMapper().readValue(response.body(), Weather.class);
            System.out.println("Weather model: " + mCurrentWeather);
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
        return mCurrentWeather;
    }
    
}
