package com.demo.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping(path = "/login")
	public String getLoginPage(Model modelMap) {
		UserModel user = new UserModel();
		modelMap.addAttribute("user", user);
		return "login";
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public ModelAndView processLogin(@ModelAttribute("user") UserModel user) {
		ModelAndView mv = new ModelAndView();
		if (user.getUserName().equals(user.getPassword())) {
			mv.setViewName("success");
			mv.addObject("username", user.getUserName());
		} else {
			mv.setViewName("failure");
		}
		return mv;
	}
}
