package com.project.application.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.application.model.User;
import com.project.dao.UserDao;

@RestController
@RequestMapping("/hello")
public class HelloRestController {

	@Autowired
	UserDao UserDao;

	@RequestMapping(method = RequestMethod.GET)
	public String sayHello() {
		return "Hello World!";
	}

	@RequestMapping(method = RequestMethod.POST, path = "/addUser", consumes = "application/json")
	public String addUser(@RequestBody User user) {
		boolean isAdded = UserDao.insertUser(user);
		String response = "";
		if (isAdded) {
			response = "Inserted Successfully!";
		}
		return response;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/getUser", produces = "application/json")
	public User getUser(@RequestParam int userId) {
		User user = UserDao.getUser(userId);
		return user;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/getAllUser", produces = "application/json")
	public List<User> getAllUser() {
		List<User> user = UserDao.getAllUser();
		return user;
	}
}
