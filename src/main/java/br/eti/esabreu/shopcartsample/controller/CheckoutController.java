package br.eti.esabreu.shopcartsample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.eti.esabreu.shopcartsample.wsclient.PagSeguroWSClient;

@Controller
public class CheckoutController {
	
	@Autowired
	private PagSeguroWSClient pagSeguroWSClient;

	@GetMapping("/checkout")
	public ModelAndView checkout() {
		ModelAndView mView = new ModelAndView("checkout");
		String sessionID = pagSeguroWSClient.getSessionId();
		mView.addObject("sessionID", sessionID);
		return mView;
	}
}
