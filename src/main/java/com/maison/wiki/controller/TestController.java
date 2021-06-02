package com.maison.wiki.controller;

import com.maison.wiki.entity.Test;
import com.maison.wiki.service.TestService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @RestController: 返回一个html页面
 * @Controller: 返回一个String字符串
 */

@RestController
public class TestController {

    @Value("${test.hello:Maison}")
    private String testHello;

    @Resource
    private TestService testService;

//    @RequestMapping("/hello")
    @GetMapping("/hello")
    public String hello () {
        return "Hello Maison" + testHello;
    }

    @PostMapping("/hello/post")
    public String helloPost (String name) {
        return "Hello Maison, Post Request !, " + name;
    }

    @GetMapping("/test/list")
    public List<Test> list () {
        return testService.list();
    }
}
