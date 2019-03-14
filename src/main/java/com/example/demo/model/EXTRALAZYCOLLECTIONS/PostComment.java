package com.example.demo.model.EXTRALAZYCOLLECTIONS;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="COMMENT_POST")
public class PostComment {
	@Id
    private Long id;
 
    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;
 
    private String review;
 
    public Long getId() {
        return id;
    }
 
    public PostComment setId(Long id) {
        this.id = id;
        return this;
    }
 
    public Post getPost() {
        return post;
    }
 
    public PostComment setPost(Post post) {
        this.post = post;
        return this;
    }
 
    public String getReview() {
        return review;
    }
 
    public PostComment setReview(String review) {
        this.review = review;
        return this;
    }
 
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        return id != null &&
               id.equals(((PostComment) o).id);
    }
 
    @Override
    public int hashCode() {
        return 31;
    }
}
