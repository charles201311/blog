package com.zhaoliu.blog.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhaoliu.blog.dao.BlogMapper;
import com.zhaoliu.blog.dao.BlogTypeMapper;
import com.zhaoliu.blog.domain.Blog;
import com.zhaoliu.blog.domain.BlogType;
import com.zhaoliu.blog.utils.DateUtil;

@Service
public class BlogServiceImpl implements BlogService {

	@Resource
	private BlogMapper  blogMapper;
	@Resource
	private BlogTypeMapper  blogTypeMapper;
	
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return blogMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insertSelective(Blog record) {
		// TODO Auto-generated method stub
		return blogMapper.insertSelective(record);
	}

	@Override
	public Blog selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return blogMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeyWithBLOBs(Blog record) {
		// TODO Auto-generated method stub
		return blogMapper.updateByPrimaryKeyWithBLOBs(record);
	}

	@Override
	public List<Map> selectList(String month) {
		String startTime="";
		String endTime="";
		//调用工具类获取指定时间
		if(!"".equals(month) && !"undefined".equals(month)) {
			if(!"".equals(month) &&month.equals("1")) {//获取当前月的月初和月末
				startTime = DateUtil.getDateByInitMonth(new Date());
				endTime =  DateUtil.getDateByFullMonth(new Date());
			}else {
				//让当前月份减去指定月份
				startTime = DateUtil.getDateDiff(Integer.valueOf(month));
				 //当前月份
				 endTime =  DateUtil.getDateDiff(Integer.valueOf(0));
			}
			}
			
		
		
		return blogMapper.selectList(startTime, endTime);
	}

	@Override
	public List<Map> selectTypeList() {
		// TODO Auto-generated method stub
		return blogTypeMapper.selectTypeList();
	}

	@Override
	public boolean importType(String str) {
		try {
			if(null!=str && str.length()>0 && str.contains(",")) {
				String[] strs = str.split(",");
				for (String string : strs) {
					blogTypeMapper.insertSelective(new BlogType(null, string));
				}
			}else {
			blogTypeMapper.insertSelective(new BlogType(null, str));
			}
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return false;
	}

}
