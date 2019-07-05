package br.eti.esabreu.shopcartsample.dto;

import java.math.BigDecimal;

public class CartOverallDTO {
	
	private Integer productsQuantity;
	private BigDecimal total;
	
	public Integer getProductsQuantity() {
		return productsQuantity;
	}
	
	public void setProductsQuantity(Integer productsQuantity) {
		this.productsQuantity = productsQuantity;
	}
	
	public BigDecimal getTotal() {
		return total;
	}
	
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
}