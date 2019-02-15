package com.example.demo.repository.SYNCHRONIZEBIDIRECTIONALENTITY;

import java.util.List;

import com.example.demo.model.SYNCHRONIZEBIDIRECTIONALENTITY.OneToMany.Post;

public interface CustomPostRepository {
public Post getPostById(Long id);
public Post savePost(Post post);
public List<Post> getAllPosts();
}
