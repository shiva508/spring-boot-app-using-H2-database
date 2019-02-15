package com.example.demo.repository.SYNCHRONIZEBIDIRECTIONALENTITY;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.SYNCHRONIZEBIDIRECTIONALENTITY.OneToMany.Post;

@Repository
public class CustomPostRepositoryImpl implements CustomPostRepository {
	@Autowired
	EntityManager entityManager;

	@Override
	public Post getPostById(Long id) {
		Query query = entityManager.createQuery("FROM Post as P where P.id=:id");
		query.setParameter("id", id);
		return (Post) query.getSingleResult();
	}

	@Override
	public Post savePost(Post post) {
		return entityManager.merge(post);
	}

	@Override
	public List<Post> getAllPosts() {
		List<Post> query = entityManager
				.createQuery("SELECT P from  Post P " + "INNER JOIN FETCH P.postComments pc  "
						+ "INNER JOIN FETCH P.postDetails pd  " + "INNER JOIN FETCH P.tags t ", Post.class)
				.getResultList();
		return query;
	}

}
