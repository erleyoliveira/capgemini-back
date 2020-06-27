package br.com.capgemini.desafio.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.capgemini.desafio.model.ClienteDTO;
import br.com.capgemini.desafio.service.ClienteService;

@RequestMapping("/api/")
public class ClienteAPI {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("buscarcliente")
	public ClienteDTO buscarInfoCliente(@RequestBody String cpf) {
		return clienteService.buscarInfoCliente(cpf);
	}
	
	@PostMapping("cadastrarcliente")
	public void cadastrarCliente(@RequestBody ClienteDTO cliente) {
		System.out.println("bateu");
	}

}
