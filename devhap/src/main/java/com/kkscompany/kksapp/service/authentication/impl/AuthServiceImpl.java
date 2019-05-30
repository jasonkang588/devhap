package com.kkscompany.kksapp.service.authentication.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kkscompany.kksapp.service.authentication.AuthService;
import com.kkscompany.kksapp.service.users.UserInfoService;

@Service
public class AuthServiceImpl implements AuthService{

	@Autowired
	private UserInfoService userInfoService;

	@Override
	public List<Map<String, Object>> getAuthUserInfo(Map<String, Object> bizInDto) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean authServiceAccess(Map<String, Object> bizInDto) {
		// TODO Auto-generated method stub
		return false;
	}

}
