package com.kkscompany.kksapp.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.kkscompany.kksapp.constants.CommonConstants;

public class UrlInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(UrlInterceptor.class);
	 
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
    	/*logger.info("===================       START       ===================");
    	logger.info(" Request URI \t:  " + request.getRequestURI());*/
    	request.getSession().setAttribute(CommonConstants.ATTRIBUTE_NAME_PRE_LOGIN_URL, request.getRequestURI());
        return super.preHandle(request, response, handler);
    }
 
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,  ModelAndView modelAndView)
    		throws Exception {
    	/*logger.info("===================       START       ===================");
    	logger.info(" Request URI \t:  " + request.getRequestURI());*/
    }
}
