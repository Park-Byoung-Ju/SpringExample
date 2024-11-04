package com.totra.spring.ex.mybatis.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.totra.spring.ex.mybatis.domain.Review;

@Mapper
public interface ReviewRepository {

	public Review selectReview(@Param("id") int id);
}
