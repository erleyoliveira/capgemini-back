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
	
	/**
	 * Método responsável por direcionar a chamada ao método de criação ou exclusão da tabela CLIENTE_CONTA.	
	 * 
	 */
	public void criarTabelaClienteConta() {
		logger.info("CRIANDO TABELA CLIENTE_CONTA");
		
		try {
			clienteDao.criarTabelaClienteConta();
		} catch (Exception e) {
			clienteDao.droparTabelaClienteConta();
			clienteDao.criarTabelaClienteConta();
		}
	}
	
	/**
	 * Método responsável por direcionar a chamada ao método de consulta das informações do cliente.
	 * 
	 * @param cpf Indica o cpf que será utilizado para realizar a consulta.
	 * @return Retorna um objeto contendo as informações do cliente especificado.
	 */
	public ClienteDTO buscarInfoCliente(String cpf) {
		return clienteDao.buscarInfoCliente(cpf);
	}

	/**
	 * Método responsável por direcionar a chamada ao método de cadastro do cliente.
	 * 
	 * @param cliente Indica o objeto contendo as informações do cliente que será cadastrado.
	 * @throws Exception 
	 */
	public void cadastrarCliente(ClienteDTO cliente) throws Exception {
		if(!clienteDao.validarExisteCliente(cliente.getCpf())) {
			clienteDao.cadastrarCliente(cliente);
		} else {
			throw new Exception("clienteExistente");
		}
	}

}
