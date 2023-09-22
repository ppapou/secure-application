package com.example.secureapplication.rest;


import com.example.secureapplication.data.AppInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


//TODO: add API version path
//service layer

@RestController
public class AppController {

    private final AppInfo appInfo;

    public AppController(AppInfo appInfo) {
        this.appInfo = appInfo;
    }
    @GetMapping("/info")
    public String getInfo() {
        return appInfo.getAppInfoTemplate();
    }
}
