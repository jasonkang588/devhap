package com.kkscompany.kksapp.service.board.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kkscompany.kksapp.constants.CommonConstants;
import com.kkscompany.kksapp.dao.CommonDao;
import com.kkscompany.kksapp.pojo.PagingCriteria;
import com.kkscompany.kksapp.service.board.TestBoardService;

@Service
public class TestBoardServiceImpl implements TestBoardService{
	private static final Logger logger = LoggerFactory.getLogger(TestBoardServiceImpl.class);
	
	@Autowired
	CommonDao commonDao;

	@Override
	public void regist(List<Map<String, Object>> bizInDto) {
		// TODO Auto-generated method stub
	}

	@Override
	public void modify(List<Map<String, Object>> bizInDto) {
		// TODO Auto-generated method stub
	}

	@Override
	public void save(List<Map<String, Object>> bizInDto) {
		// TODO Auto-generated method stub
	}

	@Override
	public List findOne(List<Map<String, Object>> bizInDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List findAll(List<Map<String, Object>> bizInDto) {
		Map param = null;
		if(bizInDto == null || bizInDto.isEmpty()) {
			param = new HashMap<String,Object>();
		} else {
			param = bizInDto.get(0);
		}		
		return commonDao.selectList("board.selectList", param);
	}

	@Override
	public Map<String,Object> findAllByPage(List<Map<String, Object>> bizInDto) {
		Map<String,Object> param = null;
		if(bizInDto == null || bizInDto.isEmpty()) {
			param = new HashMap<String,Object>();
		} else {
			param = bizInDto.get(0);
		}
		return commonDao.selectListByPage("board.selectList", param);
	}

	@Override
	public void generateTestData() {
		Map paramMap = new HashMap<String,Object>();
		for(int i=0; i<10; i++) {
			paramMap.put("title", "title"+i);
			paramMap.put("content", "content"+i);
			commonDao.insert("board.insertItem", paramMap);
		}	
	}
	
}
