package com.kkscompany.kksapp.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kkscompany.kksapp.constants.CommonConstants;

@Repository
public class CommonDao {
	
	@Autowired
	@Resource(name="sqlSession")
	private SqlSessionTemplate sqlSession;
	
	public List selectList(String id, Map param) {		
		return sqlSession.selectList(id, param);
	}
	
	public List selectListByPage(String id, Map param, RowBounds rowBounds) {
		return sqlSession.selectList(id, param, rowBounds);
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
