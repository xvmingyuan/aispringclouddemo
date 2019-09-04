package com.xmy.controller;

import com.xmy.entity.Type;
import com.xmy.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/type")
public class TypeHandler {
    @Value("${server.port}")
    private String port;

    @Autowired
    private TypeRepository typeRepository;

    @GetMapping("/index")
    public String index() {
        return this.port;
    }

    @GetMapping("/findAll")
    public List<Type> findAll() {
        return typeRepository.findAll();
    }
}
