package com.totra.spring.ex.lifecycle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 해당 클래스의 모든 메소드에 @ResponseBody가 적용된다.
@RestController // @Controller + @ResponseBody
@RequestMapping("/lifecycle/ex01") // 이렇게 클래스에 지정해주면 기본 주소가 지정된다.
public class Ex01RestController {

	
	// 직접만든 클레스 객체 리턴
	@RequestMapping("/3") // 그래서 뒤에 붙을 주소만 기재해주면 된다
	public Person objectResponse() {
		Person me = new Person("김인규", 31);
		
		return me;
	}
	
	// status code 적용
	@RequestMapping("/4")
	public ResponseEntity<Person> entityResponse() {
		
		Person me = new Person("김인규", 31);
		
		ResponseEntity<Person> entity = new ResponseEntity<Person>(me, HttpStatus.INTERNAL_SERVER_ERROR);
		
		return entity;
	}
	
}
