package com.example.demo.model.EXTRALAZYCOLLECTIONS;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="EXTRA_POST")
public class Post {
	@Id
    private Long id;
 
    private String title;
 
    @OneToMany(
        mappedBy = "post",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    @LazyCollection(
        LazyCollectionOption.EXTRA
    )
    @OrderColumn(name = "order_id")
    private List<PostComment> comments = new ArrayList<>();
 
    public Long getId() {
        return id;
    }
 
    public Post setId(Long id) {
        this.id = id;
        return this;
    }
 
    public String getTitle() {
        return title;
    }
 
    public Post setTitle(String title) {
        this.title = title;
        return this;
    }
 
    public List<PostComment> getComments() {
        return comments;
    }
 
    public Post addComment(
            PostComment comment) {
        comments.add(comment);
        comment.setPost(this);
        return this;
    }
 
    public Post removeComment(
            PostComment comment) {
        comments.remove(comment);
        comment.setPost(null);
        return this;
    }
}
