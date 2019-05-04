<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "sql" uri = "http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix = "x" uri = "http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix = "tiles" uri = "http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>

<html>  
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=8" />
		
		<spring:theme code="styleSheet" var="app_css" />
        <spring:url value="/${app_css}" var="app_css_url" />
        <link rel="stylesheet" type="text/css" media="screen" href="${app_css_url}" />
		
        <!-- jQuery and jQuery UI -->
        <spring:url value="/resources/scripts/jquery-1.7.1.js" var="jquery_url" />
        <spring:url value="/resources/scripts/jquery-ui-1.8.16.custom.min.js" var="jquery_ui_url" />          
        <spring:url value="/resources/styles/custom-theme/jquery-ui-1.8.16.custom.css" var="jquery_ui_theme_css" />        
        <link rel="stylesheet" type="text/css" media="screen" href="${jquery_ui_theme_css}" />        
        <script src="${jquery_url}" type="text/javascript"><jsp:text/></script>
        <script src="${jquery_ui_url}" type="text/javascript"><jsp:text/></script>

        <!-- CKEditor -->
        <spring:url value="/resources/ckeditor/ckeditor.js" var="ckeditor_url" />
        <spring:url value="/resources/ckeditor/adapters/jquery.js" var="ckeditor_jquery_url" />
        <script type="text/javascript" src="${ckeditor_url}"><jsp:text/></script>
        <script type="text/javascript" src="${ckeditor_jquery_url}"><jsp:text/></script>		

        <!-- jqGrid -->
        <spring:url value="/resources/jqgrid/css/ui.jqgrid.css" var="jqgrid_css" />
        <spring:url value="/resources/jqgrid/js/i18n/grid.locale-en.js" var="jqgrid_locale_url" />
        <spring:url value="/resources/jqgrid/js/jquery.jqGrid.min.js" var="jqgrid_url" />
        <link rel="stylesheet" type="text/css" media="screen" href="${jqgrid_css}" />
        <script type="text/javascript" src="${jqgrid_locale_url}"><jsp:text/></script> 
        <script type="text/javascript" src="${jqgrid_url}"><jsp:text/></script>
		
		<title>title here</title>
	</head>
	
  	<body class="tundra spring">
  	    <div id="headerWrapper">
  	        <tiles:insertAttribute name="header" ignore="true" />
  	    </div>
   		<div id="wrapper">
		    <tiles:insertAttribute name="menu" ignore="true" />   
		    <div id="main">
	    		<tiles:insertAttribute name="body"/> 
		    	<tiles:insertAttribute name="footer" ignore="true"/>
		    </div>
		</div>
	</body>
</html>
