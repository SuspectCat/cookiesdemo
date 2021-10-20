<%@page import="java.util.ArrayList"%>
<%@page import="com.entity.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<button onclick="location-href='LogoutServlet'"></button>
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
			
			<td>
				<button onclick="location-href='SelectServlet'"></button>
			</td>
		</tr>
		<tr>
			<td>用户名</td>
			<td>姓名</td>
			<td>性别</td>
		</tr>

	<%
		List<User> userList = (List<User>) request.getAttribute("displayAllUser");
		List<User> users = (List<User>) request.getAttribute("selectUser");
		
		if (null == users) {
	
		for (User user : userList) {
			
			if (user.getGender().equals("1"))
				user.setGender("男");
			else
				user.setGender("女");
	%>
	
		<tr>
			<td><%= user.getUsername() %></td>
			<td><%= user.getReal_Name() %></td>
			<td><%= user.getGender() %></td>
		</tr>
		<button onclick="location.href='Web/InsertServlet.jsp'">添加</button>
	
	<%	
			}
		} else {
			for (User u : users) {
				if (u.getGender().equals("1")) u.setGender("男"); else u.setGender("女");
	%>
				<tr>
					<td><%= u.getUsername() %></td>
					<td><%= u.getReal_Name() %></td>
					<td><%= u.getGender() %></td>
				</tr>			
	<%
			}
		}
	%>
	
	</table>
</body>
</html>