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
public class chatController {
	
	private static final Logger logger = LoggerFactory.getLogger(chatController.class);
	
	@RequestMapping(value = "/chat", method = RequestMethod.GET)
	public ModelAndView getChatView() {
		ModelAndView mv = new ModelAndView("jsp/chat/chat");
		return mv;
	}
	
}
