package com.oto.kyc.model.base;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * 
 * @author thuyntp
 *
 */
@MappedSuperclass
public abstract class DeletedFlagAuditableEntity extends AuditableEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6170028258470491796L;
	
	@Column(name = "deleted_flag", nullable = false, columnDefinition = "TINYINT(1)")
    private Boolean deleteFlag = false;
	
	public Boolean getDeletedFlag(){
		return deleteFlag;
	}
	
	public void setDeletedFlag(Boolean deletedFlag) {
		this.deleteFlag = deletedFlag;
	}
}
