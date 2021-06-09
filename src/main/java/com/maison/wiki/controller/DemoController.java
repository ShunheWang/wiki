package com.maison.wiki.controller;

import com.maison.wiki.entity.Demo;
import com.maison.wiki.service.DemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @RestController: 返回一个html页面
 * @Controller: 返回一个String字符串
 */

@RestController
public class DemoController {

    @Resource
    private DemoService demoService;

    @GetMapping("/demo1/list")
    public List<Demo> list () {
        return demoService.list();
    }
}
