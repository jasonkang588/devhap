package com.kkscompany.kksapp.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommonDao {
	
	@Autowired
	@Resource(name="sqlSession")
	private SqlSessionTemplate sqlsession;
	
	@SuppressWarnings("unchecked")
	public List selectList(String id, Map param) {
		List result = sqlsession.selectList(id, param);
		return result;
	}

}
