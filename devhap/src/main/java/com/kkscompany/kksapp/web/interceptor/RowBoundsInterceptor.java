package com.kkscompany.kksapp.web.interceptor;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.ReflectorFactory;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kkscompany.kksapp.constants.CommonConstants;

import java.sql.Connection;
import java.util.Map;
import java.util.Properties;

@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})})
public class RowBoundsInterceptor implements Interceptor {
	private static final Logger logger = LoggerFactory.getLogger(RowBoundsInterceptor.class);

	private static final ObjectFactory DEFAULT_OBJECT_FACTORY = new DefaultObjectFactory();
	private static final ObjectWrapperFactory DEFAULT_OBJECT_WRAPPER_FACTORY = new DefaultObjectWrapperFactory();
	private static final ReflectorFactory DEFAULT_REFLECTOR_FACTORY = new DefaultReflectorFactory();

	public Object intercept(Invocation invocation) throws Throwable {
		StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
		MetaObject metaStatementHandler = MetaObject.forObject(statementHandler, DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY, DEFAULT_REFLECTOR_FACTORY);
		String originalSql = (String) metaStatementHandler.getValue("delegate.boundSql.sql");
		Map<String,Object> parameterObject = (Map<String,Object>) metaStatementHandler.getValue("delegate.parameterHandler.parameterObject");

		logger.debug("originalSql = {}", originalSql);
		logger.debug("parameterObject = {}", parameterObject.toString());

		if(parameterObject.get(CommonConstants.PARAM_NAME_CURRENT_PAGE) == null) {
			// paging 처리가 없으면 그냥 실행
			return invocation.proceed();
		}
		
		// paging 처리
		StringBuffer sb = new StringBuffer();
		if(parameterObject.get(CommonConstants.PARAM_NAME_TOTAL_COUNT) == null) {
			sb.append("select count(*) as \"totalCount\" from (");
			sb.append(originalSql);
			sb.append(")");				
		} else {
			sb.append("select T3.* from (select T2.* from (select rownum as rnum, T1.* from (");
			sb.append(originalSql);
			sb.append(")T1 )T2 where T2.rnum <=");
			sb.append(parameterObject.get(CommonConstants.PARAM_NAME_ROWBOUNDS_TO)); 
			sb.append(")T3 where T3.rnum >=");
			sb.append(parameterObject.get(CommonConstants.PARAM_NAME_ROWBOUNDS_FROM));
		}
		
		// 변경된 쿼리로 바꿔치기
		logger.debug("modifedSql = {}", sb.toString());
		metaStatementHandler.setValue("delegate.boundSql.sql", sb.toString());
		return invocation.proceed();
	}

	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	public void setProperties(Properties properties) {

	}

}
