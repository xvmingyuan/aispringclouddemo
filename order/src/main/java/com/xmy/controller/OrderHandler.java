package com.xmy.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class OrderHandler {
    @Value("${server.port}")
    private String port;

    @Value("${eureka.client.serviceUrl.defaultZone}")
    private String defaultZone;

    @GetMapping("/index")
    public String index() {
        return this.port + "-" + this.defaultZone;
    }
}

