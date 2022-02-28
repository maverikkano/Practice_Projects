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
 * Servlet implementation class EditResponseServlet
 */
@WebServlet("/EditResponseServlet")
public class EditResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditResponseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Set response type & create PrintWriter
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		// Get query params from request
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		String sid = request.getParameter("id");
		
		// Create a new employee from the query params
		Employee employee = new Employee(name, password, email, country);
		
		employee.setId(Integer.parseInt(sid));
		
		// Update the employee
		int status = EmployeeDAO.update(employee);
		
		// If status > 0 -> ViewServlet
		if (status > 0) {
			response.sendRedirect("ViewServlet");
		}else {
			out.println("Sorry! Not able to update.");
		}
		
		// Close PrintWriter
		out.close();
	}

}
