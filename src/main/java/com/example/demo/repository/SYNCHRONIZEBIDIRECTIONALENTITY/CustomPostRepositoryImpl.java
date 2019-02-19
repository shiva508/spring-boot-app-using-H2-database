package com.example.demo.repository.SYNCHRONIZEBIDIRECTIONALENTITY;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.validator.internal.util.stereotypes.ThreadSafe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.SYNCHRONIZEBIDIRECTIONALENTITY.OneToMany.Post;
@Repository
public class CustomPostRepositoryImpl implements CustomPostRepository {
@Autowired
	EntityManager entityManager;

@Override
public Post getPostById(Long id) {
	Query query=entityManager.createQuery("FROM Post as P where P.id=:id");
	query.setParameter("id",id);
	return 	(Post) query.getSingleResult();
}

@Override
public Post savePost(Post post) {
	
	return entityManager.merge(post);
}

@Override

public List<Post> getAllPosts() {
	Query query=entityManager.createQuery("SELECT P FROM Post as P ");
	return query.getResultList();
}
}
