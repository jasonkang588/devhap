<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "sql" uri = "http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix = "x" uri = "http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix = "tiles" uri = "http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
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
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>게시판 샘플</title>	
	</head>
	<body>
		<h2>게시판 샘플</h2>
		
		<form id="frm_trans">
			<input type="hidden" id="ipt_trans">
		</form>
		
		<button id="btn_genData">게시판 데이타 생성 10건</button>
		<button id="btn_search">조회</button>
		<button id="btn_create">글쓰기</button>
		
		<table border="1" width="800px">
			<colgroup>
				<col width="10%" /> <!-- 번호 -->
				<col width="*" />   <!-- 제목 -->
				<col width="20%" /> <!-- 작성자 -->
				<col width="15%" /> <!-- 작성일 -->
				<col width="15%" /> <!-- 조회수 -->
			</colgroup>
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="row" items="${list}">
					<tr>
						<td style="text-align:center;">${row.id}</td>
						<td><a href="#">${row.title}</a></td>
						<td style="text-align:center;">${row.creBy}</td>
						<td style="text-align:center;">${row.creDt}</td>
						<td style="text-align:center;">${row.readCount}</td>
					</tr>
				</c:forEach>				
			</tbody>
		</table>
		
		<script type="text/javascript">
			var view = {
				init : function() {
					this.initEventListener();
				},
				initEventListener : function() {
					var btnGenData = document.getElementById('btn_genData');
					btnGenData.addEventListener('click', function(event) {
						boardUtil.formSubmit({
							  formId : "frm_trans"
							, action : "/test-board/generate-test-data"
							, method : "post"
						});
					});
					
					var btnSearch = document.getElementById('btn_search');
					btnSearch.addEventListener('click', function(event) {
						boardUtil.formSubmit({
							  formId : "frm_trans"
							, action : "/test-board/posts"
							, method : "get"
						});
					});
					
					$('#btn_create').on('click', function(event) {
						boardUtil.formSubmit({
							  formId : "frm_trans"
							, action : "/test-board/posts"
							, method : "post"
						});
					});
				}	
			}
		
			var boardUtil = {				
				getContextPath : function() {
					/* var hostIndex = location.href.indexOf( location.host ) + location.host.length;
					return location.href.substring( hostIndex, location.href.indexOf('/', hostIndex + 1) ); */
					return '${pageContext.request.contextPath}';
				},
				formSubmit : function(obj) {					
					var frm = document.getElementById(obj.formId);
					var contextPath = this.getContextPath();
					frm.action = contextPath + obj.action;
					frm.method = obj.method;
					frm.submit();
				}			
			};
			
			window.onload = function() {
				view.init();		
			}
		</script> 
	</body>
</html>