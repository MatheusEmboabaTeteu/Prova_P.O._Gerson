package com.wb.negocio;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Servico;

public class SelecionarServico extends Listagem {
	private List<Servico> servicos;
	int n = 0;
	int num = 0;
	
	public SelecionarServico(List<Servico> servicos) {
		this.servicos = servicos;
	}

	@Override
	public void listar() {
		System.out.println("Lista de todos os produtos:");
		for (Servico servico : servicos) {
			System.out.println("Servico " + n);
			System.out.println("Nome do servico: " + servico.nomeservico);
			System.out.println("Valor do servico: " + servico.valorservico);
			System.out.println("--------------------------------------");
			n = n + 1;
		}
		Servico editarservico = null;
		while (num == 0) {
			Entrada entrada = new Entrada();
			System.out.println("\n\n Escolha o numero do servico que deseja editar.");
			num = entrada.receberNumeroInteiro();
			if (num <= n) {
				editarservico = servicos.get(num);
				num = 0;
				break;
			} else {
				num = 0;
			}
	}
		
		//EDITANDO
		
		int casos = 3;
		int m = 10;
		while (m == 10) {
			System.out.println("Por favor informe o que deseja editar:");
			System.out.println("1 - Nome do servico.");
			System.out.println("2 - Valor do servico.");
			System.out.println("3 - Deseja deletar o servico.");
			System.out.println("0 - Sair.");
			Entrada entrada = new Entrada();
			m = entrada.receberNumeroInteiro();
			if (m == 0) {
				break;
			}
			if (m <= casos) {
				switch (m) {
				case 1:
					System.out.println("Por favor informe o nome do servico:");
					entrada = new Entrada();
					String nome = entrada.receberTexto();
					editarservico.setNomeServico(nome);
					break;
				case 2:
					System.out.println("Por favor informe o valor do servico:");
					entrada = new Entrada();
					String valor = entrada.receberTexto();;
					editarservico.setValorServico(valor);
					break;
				case 3:
					servicos.remove(num);
					m=1;
					break;
				}
			if (m==1) {break;}
			m = 10;
			}
		}

	}
}