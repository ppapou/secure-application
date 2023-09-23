package com.example.secureapplication.rest;


import com.example.secureapplication.data.AppInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


//TODO: add API version path
//service layer
@Slf4j
@RestController
public class AppController {

    private final AppInfo appInfo;

    public AppController(AppInfo appInfo) {
        this.appInfo = appInfo;
    }
    @GetMapping("/info")
    public String getInfo() {
        log.info("Trying to get the application info resource");
        return appInfo.getAppInfoTemplate();
    }

    @GetMapping("/user")
    public void getUserInfo(){
        log.info("User resource place holder");
    }
}
