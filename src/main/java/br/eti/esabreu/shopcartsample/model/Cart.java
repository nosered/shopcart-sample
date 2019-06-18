package br.eti.esabreu.shopcartsample.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Cart {
	
	private Integer id;
	private List<CartItem> itens;
	
	public Cart() {
		this.id = null;
		this.itens = new ArrayList<CartItem>();
	}
	
	public Cart(List<CartItem> itens) {
		this.itens = itens;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public List<CartItem> getItens() {
		return itens;
	}
	
	public void setItens(List<CartItem> itens) {
		this.itens = itens;
	}
	
	public BigDecimal getTotal() {
		BigDecimal total = BigDecimal.ZERO;
		for(CartItem item: this.itens) {
			total = total.add(item.getSubTotal());
		}
		return total;
	}
}