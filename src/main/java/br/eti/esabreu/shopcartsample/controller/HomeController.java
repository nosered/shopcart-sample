package br.eti.esabreu.shopcartsample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import br.eti.esabreu.shopcartsample.model.Cart;
import br.eti.esabreu.shopcartsample.model.CartItem;
import br.eti.esabreu.shopcartsample.model.Product;
import br.eti.esabreu.shopcartsample.service.ProductService;

@Controller
@RequestMapping(value = "/")
@SessionAttributes(value = "cart")
public class HomeController {
	
	@Autowired
	private ProductService productService;
	
	@ModelAttribute(value = "cart")
	private Cart getCart() {
		return new Cart();
	}

	@GetMapping(value = "/")
	public ModelAndView home(@ModelAttribute(name = "cart") Cart cart) {
		ModelAndView mView = new ModelAndView("home");
		mView.addObject("products", productService.findAll());
		mView.addObject("itemToAdd", new CartItem());
		return mView;
	}
	
	@PostMapping(value = "/add-to-cart")
	public ModelAndView addToCartPOST(Product product, Integer quantity, @ModelAttribute(name = "cart") Cart cart) {
		cart.getItens().add(new CartItem(product, quantity));
		return new ModelAndView("redirect:/");
	}
	
	@PostMapping(value = "/ws/add-to-cart", produces = "application/json; charset=UTF-8")
	public ResponseEntity<CartItem> addToCartWS(@RequestBody CartItem item, @ModelAttribute(name = "cart") Cart cart) {
		cart.getItens().add(item);
		return ResponseEntity.ok().body(item);
	}
	
	@PostMapping(value = "/ws/remove-from-cart", produces = "application/json; charset=UTF-8")
	public ResponseEntity<Void> removeFromCartWS(@RequestBody CartItem item, @ModelAttribute(name = "cart") Cart cart) {
		cart.getItens().remove(item);
		return ResponseEntity.ok().build();
	}
}