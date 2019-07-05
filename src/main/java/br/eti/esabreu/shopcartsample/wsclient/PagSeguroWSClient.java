package br.eti.esabreu.shopcartsample.wsclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(url = "https://ws.sandbox.pagseguro.uol.com.br/v2/", name = "pagseguro")
public interface PagSeguroWSClient {

	@PostMapping(value = "/sessions?email=ederson.dimm@gmail.com&token=27D1B8327FC649D7BCBA3CF208FD31BC")
	public String getSessionId();
}
