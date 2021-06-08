package com.maison.wiki.controller;

import com.maison.wiki.req.EbookReq;
import com.maison.wiki.resp.CommonResp;
import com.maison.wiki.resp.EbookResp;
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

    @GetMapping("/list")
    public CommonResp list (EbookReq req) {
        CommonResp<List<EbookResp> > responses = new CommonResp<>();
        List<EbookResp> list = ebookService.list(req);
        responses.setContent(list);
        return responses;
    }
}
