package com.maison.wiki.service;

import com.maison.wiki.entity.Test;
import com.maison.wiki.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestService {

//    @Autowired spring的 @Resource jdk自带的
    @Resource
    private TestMapper testMapper;

    public List<Test> list(){
        return testMapper.list();
    }

}
