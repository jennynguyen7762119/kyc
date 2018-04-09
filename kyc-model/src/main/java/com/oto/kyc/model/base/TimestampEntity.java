/**
 * 
 */
package com.oto.kyc.model.base;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;

import com.oto.kyc.model.util.LocalDateAttributeConverter;

/**
 * @author thuyntp
 *
 */
@MappedSuperclass
public class TimestampEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2060414519288694278L;
	
	@Column(name = "created_date", columnDefinition = "DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP")
	@Convert(converter = LocalDateAttributeConverter.class)
	private LocalDateTime createdDate;
	
	@Column(name = "updated_date", columnDefinition = "DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP")
	@Convert(converter = LocalDateAttributeConverter.class)
	private LocalDateTime updatedDate;
	
	@Transient
    private boolean manualUpdatedDate = false;
	
	@PreUpdate
    protected void onUpdate() {
        if (!isManualUpdatedDate() || this.updatedDate == null) {
            this.updatedDate = this.getCurrentDate();
        }
    }

    @PrePersist
    protected void onSave() {
        LocalDateTime ldt = this.getCurrentDate();
        
        this.createdDate = ldt;
        this.updatedDate = ldt;
    }
    
    private LocalDateTime getCurrentDate() {
        Date date = new Date(System.currentTimeMillis());
        
        SimpleDateFormat japanDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.US);
        japanDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+9"));
        String japanDateString = japanDateFormat.format(date);
        
        SimpleDateFormat systemDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        try {
            date = systemDateFormat.parse(japanDateString);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return LocalDateTime.of(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1,
                cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND));
    }

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	public boolean isManualUpdatedDate() {
		return manualUpdatedDate;
	}

	public void setManualUpdatedDate(boolean manualUpdatedDate) {
		this.manualUpdatedDate = manualUpdatedDate;
	}

	@Override
	public String toString() {
		return "TimestampEntity [createdDate=" + createdDate + ", updatedDate=" + updatedDate + ", manualUpdatedDate="
				+ manualUpdatedDate + "]";
	}
	
	
	

}
