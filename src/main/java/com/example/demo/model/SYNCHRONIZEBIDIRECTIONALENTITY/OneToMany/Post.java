package com.example.demo.model.SYNCHRONIZEBIDIRECTIONALENTITY.OneToMany;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.demo.model.SYNCHRONIZEBIDIRECTIONALENTITY.ManyToMany.Tag;
import com.example.demo.model.SYNCHRONIZEBIDIRECTIONALENTITY.OneToOne.PostDetails;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table
public class Post {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long postId;
	private String title;
	@OneToMany(
			fetch=FetchType.EAGER,
			cascade=CascadeType.ALL,
			mappedBy = "post" , orphanRemoval=true		 
			)
	@JsonManagedReference
	private List<PostComment>  postComments=new ArrayList<PostComment>();
	@OneToOne(
			cascade=CascadeType.ALL,
			mappedBy="post",
			fetch=FetchType.LAZY,
			orphanRemoval=true)
	@JsonManagedReference
	private PostDetails postDetails;
	@ManyToMany(cascade= {
			CascadeType.PERSIST,
			CascadeType.MERGE}
	)
	@JoinTable(name="POST_TAG",
	joinColumns= @JoinColumn(name="POST_ID"),
			inverseJoinColumns=@JoinColumn(name="TAG_ID"))
	@JsonManagedReference
	private Set<Tag> tags=new LinkedHashSet<Tag>();
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getPostId() {
		return postId;
	}
	public void setPostId(Long postId) {
		this.postId = postId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<PostComment> getPostComments() {
		if(postComments==null) {
			postComments=new ArrayList<PostComment>();
		}
		return postComments;
	}
	public void setPostComments(List<PostComment> postComments) {
	
			this.postComments = postComments;
		
	}
	public void addTag(Tag newTag) {
		if(!getTags().contains(newTag)) {
			getTags().add(newTag);
			newTag.getPosts().add(this);	
		}
	
	}
	public void removeTag(Tag newTag) {
		getTags().remove(newTag);
		newTag.getPosts().remove(this);
	}
	public void addComment(PostComment newPostComment) {
		getPostComments().add(newPostComment);
		newPostComment.setPost(this);
	}
	public void removeComment(PostComment newPostComment) {
		getPostComments().remove(newPostComment);
		newPostComment.setPost(null);
	}
	
	public PostDetails getPostDetails() {
		return postDetails;
	}
	public void setPostDetails(PostDetails postDetails) {
		 if (postDetails == null) {
	            if (this.postDetails != null) {
	                this.postDetails.setPost(null);
	            }
	        }
	        else {
	        	postDetails.setPost(this);
	        }
	        this.postDetails = postDetails;
	}
	
	public Set<Tag> getTags() {
		return tags;
	}
	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;
        return postId != null && postId.equals(((Post) o).postId);
    }
 
    @Override
    public int hashCode() {
        return 31;
    }
	@Override
	public String toString() {
		return "Post [postId=" + postId + ", title=" + title + ", postComments=" + postComments + ", postDetails="
				+ postDetails + ", tags=" + tags + "]";
	}
	
	
	
}
