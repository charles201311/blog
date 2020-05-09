package com.zhaoliu.blog.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zhaoliu.blog.domain.Blog;

public interface BlogService {

	
	   int deleteByPrimaryKey(Integer id);


	    int insertSelective(Blog record);

	    Blog selectByPrimaryKey(Integer id);


	    int updateByPrimaryKeyWithBLOBs(Blog record);

	    /**
	     * 
	     * @Title: selectList 
	     * @Description: TODO
	     * @param month 用month计算开始和结束时间
	     * @return
	     * @return: List<Map>
	     */
	    List<Map> selectList(String month);

	    //分类列表
	    List<Map> selectTypeList();
	    //导入分类
	    boolean importType(String str);

}
