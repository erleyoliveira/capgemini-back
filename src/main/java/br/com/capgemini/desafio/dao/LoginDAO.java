package br.com.capgemini.desafio.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import br.com.capgemini.desafio.model.ClienteLogin;

@Component
public class LoginDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * Método responsável por realizar a consulta do cliente pelo cpf informado no login.
	 * 
	 * @param cpf Indica o cpf que será utilizado para validação do login.
	 * @return Retorna um objeto contendo as informações de login do cliente.
	 */
	public ClienteLogin getUsuarioPorCpf(String cpf) {
		return jdbcTemplate.queryForObject("SELECT * FROM CLIENTE_CONTA WHERE CPF = ?", new Object[] { cpf },
                (rs, rowNum) -> {
                	ClienteLogin clienteLogin = new ClienteLogin(rs.getString("CPF"), rs.getString("SENHA"), true, true, true, true,
                                new ArrayList<GrantedAuthority>());
                        return clienteLogin;
                });
	}

}
