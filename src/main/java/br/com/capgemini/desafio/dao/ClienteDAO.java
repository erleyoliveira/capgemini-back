package br.com.capgemini.desafio.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import br.com.capgemini.desafio.model.ClienteDTO;
import br.com.capgemini.desafio.service.ContaService;

@Component
public class ClienteDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private ContaService contaService;
	
	public void criarTabelaClienteConta() {
		jdbcTemplate.execute("CREATE TABLE CLIENTE_CONTA(" +
				"NOME_COMPLETO varchar(255), " +
				"CPF varchar(11), " +
				"SENHA varchar(255), " +
				"CONTA varchar(6), " +
				"AGENCIA varchar(4), " +
				"VALOR double)");
	}
	
	public void droparTabelaClienteConta() {
		jdbcTemplate.execute("DROP TABLE CLIENTE_CONTA");
	}
	
	public void cadastrarCliente(ClienteDTO cliente) {
		jdbcTemplate.update("INSERT INTO CLIENTE_CONTA(NOME_COMPLETO, CPF, SENHA, CONTA, AGENCIA, VALOR)VALUES(?, ?, ?, ?, ?, ?)",
				new Object[] { cliente.getNomeCompleto(), cliente.getCpf(), cliente.getSenha(), contaService.gerarNumeroAleatorio(6), contaService.gerarNumeroAleatorio(4), 0D });
	}
	
	public ClienteDTO buscarInfoCliente(String cpf) {
		return jdbcTemplate.queryForObject("SELECT * FROM CLIENTE_CONTA WHERE CPF = ?",
				new Object[] { cpf }, ClienteDTO.class);
	}

}
