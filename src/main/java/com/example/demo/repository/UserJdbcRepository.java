package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.model.UserJdbc;

@Repository
public interface UserJdbcRepository extends JpaRepository<UserJdbc, Integer> {

	@Query("SELECT u FROM UserJdbc u where u.userName=?1")
	UserJdbc findByUserNameUser(String name);
	

}
