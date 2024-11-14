package com.totra.spring.ex.ajax;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.totra.spring.ex.mvc.service.UserService;

@RequestMapping("/ajax/user")
@Controller
public class NewUserController {
	
	@Autowired
	private UserService userService;

	@PostMapping("/create")
	@ResponseBody
	//사용자 추가 api
	public  Map<String, String> createUser(
			@RequestParam("name") String name
			,@RequestParam("birthday") String birthday
			,@RequestParam("email") String email
			,@RequestParam("introduce") String introduce) {
		
		int count = userService.addUser(name,birthday,email,introduce);
		Map<String, String> resultMap = new HashMap<>();
		if(count == 1) {
			//성공 {result:"success"}
			resultMap.put("result", "success");
		}else {
			//실패 {result:"fail"}
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
	@GetMapping("/input")
	public String userInput() {
		return "ajax/userInput";
	}
}
