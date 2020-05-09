package com.zhaoliu.blog.dao;

import java.util.List;
import java.util.Map;

import com.zhaoliu.blog.domain.BlogType;

public interface BlogTypeMapper {
    int deleteByPrimaryKey(Integer tid);

    int insert(BlogType record);

    int insertSelective(BlogType record);

    BlogType selectByPrimaryKey(Integer tid);

    int updateByPrimaryKeySelective(BlogType record);

    int updateByPrimaryKey(BlogType record);
    
    List<Map> selectTypeList();
}