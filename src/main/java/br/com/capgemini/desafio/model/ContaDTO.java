package br.com.capgemini.desafio.model;

public class ContaDTO {
	
	private String agencia;
	private String numeroConta;
	private Double saldo;
	
	public ContaDTO(String agencia, String numeroConta, ClienteDTO cliente) {
		this.agencia = agencia;
		this.numeroConta = numeroConta;
		this.saldo = 0D;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

}
