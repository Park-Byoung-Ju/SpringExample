package com.totra.spring.ex.lifecycle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Ex02Controller {

	// ResponseBody를 사용하면 string이 그대로 body에 담겨서 파일이 실행되지 않는다.
	@RequestMapping("/lifecycle/ex02")
	public String thymleafEx() {
		return "lifecycle/ex02";
	}
}
