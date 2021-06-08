package com.maison.wiki.controller;

import com.maison.wiki.entity.Ebook;
import com.maison.wiki.resp.CommonResp;
import com.maison.wiki.service.EbookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @RestController: 返回一个html页面
 * @Controller: 返回一个String字符串
 */

@RestController
public class EbookController {

    @Resource
    private EbookService ebookService;

    @GetMapping("/ebook/list")
    public CommonResp list () {
        CommonResp<List<Ebook>> responses = new CommonResp<>();
        List<Ebook> ebooks = ebookService.list();
        responses.setContent(ebooks);
        return responses;
    }
}
