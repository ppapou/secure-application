package com.example.secureapplication.data;

import org.springframework.stereotype.Component;

@Component
public class AppInfo {

//TODO: probably property file should be created with appNam, verstion etc...
    private static final String appInfoTemplate = "This a secure application";

    public String getAppInfoTemplate() {
        return appInfoTemplate;
    }
}
