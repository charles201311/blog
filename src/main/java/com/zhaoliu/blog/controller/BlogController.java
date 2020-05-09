package com.zhaoliu.blog.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhaoliu.blog.domain.Blog;
import com.zhaoliu.blog.service.BlogService;
import com.zhaoliu.blog.utils.PageUtil;
import com.zhaoliu.blog.utils.StreamUtil;

@Controller
public class BlogController {

	@Resource
	private BlogService blogService;

	/**
	 * 
	 * @Title: list
	 * @Description: TODO
	 * @param page
	 * @param month    查询条件 : 1个月 三个月, 6个月
	 * @param request
	 * @return
	 * @return: String
	 */
	@RequestMapping("list")
	public String list(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue="")String month, HttpServletRequest request) {
		Integer pageSize = 3;
		
		PageHelper.startPage(page, pageSize);
		List<Map> list = blogService.selectList(month);
		PageInfo<Map> info = new PageInfo<>(list);
		// 分页工具类
		String pageInfo = PageUtil.page(page, info.getPages(), "/list?month="+month, pageSize);
		request.setAttribute("list", list);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("month", month);

		return "list";
	}

	@RequestMapping("toAdd")
	public String toAdd() {

		return "add";

	}
	//跳转到明细页面
	
	@RequestMapping("toDetail")
	public String toDetail(Integer id,Model model) {
		Blog blog = blogService.selectByPrimaryKey(id);
		model.addAttribute("blog", blog);

		return "detail";

	}
	
	@RequestMapping("toUpdate")
	public String toUpdate(Integer id,Model model) {
		Blog blog = blogService.selectByPrimaryKey(id);
		model.addAttribute("blog", blog);
		return "update";

	}
	
	@ResponseBody
	@RequestMapping("update")
	public boolean update(Blog blog) {
		blog.setAuthor("张三");
		return blogService.updateByPrimaryKeyWithBLOBs(blog)>0;

	}
	
	
	@ResponseBody
	@RequestMapping("deleteByid")
	public boolean deleteByid(Integer id) {
		return blogService.deleteByPrimaryKey(id)>0;

	}
	
	
	
	
	@ResponseBody
	@RequestMapping("add")
	public boolean add(Blog blog) {
		blog.setAuthor("张三");
		return blogService.insertSelective(blog)>0;

	}

	@ResponseBody
	@RequestMapping("getTypeList")
	public List<Map> getTypeList() {
		return blogService.selectTypeList();

	}

	
	//管理博文页面
	@RequestMapping("toManager")
	public String toManager() {
		return "manager";
	}
	
	@ResponseBody
	@RequestMapping("importType")
	public boolean importType(@RequestParam("file")MultipartFile file) throws IOException {
		if(!file.isEmpty()) {
		
			InputStream inputStream = file.getInputStream();
			String string = StreamUtil.readTextFile(inputStream);
			
			return blogService.importType(string);
		}
		return false;
		
	}
}
