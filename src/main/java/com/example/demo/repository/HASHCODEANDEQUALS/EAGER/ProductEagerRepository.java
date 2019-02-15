package com.example.demo.repository.HASHCODEANDEQUALS.EAGER;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.HASHCODEANDEQUALS.EAGER.ProductEager;
@Repository
public interface ProductEagerRepository extends JpaRepository<ProductEager, Long> {

}
