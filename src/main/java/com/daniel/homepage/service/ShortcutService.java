package com.daniel.homepage.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daniel.homepage.config.ShortcutConfig;
import com.daniel.homepage.model.Shortcut;

@Service
public class ShortcutService {
    @Autowired
    public ShortcutConfig shortcutConfig;

    public List<Shortcut> getShortcuts() {
        int numOfShortcuts = 0;
        try{
            numOfShortcuts = shortcutConfig.getLength();
        }
        catch (Exception e){
            System.out.println("Failed to get shortcuts, can not match as a zip!");
            return new LinkedList<Shortcut>();
        }

        LinkedList<Shortcut> shortcuts = new LinkedList<>();
        for (int i = 0; i < numOfShortcuts; i++){
            shortcuts.add(new Shortcut(shortcutConfig.getUrl(i), shortcutConfig.getImage(i), shortcutConfig.getAlt(i)));
        }
        return shortcuts;
    }
}
