package com.example.demo.service.HASHCODEANDEQUALS;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.HASHCODEANDEQUALS.EAGER.ProductEager;
import com.example.demo.repository.HASHCODEANDEQUALS.EAGER.ProductEagerRepository;
@Service
@Transactional
public class ProductEagerServiceImpl implements ProductEagerService {
	@Autowired
	ProductEagerRepository productEagerRepository;   
	@Override
	public List<ProductEager> getAllProductEager() {
		return productEagerRepository.findAll();
	}

}
