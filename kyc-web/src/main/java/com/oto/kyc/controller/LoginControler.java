/**
 * 
 */
package com.oto.kyc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author thuyntp
 *
 */
@Controller
public class LoginControler {

	public final static String KYC_LOGIN_ACTION = "/login";
	public final static String KYC_LOGIN_VIEW = "login";
	
	@RequestMapping(value = KYC_LOGIN_ACTION, method = RequestMethod.GET)
	public String login() {
		return KYC_LOGIN_VIEW;
	}
}
