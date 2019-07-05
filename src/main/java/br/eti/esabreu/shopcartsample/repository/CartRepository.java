package br.eti.esabreu.shopcartsample.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.eti.esabreu.shopcartsample.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, UUID> { }