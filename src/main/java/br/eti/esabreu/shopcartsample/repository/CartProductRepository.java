package br.eti.esabreu.shopcartsample.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.eti.esabreu.shopcartsample.model.Cart;
import br.eti.esabreu.shopcartsample.model.CartProduct;
import br.eti.esabreu.shopcartsample.model.Product;

@Repository
public interface CartProductRepository extends JpaRepository<CartProduct, Long> {
	
	@EntityGraph(attributePaths = {"product"})
	public CartProduct findOneByCartAndProduct(Cart cart, Product product);
}
