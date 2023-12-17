package com.student.manage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Start {

	public static void main(String[] args) throws IOException{
		System.out.println("Welcome to Student Management App");
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println("Press 1 to Add Student");
			System.out.println("Press 2 to Delete Student");
			System.out.println("Press 3 to Display Student");
			System.out.println("Press 4 to Update Student");
			System.out.println("Press 5 to exit Student");
			int c=Integer.parseInt(br.readLine());
			
			if(c==1) {
				System.out.println("Enter user name");
				String name=br.readLine();
				
				System.out.println("Enter user phone");
				String phone =br.readLine();
				
				System.out.println("Enter user city");
				String city=br.readLine();
				
				Student st=new Student(name,phone,city);
				
				boolean answer=StudentDAO.insertStudentToDB(st);
				if(answer) {
					System.out.println("Student is added successfully");
				}else {
					System.out.println("something went wrong try again");
				}
				System.out.println(st);
				}
			else if(c==2) {
				System.out.println("Enter student id to delete");
				int userId=Integer.parseInt(br.readLine());
				boolean f=StudentDAO.deleteStudent(userId);
				if(f) {
					System.out.println("Deleted");
				}
				else {
					System.out.println("Something went wrong");
				}
			}
			else if(c==3) {
				
				StudentDAO.showAllStudent();
				
			}
			else if(c==4) {
				System.out.println("Enter student id to update");
				int userId=Integer.parseInt(br.readLine());
				System.out.println("Enter user name");
				String name=br.readLine();
				
				System.out.println("Enter user phone");
				String phone =br.readLine();
				
				System.out.println("Enter user city");
				String city=br.readLine();
				
				Student st=new Student(name,phone,city);
				
				boolean answer=StudentDAO.updateStudentToDB(userId,st);
				if(answer) {
					System.out.println("Student data is updated successfully");
				}else {
					System.out.println("something went wrong try again");
				}
				System.out.println(st);
			}
			else if(c==5) {
				break;
			}
			
		}
		System.out.println("Thank you using this App");
	}

}
