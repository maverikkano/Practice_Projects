package com.crud.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.crud.dao.EmployeeDAO;
import com.crud.entity.Employee;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ContentType PrintOut
		response.setContentType("text/html");

		// Get ID
		String sid = request.getParameter("id");
		
		// delete method
		EmployeeDAO.delete(Integer.parseInt(sid));
		
		// Redirect to view
		response.sendRedirect("ViewServlet");
	}

}
