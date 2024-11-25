package com.totra.spring.ex.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.totra.spring.ex.jpa.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{ // Entity, primary key
	
	// 아무것도 없어도 lombok에서 여러가지 기능의 메소드가 있다
	
	// 필요한 것을 모두 정의해놓을수는 없으므로 따로 정의할수도있다
	// ID 기준으로 내림차순 정렬된 결과 조회
	// ORDER BY `id` DESC
	public List<Student> findAllByOrderByIdDesc();
	
	public List<Student> findTop2ByOrderByIdDesc();
	
	// 전달받은 이름과 일치하는 행 조회
	public List<Student> findByName(String name);
	
	
	public List<Student> findByNameIn(List<String> nameList);
	
	// 전달 받은 키워드가 포함된 email 컬럼을 가진 행 조회
	// WHERE `email` LIKE '%${keyword}';
	public List<Student> findByEmailContaining(String keyword);
	
	// id 컬럼 값이 특정한 값들 사이에 포함되는 행을 id 기반으로 내림차순 해서 조회
	// WHERE `id` BETWEEN 1 AND 3 ORDER BY `id` DESC;
	public List<Student> findIdBetweenOrderbyIdDesc(int start, int end);
	
	// 쿼리를 직접 작성
	// Native Query
	// dreamJob 일치하는 행 조회
	@Query(value="SELECT * FROM `new_student` WHERE `dreamJob` = :dreamJob", nativeQuery=true)
	public List<Student> selectByDreamJob(@Param("dreamJob") String dreamJob);
	
}
