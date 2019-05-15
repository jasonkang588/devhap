<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/jsp/common/header.jsp" %>

<html>
	<head>
		<title>TEST게시판 글목록</title>	
	</head>
	<body>
		<h2>TEST게시판 글목록</h2>
						
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
					this.initComponents();
				},
				initComponents : function() {
					this.addEventListenerToComponents();
				},
				addEventListenerToComponents : function() {
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
						location.href = '/resources/WEB-INF/views/jsp/board/regist.jsp';
					});
				}
			}
			
			window.onload = function() {
				view.init();		
			}
		</script> 
	</body>
</html>