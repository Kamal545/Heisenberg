package com.pages;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qa.util.DBManager;

public class DataBase {
	DBManager db = new DBManager();
	public List<List<String>> fetchEmpData() throws ClassNotFoundException, SQLException {
		ResultSet rs = db.connectDB("Select employee_id,first_name,last_name,email from employees where employee_id<105 order by employee_id desc");
		List<List<String>> list = new ArrayList<List<String>>();
		for(int i=0;i<=4;i++) {
			while(rs.next()) {
				
			    List<String> e=new ArrayList<String>();
				Integer eid = rs.getInt("employee_id");
				String empid =eid.toString();
				String fname =rs.getString("first_name");
				e.add(empid);
				e.add(fname);
				e.add(rs.getString("last_name"));
				e.add(rs.getString("email"));
				list.add(i,e);
			}
			
		}
			return list;
	}
	
	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		DataBase db = new DataBase();
		List<List<String>> emp = db.fetchEmpData();
		System.out.println(emp);
		System.out.println(emp.get(0));
	}
	
}
