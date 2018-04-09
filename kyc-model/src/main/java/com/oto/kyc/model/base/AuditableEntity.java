/**
 * 
 */
package com.oto.kyc.model.base;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.oto.kyc.model.util.CurrentUserGetter;


/**
 * @author thuyntp
 *
 */
@MappedSuperclass
public class AuditableEntity extends TimestampEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -249484644734885580L;
	
	@Column(name = "create_user_id")
    private Integer createUserId;

    @Column(name = "update_user_id")
    private Integer updateUserId;

    @PreUpdate
    protected void onUpdate() {
        super.onUpdate();
        this.updateUserId = CurrentUserGetter.getInstance().getCurrentUser();
    }

    @PrePersist
    protected void onSave() {
        super.onSave();
        this.createUserId = CurrentUserGetter.getInstance().getCurrentUser();
        this.updateUserId = CurrentUserGetter.getInstance().getCurrentUser();
    }

    /**
     * get value of <b>createUserId</b>.
     * 
     * @return the createUserId
     */
    public Integer getCreateUserId() {
        return this.createUserId;
    }

    /**
     * Set value to <b>createUserId</b>.
     * 
     * @param createUserId
     *            the createUserId to set
     */
    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * get value of <b>updateUserId</b>.
     * 
     * @return the updateUserId
     */
    public Integer getUpdateUserId() {
        return this.updateUserId;
    }

    /**
     * Set value to <b>updateUserId</b>.
     * 
     * @param updateUserId
     *            the updateUserId to set
     */
    public void setUpdateUserId(Integer updateUserId) {
        this.updateUserId = updateUserId;
    }
}
