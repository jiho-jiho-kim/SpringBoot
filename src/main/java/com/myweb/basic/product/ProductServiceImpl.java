package com.myweb.basic.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myweb.basic.command.ProductVo;

@Service("productService")
public class ProductServiceImpl implements ProductService {
	

	@Autowired
	ProductMapper productMapper;

	@Override
	public boolean productRegist(ProductVo vo) {
		
		return productMapper.productRegist(vo);
	}

	@Override
	public List<ProductVo> getList() {
		
		return productMapper.getList();
	}

	@Override
	public ProductVo getDetail(int prod_id) {
		
		return productMapper.getDetail(prod_id);
	}
	
	
}
