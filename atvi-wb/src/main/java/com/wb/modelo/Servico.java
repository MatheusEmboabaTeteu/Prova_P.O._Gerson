package com.wb.modelo;

public class Servico {
	public String nomeservico;
	public String valorservico;

	public Servico(String nomeservico, String valorservico) {
		this.nomeservico = nomeservico;
		this.valorservico = valorservico;
	}

	public void setNomeServico(String nome) {
		this.nomeservico = nome;
		
	}

	public void setValorServico(String valor) {
		this.valorservico = valor;
		
	}
}