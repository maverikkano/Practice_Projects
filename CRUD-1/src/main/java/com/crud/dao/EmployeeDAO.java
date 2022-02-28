package com.crud.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.crud.entity.Employee;

public class EmployeeDAO {
	
	// Create connection
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("org.postgresql.Driver");
//			connection = DriverManager.getConnection("jdbc:postgresql:DRA_Project");
//			connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/DRA_Project?currentSchema=public&user=postgres&password=database");
			connection = DriverManager.getConnection("jdbc:postgresql:DRA_Project", "postgres", "database");
			
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	// Save employee
	public static int save(Employee employee) {
		int status = 0;
		try {
			
			// Establish connection
			Connection connection = EmployeeDAO.getConnection();
			
			// Create PreparedStatement
			PreparedStatement ps = connection.prepareStatement(
					"INSERT INTO user905(name,password,email,country) values (?,?,?,?)");
			
			System.out.println("*************************"+employee.getCountry());
			// Add setters
			ps.setString(1, employee.getName());
			ps.setString(2, employee.getPassword());
			ps.setString(3, employee.getEmail());
			ps.setString(4, employee.getCountry());
			
			status = ps.executeUpdate();
			
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return status;
	}
	
	// Update employee
	public static int update(Employee employee) {
		int status = 0;
		try {
			// Establish connection
			Connection connection = EmployeeDAO.getConnection();
			
			// Make PreparedStatement
			PreparedStatement ps = connection.prepareStatement(
					"UPDATE user905 set name=?,password=?,email=?,country=? where id=?");
			
			// Setters
			ps.setString(1, employee.getName());
			ps.setString(2, employee.getPassword());
			ps.setString(3, employee.getEmail());
			ps.setString(4, employee.getCountry());
			ps.setInt(5, employee.getId());
			
			// Execute Query
			status = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return status;
	}
	
	// Delete employee
	public static int delete(int id){  
        int status=0;  
        try{
        	// Establish connection
            Connection con=EmployeeDAO.getConnection();  
            
            // PreparedStatement
            PreparedStatement ps=con.prepareStatement("delete from user905 where id=?");  
            
            // Setter
            ps.setInt(1,id);  
            
            // Execute Statement
            status=ps.executeUpdate();  
              
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  

	// Get employee
    public static Employee getEmployeeById(int id){  
        Employee employee= new Employee();  
          
        try{
        	// Establish connection
            Connection connection = EmployeeDAO.getConnection();  
            
            // PrepareStatement
            PreparedStatement ps=connection.prepareStatement("select * from user905 where id=?");  
            
            // Setter
            ps.setInt(1,id);
            
            // Get data from query
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                employee.setId(rs.getInt(1));  
                employee.setName(rs.getString(2));  
                employee.setPassword(rs.getString(3));  
                employee.setEmail(rs.getString(4));  
                employee.setCountry(rs.getString(5));  
            }
            
            // Close connection
            connection.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return employee;  
    }
	
	// Show all employees
    public static List<Employee> getAllEmployees(){  
        List<Employee> list=new ArrayList<Employee>();  
          
        try{
            Connection con=EmployeeDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from user905");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Employee e=new Employee();  
                e.setId(rs.getInt(1));
                e.setName(rs.getString(2));  
                e.setPassword(rs.getString(3));  
                e.setEmail(rs.getString(4));  
                e.setCountry(rs.getString(5));  
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
}
