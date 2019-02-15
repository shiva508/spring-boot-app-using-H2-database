package com.example.demo.service.SYNCHRONIZEBIDIRECTIONALENTITY;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.SYNCHRONIZEBIDIRECTIONALENTITY.OneToMany.Post;
import com.example.demo.repository.SYNCHRONIZEBIDIRECTIONALENTITY.PostRepository;

@Service

public class PostServiceImpl implements PostService {
	@Autowired
	PostRepository postRepository;

	@Override
	@Transactional
	public Optional<Post> getPost(Long id) {

		return postRepository.findById(id);
	}

	@Override
	@Transactional
	public Post getPostById(Long id) {
		
		return postRepository.getPostById(id);
	}

	@Override
	@Transactional
	public Post savePost(Post post) {
		return postRepository.savePost(post);
	}

	@Override
	@Transactional
	public List<Post> getAllPosts() {
		
		/* return postRepository.findAll(); */
		return postRepository.getAllPosts();
	}

}
