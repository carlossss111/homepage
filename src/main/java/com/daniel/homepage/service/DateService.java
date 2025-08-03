package com.daniel.homepage.service;

import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.Locale;

import org.springframework.stereotype.Service;

@Service
public class DateService {
    private static final Locale M_LOCALE = Locale.ENGLISH;

    public String getDayStr(LocalDateTime dt){
        return dt.getDayOfWeek().getDisplayName(TextStyle.FULL, M_LOCALE).toLowerCase();
    }
    
}
