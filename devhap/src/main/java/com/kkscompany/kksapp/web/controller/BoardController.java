package com.kkscompany.kksapp.web.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
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

import com.kkscompany.kksapp.service.board.BoardService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		Map param = new HashMap<String,Object>(); 
		
		logger.info("start boardService.selectList");
		List result = boardService.selectList(param);
		logger.info(result.toString());
		
		return "board/list";
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/jsp/board/list", method = RequestMethod.GET)
	public String board(Locale locale, Model model, HttpServletRequest req) {
		
		logger.info(req.getServerName());
		
		logger.info(req.getPathInfo());
		
		logger.info(req.getServletPath());
		
		logger.info(req.getContextPath());
		
		logger.info(req.getRequestURI());
		
		return "jsp/board/list";
	}
	
}
