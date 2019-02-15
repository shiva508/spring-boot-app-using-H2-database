package com.example.demo.model.SYNCHRONIZEBIDIRECTIONALENTITY.OneToMany;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class PostComment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long postCommentId;

	private String review;
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "POST_ID")
	@JsonBackReference
	private Post post;
	public PostComment() {
		super();
	}
	public Long getPostCommentId() {
		return postCommentId;
	}
	public void setPostCommentId(Long postCommentId) {
		this.postCommentId = postCommentId;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	@Override
	public String toString() {
		return "PostComment [postCommentId=" + postCommentId + ", review=" + review + "]";
	}
	
	
	
}
