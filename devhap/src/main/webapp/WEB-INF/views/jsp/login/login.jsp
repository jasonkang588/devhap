<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>login</h2>
	<form  name="loginForm" action="/kksapp/login" method="post">
		<table>               
			<tr>
				<td>User ID:</td>
				<td><input type="text" name="userId"/></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password"/></td>
			</tr>
			<tr>
				<td colspan="2"><input name="submit" type="submit" value="Login"/></td>
			</tr>           
		</table>
	</form>
	
	<div>
		<span>${errmsg}</span>
	</div>
</body>
</html>