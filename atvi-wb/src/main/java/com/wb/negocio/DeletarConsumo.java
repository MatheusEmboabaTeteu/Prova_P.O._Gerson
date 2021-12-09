package com.wb.negocio;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Cliente;
import com.wb.modelo.Produto;
import com.wb.modelo.RG;
import com.wb.modelo.Servico;
import com.wb.modelo.Telefone;

public class DeletarConsumo extends Listagem {
	private List<Cliente> clientes;
	int n = 0;

	public DeletarConsumo(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	@Override
	public void listar() {
		for (Cliente cliente : clientes) {
			System.out.println("Cliente " + n);
			System.out.println("Nome: " + cliente.getNome());
			System.out.println("Nome social: " + cliente.nomeSocial);
			System.out.println("Genero: " + cliente.genero);
			System.out.println(
					"CPF e Data de Emissao: " + cliente.getCpf().getValor() + " " + cliente.getCpf().getDataEmissao());
			for (RG rgnumero : cliente.getRgs()) {
				System.out.println("RG e Data Emissao: " + rgnumero.getRgcodigo() + " " + rgnumero.getDataEmissao());
			}
			for (Telefone tellnumero : cliente.getTelefones()) {
				System.out.println("Telefones: " + tellnumero.getDdd() + " " + tellnumero.getNumero());
			}
			System.out.println("--------------------------------------");
			n = n + 1;
		}
		int num = 0;

		Cliente deletarconsumo = null;
		while (num == 0) {
			Entrada entrada = new Entrada();
			System.out.println("\n\n Escolha o numero do cliente que deseja deletar consumo.");
			num = entrada.receberNumeroInteiro();

			if (num <= n) {
				deletarconsumo = clientes.get(num);
				break;
			}
		}

		List<Servico> servicoConsumidos = deletarconsumo.getServicosConsumidos();
		List<Produto> produtoConsumidos = deletarconsumo.getProdutosConsumidos();
		System.out.println("Lista de todos os servicos consumidos:");
		for (Servico servico : servicoConsumidos) {
			System.out.println("--------------------------------------");
			System.out.println("Nome do servico: " + servico.nomeservico);
			System.out.println("Valor do servico: " + servico.valorservico);
		}

		System.out.println("Lista de todos os produtos consumidos:");
		for (Produto produto : produtoConsumidos) {
			System.out.println("--------------------------------------");
			System.out.println("Nome do produto: " + produto.nomeproduto);
			System.out.println("Valor do produto: " + produto.valorproduto);
		}
		while (true) {
			System.out.println("Qual o tipo de consumo deseja deletar:");
			System.out.println("1 - Servico");
			System.out.println("2 - Produto");
			System.out.println("0 - Sair");
			n = 0;

			Entrada entrada = new Entrada();
			num = entrada.receberNumeroInteiro();
			if (num == 0) {
				break;
			}
			if (num == 1) {
				for (Servico servico : servicoConsumidos) {
					System.out.println("--------------------------------------");
					System.out.println("Servico consumido numero " + n);
					System.out.println("Nome do servico: " + servico.nomeservico);
					System.out.println("Valor do servico: " + servico.valorservico);
					n = n + 1;
				}
				System.out.println("Por favor informe o numero do servico consumido que deseja deletar:");
				Entrada entrada2 = new Entrada();
				num = entrada2.receberNumeroInteiro();
				if (num <= n) {
					deletarconsumo.getServicosConsumidos().remove(num);
					break;
				}
			}
			if (num == 2) {
				for (Produto produto : produtoConsumidos) {
					System.out.println("--------------------------------------");
					System.out.println("Produto consumido numero " + n);
					System.out.println("Nome do produto: " + produto.nomeproduto);
					System.out.println("Valor do produto: " + produto.valorproduto);
					n = n + 1;
				}
				System.out.println("Por favor informe o numero do produto consumido que deseja deletar:");
				Entrada entrada1 = new Entrada();
				num = entrada1.receberNumeroInteiro();
				if (num <= n) {
					deletarconsumo.getProdutosConsumidos().remove(num);
					break;
				}
			}
		}
	}
}