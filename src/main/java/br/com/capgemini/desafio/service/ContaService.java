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
	
	public void depositarConta(ClienteDTO cliente) {
		contaDao.depositarConta(cliente);
	}

	public void debitarConta(ClienteDTO cliente) {
		contaDao.debitarConta(cliente);
	}

	public String gerarNumeroAleatorio(Integer limite) {
		Random random = new Random();
		return random.nextInt(limite) + "";
	}
	
	public Double consultarSaldo(String cpf) {
		return contaDao.consultarSaldo(cpf);
	}
	
}
