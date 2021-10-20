package com.servlet;

import java.io.IOException;

import com.service.UserService;
import com.service.impl.UserServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserService insert = new UserServiceImpl();
		
		String username = request.getParameter("username");
		String real_name = request.getParameter("real_name");
		String gender = request.getParameter("gender");
		
		insert.insertMessage(username, real_name, gender);
		
		request.getRequestDispatcher("Web/Display.jsp").forward(request, response);
	}

}
