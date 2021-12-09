package com.wb.modelo;

import java.time.LocalDate;

public class Produto {
	public String nomeproduto;
	public String valorproduto;
	private CodigoProduto codigoproduto;
	private LocalDate dataCadastro;

	public Produto(String nomeproduto, String valorproduto, CodigoProduto codigoproduto) {
		this.nomeproduto = nomeproduto;
		this.valorproduto = valorproduto;
		this.codigoproduto = codigoproduto;
		this.dataCadastro = LocalDate.now();
	}

	public CodigoProduto getCodigoProduto() {
		return codigoproduto;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setnomeproduto(String nome) {
		this.nomeproduto = nome;

	}

	public void setvalorproduto(String valor) {
		this.valorproduto = valor;

	}
}