package br.com.capgemini.desafio.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.capgemini.desafio.model.ClienteDTO;
import br.com.capgemini.desafio.service.ContaService;
import springfox.documentation.annotations.ApiIgnore;

@RequestMapping("/api/conta")
@RestController
public class ContaAPI {
	
	@Autowired
	private ContaService contaService;
	
	@PostMapping("depositar")
	public void depositarConta(@RequestBody ClienteDTO cliente) {
		contaService.depositarConta(cliente);
	}
	
	@PostMapping("sacar")
	public void debitarConta(@ApiIgnore Authentication authentication, @RequestBody ClienteDTO cliente) {
		contaService.debitarConta(cliente);
	}
	
	@GetMapping("consultarsaldo/{cpf}")
	public Double consultarSaldo(@PathVariable("cpf") String cpf) {
		Double a =contaService.consultarSaldo(cpf);
		return a;
	}

}
