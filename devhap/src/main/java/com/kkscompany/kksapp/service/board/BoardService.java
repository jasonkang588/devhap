package com.kkscompany.kksapp.service.board;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kkscompany.kksapp.dao.CommonDao;

@Service
public class BoardService {
	
	@Autowired
	CommonDao commonDao;
	
	public List selectList(Map param) {		
		return commonDao.selectList("selectList", param); 
	}
}
