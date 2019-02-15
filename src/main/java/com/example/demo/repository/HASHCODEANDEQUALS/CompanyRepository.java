package com.example.demo.repository.HASHCODEANDEQUALS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.HASHCODEANDEQUALS.Company;
@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

}
