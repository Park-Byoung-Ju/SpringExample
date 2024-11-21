package com.totra.spring.ex.jpa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.totra.spring.ex.jpa.domain.Student;
import com.totra.spring.ex.jpa.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	public Student addStudent(String name, String phoneNumber, String email, String dreamJob) {
		
		
		// find : select
		// delete : delete
		// save : insert
		Student student = Student.builder()
									.name(name)
									.phoneNumber(phoneNumber)
									.email(email)
									.dreamJob(dreamJob)
									.build();
		
		Student result = studentRepository.save(student); 
		
		return result;
	}
	
	public Student updateStudent(int id, String dreamJob) {
		// updated 대상을 조회한다.
		// 조회된 결과 객체를 얻어온다.
		// 조회된 객체에서 수정사항을 적용한다.
		// 수정된 객체를 저장한다.
		
		//일반적인 entity 클래스로 받지 못하고 Optional로 받아야한다
		// Optional : null 일 수도 있는 객체를 null을 처리하는 기능으로 감싸놓은 객체
		// null을 다룰때 발생될 수 있는 NullPointerException 위험없이 처리하도록 도와준다.
		Optional<Student> optionalStudent = studentRepository.findById(id);
		
		// null일떄 null로 return 아닐때는 객체로 리턴
		Student student = optionalStudent.orElse(null);		
		
		student = student.toBuilder().dreamJob(dreamJob).build();
			
		// id에 대응되는 값이 없으면 insert
		// id에 대응되는 값이 있으면 update로 실행된다
		Student result = studentRepository.save(student);
		
		return result;
	}
	
	public void deleteStudent(int id){
		// 삭제 대상을 조회한다.
		// 조회된 객체를 통해 삭제한다.
		Optional<Student> optionalStudent =  studentRepository.findById(id);
		
		Student student = optionalStudent.orElse(null);
		
		studentRepository.delete(student);
		
	}
}
