package com.daniel.homepage.services;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;

import org.springframework.stereotype.Service;

import com.daniel.homepage.entity.Weather;

@Service
public class WeatherService {
    private static final String WEATHER_URL = "https://api.openweathermap.org/data/2.5/weather"; //TODO: move to config
    private static final long HTTP_TIMEOUT = 3;
    
    public void cacheWeather() {
        // In very near future we want to make the HTTP request periodically, then getWeather() will just get from the cache
    }
    
    public Weather getWeather() {
        HttpClient httpClient = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(HTTP_TIMEOUT))
            .build();

        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(WEATHER_URL + "?lat=52.6614528&lon=1.3205504&units=metric&appid=59c1a6efb5ee1aa080e71cdfc6293b6c"))
            .build();

        try{
            HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());
            System.out.println(response.body());
        }
        catch (IOException | InterruptedException e){
            System.out.println("Failed to request the weather! " + e);
        }
        
        return new Weather("todo");
    }
    
}
