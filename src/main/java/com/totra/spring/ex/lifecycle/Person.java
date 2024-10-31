package com.totra.spring.ex.lifecycle;

public class Person {

	// 멤버 변수
	// 이름, 나이
	private String name;
	
	private int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "이름 : " + name + ", 나이 : " + age;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getAge() {
		return this.age;
	}
}
