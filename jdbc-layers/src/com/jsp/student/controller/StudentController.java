package com.jsp.student.controller;

import com.jsp.student.dao.StudentCrud;
import com.jsp.student.dto.Student;

public class StudentController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student student = new Student();
		student.setId(10);
		student.setName("Sanket");
		student.setEmail("phoenixsan10@gmail.com");

		StudentCrud studentCrud = new StudentCrud();
		//studentCrud.saveStudent(student);
	//	studentCrud.deleteStudentById(13);
		//studentCrud.updateStudent(student);
		 studentCrud.getStudentDetails(10);
	}

}
