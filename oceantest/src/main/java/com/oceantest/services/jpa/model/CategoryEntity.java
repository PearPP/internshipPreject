package com.oceantest.services.jpa.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Table(name = "category")
@Entity

public class CategoryEntity implements Serializable {

	@Id
	@Column(name = "cat_id")
	private Long catId;
	@Column(name = "cat_name")
	private String catName;

	@OneToMany(mappedBy = "categoryId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	List<PantEntity> pantEntity;

	public CategoryEntity() {
	}

	public Long getId() {
		return catId;
	}

	public void setId(Long id) {
		this.catId = id;
	}

	public String getName() {
		return catName;
	}

	public void setName(String name) {
		this.catName = name;
	}

	@Override
	public String toString() {
		return "CategoryEntity [catId=" + catId + ", catName=" + catName + "]";
	}
	
	

	
}
