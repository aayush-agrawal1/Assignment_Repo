package com.assignment.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.assignment.entity.AssignmentEntity;
import com.assignment.service.AssignmentService;
import com.assignment.service.AssignmentServiceInterface;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("nm");
		String password=request.getParameter("pass");
		String email=request.getParameter("em");
		String address=request.getParameter("ad");
		
		AssignmentEntity w = new AssignmentEntity();
		w.setAddress(address);
		w.setEmail(email);
		w.setPassword(password);
		w.setName(name);
		
		AssignmentServiceInterface ms = new AssignmentService();
		int i = ms.createProfileService(w);
		
		if(i>0) {
			request.setAttribute("result", "Profile created <a href=login.jsp>Sign In</a>");
			
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/register.jsp");
			rd.forward(request, response);
		}
		else {
			request.setAttribute("result","could not create profile");
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/register.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
