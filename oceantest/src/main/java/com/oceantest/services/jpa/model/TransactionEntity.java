package com.oceantest.services.jpa.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Table(name = "TRANSACTION")
@Entity
@NamedQueries({
		@NamedQuery(name = "TransactionEntity.findAll", query = "SELECT o FROM com.oceantest.services.jpa.model.TransactionEntity o ") })

@SequenceGenerator(name = "transId", sequenceName = "SEQ_PANT_ID", allocationSize = 1)
public class TransactionEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transId")
	@Column(name = "TRANS_ID")
	private Long transId;
	@Column(name = "CREATE_DATE")
	private Date creatDate;
	@Column(name = "CREATE_BY")
	private String creatBy;

	@OneToOne
	@JoinColumn(name = "PANT_ID")
	private PantEntity pant;

	public TransactionEntity() {
		creatDate = new Date();
	}

	public Long getTransId() {
		return transId;
	}

	public void setTransId(Long transId) {
		this.transId = transId;
	}

	public Date getCreatDate() {
		return creatDate;
	}

	public void setCreatDate(Date creatDate) {
		this.creatDate = creatDate;
	}

	public String getCreatBy() {
		return creatBy;
	}

	public void setCreatBy(String creatBy) {
		this.creatBy = creatBy;
	}

	public PantEntity getPant() {
		return pant;
	}

	public void setPant(PantEntity pant) {
		this.pant = pant;
	}

}
