package com.kkscompany.kksapp.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.hamcrest.core.IsNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kkscompany.kksapp.constants.CommonConstants;
import com.kkscompany.kksapp.service.authentication.AuthService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AuthController {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
	
	@Autowired
	private AuthService authService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getIndex(HttpServletRequest request) {
		return "jsp/login/login";
	}
	
/*	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String checkLoginAuth(@RequestParam Map<String, Object> parameters, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		
		List<Map<String,Object>> authUserInfo = authService.getAuthUserInfo(parameters);		
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userId", "kks");
		map.put("userNm", "강기순");
		map.put("userNick", "쑨..");	
		authUserInfo = new ArrayList<Map<String,Object>>();
		authUserInfo.add(map);
		
		String redirectUrl = null;
		if(authUserInfo == null || authUserInfo.isEmpty()) {
			redirectUrl = "/login";
			redirectAttributes.addFlashAttribute("errmsg", "wrong id or password submitted!!");
		} else {
			request.getSession().setAttribute("userInfo", authUserInfo.get(0));
			redirectUrl = (String) request.getSession().getAttribute(CommonConstants.ATTRIBUTE_NAME_HTTP_REFERER);
			request.getSession().removeAttribute(CommonConstants.ATTRIBUTE_NAME_HTTP_REFERER);			
			logger.info("ATTRIBUTE_NAME_HTTP_REFERER ::" + redirectUrl);			
			
			if(redirectUrl == null || "".equals(redirectUrl)) {
				redirectUrl = "/";
			} else {
				String strHttp = "://";
				String strCtxPath = request.getContextPath();
				int ctxPathLenth = strCtxPath.length();
				if(strCtxPath == null || "".equals(strCtxPath)) {
					strCtxPath = "/";
				}
				int idx = redirectUrl.indexOf(strCtxPath, redirectUrl.indexOf(strHttp)+strHttp.length());				
				redirectUrl = redirectUrl.substring(idx + request.getContextPath().length());
				if(redirectUrl.indexOf("/login") >= 0) redirectUrl = "/";    
				logger.info("redirect url :: " + redirectUrl);
			}
		}

		return "redirect:" + redirectUrl;
	}*/
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String checkLoginAuth(@RequestParam Map<String, Object> parameters, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		
		List<Map<String,Object>> authUserInfo = authService.getAuthUserInfo(parameters);		
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userId", "kks");
		map.put("userNm", "강기순");
		map.put("userNick", "쑨..");	
		authUserInfo = new ArrayList<Map<String,Object>>();
		authUserInfo.add(map);
		
		String redirectUrl = null;
		if(authUserInfo == null || authUserInfo.isEmpty()) {
			redirectUrl = "/login";
			redirectAttributes.addFlashAttribute("errmsg", "wrong id or password submitted!!");
		} else {
			request.getSession().setAttribute("userInfo", authUserInfo.get(0));
			redirectUrl = (String) request.getSession().getAttribute(CommonConstants.ATTRIBUTE_NAME_PRE_LOGIN_URL);
			request.getSession().removeAttribute(CommonConstants.ATTRIBUTE_NAME_PRE_LOGIN_URL);
			logger.info("ATTRIBUTE_NAME_PRE_LOGIN_URL ::" + redirectUrl);
			
			if(redirectUrl == null || "".equals(redirectUrl)) {
				redirectUrl = "/";
			} else {			
				redirectUrl = redirectUrl.substring(request.getContextPath().length());
			}
		}
		
		logger.info("redirect url :: " + redirectUrl);

		return "redirect:" + redirectUrl;
	}
	
}
