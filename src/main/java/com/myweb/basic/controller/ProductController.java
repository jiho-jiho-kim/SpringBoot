package com.myweb.basic.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myweb.basic.command.ProductVo;
import com.myweb.basic.product.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	@Qualifier("productService")
	ProductService productService;
	
	
	@GetMapping("/productReg")
	public String productReg() {
		return "product/productReg";
	}
	
	@GetMapping("/productList")
	public String productList(Model model) {
		
		//1st - admin 기반으로 조회(나중에 세션값으로 변경)
		List<ProductVo> list = productService.getList();
		model.addAttribute("list", list);
		
		
		return "product/productList";
	}

	@GetMapping("/productDetail")
	public String productDetail(@RequestParam("prod_id") int prod_id, Model model) {
		
		/*
		 * 1.화면에서 넘어오는 prod_id 값을 받습니다.
		 * 2.getDetail(prod_id) 형식으로 select한 결과를 vo에 저장합니다
		 * 3.model에 vo를 저장합니다.
		 * 4.화면에는 vo의 결과값을 출력해주세요.
		 */
		
		ProductVo vo = productService.getDetail(prod_id);
		model.addAttribute("vo", vo);
		
		return "product/productDetail";
	}
	
	@PostMapping("/productForm")
	public String productForm(@Valid ProductVo vo, Errors errors, Model model) {
		
		if(errors.hasErrors()) {
			List <FieldError> list = errors.getFieldErrors();
			for(FieldError err : list) {
				if(err.isBindingFailure()) {
					model.addAttribute("valid" + err.getField(), "형식을 일치시켜주세요");
				}else {
					model.addAttribute("valid_" + err.getField(), err.getDefaultMessage() );
				}
			}
			
			//다시 등록화면으로
			model.addAttribute("vo", vo);
			return "product/productReg";
		}
		
		//상품등록
		boolean result = productService.productRegist(vo);
				
		return "redirect:/product/productList";
		
		
	}
	
	
	
	
}
