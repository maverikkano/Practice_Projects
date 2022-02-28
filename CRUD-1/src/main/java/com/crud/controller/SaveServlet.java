package com.crud.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.dao.EmployeeDAO;
import com.crud.entity.Employee;

/**
 * Servlet implementation class SaveServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/SaveServlet" })
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Set response type
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		
		// Extract query params from request
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		
		// Create Employee object
		Employee employee = new Employee(name, password, email, country);
		
		int status = EmployeeDAO.save(employee);
				
		// If status > 0
		if (status > 0) {
			printWriter.print("<p>Record saved successfully!</p>");
			request.getRequestDispatcher("index.html").include(request, response);
		}
			
		else {
			printWriter.print("<p>Sorry could not save the record.</p>");
		}
		
		// Close PrintOutput
		printWriter.close();
	}
}
