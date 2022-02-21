package com.assignment.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.assignment.entity.AssignmentEntity;
import com.assignment.service.AssignmentService;
import com.assignment.service.AssignmentServiceInterface;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email=request.getParameter("em");
		String password =request.getParameter("pass");
		
		AssignmentEntity m=new AssignmentEntity();
		m.setEmail(email);
		m.setPassword(password);
		
		AssignmentServiceInterface ms=new AssignmentService();
		boolean b=ms.loginProfile(m);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body><center>");
			if(b) {
				
				HttpSession s=request.getSession(true);
				s.setAttribute("id", email);
				
				out.println("Welcome "+email);
				out.println("<button><a href=ViewProfileServlet>View Profile</a></button>");
				out.println("<button><a href=DeleteProfileServlet>Delete Profile</a></button>");
				out.println("<button><a href=ViewAllProfileServlet>View All Profile</a></button>");
			}
			else {
				out.println("Invalid Id and Password <a href=login.html>Try Again</a>");
				
			}
		out.println("</center></body></html>");
	}

}
