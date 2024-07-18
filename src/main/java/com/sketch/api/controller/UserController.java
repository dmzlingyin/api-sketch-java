package com.sketch.api.controller;

import com.sketch.api.model.dto.UserDTO;
import com.sketch.api.service.UserService;
import com.sketch.api.util.Response;
import com.sketch.api.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/user")
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService helloService) {
		this.userService = helloService;
	}

	@GetMapping("/find")
	public Response find(@RequestParam(name="name", required=false, defaultValue="alice") String name) {
		String res = this.userService.find(name);
		return ResponseUtil.response(0, "", new HashMap<String, Object>() {{put("name", res);}});
	}

	@PostMapping("/create")
	public Response create(@RequestBody UserDTO user) {
		this.userService.create(user);
		return ResponseUtil.response(0, "", null);
	}

}
