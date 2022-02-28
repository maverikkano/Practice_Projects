package com.crud.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.dao.EmployeeDAO;
import com.crud.entity.Employee;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// content type, printwriter
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		// Link to add new emmployees
		out.println("<a href='index.html'>Add New Employee</a>");
		out.println("<h1>Employee List</h1>");
		
		// get all employees
		List<Employee> employeeList = EmployeeDAO.getAllEmployees();
		
		// table
		out.print("<table style='border:1px length=150%'>");
		out.print("<tr><th>ID</th><th>Name</th><th>Email</th><th>Country</th><th>View</th><th>Delete</th><tr>");
		for (Employee employee: employeeList) {
			out.print("<tr><td>"+employee.getId()+"</td><td>"+employee.getName()+"</td><td>"+employee.getEmail()+"</td><td>"+employee.getCountry()+"</td><td><a href='EditFormServlet?id="+employee.getId()+"'>edit</a></td><td><a href='DeleteServlet?id="+employee.getId()+"'>delete</a></td></tr>");
		}
		out.print("</table>");
		
		// close printwriter
		out.close();
	}
}