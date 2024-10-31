package com.totra.spring.ex.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	@ResponseBody
	@RequestMapping("/hello")
	public String helloWorld() {
		return "Hello World!!";
	}
	
	// servlet에 비해 설정할 것이 없다. 모두 세팅을 sts에서 해주기 때문이다.
	// spring은 데이터를 보낼때 자료형이 아닌 객체형일때 json형태로 만들어서 보낸다.
	// Jackson Library가 컴파일 단계에서 json형태의 데이터로 변환해준다.
	
}
