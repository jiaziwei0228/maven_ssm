package com.jzw.cotroller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jzw.model.User;
import com.jzw.service.IUserService;


@Controller
@RequestMapping("/user")
public class UserController {
@Autowired
private IUserService userService;

public IUserService getUserService() {
	return userService;
}

public void setUserService(IUserService userService) {
	this.userService = userService;
}


@RequestMapping("/list")
public String list(Model model,HttpSession session){
	model.addAttribute("users",userService.list());
	return "user/list";
}
@RequestMapping(value = "/add", method = RequestMethod.GET)
public String add(@ModelAttribute("user") User user) {
	return "user/add";
}
//@Validated校验
@RequestMapping(value = "/add", method = RequestMethod.POST)
public String add(@Validated User user,BindingResult bindingResult){
	 if (bindingResult.hasErrors()) {
	 return "user/add";
	 }
	 // 操作数据库添加
	 userService.add(user);
		 return "redirect:/user/list";
	 }

@RequestMapping("/delete")
public String delete(int id){
	userService.delete(id);
	return "redirect:/user/list";
}
@RequestMapping(value = "/update", method = RequestMethod.GET)
public String update(User user,Model model) {
	model.addAttribute(user);
	return "user/update";
}
//@Validated校验
@RequestMapping(value = "/update", method = RequestMethod.POST)
public String update(@Validated User user,BindingResult bindingResult){
	 if (bindingResult.hasErrors()) {
	 return "user/update";
	 }
	 userService.update(user);
	 return "redirect:/user/list";
}
}