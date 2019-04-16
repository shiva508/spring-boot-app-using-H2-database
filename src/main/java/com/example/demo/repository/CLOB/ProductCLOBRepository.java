package com.example.demo.repository.CLOB;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.CLOB.ProductCLOB;
@Repository
public interface ProductCLOBRepository extends JpaRepository<ProductCLOB, Integer> {

}
