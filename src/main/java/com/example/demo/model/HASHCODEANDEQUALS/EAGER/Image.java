package com.example.demo.model.HASHCODEANDEQUALS.EAGER;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

@Entity
public class Image {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(updatable = false)
	private String name;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(
			name = "PRODUCT_EAGER_ID", 
			nullable = false, 
			updatable = false
			)
	private ProductEager productEager;
	public Image() {
		super();
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
	public ProductEager getProductEager() {
		return productEager;
	}
	public void setProductEager(ProductEager productEager) {
		this.productEager = productEager;
	}
	@Override
	public int hashCode() {
		HashCodeBuilder hcb=new HashCodeBuilder();
		hcb.append(name);
		hcb.append(productEager);
		return hcb.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if(!(obj instanceof Image)) {
			return false;
		}
		Image that=(Image)obj;
		EqualsBuilder eb=new EqualsBuilder();
		eb.append(name, that.name);
		eb.append(productEager, that.productEager);
		return eb.isEquals();
	}
	@Override
	public String toString() {
		return "Image [id=" + id + ", name=" + name + "]";
	}
	
	
}
