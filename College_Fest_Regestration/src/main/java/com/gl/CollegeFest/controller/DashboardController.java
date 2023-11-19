package com.gl.CollegeFest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
	@GetMapping("/")
	public String showHomeDashboard() {
		return "home-dashboard";
	}
	@GetMapping("/access-denied")
	public String showAccessDeniedPage() {

		return "access-denied";
	}

}
