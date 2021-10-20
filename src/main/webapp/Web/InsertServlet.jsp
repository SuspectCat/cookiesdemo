<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="InsertServlet" method="post">
		<table>
			<tr>
				<td>用户名</td>
				<td><input type="text" name="username"></td>
				<td>姓名</td>
				<td><input type="text" name="real_name"></td>
				<td>性别</td>
				<td>
					<select name="gender">
						<option>请选择</option>
						<option value="1">男</option>
						<option value="0">女</option>
					</select>
				</td>
			</tr>
		</table>
		
		<button type="submit">添加</button>
	</form>
</body>
</html>