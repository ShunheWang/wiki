package com.maison.wiki.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController: 返回一个html页面
 * @Controller: 返回一个String字符串
 */

@RestController
public class TestController {

    @RequestMapping("/hello")
    public String hello () {
        return "hello Maison";
    }
}
