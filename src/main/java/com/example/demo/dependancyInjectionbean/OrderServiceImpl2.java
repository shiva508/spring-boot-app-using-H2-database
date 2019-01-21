package com.example.demo.dependancyInjectionbean;

public class OrderServiceImpl2 implements OrderService {

	@Override
	public String getOrderDetails(String orderid) {
		return "Order details from impl 2, for order id=" + orderid;
	}
}
