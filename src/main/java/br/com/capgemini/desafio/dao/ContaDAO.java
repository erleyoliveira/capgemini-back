package br.com.capgemini.desafio.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import br.com.capgemini.desafio.model.ClienteDTO;

@Component
public class ContaDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void depositarConta(ClienteDTO cliente) {
		Double valorAtual = jdbcTemplate.queryForObject("SELECT VALOR FROM CLIENTE_CONTA WHERE CPF = ?",
				new Object[] { cliente.getCpf() }, Double.class);
		Double valorTotal = valorAtual + cliente.getValor();
		jdbcTemplate.update("UPDATE CLIENTE_CONTA SET VALOR = ? WHERE CPF = ?", new Object[] { valorTotal, cliente.getCpf() });
	}
	
	public void debitarConta(ClienteDTO cliente) {
		Double valorAtual = jdbcTemplate.queryForObject("SELECT VALOR FROM CLIENTE_CONTA WHERE CPF = ?",
				new Object[] { cliente.getCpf() }, Double.class);
		Double valorTotal = valorAtual - cliente.getValor();
		jdbcTemplate.update("UPDATE CLIENTE_CONTA SET VALOR = ? WHERE CPF = ?", new Object[] { valorTotal, cliente.getCpf() });
	}
	
	public Double consultarSaldo(String cpf) {
		return jdbcTemplate.queryForObject("SELECT VALOR FROM CLIENTE_CONTA WHERE CPF = ?",
				new Object[] { cpf }, Double.class);
	}

}
