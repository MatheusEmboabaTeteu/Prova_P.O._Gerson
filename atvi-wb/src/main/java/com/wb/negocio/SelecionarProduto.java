package com.wb.negocio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Produto;

public class SelecionarProduto extends Listagem {
	private List<Produto> produtos;
	int n = 0;
	int num = 0;

	public SelecionarProduto(List<Produto> produtos) {
		this.produtos = produtos;
	}

	@Override
	public void listar() {
		System.out.println("Lista de todos os produtos:");
		for (Produto produto : produtos) {
			System.out.println("Produto " + n);
			System.out.println("Nome do produto: " + produto.nomeproduto);
			System.out.println("C�digo do produto: " + produto.getCodigoProduto().getNumeroProduto());
			System.out.println("Valor do produto: " + produto.valorproduto);
			System.out.println("Data de criacao: " + produto.getCodigoProduto().getDatacriacao());
			System.out.println("--------------------------------------");
			n = n + 1;
		}
		Produto editarproduto = null;
		while (num == 0) {
			Entrada entrada = new Entrada();
			System.out.println("\n\n Escolha o n�mero do produto que deseja editar.");
			num = entrada.receberNumeroInteiro();
			if (num <= n) {
				editarproduto = produtos.get(num);
				num = 0;
				break;
			} else {
				num = 0;
			}
		}

		// EDITANDO

		int casos = 5;
		int m = 10;
		while (m == 10) {
			System.out.println("Por favor informe o que deseja editar:");
			System.out.println("1 - Nome do produto.");
			System.out.println("2 - Codigo do produto.");
			System.out.println("3 - Valor do produto.");
			System.out.println("4 - Data de cadastro do produto.");
			System.out.println("5 - Deseja deletar o produto.");
			System.out.println("0 - Sair.");

			Entrada entrada = new Entrada();
			m = entrada.receberNumeroInteiro();
			if (m == 0) {
				break;
			}
			if (m <= casos) {
				switch (m) {
				case 1:
					System.out.println("Por favor informe o nome do produto:");
					entrada = new Entrada();
					String nome = entrada.receberTexto();
					editarproduto.setnomeproduto(nome);
					break;
				case 2:
					System.out.println("Por favor informe o codigo do produto:");
					entrada = new Entrada();
					String codigoproduto = entrada.receberTexto();
					editarproduto.getCodigoProduto().setNumeroproduto(codigoproduto);
					break;
				case 3:
					System.out.println("Por favor informe o valor do produto:");
					entrada = new Entrada();
					String valor = entrada.receberTexto();
					editarproduto.setvalorproduto(valor);
					break;
				case 4:
					System.out.println("Por favor informe a data de atual para cadastro do produto, no padrao dd/mm/yyyy:");
					entrada = new Entrada();
					String dataproduto = entrada.receberTexto();

					DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					LocalDate dataEmissaoproduto = LocalDate.parse(dataproduto, formato);
					editarproduto.getCodigoProduto().setDatacriacao(dataEmissaoproduto);
					break;
				case 5:
				produtos.remove(num);
				m=1;
				break;
				}
				if (m==1) {break;}
				m = 10;
			}
		}
	}
}