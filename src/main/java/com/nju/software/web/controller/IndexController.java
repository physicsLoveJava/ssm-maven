package com.nju.software.web.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nju.software.service.UserService;
import com.nju.software.util.JsonResult;

@Controller
public class IndexController {

	@Resource
	private UserService userService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(
			ModelMap model
			){
		model.addAttribute("userList", userService.findAll());
		return "index";
	}
	
	@RequestMapping(value = "/json", method = RequestMethod.GET)
	public void json(
			HttpServletRequest request,
			HttpServletResponse response
			) throws IOException{
		JsonResult.toJson(response, userService.findAll());
	}
	
	
	
}
