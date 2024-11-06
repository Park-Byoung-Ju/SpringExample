package com.totra.spring.ex.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.totra.spring.ex.mybatis.domain.Review;
import com.totra.spring.ex.mybatis.repository.ReviewRepository;

@Service
public class ReviewService {
	@Autowired
	private ReviewRepository reviewRepository;
	
	public Review getReview(int id){
		Review review = reviewRepository.selectReview(id);
		return review;
	}
	
	// 전달받은 리뷰 정보를 기반으로 리뷰 저장
	public int addReview(int storeId
					,String menu
					,String userName
					,double point
					,String review) {
		// 4, 치즈피자, 김인규, 4.5, 치즈피자 존맛!
		int count = reviewRepository.insertReview(storeId, menu, userName, point, review);
		
		return count;
	}
	
	public int addReviewByObject(Review review) {
		// 전달받은 Review 객체로 new_review에 전달
		
		int count = reviewRepository.insertReviewByObject(review);
		return count;
	}
}
