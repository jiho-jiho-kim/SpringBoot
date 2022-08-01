package com.myweb.basic.product;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.myweb.basic.command.ProductVo;

@Mapper
public interface ProductMapper {

	public boolean productRegist(ProductVo vo);
	
	public List<ProductVo> getList(); //조회
	
	public ProductVo getDetail(int prod_id);
}
