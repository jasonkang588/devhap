<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/jsp/common/header.jsp" %>

<html>
	<head>
		<title>TEST게시판 글쓰기</title>	
	</head>
	<body>
		<h2>TEST게시판 글쓰기</h2>
		
		<table border="1">
			<colgroup>
				<col width="20%" /> <!-- 번호 -->
				<col width="*" />   <!-- 제목 -->				
			</colgroup>			
			<tbody>
				<tr>
					<td>제목</td>
					<td><input type="text"></td>
				</tr>				
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
					$('#btn_create').on('click', function(event) {
						boardUtil.formSubmit({
							  formId : "frm_trans"
							, action : "/test-board/posts"
							, method : "post"
						});
					});
				}
			}
			
			window.onload = function() {
				view.init();		
			}
		</script> 
	</body>
</html>