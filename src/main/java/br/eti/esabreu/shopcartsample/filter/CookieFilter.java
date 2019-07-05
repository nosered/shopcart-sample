package br.eti.esabreu.shopcartsample.filter;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.eti.esabreu.shopcartsample.model.Cart;
import br.eti.esabreu.shopcartsample.service.CartService;

@Component
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class CookieFilter implements Filter {
	
	@Autowired
	private CartService cartService;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		Cookie[] cookies = httpRequest.getCookies();
		boolean existsShopcartCookie = false;
		if(cookies == null) {
			addShopcartCookie(httpResponse);
		} else {
			for (Cookie cookie : cookies) {
				if ("shopcartId".equals(cookie.getName())) {
					existsShopcartCookie = true;
					break;
				}
			}
			if(!existsShopcartCookie) {
				addShopcartCookie(httpResponse);
			}
		}
		chain.doFilter(request, response);
	}
	
	private void addShopcartCookie(HttpServletResponse httpResponse) {
		Cart cart = new Cart();
		cart.setId(UUID.randomUUID());
		cartService.save(cart);
		Cookie shopcartCookie = new Cookie("shopcartId", cart.getId().toString());
		shopcartCookie.setPath("/");
		shopcartCookie.setMaxAge(7 * 24 * 60 * 60); // 7 days
		httpResponse.addCookie(shopcartCookie);
	}
}