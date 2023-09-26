package com.example.secureapplication.data;

import org.springframework.stereotype.Component;

@Component
public class AboutApp {
    private static final String appInfoTemplate = "This is a public resource";

    public String aboutApp() {
        return appInfoTemplate;
    }
}
