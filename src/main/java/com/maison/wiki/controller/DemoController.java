package com.maison.wiki.controller;

import com.maison.wiki.entity.Demo;
import com.maison.wiki.service.DemoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @RestController: 返回一个html页面
 * @Controller: 返回一个String字符串
 */

@RestController
public class DemoController {

    @Value("${demo.hello:Maison}")
    private String demoHello;

    @Resource
    private DemoService demoService;

//    @RequestMapping("/hello")
    @GetMapping("/hello")
    public String hello () {
        return "Hello Maison" + demoHello;
    }

    @PostMapping("/hello/post")
    public String helloPost (String name) {
        return "Hello Maison, Post Request !, " + name;
    }

    @GetMapping("/demo/list")
    public List<Demo> list () {
        return demoService.list();
    }
}
