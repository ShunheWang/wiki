package com.maison.wiki.service;

import com.maison.wiki.entity.Demo;
import com.maison.wiki.mapper.DemoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DemoService {

//    @Autowired spring的 @Resource jdk自带的
    @Resource
    private DemoMapper demoMapper;

    public List<Demo> list(){
        return demoMapper.selectByExample(null);
    }

}
