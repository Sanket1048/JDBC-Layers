package com.jsp.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.jsp.student.dto.Student;
import com.jsp.student.util.HelperClass;

public class StudentCrud {
	HelperClass helperClass = new HelperClass();
	
	
	public void saveStudent(Student student) {
		Connection connection = helperClass.getConnection();
		String sql = "INSERT INTO student VALUES(?,?,?)";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, student.getId());
			preparedStatement.setString(2, student.getName());
			preparedStatement.setString(3, student.getEmail());
			
			
			preparedStatement.execute();
				System.out.println("student installed in database");
			
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void deleteStudentById(int id) {
		Connection connection = helperClass.getConnection();
		String sql ="DELETE FROM student WHERE id =?";
		
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);  
			
			
			int id1 = preparedStatement.executeUpdate();
			if (id1>0) {
				System.out.println("Data Deleted");
			}else {
				System.out.println("Not deleted");
			}
			
			if (connection != null) {
				connection.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	}
	public void updateStudent(Student student) {
		Connection connection = helperClass.getConnection();
		String sql = "UPDATE student SET studentname = ? , email =? WHERE id = ?"  ;
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,student.getName());
			preparedStatement.setString(2,student.getEmail());
			preparedStatement.setInt(3,student.getId());
			
			int a = preparedStatement.executeUpdate();
			
			if (a>0) {
				System.out.println("Student Updated");
			}else {
				System.out.println("Student not Updated");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		}
	
	public void getStudentDetails(int id) {
		Connection connection = helperClass.getConnection();
		String sql = "SELECT * FROM student";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int id1 = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String email = resultSet.getString(3);
				
				System.out.println("=================");
				System.out.println(name);
				System.out.println(email);
				System.out.println(id);


			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void batchExecution(List <Student>list) {
		
		Connection connection = helperClass.getConnection();
		String sql ="INSERT INTO student VALUES(?,?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			for(Student s : list) {
				preparedStatement.setInt(1, s.getId());
				preparedStatement.setString(2, s.getName());
				preparedStatement.setString(3, s.getEmail());
				
				preparedStatement.addBatch();
				System.out.println("Student "+ s.getName()+" added");
			}
			preparedStatement.executeBatch();
			if(connection != null) {
			connection.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
