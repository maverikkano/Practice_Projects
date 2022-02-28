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
 * Servlet implementation class EditFormServlet
 */
@WebServlet("/EditFormServlet")
public class EditFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		// Get employee ID from request
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		
		// Fetch employee
		Employee employee = EmployeeDAO.getEmployeeById(id);
		
		// Create form to accept other details
		out.print("<form action='EditResponseServlet' method='post'");
		out.print("<table>");
		out.print("<tr><td>ID</td><td><input type='hidden' name='id' value="+employee.getId()+"></td></tr><br>");
		out.print("<tr><td>Name</td><td><input type='text' name='name' value="+employee.getName()+"></td></tr><br>");
		out.print("<tr><td>Password</td><td><input type='password' name='password' value="+employee.getPassword()+"></td></tr><br>");
		out.print("<tr><td>Email</td><td><input type='email' name='email' value="+employee.getEmail()+"></td></tr><br>");
		out.print("<tr><td>Country</td><td>");
		out.print("<select name='country' style='width=145px'>");
		out.print("<option>India</option>");
		out.print("<option>USA</option>");
		out.print("<option>Russia</option>");
		out.print("<option>UK</option>");
		out.print("<option>Others</option>");
		out.print("</select>");
		out.print("</td></tr>");
		out.print("<tr><td><input type='submit' value='Update & Save'/></td></tr>");
		out.print("</table>");
		out.print("</form>");
		
		// Close PrintWriter
		out.close();
	}

}
