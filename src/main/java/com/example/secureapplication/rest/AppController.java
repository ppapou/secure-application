package com.example.secureapplication.rest;


import com.example.secureapplication.data.AboutApp;
import com.example.secureapplication.data.AppInfo;
import com.example.secureapplication.service.AppUserDetailsService;
import com.example.secureapplication.user.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


//TODO: add API version path
//service layer
@Slf4j
@RestController
public class AppController {

    private final AppInfo appInfo;
    private final AboutApp aboutApp;

    private final AppUserDetailsService userDetailsService;

    public AppController(AppInfo appInfo, AboutApp aboutApp, AppUserDetailsService userDetailsService) {

        this.appInfo = appInfo;
        this.aboutApp = aboutApp;
        this.userDetailsService = userDetailsService;
    }
    @GetMapping("/info")
    public String getInfo() {
        log.info("Trying to get the application info resource");
        return appInfo.getAppInfoTemplate();
    }

    @GetMapping("/about")
    public String about() {
        log.info("Trying to get the public resource");
        return aboutApp.aboutApp();
    }

    @GetMapping("/user")
    public void getUserInfo(){
        log.info("User resource place holder");
    }

    @PostMapping("/user")
    public void createUser(@RequestBody User user) {
        userDetailsService.createUser(user);
    }
}
