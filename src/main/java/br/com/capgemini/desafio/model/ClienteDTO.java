package br.com.capgemini.desafio.model;

public class ClienteDTO {
	
	private String nomeCompleto;
	private Integer cpf;
	private String senha;
	private ContaDTO conta;
	
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	
	public Integer getCpf() {
		return cpf;
	}
	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public ContaDTO getConta() {
		return conta;
	}
	public void setConta(ContaDTO conta) {
		this.conta = conta;
	}
	
}
