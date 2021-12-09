package com.wb.negocio;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Cliente;
import com.wb.modelo.Produto;
import com.wb.modelo.RG;
import com.wb.modelo.Servico;
import com.wb.modelo.Telefone;

public class CadastroConsumo extends Listagem {
	private List<Cliente> clientes;
	private List<Produto> produtos;
	private List<Servico> servicos;
	int n = 0;

	public CadastroConsumo(List<Cliente> clientes, List<Produto> produtos, List<Servico> servicos) {
		this.clientes = clientes;
		this.produtos = produtos;
		this.servicos = servicos;
	}

	@Override
	public void listar() {
		System.out.println("Lista de todos os clientes:");
		for (Cliente cliente : clientes) {
			System.out.println("Cliente " + n);
			System.out.println("Nome: " + cliente.getNome());
			System.out.println("Nome social: " + cliente.nomeSocial);
			System.out.println("G�nero: " + cliente.genero);
			System.out.println(
					"CPF e Data de Emissão: " + cliente.getCpf().getValor() + " " + cliente.getCpf().getDataEmissao());
			for (RG rgnumero : cliente.getRgs()) {
				System.out.println("RG e Data Emissão: " + rgnumero.getRgcodigo() + " " + rgnumero.getDataEmissao());
			}
			for (Telefone tellnumero : cliente.getTelefones()) {
				System.out.println("Telefones: " + tellnumero.getDdd() + " " + tellnumero.getNumero());
			}
			System.out.println("--------------------------------------");
			n = n + 1;
		}
		int num = 0;

		Cliente cadastrarconsumo = null;
		while (num == 0) {
			Entrada entrada = new Entrada();
			System.out.println("\n\n Escolha o número do cliente que deseja cadastrar o consumo.");
			num = entrada.receberNumeroInteiro();

			if (num <= n) {
				cadastrarconsumo = clientes.get(num);
				break;
			}
		}

		int m = 0;
		while (m == 0) {
			System.out.println("Por favor informe o que " + cadastrarconsumo.getNome() + " consumiu:");
			System.out.println("1 - Produto.");
			System.out.println("2 - Serviço.");
			System.out.println("0 - Sair.");
			Entrada entrada = new Entrada();
			m = entrada.receberNumeroInteiro();
			if (m == 0) {
				break;
			}
			if (m == 1) {

				n = 0;
				for (Produto produto : produtos) {
					System.out.println("Produto " + n);
					System.out.println("Nome do produto: " + produto.nomeproduto);
					System.out.println("Código do produto: " + produto.getCodigoProduto().getNumeroProduto());
					System.out.println("Valor do produto: " + produto.valorproduto);
					System.out.println("Data de criação: " + produto.getCodigoProduto().getDatacriacao());
					System.out.println("--------------------------------------");
					n = n + 1;
				}
				m = 0;
				System.out.println("Por favor informe o número do produto que foi consumido:");
				while (m == 0) {
					Entrada entrada1 = new Entrada();
					System.out.println("\n\n Escolha o número do cliente que deseja cadastrar o consumo.");
					m = entrada1.receberNumeroInteiro();
					if (m <= n) {
						cadastrarconsumo.getProdutosConsumidos().add(produtos.get(m));
						break;
					}
				}

			}
			if (m == 2) {

				System.out.println("Qual servico foi consumido ?");
				n = 0;
				for (Servico servico : servicos) {
					System.out.println("Servico " + n);
					System.out.println("Nome do servico: " + servico.nomeservico);
					System.out.println("Valor do servico: " + servico.valorservico);
					System.out.println("--------------------------------------");
					n = n + 1;
				}

				m = 0;
				System.out.println("Por favor informe o n�mero do produto que foi servi�o:");
				while (m == 0) {
					Entrada entrada1 = new Entrada();
					System.out.println("\n\n Escolha o n�mero do cliente que deseja cadastrar o servi�o.");
					m = entrada1.receberNumeroInteiro();
					if (m <= n) {
						cadastrarconsumo.getServicosConsumidos().add(servicos.get(m));
						break;
					}
				}
			}

		}

	}
}
