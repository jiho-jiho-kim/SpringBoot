package com.myweb.basic.product;

import java.util.List;

import com.myweb.basic.command.ProductVo;

public interface ProductService {

	public boolean productRegist(ProductVo vo);
	
	public List<ProductVo> getList(); //조회
	
	public ProductVo getDetail(int prod_id);
	
}
