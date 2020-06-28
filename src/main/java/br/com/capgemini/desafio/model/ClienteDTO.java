package br.com.capgemini.desafio.model;

public class ClienteDTO {
	
	private String nomeCompleto;
	private String cpf;
	private String senha;
	private Double valor;
	private ContaDTO conta;
	
	public ClienteDTO(String nomeCompleto, String cpf, ContaDTO conta) {
		this.nomeCompleto = nomeCompleto;
		this.cpf = cpf;
		this.conta = conta;
	}
	
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
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
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public ContaDTO getConta() {
		return conta;
	}
	public void setConta(ContaDTO conta) {
		this.conta = conta;
	}
	
}
