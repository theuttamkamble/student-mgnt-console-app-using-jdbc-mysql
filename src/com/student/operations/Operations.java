package com.student.operations;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.student.dbcon.DBConnection;

public class Operations {
	static Scanner sc = new Scanner(System.in);

	// Display All Students
	public static void displayAll() throws ClassNotFoundException, SQLException {
		String select = "select * from studjdbcapp;";
		ResultSet rs = DBConnection.getStatement().executeQuery(select);

		System.out.println("------------------------------");
		System.out.println("sid\t\tsname\t\tcity\t\tgender");
		System.out.println("------------------------------");
		
		while (rs.next()) {
			System.out.println();
			System.out.print(rs.getInt(1) + "\t\t");
			System.out.print(rs.getString(2) + "\t\t");
			System.out.print(rs.getString(3) + "\t\t");
			System.out.print(rs.getString(4));
		}
		
		System.out.println();
		System.out.println("------------------------------\n");
	}

	// Create New Student
	public static void createStudent() throws ClassNotFoundException, SQLException {
		System.out.println("How many students do you want to create? \n:");
		int opt = sc.nextInt();
		sc.nextLine();

		for (int i = 1; i <= opt; i++) {
			System.out.println("Enter Student " + i + " information");

			System.out.print("Enter Student Name: ");
			String sname = sc.nextLine();

			System.out.print("Enter Student City: ");
			String city = sc.nextLine();

			System.out.print("Enter Student Gender: ");
			char gender = sc.nextLine().charAt(0);

			String insert = "insert into studjdbcapp (sname, city, gender) values ('" + sname + "', '" + city + "', '"+ gender + "'" + ");";
			DBConnection.getStatement().executeUpdate(insert);
			System.out.println();
		}
		System.out.println("Student/s Created Successfully.\n");

	}

	// Update a Student
	public static void updateStudent() throws ClassNotFoundException, SQLException {
		System.out.print("Enter Student ID for update: ");
		int sid = sc.nextInt();
		sc.nextLine();

		System.out.println("What do you want to update?");
		System.out.println("1 for Name");
		System.out.println("2 for City");
		System.out.println("3 for gender");
		System.out.print("Choose Option: ");

		int opt = sc.nextInt();
		sc.nextLine();

		switch (opt) {
		case 1:
			System.out.print("Enter new Name: ");
			String sname = sc.nextLine();
			DBConnection.getStatement()
					.executeUpdate("update studjdbcapp set sname = '" + sname + "' where sid = " + sid + ";");
			System.out.println("Student " + sid + " Updated.");
			break;

		case 2:
			System.out.print("Enter new City: ");
			String city = sc.nextLine();
			DBConnection.getStatement()
					.executeUpdate("update studjdbcapp set city = '" + city + "' where sid = " + sid + ";");
			System.out.println("Student " + sid + " Updated.");
			break;

		case 3:
			System.out.print("Enter new Gender: ");
			char gender = sc.nextLine().charAt(0);
			DBConnection.getStatement()
					.executeUpdate("update studjdbcapp set gender = '" + gender + "' where sid = " + sid + ";");
			System.out.println("Student " + sid + " Updated.");
			break;

		default:
			System.out.println("Try again!");
			break;
		}
		System.out.println();

//		  You can also use if else statement here
		/*
		 * if(opt == 1) { 
		 * System.out.print("Enter new Name: "); 
		 * String sname = sc.nextLine();
		 * StatementObj.getStmt().executeUpdate("update studjdbcapp set sname = '" +sname+"' where sid = "+sid+";");
		 * System.out.println("Student "+sid+" Updated."); 
		 * } else if(opt == 2) {
		 * System.out.print("Enter new City: "); 
		 * String city = sc.nextLine();
		 * StatementObj.getStmt().executeUpdate("update studjdbcapp set city = '" +city+"' where sid = "+sid+";");
		 * System.out.println("Student "+sid+" Updated."); 
		 * } else if(opt == 3) {
		 * System.out.print("Enter new Gender: "); 
		 * char gender = sc.nextLine().charAt(0);
		 * StatementObj.getStmt().executeUpdate("update studjdbcapp set gender = '" +gender+"' where sid = "+sid+";");
		 * System.out.println("Student "+sid+" Updated."); 
		 * } else {
		 * System.out.println("Try again!"); 
		 * }
		 */
	}

//	 Delete a Student
	public static void deleteStudent() throws ClassNotFoundException, SQLException {
		System.out.print("Enter Student ID for delete : ");
		int sid = sc.nextInt();
		String delete = "delete from studjdbcapp where sid = " + sid + ";";

		int res = DBConnection.getStatement().executeUpdate(delete);
		if (res == 1) {

			System.out.println("Student " + sid + " deleted.");
		} else {
			System.out.println("Student not found.");
		}
		System.out.println();
	}
}
