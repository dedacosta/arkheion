package net.mephys.arkheion.eureka.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    public String getHome(){
        return "Home";
    }
}
