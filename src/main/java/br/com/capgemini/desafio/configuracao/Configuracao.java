package br.com.capgemini.desafio.configuracao;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import br.com.capgemini.desafio.service.ClienteService;

@Component
public class Configuracao {
	
	@Autowired
	private ClienteService clienteService;
	
	@PostConstruct
	public void configuracaoInicial() throws DataAccessException, IOException {
		clienteService.criarTabelaClienteConta();
	}

}
