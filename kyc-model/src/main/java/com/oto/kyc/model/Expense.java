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
@Table(name = "t_expense")
public class Expense extends DeletedFlagAuditableEntity implements IdentifiedEntity<Integer>, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4344187846823207605L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "user_id")
	@NotNull
	private Integer userId;
	
	@Column(name = "expense_category_id")
	@NotNull
	private Integer expenseCategoryId;
	
	@Column(name = "expensed_date")
	@NotNull
	private Date expensedDate;
	
	@Column(name = "expensed_amount")
	@NotNull
	private Integer expensedAmount;
	
	@Column(name = "desciption")
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
	public Integer getExpenseCategoryId() {
		return expenseCategoryId;
	}
	public void setExpenseCategoryId(Integer expenseCategoryId) {
		this.expenseCategoryId = expenseCategoryId;
	}
	public Date getExpensedDate() {
		return expensedDate;
	}
	public void setExpensedDate(Date expensedDate) {
		this.expensedDate = expensedDate;
	}
	public Integer getExpensedAmount() {
		return expensedAmount;
	}
	public void setExpensedAmount(Integer expensedAmount) {
		this.expensedAmount = expensedAmount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Expense [id=" + id + ", userId=" + userId + ", expenseCategoryId=" + expenseCategoryId
				+ ", expensedDate=" + expensedDate + ", expensedAmount=" + expensedAmount + ", description="
				+ description + "]";
	}
	

}
