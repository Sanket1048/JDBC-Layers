package com.jsp.student.controller;

import java.util.ArrayList;

import com.jsp.student.dao.StudentCrud;
import com.jsp.student.dto.Student;

public class BatchStudentController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentCrud stud = new StudentCrud();  
		Student s = new Student ();
		s.setEmail("san@gmail.com");
		s.setId(90);
		s.setName("san");
		Student s1 = new Student ();
		s1.setEmail("han@gmail.com");
		s1.setId(91);
		s1.setName("han");
		
		 
		Student s2 = new Student ();
		s2.setEmail("man@gmail.com");
		s2.setId(92);
		s2.setName("man");
		
		ArrayList<Student> al = new ArrayList<>();
		al.add(s);
		al.add(s1);
		al.add(s2);
		stud.batchExecution(al);
	}

}
