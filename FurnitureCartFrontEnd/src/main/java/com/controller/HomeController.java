package com.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.User;

import com.dao.UserDao;
import com.daoImpl.UserDaoImpl;
import com.model.User;

@Controller

public class HomeController
{
	
//	
//	@Autowired
//	private UserDaoImpl  userDaoImpl;
	
	
	@RequestMapping("/")
		public String index()
		{
			return "index";
		}
	
	@RequestMapping("/index")
		public String home()
		{
			return "index";
		}
	
	@RequestMapping("/signup")
		public String signup()
		{
			return "signup";
		}


	@RequestMapping("/login")
	public String login()
	{
		return "login";
	}

	@RequestMapping("/goTologin")
	public ModelAndView goToLogin()
	{
		ModelAndView mav=new ModelAndView();
		mav.setViewName("login");
		return mav;
	}

	@RequestMapping(value="/addUser",method=RequestMethod.POST)
	public String insertUser(@Validated @ModelAttribute("user")User user,BindingResult result)
	{
		System.out.println(user.getId());
		System.out.println(user.getName());
		System.out.println(user.getMail());
		System.out.println(user.getPassword());
		System.out.println(user.getPhoneno());
		System.out.println(user.getAddr());
		System.out.println(user.getZipcode());
		System.out.println(user.isStatus());
		System.out.println("@");
		System.out.println();
		
		System.out.println("Hello ");
		return "login";
		
	}
	



	@RequestMapping(value="/saveregister", method=RequestMethod.POST)
		public ModelAndView saveRegister(@ModelAttribute("user") User user, BindingResult result)
		{
			ModelAndView mav=new ModelAndView ();
			if(result.hasErrors())
			{
				mav.setViewName("signup");
				return mav;
			}
			else
			{
				
				user.setRole("ROLE_USER");// user and admin
				
				
				UserDaoImpl.insertUser(user);
				mav.setViewName("redirect:/goTologin");
				return mav;
			}
		
	} 

/*public String login()
{
	return "login";
}*/

}

