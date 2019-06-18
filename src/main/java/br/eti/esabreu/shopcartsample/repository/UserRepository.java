package br.eti.esabreu.shopcartsample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.eti.esabreu.shopcartsample.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findByUsername(String username);
}