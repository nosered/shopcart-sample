package br.eti.esabreu.shopcartsample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.eti.esabreu.shopcartsample.service.ProductService;

@Controller
// @SessionAttributes(value = "cart")
public class HomeController {

	/*
	@Autowired
	private CartService cartService;
	*/
	
	@Autowired
	private ProductService productService;
	
	/*
	@ModelAttribute(value = "cart")
	private Cart getCart() {
		return new Cart();
	}
	*/
	
	@GetMapping("/")
	public ModelAndView root() {
		return new ModelAndView("forward:/home");
	}

	@GetMapping(value = "/home")
	public ModelAndView home(/*@CookieValue("shopcartId") UUID cartId*/) {
		ModelAndView mView = new ModelAndView("home");
		mView.addObject("products", productService.findAll());
		// mView.addObject("cart", cartService.find(cartId));
		return mView;
	}
}