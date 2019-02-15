package com.example.demo.repository.SYNCHRONIZEBIDIRECTIONALENTITY;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.SYNCHRONIZEBIDIRECTIONALENTITY.OneToMany.Post;
@Repository
public interface PostRepository extends JpaRepository<Post, Long>,CustomPostRepository {

}
