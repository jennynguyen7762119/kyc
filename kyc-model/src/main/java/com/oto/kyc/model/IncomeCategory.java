/**
 * 
 */
package com.oto.kyc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.criteria.CriteriaBuilder.In;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.oto.kyc.model.base.DeletedFlagAuditableEntity;
import com.oto.kyc.model.base.IdentifiedEntity;

/**
 * @author otocon
 *
 */
@Entity
@Table(name = "m_income_category")
public class IncomeCategory extends DeletedFlagAuditableEntity implements IdentifiedEntity<Integer>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5652709887254278788L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "title")
	@NotNull
	@Size(max = 100)
	private String tilte;
	
	@Column(name = "description")
	@Size(max = 200)
	private String description;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTilte() {
		return tilte;
	}
	public void setTilte(String tilte) {
		this.tilte = tilte;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "IncomeCategory [id=" + id + ", tilte=" + tilte + ", description=" + description + "]";
	}

}
