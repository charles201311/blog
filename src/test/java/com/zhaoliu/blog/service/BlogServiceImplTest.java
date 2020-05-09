package com.zhaoliu.blog.service;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-beans.xml")
public class BlogServiceImplTest {

	@Autowired
	private BlogService blogService;
	
	@Test
	public void testSelectList() {
		List<Map> list = blogService.selectList("3");
		System.out.println(list.size());
		assertEquals(4, list.size());
	}

}
