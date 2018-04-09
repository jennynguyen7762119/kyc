/**
 * 
 */
package com.oto.kyc.service;

import java.io.Serializable;
import java.util.List;

import com.oto.kyc.model.User;

/**
 * @author otocon
 *
 */
public interface UserService extends Serializable {

	List<User> getAllUser();
}
