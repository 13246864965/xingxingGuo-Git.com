package com.cn.hwyl.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.hwyl.pojo.User;
import com.cn.hwyl.service.IFirstAidInfoService;
import com.cn.hwyl.service.IFirstAidService;
import com.cn.hwyl.service.IUserService;

@Controller
@RequestMapping("/user")
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class UserController {
//	@Resource
	private IUserService userService;
	
	@RequestMapping("/showUser")
	public String toIndex(HttpServletRequest request,Model model){
		int userId = Integer.parseInt(request.getParameter("id"));
		User user = this.userService.selectByPrimaryKey("1");
		model.addAttribute("user", user);
		return "showUser";
	}
}
