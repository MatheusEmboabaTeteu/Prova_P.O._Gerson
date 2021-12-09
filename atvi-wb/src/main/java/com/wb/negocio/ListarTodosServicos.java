package com.wb.negocio;

import java.util.List;

import com.wb.modelo.Servico;

public class ListarTodosServicos extends Listagem {
	private List<Servico> servicos;

	public ListarTodosServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	@Override
	public void listar() {
		System.out.println("Lista de todos os produtos:");
		for (Servico servico : servicos) {
			System.out.println("Nome do servi�o: " + servico.nomeservico);
			System.out.println("Valor do servi�o: " + servico.valorservico);
			System.out.println("--------------------------------------");
		}
	}
}