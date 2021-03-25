package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {

	@GetMapping("/")
	public String sampleHome() {
		System.out.println("asdfasfdasfd");
		return "Hello Spring Boot!";

	}
}
