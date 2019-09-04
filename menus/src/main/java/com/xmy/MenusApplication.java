package com.xmy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// 扫描 mybatis xml 的接口路径
@MapperScan("com.xmy.repository")
public class MenusApplication {
    public static void main(String[] args) {
        SpringApplication.run(MenusApplication.class, args);
    }


}
