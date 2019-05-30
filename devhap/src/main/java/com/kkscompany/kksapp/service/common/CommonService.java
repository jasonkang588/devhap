package com.kkscompany.kksapp.service.common;

import java.util.List;
import java.util.Map;

public interface CommonService {
	public void regist(List<Map<String,Object>> bizInDto);
	public void modify(List<Map<String,Object>> bizInDto);
	public void save(List<Map<String,Object>> bizInDto);
	public List findOne(List<Map<String,Object>> bizInDto);
	public List findAll(List<Map<String,Object>> bizInDto);
	public Map<String, Object> findAllByPage(List<Map<String,Object>> bizInDto);
}
