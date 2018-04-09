/**
 * 
 */
package com.oto.kyc.web.security;

import java.io.Serializable;

import com.oto.kyc.model.User;

/**
 * @author thuyntp
 *
 */
public class SessionInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1384865358920647873L;
	
	public static final String KYC_CURRENT_USER_KEY = "currentUser";
    public static final String KYC_TOKEN_VALUE_KEY = "token";
    
    private User user;
    private String token;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@Override
	public String toString() {
		return "SessionInfo [user=" + user + ", token=" + token + "]";
	}
    
    

}
