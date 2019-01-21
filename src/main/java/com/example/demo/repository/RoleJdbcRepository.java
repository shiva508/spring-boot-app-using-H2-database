package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.RoleJdbc;
@Repository
public interface RoleJdbcRepository extends JpaRepository<RoleJdbc, Integer> {
	@Query("SELECT r.role from RoleJdbc r where r.userName=?1")
	public List<String> getRolesByUserName(String name);
}
