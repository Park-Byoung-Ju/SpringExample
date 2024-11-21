package com.totra.spring.ex.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.totra.spring.ex.jpa.domain.Student;
import com.totra.spring.ex.jpa.service.StudentService;

@RequestMapping("/jpa/student")
@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	// created, update, delete
	
	// 한 학생의 정보 저장 기능
	@ResponseBody
	@GetMapping("/create")
	public Student  createdStudent() {
		// 이름, 전화번호, 이메일, 장래희망
		// 실험용, 010-1234-5678, email@domain.com, 개발자
		Student student = studentService.addStudent("실험용", "010-1234-5678", "email@domain.com", "개발자");
		
		return student;
	}
	
	@ResponseBody
	@GetMapping("/update")
	public Student updateStudent() {
		// id가 3인 장래희망을 강사로 변경
		Student student = studentService.updateStudent(3, "강사");
		
		return student;
	}
	
	@ResponseBody
	@GetMapping("delete")
	public String deleteStudent() {
		
		studentService.deleteStudent(3);
		
		return "삭제!!";
	}
	

	@ResponseBody
	@GetMapping("/lombok")
	public Student lombokTest() {
		//Student student = new Student(1, "실험용", "010-1234-5678", "email@domain.com", "개발자", null, null);
		
		/*
		student.setName("실험용");
		student.setEmail("email@domain.com");
		student.setPhoneNumber("010-1234-5678");
		*/
		
		Student student = Student.builder()
									.name("실험용")
									.email("email@domain.com")
									.phoneNumber("010-1234-5678")
									.build();
		
		return student;
	}
}
