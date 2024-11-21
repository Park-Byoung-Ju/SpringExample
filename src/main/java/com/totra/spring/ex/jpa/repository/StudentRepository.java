package com.totra.spring.ex.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.totra.spring.ex.jpa.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{ // Entity, primary key
	
	// 아무것도 없어도 lombok에서 여러가지 기능의 메소드가 있다
	
}
