package com.maison.wiki.mapper;

import com.maison.wiki.entity.demo;
import com.maison.wiki.entity.demoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface demoMapper {
    long countByExample(demoExample example);

    int deleteByExample(demoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(demo record);

    int insertSelective(demo record);

    List<demo> selectByExample(demoExample example);

    demo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") demo record, @Param("example") demoExample example);

    int updateByExample(@Param("record") demo record, @Param("example") demoExample example);

    int updateByPrimaryKeySelective(demo record);

    int updateByPrimaryKey(demo record);
}