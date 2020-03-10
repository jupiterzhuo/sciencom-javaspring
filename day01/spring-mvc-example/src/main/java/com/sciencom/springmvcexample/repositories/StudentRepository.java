package com.sciencom.springmvcexample.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.sciencom.springmvcexample.model.Student;

@Repository
public class StudentRepository {
	private static final Map<String, Student> STUDENTS = new HashMap<>();
	//Static Initial Block
	static {
		Student student1 = new Student("0001", 
				"Jupiter", "Zhuo", "Jupiterc@gmail.com", "M", "ID");
		Student student2 = new Student("0002", 
				"Davin", "Zhuo", "dd@gmail.com", "M", "ID");
		STUDENTS.put(student1.getUserName(), student1);
		STUDENTS.put(student2.getUserName(), student2);
	}
	
	public List<Student> getAllStudent(){
		List<Student> listStudents = new ArrayList<Student>();
		listStudents.addAll(STUDENTS.values());
		return listStudents;
	}
	
}
