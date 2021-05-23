package com.maison.wiki.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController: 返回一个html页面
 * @Controller: 返回一个String字符串
 */

@RestController
public class TestController {

//    @RequestMapping("/hello")
    @GetMapping("/hello")
    public String hello () {
        return "Hello Maison";
    }

    @PostMapping("/hello/post")
    public String helloPost (String name) {
        return "Hello Maison, Post Request !, " + name;
    }
}
