package com.wb.negocio;

import java.util.List;

import com.wb.modelo.Cliente;
import com.wb.modelo.Produto;
import com.wb.modelo.Servico;

public class ListarTodosConsumos extends Listagem {
	private List<Cliente> clientes;

	public ListarTodosConsumos(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	@Override
	public void listar() {
		for (Cliente cliente : clientes) {
			System.out.println("Nome: " + cliente.getNome());
			List<Servico> servicoConsumidos = cliente.getServicosConsumidos();
			List<Produto> produtoConsumidos = cliente.getProdutosConsumidos();
			System.out.println("Lista de todos os servicos consumidos:");
			for (Servico servico : servicoConsumidos) {
				System.out.println("--------------------------------------");
				System.out.println("Nome do serviço: " + servico.nomeservico);
				System.out.println("Valor do serviço: " + servico.valorservico);
			}

			System.out.println("Lista de todos os produtos consumidos:");
			for (Produto produto : produtoConsumidos) {
				System.out.println("--------------------------------------");
				System.out.println("Nome do produto: " + produto.nomeproduto);
				System.out.println("Valor do produto: " + produto.valorproduto);
			}

		}

	}
}