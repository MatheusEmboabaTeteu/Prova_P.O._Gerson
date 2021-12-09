package com.wb.negocio;

import java.util.List;

import com.wb.modelo.Produto;

public class ListarTodosProdutos extends Listagem {
	private List<Produto> produtos;

	public ListarTodosProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	@Override
	public void listar() {
		System.out.println("Lista de todos os produtos:");
		for (Produto produto : produtos) {
			System.out.println("Nome do produto: " + produto.nomeproduto);
			System.out.println("Código do produto: " + produto.getCodigoProduto().getNumeroProduto());
			System.out.println("Valor do produto: " + produto.valorproduto);
			System.out.println("Data de criação: " + produto.getCodigoProduto().getDatacriacao());
			System.out.println("--------------------------------------");
		}
	}
}
