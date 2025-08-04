package com.daniel.homepage.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daniel.homepage.config.MessageConfig;
import com.daniel.homepage.config.WallpaperConfig;
import com.daniel.homepage.model.Wallpaper;

import jakarta.annotation.PostConstruct;

@Service
public class WallpaperService {

    @Autowired
    public WallpaperConfig wallpaperConfig;

    @Autowired
    public MessageConfig messageConfig;

    private Map<String, String> imageMap;

    @PostConstruct
    private void initializeMap(){
        imageMap = Map.ofEntries(
            Map.entry(messageConfig.getSnow(), wallpaperConfig.getSnow()),
            Map.entry(messageConfig.getThunder(), wallpaperConfig.getThunder()),
            Map.entry(messageConfig.getRain(), wallpaperConfig.getRain()),
            Map.entry(messageConfig.getMist(), wallpaperConfig.getMist()),
            Map.entry(messageConfig.getClouds(), wallpaperConfig.getClouds()),
            Map.entry(messageConfig.getBelowZero(), wallpaperConfig.getBelowZero()),
            Map.entry(messageConfig.getVeryHighHeat(), wallpaperConfig.getVeryHighHeat()),
            Map.entry(messageConfig.getHighHeat(), wallpaperConfig.getVeryHighHeat()),
            Map.entry(messageConfig.getHighHumidity(), wallpaperConfig.getHighHumidity()),
            Map.entry(messageConfig.getWind(), wallpaperConfig.getWind()),
            Map.entry(messageConfig.getClear(), wallpaperConfig.getClear())
        );
    }

    public Wallpaper getWallpaper(String weatherAdjective) {
        weatherAdjective = weatherAdjective.toLowerCase();
        if (weatherAdjective == null || imageMap.get(weatherAdjective) == null){
            return new Wallpaper(wallpaperConfig.getClear());
        }

        return new Wallpaper(imageMap.get(weatherAdjective));
    }
}
