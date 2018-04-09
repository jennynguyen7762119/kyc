/**
 * 
 */
package com.oto.kyc.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.oto.kyc.model.base.DeletedFlagAuditableEntity;
import com.oto.kyc.model.base.IdentifiedEntity;

/**
 * @author otocon
 *
 */
@Entity
@Table(name ="t_income")
public class Income extends DeletedFlagAuditableEntity implements IdentifiedEntity<Integer>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1444416945448478658L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "user_id")
	@NotNull
	private Integer userId;
	
	@Column(name = "income_category_id")
	@NotNull
	private Integer incomeCategoryId;
	
	@Column(name = "income_date")
	@NotNull
	private Date incomeDate;
	
	@Column(name = "income_amount")
	@NotNull
	private Integer incomeAmount;
	
	@Column(name = "description")
	@Size(max = 200)
	private String description;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getIncomeCategoryId() {
		return incomeCategoryId;
	}
	public void setIncomeCategoryId(Integer incomeCategoryId) {
		this.incomeCategoryId = incomeCategoryId;
	}
	public Date getIncomeDate() {
		return incomeDate;
	}
	public void setIncomeDate(Date incomeDate) {
		this.incomeDate = incomeDate;
	}
	public Integer getIncomeAmount() {
		return incomeAmount;
	}
	public void setIncomeAmount(Integer incomeAmount) {
		this.incomeAmount = incomeAmount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Income [id=" + id + ", userId=" + userId + ", incomeCategoryId=" + incomeCategoryId + ", incomeDate="
				+ incomeDate + ", incomeAmount=" + incomeAmount + ", description=" + description + "]";
	}
}
