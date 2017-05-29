package com.oceantest.services.jpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Table(name = "PANT")
@Entity
@NamedQueries({
		@NamedQuery(name = "PantEntity.findAll", query = "SELECT o FROM com.oceantest.services.jpa.model.PantEntity o "),

		@NamedQuery(name = "PantEntity.findBrand", query = "SELECT b FROM com.oceantest.services.jpa.model.PantEntity b where PANT_BRAND = :brand") })

@SequenceGenerator(name = "pantId", sequenceName = "SEQ_PANT_ID", allocationSize = 1)
public class PantEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pantId")
	@Column(name = "PANT_ID")
	private long pantId;

	@Column(name = "PANT_BRAND")
	private String pantBrand;
	@Column(name = "PANT_MODEL")
	private String pantModel;
	@Column(name = "PANT_RATING")
	private Integer pantRating;
	@Column(name = "PANT_PRICE")
	private Double pantPrice;

	@ManyToOne /* (cascade = CascadeType.ALL, fetch = FetchType.LAZY) */
	@JoinColumn(name = "CATEGORY_ID")
	CategoryEntity categoryId;

	@OneToOne(mappedBy = "pant")
	private TransactionEntity transaction;

	public PantEntity() {
	}

	public long getPantId() {
		return pantId;
	}

	public void setPantId(long pantId) {
		this.pantId = pantId;
	}

	public String getPantBrand() {
		return pantBrand;
	}

	public void setPantBrand(String pantBrand) {
		this.pantBrand = pantBrand;
	}

	public Integer getPantTest() {
		return pantRating;
	}

	public void setPantTest(Integer pantTest) {
		this.pantRating = pantTest;
	}

	public Double getPantPrice() {
		return pantPrice;
	}

	public void setPantPrice(Double pantPrice) {
		this.pantPrice = pantPrice;
	}

	public String getPantModel() {
		return pantModel;
	}

	public void setPantModel(String pantModel) {
		this.pantModel = pantModel;
	}

	public CategoryEntity getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(CategoryEntity categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "PantEntity [pantId=" + pantId + ", pantBrand=" + pantBrand + ", pantModel=" + pantModel + ", pantTest="
				+ pantRating + ", pantPrice=" + pantPrice + ", categoryId=" + categoryId + "]";
	}



}