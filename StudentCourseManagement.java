package module5.activity3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentCourseManagement {
	
	static String dbUrl = "jdbc:postgresql://localhost:5432/training_db";
	
	static int DisplayMenu() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n=== STUDENT COURSE MANAGEMENT ===");
		System.out.println("[1] Add Student");
		System.out.println("[2] Add Course");
		System.out.println("[3] Show Students");
		System.out.println("[4] Show Courses");
		System.out.println("[0] Exit");
		System.out.print("Choice: ");
		
		if (scanner.hasNextInt()) {
			int id = scanner.nextInt();
			scanner.nextLine();
			if ( id >= 0 && id < 5 ) {
				return id;
			} else {
				System.out.println("Invalid Menu Choice, Please choose between 0 - 4.");

			}
		} else {
			System.out.println("Invalid Menu Choice, please provide numeric value.");
			scanner.nextLine();
		}
		return -1;
	}
	
	public static Connection getDBConnection() {
		Connection conn = null;
		try {
			String username = "postgres";
			String password = "postgres";
			conn = DriverManager.getConnection(dbUrl, username, password);
			return conn;
		} catch (SQLException e) {
			System.out.println("Error Connection Failed: " + e.getMessage());
			e.printStackTrace();
			return null;
		} //try
		
	} // getDBConnection();
	
	public static void ShowStudens(Connection dbConn) {
	
		try {
			PreparedStatement ps;
			String sql = "SELECT * FROM students";
			ps = dbConn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			System.out.println("\n-[ STUDENT LIST ] -------------------------------------------------------------");
			System.out.printf("%-5s %-32s %-5s %-20s %n", "ID", "Name", "Age", "Email");
			System.out.println("-------------------------------------------------------------------------------");
			while (rs.next()) {
				System.out.printf("%-5s %-32s %-5s %-20s %n", rs.getString("id"), rs.getString("name"),rs.getString("age"),rs.getString("email"));			
			} // while
			System.out.println("-------------------------------------------------------------------------------");
			
			ps.close();
			rs.close();	
		} catch (Exception e) {
			e.printStackTrace();
		} // try
		
	} // ShowStudens()
	
	
	public static void ShowCourses(Connection dbConn) {
		
		try {
			PreparedStatement ps;
			String sql = "SELECT c.ID, c.COURSE_NAME, c.GRADE, s.NAME FROM COURSES c INNER JOIN STUDENTS s ON c.STUDENT_ID = s.ID;";
			ps = dbConn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			System.out.println("\n-[ COURSE LIST ] --------------------------------------------------------------");
			System.out.printf("%-5s %-20s %-10s %-20s %n", "ID", "Course Name", "Grade", "Student");
			System.out.println("-------------------------------------------------------------------------------");
			while (rs.next()) {
				System.out.printf("%-5s %-20s %-10s %-20s %n", rs.getString("id"), rs.getString("course_name"),rs.getString("grade"),rs.getString("name"));			
			} // while
			System.out.println("-------------------------------------------------------------------------------");
			
			ps.close();
			rs.close();	
		} catch (Exception e) {
			e.printStackTrace();
		} // try
		
	} // ShowCourses()
	
	
	
	static void AddStudent(Connection dbConn) {
		
		Scanner scanner = new Scanner(System.in);
		
		try {
			PreparedStatement ps;
			String sql = "INSERT INTO students (name, age, email) VALUES (?, ?, ?)";
			ps = dbConn.prepareStatement(sql);
			
			System.out.println("\n-[ ADD A STUDENT ] --------------------------------------------------------------");
			
			String studentName;
			int studentAge;
			String studentEmail;
			
			
			while (true) {
				System.out.print("Enter Name: ");
				studentName = scanner.nextLine();
				
				if (studentName.trim().isEmpty()) {
					System.out.println("Please supply Student Name.");
				} else {
					break;
				}
			}// while
			
					
			while (true) {
				System.out.print("Enter Age: ");
				if (scanner.hasNextInt()) {
					studentAge = scanner.nextInt();		
					break;
				} else {
					System.out.println("Please supply numeric ID.");
					scanner.nextLine();
				}
			}// while
			
			scanner.nextLine();
			while (true) {
				System.out.print("Enter email: ");
				studentEmail = scanner.nextLine();
				
				if (studentEmail.trim().isEmpty()) {
					System.out.println("Please supply Student Email.");
				} else {
					break;
				}
			}// while
				
			ps.setString(1, studentName);
			ps.setInt(2, studentAge);
			ps.setString(3, studentEmail);
			
			int rowsInserted = ps.executeUpdate(); 
			if (rowsInserted > 0) { 
				System.out.printf("%nStudent %s successfully added!%n", studentName); 
				
				ShowStudens(dbConn);
				
			} else {
				System.out.printf("%nERROR: Failed to add new student!"); 
			}
			
			ps.close();
	
		} catch (Exception e) {
			e.printStackTrace();
		} // try
		
	}// AddStudent()
	
	
	public static boolean checkIfStudentExists(int studentID, Connection dbConn) {
		
		try {
			
			String sql = "SELECT 1 FROM STUDENTS WHERE id = ?";
			PreparedStatement ps = dbConn.prepareStatement(sql);
			ps.setInt(1, studentID);
			ResultSet rs = ps.executeQuery(); 
	
			boolean found = false;
			if (rs.next()) found = true;
		
			ps.close();
			rs.close();
			
			return found;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	} //checkIfStudentExists
	
	

	static void AddCourse(Connection dbConn) {
		
		Scanner scanner = new Scanner(System.in);
		
		try {
			PreparedStatement ps;
			String sql = "INSERT INTO COURSES (student_id, course_name, grade) VALUES (?, ?, ?)";
			ps = dbConn.prepareStatement(sql);
			
			System.out.println("\n-[ ADD A COURSE ] --------------------------------------------------------------");
			
			int studentID;
			double studentGrade;
			String courseName;
				
			while (true) {
				System.out.print("Enter Student ID: ");
				if (scanner.hasNextInt()) {
					studentID = scanner.nextInt();				
					if (checkIfStudentExists(studentID, dbConn)) {		
						break;
					} else {
						System.out.println("Student ID provided is not found, please provide valid student ID!");
					}
				} else {
					System.out.println("Please supply numeric ID.");
					scanner.nextLine();
				}
			}// while
			
			scanner.nextLine();
			while (true) {
				System.out.print("Enter Course Name: ");
				courseName = scanner.nextLine();
				
				if (courseName.trim().isEmpty()) {
					System.out.println("Please supply Course Name");
				} else {
					break;
				}
			}// while
			
			

			while (true) {
				System.out.print("Enter Grade: ");
			
				if (scanner.hasNextDouble()) {
					studentGrade = scanner.nextDouble();	
					break;
				} else {
					System.out.println("Please supply numeric grade.");
					scanner.nextLine();
				}
			}// while
			
			
				
			ps.setInt(1, studentID);
			ps.setString(2, courseName);
			ps.setDouble(3, studentGrade);
			
			int rowsInserted = ps.executeUpdate(); 
			if (rowsInserted > 0) { 
				System.out.printf("%nCourse %s successfully added!%n", courseName); 
				
				ShowCourses(dbConn);
				
			} else {
				System.out.printf("%nERROR: Failed to add new course!"); 
			}
			
			ps.close();
			
			
	
		} catch (Exception e) {
			e.printStackTrace();
		} // try
		
	}// AddCourse()
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection dbConn = getDBConnection();
		if (dbConn == null) {
			System.out.println("Failed to establish connection to database: " + dbUrl + " Please check...");
		} else {
			Boolean exit = false;
			
			while (!exit) {
				int choice = DisplayMenu();
				
				switch(choice) {
				
					case 1: AddStudent(dbConn);
							break;
							
					case 2: AddCourse(dbConn);
							break;
	
					case 3: ShowStudens(dbConn);
							break;
							
					case 4: ShowCourses(dbConn);
							break;
							
					case 0: exit = true;
							System.out.println("Bye");
							break;
							
				}// switch
			
			}// while
		}

		
		
		try {
			if (dbConn != null) {
				dbConn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	
	}

}
