package com.daniel.homepage.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.daniel.homepage.model.Weather;
import com.daniel.homepage.service.DateService;
import com.daniel.homepage.service.ShortcutService;
import com.daniel.homepage.service.WallpaperService;
import com.daniel.homepage.service.WeatherService;


@Controller
public class HomepageController {
    private static final String INDEX_HTML = "index";

    @Autowired
    private DateService dateService;

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private WallpaperService wallpaperService;

    @Autowired
    private ShortcutService shortcutService;

    @GetMapping("/")
    public String getHomepage(Model model) {
        Weather weather = weatherService.getWeather();
        model.addAttribute("weather", weather);
        model.addAttribute("wallpaper", wallpaperService.getWallpaper(weather.getAdjective()));
        model.addAttribute("datestr", dateService.getDayStr(LocalDateTime.now()));
        model.addAttribute("shortcuts", shortcutService.getShortcuts());
        return INDEX_HTML;
    }
    
}
