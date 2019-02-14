package com.example.demo.repository.naturalid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.naturalid.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
public Product getProductByCode(String code);
}
