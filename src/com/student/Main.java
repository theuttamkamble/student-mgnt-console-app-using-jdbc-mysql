package com.student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import com.student.operations.Operations;

public class Main {

public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		
		/*
		 * steps to create jdbc App
		 * 1. Load the Driver class.
		 * 2. Create Connection using DriverManager.
		 * 3. Use Connection to fire query
		 * 	Statement for static Query
		 * 	PreparedStatement for dynamic Query
		 * 4. Process the result (ResultSet)
		 * 5. Close the Connection
		 */
		System.out.println("[Welcome To Student Management JDBC App]");
		BufferedReader out = new BufferedReader(new InputStreamReader(System.in)); // we can also use Scanner class here
		
		while(true) {
			System.out.println("--------------------------");
			System.out.println("1 for Display All Student");
			System.out.println("2 for Create New Student");
			System.out.println("3 for Update a Student");
			System.out.println("4 for Delete Student");
			System.out.println("5 for Exit App");
			System.out.println("--------------------------");
			System.out.println("Select Your Option:");
			
			int option = Integer.parseInt(out.readLine());
			if(option == 1) {
				Operations.displayAll();
			} else if(option == 2) {
				Operations.createStudent();
			} else if(option == 3) {
				Operations.updateStudent();
			} else if(option == 4) {
				Operations.deleteStudent();
			} else if(option == 5) {
				System.out.println("Thank you!");
				System.out.println("-------Visit again!-------");
				break;
			} else {
				System.out.println("try again.");
			}
		}
	}
}
