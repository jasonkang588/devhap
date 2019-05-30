package com.kkscompany.kksapp.service.authentication;

import java.util.List;
import java.util.Map;

import com.kkscompany.kksapp.service.common.CommonService;

public interface AuthService {
	public List<Map<String,Object>> getAuthUserInfo(Map<String,Object> bizInDto);
	public boolean authServiceAccess(Map<String,Object> bizInDto);
}
