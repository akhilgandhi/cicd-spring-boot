package com.myorg.cicdspringboot.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

    @GetMapping(path = "/home")
    public String home() {
        String message = "Hello again from AWS Continuous Delivery!!!";
        try {
            InetAddress ip = InetAddress.getLocalHost();
            message += " using host: " + ip;
        } catch (UnknownHostException e) {
            log.error("Unknown host provided {}", e.getMessage());
        }
        return message;
    }
    
}
