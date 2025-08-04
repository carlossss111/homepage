package com.daniel.homepage.adapter;

import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;

import com.daniel.homepage.model.Weather;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class WeatherDeserializer extends StdDeserializer<Weather>{
    private static final String WEATHER_NODE = "weather";
    private static final int SUMMARY_NODE = 0;
    private static final String MAIN_NODE = "main";
    private static final String WIND_NODE = "wind";
    private static final String CLOUD_NODE = "clouds";
    private static final String SUN_NODE = "sys";
    private static final String COORDS_NODE = "coord";
    private static final String WEATHER_NAME = "main";
    private static final String DESCRIPTION = "description";
    private static final String TEMPERATURE = "temp";
    private static final String TEMPERATURE_MIN = "temp_min";
    private static final String TEMPERATURE_MAX = "temp_max";
    private static final String TEMPERATURE_FEELS_LIKE = "feels_like";
    private static final String PRESSURE = "pressure";
    private static final String HUMIDITY = "humidity";
    private static final String WIND_SPEED = "speed";
    private static final String WIND_DIRECTION = "deg";
    private static final String CLOUDS_ALL = "all";
    private static final String SUNRISE = "sunrise";
    private static final String SUNSET = "sunset";
    private static final String LOCATION = "name";
    private static final String LAT = "lat";
    private static final String LON = "lon";

    public WeatherDeserializer() { 
        this(null); 
    } 

    public WeatherDeserializer(Class<?> vc) { 
        super(vc); 
    }

    @Override
    public Weather deserialize(JsonParser jp, DeserializationContext ctxt) 
      throws IOException, JsonProcessingException {

        JsonNode root = jp.getCodec().readTree(jp);
        Weather weather = new Weather();

        JsonNode summaryNode = root.get(WEATHER_NODE).get(SUMMARY_NODE);
        weather.setDescriptor(
            summaryNode.get(WEATHER_NAME).asText());
        weather.setSummary(
            summaryNode.get(DESCRIPTION).asText());

        JsonNode mainNode = root.get(MAIN_NODE);
        weather.setTemp(
            mainNode.get(TEMPERATURE).asDouble());
        weather.setMinTemp(
            mainNode.get(TEMPERATURE_MIN).asDouble());
        weather.setMaxTemp(
            mainNode.get(TEMPERATURE_MAX).asDouble());
        weather.setFeelsLike(
            mainNode.get(TEMPERATURE_FEELS_LIKE).asDouble());
        weather.setPressure(
            mainNode.get(PRESSURE).asInt());
        weather.setHumidity(
            mainNode.get(HUMIDITY).asInt());

        JsonNode windNode = root.get(WIND_NODE);
        weather.setWindSpeed(
            windNode.get(WIND_SPEED).asDouble());
        weather.setWindDirectionDeg(
            windNode.get(WIND_DIRECTION).asDouble());

        JsonNode cloudNode = root.get(CLOUD_NODE);
        weather.setCloudCover(
            cloudNode.get(CLOUDS_ALL).asInt());

        JsonNode sunNode = root.get(SUN_NODE);
        weather.setSunrise(Instant.ofEpochSecond(sunNode.get(SUNRISE).asLong())
            .atZone(ZoneId.systemDefault()) 
            .toLocalDateTime());
        weather.setSunset(Instant.ofEpochSecond(sunNode.get(SUNSET).asLong())
            .atZone(ZoneId.systemDefault()) 
            .toLocalDateTime());

        JsonNode coordsNode  = root.get(COORDS_NODE);
        weather.setLocationName(
            root.get(LOCATION).asText());
        weather.setLat(
            coordsNode.get(LAT).asDouble());
        weather.setLon(
            coordsNode.get(LON).asDouble());

        return weather;
    }
    
}
