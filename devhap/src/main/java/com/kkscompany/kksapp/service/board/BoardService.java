package com.kkscompany.kksapp.service.board;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kkscompany.kksapp.dao.CommonDao;
import com.kkscompany.kksapp.web.controller.BoardController;

@Service
public class BoardService {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	CommonDao commonDao;
	
	public List selectList(Map param) {		
		logger.info("BoardService called successfully");
		return commonDao.selectList("board.selectList", param); 
	}
}
