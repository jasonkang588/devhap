package com.kkscompany.kksapp.dao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kkscompany.kksapp.constants.CommonConstants;
import com.kkscompany.kksapp.pojo.PagingCriteria;

@Repository
public class CommonDao {
	
	@Autowired
	@Resource(name="sqlSession")
	private SqlSessionTemplate sqlSession;
	
	public List selectList(String id, Map param) {		
		return sqlSession.selectList(id, param);
	}
	
	public Map<String,Object> selectListByPage(String id, Map param) {
		List<Map<String,Object>> result = null;
		Map<String,Object> resultMap = new HashMap<String,Object>(); 
		Map paramMap = new HashMap<String,Object>();
		paramMap.putAll(param);
		
		if( paramMap.get(CommonConstants.PARAM_NAME_CURRENT_PAGE) == null ) {		
			paramMap.put(CommonConstants.PARAM_NAME_CURRENT_PAGE, "1");
		} else {
			try {
				Double d = Double.parseDouble((String)paramMap.get(CommonConstants.PARAM_NAME_CURRENT_PAGE));
				paramMap.put(CommonConstants.PARAM_NAME_CURRENT_PAGE, Integer.toString(d.intValue()));
			} catch (RuntimeException e) {
				paramMap.put(CommonConstants.PARAM_NAME_CURRENT_PAGE, "1");
			}
		}
		
		result = sqlSession.selectList(id, paramMap);
		
		PagingCriteria pc = new PagingCriteria(
			  Integer.parseInt((String) paramMap.get(CommonConstants.PARAM_NAME_CURRENT_PAGE))
			, ((BigDecimal)result.get(0).get("totalCount")).intValue()
			, (Integer)paramMap.get(CommonConstants.PARAM_NAME_FETCH_SIZE)
			, (Integer)paramMap.get(CommonConstants.PARAM_NAME_BLOCK_SIZE)
		);
		
		paramMap.put(CommonConstants.PARAM_NAME_TOTAL_COUNT, pc.getTotalCount());
		paramMap.put(CommonConstants.PARAM_NAME_ROWBOUNDS_FROM, pc.getRowBoundsFrom());
		paramMap.put(CommonConstants.PARAM_NAME_ROWBOUNDS_TO, pc.getRowBoundsTo());		
		
		result = sqlSession.selectList(id, paramMap);
		resultMap.put("list", result);
		resultMap.put("paging", pc);
		return resultMap;
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
