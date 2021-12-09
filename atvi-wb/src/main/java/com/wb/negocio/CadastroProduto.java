package com.wb.negocio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.CodigoProduto;
import com.wb.modelo.Produto;

public class CadastroProduto extends Cadastro {
	private List<Produto> produtos;
	private Entrada entrada;

	public CadastroProduto(List<Produto> produtos) {
		this.produtos = produtos;
		this.entrada = new Entrada();
	}

	@Override
	public void cadastrar() {
		System.out.println("Inicio do cadastro do Produto");
		System.out.println("Por favor informe o nome do Produto:");
		String nomeproduto = entrada.receberTexto();
		System.out.println("Por favor informe o codigo do produto:");
		String numeroproduto = entrada.receberTexto();
		System.out.println("Por favor informe o valor do produto:");
		String valorproduto = entrada.receberTexto();
		System.out.println("Por favor informe a data de atual para cadastro do produto, no padrao dd/mm/yyyy:");
		String datac = entrada.receberTexto();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate datacriacao = LocalDate.parse(datac, formato);
		CodigoProduto codigoproduto  = new CodigoProduto(datacriacao, numeroproduto);
		Produto produto = new Produto(nomeproduto,valorproduto,codigoproduto);
		this.produtos.add(produto);
	}
}