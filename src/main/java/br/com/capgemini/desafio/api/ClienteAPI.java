package br.com.capgemini.desafio.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.capgemini.desafio.model.ClienteDTO;
import br.com.capgemini.desafio.service.ClienteService;
import springfox.documentation.annotations.ApiIgnore;

@RequestMapping("/api/")
@RestController
public class ClienteAPI {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("buscarcliente/{cpf}")
	public ClienteDTO buscarInfoCliente(@ApiIgnore Authentication authentication, @PathVariable("cpf") String cpf) {
		return clienteService.buscarInfoCliente(cpf);
	}
	
	@PostMapping("cadastrarcliente")
	public void cadastrarCliente(@RequestBody ClienteDTO cliente) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		cliente.setSenha("{bcrypt}" + passwordEncoder.encode(cliente.getSenha()));
		clienteService.cadastrarCliente(cliente);
	}

}
