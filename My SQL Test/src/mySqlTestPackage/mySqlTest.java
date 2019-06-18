package mySqlTestPackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class mySqlTest {

	public static void main(String[] args) {
		//String[] s = { "test_schema", "root", "root" };
		String[] s = getUserInput();
		createConnection(s);
	}
	
	public static String[] getUserInput() {
		String[] myInput = new String[3];
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Please enter database name : ");
		myInput[0] = scn.next();
		System.out.println("Please enter username : ");
		myInput[1] = scn.next();
		System.out.println("Please enter password : ");
		myInput[2] = scn.next();
		
		scn.close();
		
		return myInput;		
	}
	
	
	public static void createConnection(String[] s) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String connectString = "jdbc:mysql://localhost:3306/" + s[0];
			Connection connect = java.sql.DriverManager.getConnection(connectString,s[1],s[2]);
			System.out.println("You have successfully connected to " + s[0]);
			
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT name FROM test_table");
			while(rs.next()) {
				System.out.println(rs.getString("name"));
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
