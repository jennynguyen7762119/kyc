/**
 * 
 */
package com.oto.kyc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oto.kyc.model.User;
import com.oto.kyc.service.UserService;


/**
 * @author otocon
 *
 */
@Controller
public class IndexController {
	
	@Autowired(required=true)
	private UserService userService;

	@RequestMapping(value="/index", method = RequestMethod.GET)
	public String index(Model model) {
		List<User> result = this.userService.getAllUser();
		System.err.println(result);
		String message = "Hello World";
		model.addAttribute("message", message);
		return "index";
	}
}
