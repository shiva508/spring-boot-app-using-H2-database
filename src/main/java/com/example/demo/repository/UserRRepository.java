package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.onetomany.UserR;
@Repository
public interface UserRRepository extends JpaRepository<UserR, Integer> {

}
