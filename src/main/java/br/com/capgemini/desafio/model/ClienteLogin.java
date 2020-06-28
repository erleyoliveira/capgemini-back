package br.com.capgemini.desafio.model;


import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;


public class ClienteLogin extends User {

    private String cpf;
    private String senha;

    public ClienteLogin(String cpf, String senha, boolean enabled, boolean accountNonExpired,
                        boolean credentialsNonExpired, boolean accountNonLocked,
                        Collection<? extends GrantedAuthority> authorities) {
        super(cpf, senha, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.cpf = cpf;
        this.senha = senha;
    }

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
