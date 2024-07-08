package com.demo;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.entity.Student;
import com.demo.repository.StudentRepository;

@SpringBootTest
class DemoappwinApplicationTests {

	@Autowired
	private StudentRepository studentrepository;
	
	@Test
	void addStudent() {
		Student s=new Student();
		s.setName("Mike");
		s.setEmail("Mike@gmail.com");
		s.setCourse("java");
		s.setFee(10000);
		studentrepository.save(s);
	}
	
	@Test
	void deleteStudentRecord() {
		studentrepository.deleteById(3);
	}
	
	@Test
	void getStudentRecord() {
		Optional<Student> opStudent = studentrepository.findById(10);
		if(opStudent.isPresent()) {
			System.out.println(opStudent.get()); 
//			System.out.println(student.getId());
//			System.out.println(student.getName());
//			System.out.println(student.getCourse());
//			System.out.println(student.getEmail());
//			System.out.println(student.getFee());
		}
		else {
			System.out.println("No Record Found");
		}
	}
	
	@Test
	void updateStudentRecord() {
		Optional<Student> opStudent = studentrepository.findById(10);
		if(opStudent.isPresent()) {
			Student s= opStudent.get();
			s.setName("Stallin");
			s.setEmail("Stallin@gmail.com");
			s.setCourse("java");
			s.setFee(10000);
			studentrepository.save(s);
		}
		else {
			System.out.println("No Record Found");
		}
	}
	
	@Test
	void getAllStudents() {
		Iterable<Student> students = studentrepository.findAll();
		for(Student student:students) {
			System.out.println(student.getId());
			System.out.println(student.getName());
			System.out.println(student.getCourse());
			System.out.println(student.getEmail());
			System.out.println(student.getFee());
		}
		
	}

}
