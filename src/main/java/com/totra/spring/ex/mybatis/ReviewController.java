package com.totra.spring.ex.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.totra.spring.ex.mybatis.domain.Review;
import com.totra.spring.ex.mybatis.service.ReviewService;

@Controller
@RequestMapping("/mybatis/review")
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	// id가 5인 리뷰 정보를 json으로 response에 담는다
	@ResponseBody
	@RequestMapping("/select")
	public Review review(@RequestParam("id") int id){
		
		Review review1 = reviewService.getReview(id);
		return review1;
	}
	
	/*@RequestParam("storeId") int storeId
	,@RequestParam("menu") String menu
	,@RequestParam("userName") String userName
	,@RequestParam("point") double point
	,@RequestParam("review") String review
	/**/
	// 리뷰내용을 저장하는 기능
	@RequestMapping("/create")
	public String createReview() {
		// 4, 치즈피자, 김인규, 4.5, 치즈피자 존맛!
		// storeId=4&menu=치즈피자&userName=김인규&point=4.5&review=치즈피자 존맛!
		// int count = reviewService.addReview(storeId, menu, userName, point, review);
		
		//2, 뿌링클, 김인규, 4.0, 역시 뿌링클은 진리입니다!
		Review review1 = new Review();
		review1.setStoreId(2);
		review1.setMenu("뿌링클");
		review1.setUserName("김인규");
		review1.setPoint(4.0);
		review1.setReview("역시 뿌링클은 진리입니다");
		
		int count = reviewService.addReviewByObject(review1);
		return "삽입결과 : " + count;
	}
}
