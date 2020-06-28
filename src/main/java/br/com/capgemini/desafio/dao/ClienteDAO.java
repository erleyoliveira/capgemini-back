package br.com.capgemini.desafio.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import br.com.capgemini.desafio.model.ClienteDTO;
import br.com.capgemini.desafio.model.ContaDTO;
import br.com.capgemini.desafio.service.ContaService;

@Component
public class ClienteDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private ContaService contaService;
	
	/**
	 * Método responsável por criar a tabela CLIENTE_CONTA ao iniciar a aplicação.
	 * 
	 */
	public void criarTabelaClienteConta() {
		jdbcTemplate.execute("CREATE TABLE CLIENTE_CONTA(" +
				"NOME_COMPLETO varchar(255), " +
				"CPF varchar(11), " +
				"SENHA varchar(255), " +
				"CONTA varchar(6), " +
				"AGENCIA varchar(4), " +
				"VALOR double)");
	}
	
	/**
	 * Método responsável por dropar a tabela CLIENTE_CONTA caso a mesma já exista ao reiniciar a aplicação.
	 * 
	 */
	public void droparTabelaClienteConta() {
		jdbcTemplate.execute("DROP TABLE CLIENTE_CONTA");
	}
	
	/**
	 * Método responsável por realizar a persistência do cliente.
	 * 
	 * @param cliente Indica o objeto com os dados do cliente que será cadastrado.
	 */
	public void cadastrarCliente(ClienteDTO cliente) {
		jdbcTemplate.update("INSERT INTO CLIENTE_CONTA(NOME_COMPLETO, CPF, SENHA, CONTA, AGENCIA, VALOR)VALUES(?, ?, ?, ?, ?, ?)",
				new Object[] { cliente.getNomeCompleto(), cliente.getCpf(), cliente.getSenha(), contaService.gerarNumeroAleatorio(999999), contaService.gerarNumeroAleatorio(9999), 0D });
	}
	
	/**
	 * Método responsável por consultar o cliente a partir do seu cpf.
	 * 
	 * @param cpf Indica o cpf que será consultado.
	 * @return Retorna o cliente que possui o cpf definido na consulta.
	 */
	public ClienteDTO buscarInfoCliente(String cpf) {
		return jdbcTemplate.queryForObject("SELECT * FROM CLIENTE_CONTA WHERE CPF = ?",
				new Object[] { cpf }, (rs, rowNum) -> {
						ClienteDTO cliente = new ClienteDTO(rs.getString("NOME_COMPLETO"), rs.getString("CPF"), new ContaDTO(rs.getString("AGENCIA"), rs.getString("CONTA"), Double.valueOf(rs.getString("VALOR"))));
                    return cliente;
            });
	}

	public boolean validarExisteCliente(String cpf) {
		try {
			jdbcTemplate.queryForObject("SELECT NOME_COMPLETO FROM CLIENTE_CONTA WHERE CPF = ?",
					new Object[] { cpf }, String.class);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
