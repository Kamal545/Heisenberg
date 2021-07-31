package com.qa.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {
	
	public ResultSet connectDB(String query) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/hr","root","0854");
		Statement smt = con.createStatement();
		ResultSet rs =smt.executeQuery(query);
		return rs;	
		
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DBManager db = new DBManager();
		ResultSet rs =db.connectDB("select employee_id,max(salary) salary from employees");
		while(rs.next()) {
			double salary = rs.getInt("salary");
			System.out.println(salary);
		}
		
	}
	
}
