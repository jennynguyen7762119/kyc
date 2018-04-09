/**
 * 
 */
package com.oto.kyc.model.base;

import java.io.Serializable;

/**
 * @author thuyntp
 *
 */
public interface IdentifiedEntity<I extends Serializable> {
	
	/**
	 * 
	 * @return ID of entity.
     * @return {@link Serializable} instance.
	 */
	I getId();

}
