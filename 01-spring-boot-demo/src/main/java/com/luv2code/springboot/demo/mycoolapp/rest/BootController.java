package com.luv2code.springboot.demo.mycoolapp.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BootController {

	@GetMapping("/")
	public String sayHello() {
		return "Hello Chaudhary! Time on server is: " + LocalDateTime.now();
	}
}
