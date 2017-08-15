package com.springmvc.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.UserException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.springmvc.model.User;
import com.sun.javafx.sg.prism.NGShape.Mode;

@Controller
@RequestMapping("/user")
public class UserController {
	private Map<String, User> users = new HashMap<String, User>();

	public UserController() {
		users.put("wjl", new User("wjl", "123", "王金连", "asss"));
		users.put("wyz", new User("wyz", "123", "吴彦祖", "asss"));
		users.put("ldh", new User("ldh", "123", "刘德华", "asss"));
		users.put("cl", new User("cl", "123", "成龙", "asss"));
		users.put("wj", new User("wj", "123", "吴京", "asss"));
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("users", users);
		return "user/list";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model model) {
		model.addAttribute(new User());
		return "user/add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@Validated User user, BindingResult br) {
		if (br.hasErrors()) {
			return "user/add";
		}
		users.put(user.getUsername(), user);
		return "redirect:/user/users";
	}

	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	public String show(@PathVariable String username, Model model) {
		model.addAttribute(users.get(username));
		return "user/show";
	}
	

	@RequestMapping(value = "/{username}", method = RequestMethod.GET,params="json")
	@ResponseBody
	public User show(@PathVariable String username) {		
		System.out.println(username);
		return  users.get(username);		
	}

	@RequestMapping(value = "/{username}/update", method = RequestMethod.GET)
	public String update(@PathVariable String username, Model model) {
		model.addAttribute(users.get(username));
		return "user/update";
	}

	@RequestMapping(value = "/{username}/update", method = RequestMethod.POST)
	public String update(@PathVariable String username, @Validated User user, BindingResult br) {
		if (br.hasErrors()) {
			return "user/update";
		}
		users.put(username, user);
		return "redirect:/user/users";
	}

	@RequestMapping(value = "/{username}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable String username) {
		users.remove(username);
		return "redirect:/user/users";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String username, String password, HttpSession session) {
		if (!users.containsKey(username)) {
			throw new com.springmvc.model.UserException("用户不存在！");
		}
		User user = users.get(username);
		if (!user.getPassword().equals(password)) {
			throw new com.springmvc.model.UserException("密码不正确");
		}
		session.setAttribute("loginUser", user);
		return "redirect:/user/users";
	}

	// //局部异常
	// @ExceptionHandler(value={com.springmvc.model.UserException.class})
	// public String handlerException(com.springmvc.model.UserException
	// e,HttpServletRequest req){
	// req.setAttribute("e", e);
	// return "error";
	// }
}
