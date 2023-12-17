package com.student.manage;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDAO {
	public static boolean insertStudentToDB(Student st) {
		boolean f=false;
		try {
			//jdbc code
			Connection con=cp.create();
			String q="insert into students(sname,sphone,scity) values(?,?,?)";
			
			////Prepared Statement
			PreparedStatement pstmt=con.prepareStatement(q);
			
			//set the value of parameter
			pstmt.setString(1, st.getStudentName());
			pstmt.setString(2, st.getStudentPhone());
			pstmt.setString(3, st.getStudentCity());
			
			//execute 
			pstmt.executeUpdate();
			f=true;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return f;
		}

	public static boolean deleteStudent(int userId) {
		boolean f=false;
		try {
			//jdbc code
			Connection con=cp.create();
			String q="delete from students where sid=?";
			
			////Prepared Statement
			PreparedStatement pstmt=con.prepareStatement(q);
			
			//set the value of parameter
			pstmt.setInt(1, userId);
			
			
			//execute 
			pstmt.executeUpdate();
			f=true;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return f;
		
	}

	public static void showAllStudent() {
		
		try {
			//jdbc code
			Connection con=cp.create();
			String q="select * from students";
			
			////Prepared Statement
			
			Statement stmt=con.createStatement();
			ResultSet set=stmt.executeQuery(q);
			
			while(set.next()) {
				int id=set.getInt(1);//1 is column number
				String name=set.getString(2);
				String phone =set.getString(3);
				String city=set.getString("scity");
				System.out.println("ID : "+id);
				System.out.println("Name : "+name);
				System.out.println("Phone : "+phone);
				System.out.println("City : "+city);
				System.out.println("++++++++++++++++++");
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}

	public static boolean updateStudentToDB(int userId, Student st) {
	    boolean f = false;
	    try {
	        // jdbc code
	        Connection con = cp.create();
	        String q = "UPDATE students SET sname = ?, sphone = ?, scity= ? WHERE sid = ?";

	        // Prepared Statement
	        PreparedStatement pstmt = con.prepareStatement(q);

	        // set the value of parameters
	        pstmt.setString(1, st.getStudentName());
	        pstmt.setString(2, st.getStudentPhone());
	        pstmt.setString(3, st.getStudentCity());
	        pstmt.setInt(4, userId);

	        // execute
	        pstmt.executeUpdate();
	        f = true;

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return f;
	}

}
