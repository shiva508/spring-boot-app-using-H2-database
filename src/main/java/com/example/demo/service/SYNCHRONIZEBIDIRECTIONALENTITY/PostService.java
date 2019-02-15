package com.example.demo.service.SYNCHRONIZEBIDIRECTIONALENTITY;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.SYNCHRONIZEBIDIRECTIONALENTITY.OneToMany.Post;

public interface PostService {
public Optional<Post> getPost(Long id);
public Post getPostById(Long id);
public Post savePost(Post post);
public List<Post> getAllPosts();
}
