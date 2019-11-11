package com.exercise31session.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html chartser='utf-8'");
		PrintWriter output = response.getWriter();
		
		String username= request.getParameter("txtUsername");
		String password=request.getParameter("txtPass");
		
		output.println("username: "+username);
		output.println("Password: "+password);
		
		if(username.equalsIgnoreCase("admin")&& password.equalsIgnoreCase("admin")) {
			HttpSession mySession =  request.getSession();
			mySession.setAttribute("user",username);
			mySession.setAttribute("password",password);
			output.println("   Usuario Logeado");
			response.sendRedirect("Welcome.jsp");
			}
		else {
			output.println("   Usario y contraseña incorrectos!");
		}
		
		
		
		output.close();

	}

}
