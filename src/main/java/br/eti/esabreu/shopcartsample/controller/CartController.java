package br.eti.esabreu.shopcartsample.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import br.eti.esabreu.shopcartsample.dto.CartOverallDTO;
import br.eti.esabreu.shopcartsample.model.Cart;
import br.eti.esabreu.shopcartsample.model.CartProduct;
import br.eti.esabreu.shopcartsample.service.CartService;

@Controller
// @SessionAttributes(value = "cart")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@GetMapping(value = "/view-cart")
	public ModelAndView viewCart(@ModelAttribute(name = "cart") Cart cart, @CookieValue("shopcartId") UUID cartId) {
		ModelAndView mView = new ModelAndView("cart");
		mView.addObject("cart", cartService.find(cartId));
		return mView;
	}
	
	@PostMapping(value = "/ws/add-to-cart", produces = "application/json; charset=UTF-8")
	public ResponseEntity<CartProduct> addToCartWS(@RequestBody CartProduct cartProduct) {
		CartProduct addedCartProduct = cartService.addToCart(cartProduct);
		return ResponseEntity.ok().body(addedCartProduct);
	}
	
	@DeleteMapping(value = "/ws/remove-from-cart", produces = "application/json; charset=UTF-8")
	public ResponseEntity<CartProduct> removeFromCartWS(@RequestBody CartProduct cartProduct) {
		CartProduct removedCartProduct = cartProduct = cartService.removeFromCart(cartProduct);
		return ResponseEntity.ok().body(removedCartProduct);
	}
	
	@GetMapping(value = "/ws/cart-overall", produces = "application/json; charset=UTF-8")
	public ResponseEntity<CartOverallDTO> cartOverall(@CookieValue(name = "shopcartId") UUID cartId) {
		CartOverallDTO cartOverall = cartService.cartOverall(cartId);
		return ResponseEntity.ok().body(cartOverall);
	}
	
	/*
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
	*/
}