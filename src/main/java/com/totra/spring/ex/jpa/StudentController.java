package com.totra.spring.ex.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.totra.spring.ex.jpa.domain.Student;
import com.totra.spring.ex.jpa.repository.StudentRepository;
import com.totra.spring.ex.jpa.service.StudentService;

@RequestMapping("/jpa/student")
@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	
	// spring mvc 활용법에 맞지않고 위험하기 때문에 이렇게 사용하지 말것
	@Autowired
	private StudentRepository studentRepository;
	
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
	
	@ResponseBody
	@GetMapping("/find")
	public List<Student> findStudent() {
		
		List<Student> studentList = null;
		
		// 모든 행 조회
		// List<Student> studentList = studentRepository.findAll();
		
		// 모든 행을 id 컬럼 내림 차순으로 조회
		// studentList = studentRepository.findAllByOrderByIdDesc();
		
		// id 기준으로 내림차순 정렬된 결과를 2개만 조회
		// ORDER BY `id` DESC LIMIT 2
		// studentList = studentRepository.findTop2ByOrderByIdDesc();
		
		// 전달받은 이름과 일치하는 행 조회
		// WHERE `name` = #{name}
		// studentList = studentRepository.findByName("실험용");
	
		// 여러 이름
		/*
		List<String> nameList = new ArrayList<>();
		nameList.add("유재석");
		nameList.add("조세호");
		
		studentList = studentRepository.findByNameIn(nameList);
		*/
		
		// 전달 받은 키워드가 포함된 email 컬럼을 가진 행 조회
		// WHERE `email` LIKE '%${keyword}';
		//studentList = studentRepository.findByEmailContaining("email");
		
		//between
		// studentList = studentRepository.findIdBetweenOrderbyIdDesc(2,5);
		
		// native Query
		studentList = studentRepository.selectByDreamJob("개발자");
		
		return studentList;
	}
}
