package com.daniel.homepage.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.daniel.homepage.service.DateService;
import com.daniel.homepage.service.WeatherService;


@Controller
public class HomepageController {
    private static final String INDEX_HTML = "index";

    @Autowired
    private DateService mDateService;

    @Autowired
    private WeatherService mWeatherService;

    @GetMapping("/")
    public String getHomepage(Model model) {
        model.addAttribute("dateStr", mDateService.getDayStr(LocalDateTime.now()));
        model.addAttribute("weather", mWeatherService.getWeather());
        return INDEX_HTML;
    }
    
}
