package br.com.capgemini.desafio.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.capgemini.desafio.dao.ClienteDAO;
import br.com.capgemini.desafio.model.ClienteDTO;

@Component
public class ClienteService {
	
	@Autowired
	private ClienteDAO clienteDao;
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	public void criarTabelaClienteConta() {
		logger.info("CRIANDO TABELA CLIENTE_CONTA");
		
		try {
			clienteDao.criarTabelaClienteConta();
		} catch (Exception e) {
			clienteDao.droparTabelaClienteConta();
			clienteDao.criarTabelaClienteConta();
		}
	}
	
	public ClienteDTO buscarInfoCliente(String cpf) {
		return clienteDao.buscarInfoCliente(cpf);
	}

}
