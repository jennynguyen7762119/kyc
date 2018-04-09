package com.oto.kyc.model.util;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.AttributeConverter;

/**
 * 
 * @author thuyntp
 *
 */
public class LocalDateAttributeConverter implements AttributeConverter<LocalDateTime, Timestamp>{

	public Timestamp convertToDatabaseColumn(LocalDateTime locDateTime) {
		return locDateTime == null ? null : Timestamp.valueOf(locDateTime);
	}

	public LocalDateTime convertToEntityAttribute(Timestamp sqlTimestamp) {
		return (sqlTimestamp == null ? null : sqlTimestamp.toLocalDateTime());
	}

}
