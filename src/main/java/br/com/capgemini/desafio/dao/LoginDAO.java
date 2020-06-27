package br.com.capgemini.desafio.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import br.com.capgemini.desafio.model.ClienteDTO;

@Component
public class LoginDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Boolean validarLogin(ClienteDTO cliente) {
		try {
			ClienteDTO clienteExiste = jdbcTemplate.queryForObject("SELECT * FROM CLIENTE_CONTA WHERE CPF = ? AND SENHA = ?",
					new Object[] { cliente.getCpf(), cliente.getSenha() }, ClienteDTO.class);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
