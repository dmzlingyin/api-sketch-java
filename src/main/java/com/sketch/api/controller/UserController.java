package com.sketch.api.controller;

import com.sketch.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	private final UserService helloService;

	@Autowired
	public UserController(UserService helloService) {
		this.helloService = helloService;
	}

	@GetMapping("/find")
	public String find(@RequestParam(name="name", required=false, defaultValue="alice") String name) {
		return this.helloService.find(name);
	}

}
