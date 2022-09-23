package com.khaled.controllers;

 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.khaled.dao.StudentDAO;
import com.khaled.dao.UserDAO;
import com.khaled.models.User;

@Controller
public class RegisterController {
	
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	//modelView to send data and redirect to page into one function
	public ModelAndView register(HttpServletRequest request,
			HttpServletResponse response) {
		
		 ModelAndView mav = new ModelAndView("register");		 
		 mav.addObject("user", new User());
		 return mav;
	}
	
	
	
	@RequestMapping(value = "/registerForm", method = RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest request,
			                               //bring data from jsp
			HttpServletResponse response, @ModelAttribute("user") User user) {
		
		userDAO.register(user);
	    return new ModelAndView("index","fullname",user.getFullname());
	}

}
