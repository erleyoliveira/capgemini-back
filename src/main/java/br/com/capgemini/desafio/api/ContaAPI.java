package br.com.capgemini.desafio.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.capgemini.desafio.model.ClienteDTO;
import br.com.capgemini.desafio.service.ContaService;

@RequestMapping("/api/conta")
public class ContaAPI {
	
	@Autowired
	private ContaService contaService;
	
	@PostMapping("depositar")
	public void depositarConta(@RequestBody ClienteDTO cliente) {
		contaService.depositarConta(cliente);
	}
	
	@PostMapping("sacar")
	public void debitarConta(ClienteDTO cliente) {
		contaService.debitarConta(cliente);
	}

}
