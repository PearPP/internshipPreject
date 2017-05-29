//package com.oceantest.services.policy.model;
//
//import java.util.Date;
//import java.io.Serializable;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.SequenceGenerator;
//import javax.persistence.Table;
//
//@SuppressWarnings("serial")
//@Entity
//@Table(name="slip_pa")
//@SequenceGenerator(name = "slipPaID", sequenceName = "seq_slip_pa_id", allocationSize = 1)
//public class SlipPaEntity implements Serializable {
//	@Id
//	@Column(name="id")
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "slipPaID")
//	private Long id;
//	
//	@Column(name="branch_code",length=4,nullable=true)
//	private String branchCode; 								//รหัสสาขา exp. 0800, 1600
//	
//	@Column(name="agent5_own",length=5)
//	private String agent5Code;			
//	
//	@Column(name="agent2_own",length=2)
//	private String agent2Code;
//	
//	@Column(name="policy_no",length=20)
//	private String policyNo;								//เลขที่กรมธรรม์ เช่น PA20401841 , PA20401837
//
//	@Column(name="year",length=4)							//ปีของกรมธรรม์
//	private String year;
//	
//	@Column(name="slip_no",length=10)						//เลขที่ใบเสร็จ
//	private String slipNo;
//	
//	@Column(name="type",length=2)
//	private String type;
//	
//	@Column(name="title",length=20)							//คำนำหน้าชื่อลูกค้า
//	private String title;
//	
//	@Column(name="first_name",length=100)					//ชื่อลูกค้า
//	private String firstName;
//	
//	@Column(name="surname")									//นามสกุลลูกค้า
//	private String surName;
//	
//	@Column(name="premium")
//	private Double premium;
//	
//	@Column(name="sum_ins")
//	private Double sumIns;
//	
//	@Column(name="cover_start_date")
//	private Date coverStartDate;
//	
//	@Column(name="cover_end_date")
//	private Date coverEndDate;
//	
//	@Column(name="create_by",length=50)
//	private String createBy;
//	
//	@Column(name="create_date")
//	private Date createDate;
//	
//	@Column(name="update_by",length=50)
//	private String updateBy;
//	
//	@Column(name="update_date")
//	private Date updateDate;
//	
//	@Column(name="flag_print",length=1)
//	private String flagPrint;
//
//	@Column(name="print_date")
//	private Date printDate;
//	
//	@Column(name="bring_date")
//	private Date bringDate;
//	
//	@Column(name="return_date")
//	private Date returnDate;
//	
//	@Column(name="cancel_date")
//	private Date cancelDate;
//	
//	@Column(name="deposit_date")
//	private Date depositDate;
//	
//	@Column(name="status", length=1)
//	private String status;
//	
//	@Column(name="count_reprint")
//	private Integer countReprint;
//	
//	@Column(name="receive_slip_no")
//	private String receiveSlipNo;
//
//	@Column(name="receive_slip_printdate")
//	private Date receiveSlipPrintdate;
//
//	@Column(name = "sum_commission")
//	private Double sumCommission;
//
//	@Column(name = "agent_tax")
//	private Double agentTax;
//	
//	///////////////////////////////////////////
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getBranchCode() {
//		return branchCode;
//	}
//
//	public void setBranchCode(String branchCode) {
//		this.branchCode = branchCode;
//	}
//
//	public String getAgent5Code() {
//		return agent5Code;
//	}
//
//	public void setAgent5Code(String agent5Code) {
//		this.agent5Code = agent5Code;
//	}
//
//	public String getAgent2Code() {
//		return agent2Code;
//	}
//
//	public void setAgent2Code(String agent2Code) {
//		this.agent2Code = agent2Code;
//	}
//
//	public String getPolicyNo() {
//		return policyNo;
//	}
//
//	public void setPolicyNo(String policyNo) {
//		this.policyNo = policyNo;
//	}
//
//	public String getYear() {
//		return year;
//	}
//
//	public void setYear(String year) {
//		this.year = year;
//	}
//
//	public String getSlipNo() {
//		return slipNo;
//	}
//
//	public void setSlipNo(String slipNo) {
//		this.slipNo = slipNo;
//	}
//
//	public String getType() {
//		return type;
//	}
//
//	public void setType(String type) {
//		this.type = type;
//	}
//
//	public String getTitle() {
//		return title;
//	}
//
//	public void setTitle(String title) {
//		this.title = title;
//	}
//
//	public String getFirstName() {
//		return firstName;
//	}
//
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//
//	public String getSurName() {
//		return surName;
//	}
//
//	public void setSurName(String surName) {
//		this.surName = surName;
//	}
//
//	public Double getPremium() {
//		return premium;
//	}
//
//	public void setPremium(Double premium) {
//		this.premium = premium;
//	}
//
//	public Double getSumIns() {
//		return sumIns;
//	}
//
//	public void setSumIns(Double sumIns) {
//		this.sumIns = sumIns;
//	}
//
//	public Date getCoverStartDate() {
//		return coverStartDate;
//	}
//
//	public void setCoverStartDate(Date coverStartDate) {
//		this.coverStartDate = coverStartDate;
//	}
//
//	public Date getCoverEndDate() {
//		return coverEndDate;
//	}
//
//	public void setCoverEndDate(Date coverEndDate) {
//		this.coverEndDate = coverEndDate;
//	}
//
//	public String getCreateBy() {
//		return createBy;
//	}
//
//	public void setCreateBy(String createBy) {
//		this.createBy = createBy;
//	}
//
//	public Date getCreateDate() {
//		return createDate;
//	}
//
//	public void setCreateDate(Date createDate) {
//		this.createDate = createDate;
//	}
//
//	public String getUpdateBy() {
//		return updateBy;
//	}
//
//	public void setUpdateBy(String updateBy) {
//		this.updateBy = updateBy;
//	}
//
//	public Date getUpdateDate() {
//		return updateDate;
//	}
//
//	public void setUpdateDate(Date updateDate) {
//		this.updateDate = updateDate;
//	}
//
//	public String getFlagPrint() {
//		return flagPrint;
//	}
//
//	public void setFlagPrint(String flagPrint) {
//		this.flagPrint = flagPrint;
//	}
//
//	public Date getPrintDate() {
//		return printDate;
//	}
//
//	public void setPrintDate(Date printDate) {
//		this.printDate = printDate;
//	}
//
//	public Date getBringDate() {
//		return bringDate;
//	}
//
//	public void setBringDate(Date bringDate) {
//		this.bringDate = bringDate;
//	}
//
//	public Date getReturnDate() {
//		return returnDate;
//	}
//
//	public void setReturnDate(Date returnDate) {
//		this.returnDate = returnDate;
//	}
//
//	public Date getCancelDate() {
//		return cancelDate;
//	}
//
//	public void setCancelDate(Date cancelDate) {
//		this.cancelDate = cancelDate;
//	}
//
//	public Date getDepositDate() {
//		return depositDate;
//	}
//
//	public void setDepositDate(Date depositDate) {
//		this.depositDate = depositDate;
//	}
//
//	public String getStatus() {
//		return status;
//	}
//
//	public void setStatus(String status) {
//		this.status = status;
//	}
//
//	public Integer getCountReprint() {
//		return countReprint;
//	}
//
//	public void setCountReprint(Integer countReprint) {
//		this.countReprint = countReprint;
//	}
//
//	public String getReceiveSlipNo() {
//		return receiveSlipNo;
//	}
//
//	public void setReceiveSlipNo(String receiveSlipNo) {
//		this.receiveSlipNo = receiveSlipNo;
//	}
//
//	public Date getReceiveSlipPrintdate() {
//		return receiveSlipPrintdate;
//	}
//
//	public void setReceiveSlipPrintdate(Date receiveSlipPrintdate) {
//		this.receiveSlipPrintdate = receiveSlipPrintdate;
//	}
//
//	public Double getSumCommission() {
//		return sumCommission;
//	}
//
//	public void setSumCommission(Double sumCommission) {
//		this.sumCommission = sumCommission;
//	}
//
//	public Double getAgentTax() {
//		return agentTax;
//	}
//
//	public void setAgentTax(Double agentTax) {
//		this.agentTax = agentTax;
//	}
//	
//	
//}
