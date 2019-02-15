package com.example.demo.model.SYNCHRONIZEBIDIRECTIONALENTITY.ManyToMany;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.criteria.Fetch;

import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.Proxy;

import com.example.demo.model.SYNCHRONIZEBIDIRECTIONALENTITY.OneToMany.Post;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table
/* @Proxy(lazy=false) */
public class Tag {
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY) 
	private Long id;
	@NaturalId
	private String name;
	@ManyToMany(mappedBy="tags",
			fetch=FetchType.EAGER,
			cascade= {
					CascadeType.PERSIST,
					CascadeType.MERGE}
			)
	@JsonBackReference
	private Set<Post> posts=new LinkedHashSet<Post>();
	public Tag() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Post> getPosts() {
		return posts;
	}
	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}
	 @Override
	    public boolean equals(Object o) {
	        if (this == o) 
	        	return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        Tag tag = (Tag) o;
	        return Objects.equals(name, tag.name);
	    }
	 
	    @Override
	    public int hashCode() {
	        return Objects.hash(name);
	    }
		@Override
		public String toString() {
			return "Tag [id=" + id + ", name=" + name + "]";
		}
	

}
