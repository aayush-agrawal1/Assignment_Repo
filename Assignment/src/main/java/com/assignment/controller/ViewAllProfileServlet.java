package com.assignment.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.assignment.entity.AssignmentEntity;
import com.assignment.service.AssignmentService;
import com.assignment.service.AssignmentServiceInterface;

/**
 * Servlet implementation class ViewAllProfiles
 */
public class ViewAllProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession s = request.getSession(true);
		Object oo = s.getAttribute("id");
		String email = oo.toString();
		AssignmentEntity m = new AssignmentEntity();
		m.setEmail(email);
		AssignmentServiceInterface ms = new AssignmentService();
		List<AssignmentEntity> mm = ms.viewAllProfile(m);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body><center>");
		for (AssignmentEntity a : mm) {
			out.println("Name is: " + a.getName());
			out.println("<br>Email is: " + a.getEmail());
			out.println("<br>Password is: " + a.getPassword());
			out.println("<br>Address is: " + a.getAddress() + "<br><br><br>");
		}
		out.println("</center></body></html>");
	}

}
