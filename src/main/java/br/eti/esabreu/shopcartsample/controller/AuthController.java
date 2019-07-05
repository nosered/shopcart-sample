package br.eti.esabreu.shopcartsample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthController {

	@GetMapping(value = "/auth/login")
	public ModelAndView loginForm() {
		return new ModelAndView("login");
	}
}