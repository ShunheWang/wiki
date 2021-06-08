package com.maison.wiki.service;

import com.maison.wiki.entity.Ebook;
import com.maison.wiki.mapper.EbookMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EbookService {

//    @Autowired spring的 @Resource jdk自带的
    @Resource
    private EbookMapper ebookMapper;

    public List<Ebook> list(){
        return ebookMapper.selectByExample(null);
    }

}
