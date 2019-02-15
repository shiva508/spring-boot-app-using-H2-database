package com.example.demo.model.HASHCODEANDEQUALS.EAGER;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.example.demo.model.HASHCODEANDEQUALS.Company;

@Entity
public class ProductEager {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="PRODUCT_EAGER_ID")
	private Long id;
	@Column(updatable=false)
	private String code;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(
			name="company_id",
			nullable=false,
			updatable=false
			)
	private Company company;
	@OneToMany(
			fetch=FetchType.LAZY,
			cascade=CascadeType.ALL,
			mappedBy="productEager",
			orphanRemoval=true
			)
	@OrderBy("index")
	private Set<Image> images=new LinkedHashSet<Image>();
	public ProductEager() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Set<Image> getImages() {
		return images;
	}
	public void addImage(Image newImage) {
		getImages().add(newImage);
		newImage.setProductEager(this);
	}
	public void setImages(Set<Image> images) {
		this.images = images;
	}
	@Override
	public int hashCode() {
		HashCodeBuilder hcb=new HashCodeBuilder();
		hcb.append(code);
		hcb.append(company);
		return hcb.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
			if((obj instanceof ProductEager)) {
				return false;
			}
		ProductEager that=(ProductEager) obj;
		EqualsBuilder eb=new EqualsBuilder();
		eb.append(code, that.code);
		eb.append(company, that.company);
		return eb.isEquals();
	}
	@Override
	public String toString() {
		return "ProductEager [id=" + id + ", code=" + code + ", company=" + company + ", images=" + images + "]";
	}
	
}
