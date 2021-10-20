<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="LoginServlet" method="post">
		<table>
			<tr>
				<td>用户名</td>
				<td><input type="text" name="username"></td>
			</tr>
			
			<tr>
				<td>密码</td>
				<td>
					<input type="password" name="password">
				</td>
			</tr>
		</table>
		
		<button type="submit">Login</button>
	</form>
</body>
</html>