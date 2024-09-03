package com.cloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NavigationController {

    @RequestMapping("/home")
    public String home()
    {
        return "home";
    }



    @RequestMapping("/settings")
    public String settings()
    {
        return "settings";
    }
    @RequestMapping("/upload")
    public String upload()
    {
        return "upload";
    }

}
