package br.eti.esabreu.shopcartsample.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.eti.esabreu.shopcartsample.dto.CartOverallDTO;
import br.eti.esabreu.shopcartsample.model.Cart;
import br.eti.esabreu.shopcartsample.model.CartProduct;
import br.eti.esabreu.shopcartsample.model.Product;
import br.eti.esabreu.shopcartsample.repository.CartProductRepository;
import br.eti.esabreu.shopcartsample.repository.CartRepository;
import br.eti.esabreu.shopcartsample.repository.ProductRepository;

@Service
public class CartService {

	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CartProductRepository cartProductRepository;
	
	public Cart find(UUID id) {
		return cartRepository.findById(id).get();
	}
	
	public Cart save(Cart cart) {
		return cartRepository.save(cart);
	}
	
	public CartProduct addToCart(CartProduct cartProduct) {
		Cart cart = cartRepository.findById(cartProduct.getCart().getId()).get();
		Product product = productRepository.findById(cartProduct.getProduct().getId()).get();
		cartProduct.setProduct(product);
		cart.getCartProducts().add(cartProduct);
		cartRepository.saveAndFlush(cart);
		return cartProductRepository.findOneByCartAndProduct(cart, product);
	}
	
	public CartProduct removeFromCart(CartProduct cartProduct) {
		CartProduct removedCartProduct = cartProductRepository.findById(cartProduct.getId()).get();
		cartProductRepository.deleteById(cartProduct.getId());
		return removedCartProduct;
	}
	
	public CartOverallDTO cartOverall(UUID cartId) {
		CartOverallDTO cartOverall = new CartOverallDTO();
		Cart cart = cartRepository.findById(cartId).get();
		cartOverall.setProductsQuantity(cart.getCartProducts().size());
		cartOverall.setTotal(cart.getTotal());
		return cartOverall;
	}
}