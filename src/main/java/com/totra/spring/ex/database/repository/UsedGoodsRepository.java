package com.totra.spring.ex.database.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.totra.spring.ex.database.domain.UsedGoods;

// 데이스베이스 관련 처리
// Mybatis Framwork 연동
@Mapper
public interface UsedGoodsRepository {
	
	//used_goods 테이블 모든 행 조회
	public List<UsedGoods> selectUsedGoodsList();
}
