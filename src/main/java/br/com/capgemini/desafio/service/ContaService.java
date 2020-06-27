package br.com.capgemini.desafio.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.capgemini.desafio.dao.ContaDAO;
import br.com.capgemini.desafio.model.ClienteDTO;

@Component
public class ContaService {
	
	@Autowired
	private ContaDAO contaoDao;
	
	public void depositarConta(ClienteDTO cliente) {
		contaoDao.depositarConta(cliente);
	}

	public void debitarConta(ClienteDTO cliente) {
		contaoDao.debitarConta(cliente);
	}

	public Integer gerarNumeroAleatorio(Integer quantidadeDigitos) {
		String numero = "";
		Random random = new Random();
		
		for(int i = 0; i < quantidadeDigitos; i++) {
			numero += numero + random.nextInt();
		}
		
		return Integer.valueOf(numero);
	}
	
}
