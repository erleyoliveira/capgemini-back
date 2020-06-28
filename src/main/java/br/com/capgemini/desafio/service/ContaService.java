package br.com.capgemini.desafio.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.capgemini.desafio.dao.ContaDAO;
import br.com.capgemini.desafio.model.ClienteDTO;

@Component
public class ContaService {
	
	@Autowired
	private ContaDAO contaDao;
	
	/**
	 * Método responsável por redirecionar a chamada ao método que irá realizar o depósito na conta do cliente.
	 * 
	 * @param cliente Indica o cliente que realizou o depósito.
	 */
	public void depositarConta(ClienteDTO cliente) {
		contaDao.depositarConta(cliente);
	}

	/**
	 * Método responsável por redirecionar a chamada ao método que irá realizar o débito na conta do cliente.
	 * 
	 * @param cliente Indica o cliente que realizou o débito.
	 */
	public void debitarConta(ClienteDTO cliente) {
		contaDao.debitarConta(cliente);
	}

	/**
	 * Método responsável por gerar os números de conta e agência para o novo cliente incluído.
	 * 
	 * @param limite Indica a quantidade máxima de digítos possíveis ao gerar o número.
	 * @return Retorna o número gerado.
	 */
	public String gerarNumeroAleatorio(Integer limite) {
		Random random = new Random();
		return random.nextInt(limite) + "";
	}
	
	/**
	 * Método responsável por direcionar a chamada ao método que irá realizar a consulta do saldo do cliente.
	 * 
	 * @param cpf Indica o cpf do cliente que terá seu saldo consultado.
	 * @return Retorna o valor do saldo em conta do cliente.
	 */
	public Double consultarSaldo(String cpf) {
		return contaDao.consultarSaldo(cpf);
	}
	
}
