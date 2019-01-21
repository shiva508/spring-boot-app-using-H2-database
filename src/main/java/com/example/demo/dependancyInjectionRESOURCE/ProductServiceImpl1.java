package com.example.demo.dependancyInjectionRESOURCE;

public class ProductServiceImpl1 implements ProductService {

	@Override
	public String getProductDetails(String prodictid) {
		
		return "Product details from impl 1, for Product id=" + prodictid;
	}

}
