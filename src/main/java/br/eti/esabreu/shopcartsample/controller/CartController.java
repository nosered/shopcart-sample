package br.eti.esabreu.shopcartsample.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import br.eti.esabreu.shopcartsample.model.Cart;
import br.eti.esabreu.shopcartsample.model.CartItem;

@Controller
@SessionAttributes(value = "cart")
public class CartController {
	
	@ModelAttribute(value = "cart")
	private Cart getCart() {
		return new Cart();
	}

	@GetMapping(value = "/view-cart")
	public ModelAndView viewCart(@ModelAttribute(name = "cart") Cart cart) {
		ModelAndView mView = new ModelAndView("cart");
		return mView;
	}
	
	@PostMapping(value = "/ws/add-to-cart", produces = "application/json; charset=UTF-8")
	public ResponseEntity<CartItem> addToCartWS(@RequestBody CartItem item, @ModelAttribute(name = "cart") Cart cart) {
		cart.getItens().add(item);
		return ResponseEntity.ok().body(item);
	}
	
	@DeleteMapping(value = "/ws/remove-from-cart", produces = "application/json; charset=UTF-8")
	public ResponseEntity<Void> removeFromCartWS(@RequestBody CartItem item, @ModelAttribute(name = "cart") Cart cart) {
		cart.getItens().remove(item);
		return ResponseEntity.ok().build();
	}
}