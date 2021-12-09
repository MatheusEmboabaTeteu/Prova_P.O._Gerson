package com.wb.modelo;

import java.time.LocalDate;

public class CodigoProduto {
	private LocalDate datacriacao;
	private String numeroproduto;
	public CodigoProduto (LocalDate datacriacao, String numeroproduto) {
		this.datacriacao = datacriacao;
		this.numeroproduto = numeroproduto;
	}

	public LocalDate getDatacriacao() {
		return datacriacao;
	}

	public String getNumeroProduto() {
		return numeroproduto;
	}

	public void setNumeroproduto(String numeroproduto) {
		this.numeroproduto = numeroproduto;
	}

	public void setDatacriacao(LocalDate datacriacao) {
		this.datacriacao = datacriacao;
	}
}