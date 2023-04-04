package me.minikuma._02_structual_patterns._11_flyweight._02_after;

import java.util.HashMap;
import java.util.Map;

public class FontFactory {
    private Map<String, Font> cache = new HashMap<>();

    public Font getFont(String font) {
        if (cache.containsKey(font)) {
            return cache.get(font);
        } else {
            String[] str = font.split(":");
            Font newFont = new Font(str[0], Integer.parseInt(str[1]));
            cache.put(font, newFont);
            return newFont;
        }
    }
}
