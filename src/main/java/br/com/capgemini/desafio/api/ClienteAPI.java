package br.com.capgemini.desafio.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.capgemini.desafio.model.ClienteDTO;

@RequestMapping("/api")
public class ClienteAPI {
	
	@PostMapping("/cadastrarcliente")
	public void cadastrarCliente(@RequestBody ClienteDTO cliente) {
		System.out.println("bateu");
	}

}
