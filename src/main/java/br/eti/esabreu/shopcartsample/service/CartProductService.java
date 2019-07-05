package br.eti.esabreu.shopcartsample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.eti.esabreu.shopcartsample.model.CartProduct;
import br.eti.esabreu.shopcartsample.repository.CartProductRepository;

@Service
public class CartProductService {

	@Autowired
	private CartProductRepository cartProductRepository;
	
	public CartProduct addToCart(CartProduct cartProduct) {
		cartProductRepository.saveAndFlush(cartProduct);
		return cartProductRepository.findById(cartProduct.getId()).get();
	}
	
	public CartProduct removeFromCart(CartProduct cartProduct) {
		CartProduct removedCartProduct = cartProductRepository.findById(cartProduct.getId()).get();
		cartProductRepository.deleteById(cartProduct.getId());
		return removedCartProduct;
	}
}