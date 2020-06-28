package br.com.capgemini.desafio.configuracao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.capgemini.desafio.dao.LoginDAO;
import br.com.capgemini.desafio.model.ClienteLogin;
import br.com.capgemini.desafio.model.CustomUserDetail;

@Service
public class ServicoDetalheUsuario implements UserDetailsService {

	@Autowired
	private LoginDAO loginDAO;

	@Override
	public CustomUserDetail loadUserByUsername(String cpf) throws UsernameNotFoundException {
		ClienteLogin clienteLogin = loginDAO.getUsuarioPorCpf(cpf);

		if (clienteLogin == null) {
			throw new UsernameNotFoundException(cpf);
		}

		return new CustomUserDetail(clienteLogin);

	}

}
