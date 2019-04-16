package com.example.demo.repository.BLOB;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.BLOB.ProductBLOB;

@Repository
public interface ProductBLOBRepository extends JpaRepository<ProductBLOB, Integer> {

}
