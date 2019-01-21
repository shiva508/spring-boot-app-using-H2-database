package com.example.demo.dependancyInjectionRESOURCE;

public class ProductServiceImpl2 implements ProductService {

	@Override
	public String getProductDetails(String prodictid) {
		return "Product details from impl 2, for Product id=" + prodictid;
	}

}
