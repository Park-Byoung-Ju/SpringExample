package com.totra.spring.ex.mybatis.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.totra.spring.ex.mybatis.domain.Review;

@Mapper
public interface ReviewRepository {

	public Review selectReview(@Param("id") int id);
	
	// 전달받은 리뷰 정보를 기반으로 insert한다.
	public int insertReview(
						  @Param("storeId") int StoreId
						, @Param("menu") String menu
						, @Param("userName") String userName
						, @Param("point") double point
						, @Param("review") String review);
	
	// 전달받은 Review 객체로 insert한다
	public int insertReviewByObject(Review review);
}
