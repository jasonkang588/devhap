package com.kkscompany.kksapp.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kkscompany.kksapp.service.board.TestBoardService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/test-board")
public class TestBoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(TestBoardController.class);
	
	@Autowired
	private TestBoardService testBoardService;
	
	@RequestMapping(value = "/posts", method = RequestMethod.GET)
	public ModelAndView getPosts(@RequestParam Map<String, Object> parameters) {
		List param = new ArrayList<Map<String, Object>>();
		param.add(parameters);
		Map<String,Object> result = testBoardService.findAllByPage(param);
		
		ModelAndView mv = new ModelAndView("jsp/board/list");
		mv.addObject("list", result.get("list"));
		mv.addObject("paging", result.get("paging"));
		
		return mv;
	}
	
	@RequestMapping(value = "/posts", method = RequestMethod.POST)
	public String postPosts(@RequestParam Map<String, Object> parameters) {
		List param = new ArrayList<Map<String, Object>>();
		param.add(parameters);
		testBoardService.regist(param);
		return "jsp/board/list";
	}
	
	@RequestMapping(value = "/editform", method = RequestMethod.GET)
	public ModelAndView getEditForm(@RequestParam Map<String, Object> parameters) {
		List param = new ArrayList<Map<String, Object>>();
		param.add(parameters);
		List result = testBoardService.findOne(param);
		
		ModelAndView mv = new ModelAndView("jsp/board/edit");
		mv.addObject("list", result);
		return mv;
	}
	
	@RequestMapping(value = "/generate-test-data", method = RequestMethod.POST)
	public String generateTestData() {
		testBoardService.generateTestData();
		return "jsp/board/list";
	}
	
}
