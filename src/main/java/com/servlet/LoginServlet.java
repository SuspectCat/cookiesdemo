package com.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import com.service.UserLoginService;
import com.service.impl.UserLoginServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserLoginService loginService = new UserLoginServiceImpl();
		
		try {
			if (loginService.isLogin(username, password)) {
				Cookie loginCookie = new Cookie("Login-Cookie", "10");
				response.addCookie(loginCookie);
				
				HttpSession session = request.getSession();
				session.setAttribute("session-Login", loginService);
				
				request.getRequestDispatcher("Web/Display.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			}
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
