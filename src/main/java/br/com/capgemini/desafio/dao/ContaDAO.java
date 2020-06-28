package br.com.capgemini.desafio.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import br.com.capgemini.desafio.model.ClienteDTO;

@Component
public class ContaDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * Método responsável por depositar um valor definido na conta do cliente.
	 * 
	 * @param cliente Indica o cliente que depositou o valor.
	 */
	public void depositarConta(ClienteDTO cliente) {
		Double valorAtual = jdbcTemplate.queryForObject("SELECT VALOR FROM CLIENTE_CONTA WHERE CPF = ?",
				new Object[] { cliente.getCpf() }, Double.class);
		Double valorTotal = valorAtual + cliente.getValor();
		jdbcTemplate.update("UPDATE CLIENTE_CONTA SET VALOR = ? WHERE CPF = ?", new Object[] { valorTotal, cliente.getCpf() });
	}
	
	/**
	 * Método responsável por sacar um valor definido da conta do cliente.
	 * 
	 * @param cliente Indica o cliente que sacou o valor.
	 */
	public void debitarConta(ClienteDTO cliente) {
		Double valorAtual = jdbcTemplate.queryForObject("SELECT VALOR FROM CLIENTE_CONTA WHERE CPF = ?",
				new Object[] { cliente.getCpf() }, Double.class);
		Double valorTotal = valorAtual - cliente.getValor();
		jdbcTemplate.update("UPDATE CLIENTE_CONTA SET VALOR = ? WHERE CPF = ?", new Object[] { valorTotal, cliente.getCpf() });
	}
	
	/**
	 * Método responsável por realizar a consulta do saldo do cliente.
	 * 
	 * @param cpf Indica o cpf que será utilizado para realizar a consulta.
	 * @return Retorna o saldo em conta do cliente especificado.
	 */
	public Double consultarSaldo(String cpf) {
		return jdbcTemplate.queryForObject("SELECT VALOR FROM CLIENTE_CONTA WHERE CPF = ?",
				new Object[] { cpf }, Double.class);
	}

}
