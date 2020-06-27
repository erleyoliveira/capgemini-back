package br.com.capgemini.desafio.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.capgemini.desafio.model.LoginDTO;
import br.com.capgemini.desafio.service.LoginService;

@RequestMapping("/api")
@RestController
public class LoginAPI {
	
	@Autowired
	private LoginService service;
	
	@PostMapping("/login")
	public void autenticarCliente(@RequestBody LoginDTO login) {
		service.autenticarCliente(login);
	}

}
