<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/jsp/common/header.jsp" %>

<html>
	<head>
		<title>채팅 페이지</title>	
	</head>
	<body>
		<h2>채팅 페이지</h2>
		<div>
			<div>
				<textarea id="messageArea" rows="10" cols="100"></textarea>
			</div>
			<div>
				<span>입력:</span><input id="message" type="text" name="message">
			</div>			
			<button id="sendMessage">메세지 전송</button>
		</div>
		
		<script type="text/javascript">
			var view = {
				init : function() {
					this.initComponents();
				},
				initComponents : function() {
					this.addEventListenerToComponents();
				},
				addEventListenerToComponents : function() {
					
				}
			}
			
	        $(document).ready(
		        function() {
		            var sock = new SockJS("<c:url value="/echo"/>");
		            sock.onopen = function() {};
		            sock.onmessage = function(evt) {
		                var jsontext = evt.data;
		            };
		            sock.onclose = function() {
		                sock.send("서버 끝");
		            };
			        $("#sendMessage").click(
				        function() {
				            sock.send($("#message").val());
				        }
			        );
			        
			        //sock.close() //웹소켓 닫기
	    		}
	        );
			
			window.onload = function() {
				view.init();
			}
		</script> 
	</body>
</html>