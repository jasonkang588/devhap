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
	private SqlSessionTemplate sqlSession;
	
	public List selectList(String id, Map param) {
		return sqlSession.selectList(id, param);
	}
	
	public int insert(String id, Map param) {
		return sqlSession.insert(id, param);
	}
	
	public int update(String id, Map param) {
		return sqlSession.update(id, param);
	}
	
	public int delete(String id, Map param) {
		return sqlSession.update(id, param);
	}

}
