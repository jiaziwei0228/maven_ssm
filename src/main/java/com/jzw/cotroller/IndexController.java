package com.jzw.cotroller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jzw.model.User;
import com.jzw.model.UserException;
import com.jzw.service.IUserService;

@Controller
public class IndexController {
@Autowired
private IUserService userService;

public IUserService getUserService() {
	return userService;
}

public void setUserService(IUserService userService) {
	this.userService = userService;
}

public IndexController(IUserService userService) {
	super();
	this.userService = userService;
}

public IndexController() {
	super();
}
@RequestMapping("/")
public String index(){
	return "login";
	
}

@RequestMapping(value = "/login", method = RequestMethod.POST)
public String login(User user,HttpSession session) throws UserException{
	
	User loginUser=userService.login(user);
	session.setAttribute("loginUser", loginUser);
	return "redirect:/user/list";
	
}
}
