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
			System.out.println("Servi�o " + n);
			System.out.println("Nome do servi�o: " + servico.nomeservico);
			System.out.println("Valor do servi�o: " + servico.valorservico);
			System.out.println("--------------------------------------");
			n = n + 1;
		}
		Servico editarservico = null;
		while (num == 0) {
			Entrada entrada = new Entrada();
			System.out.println("\n\n Escolha o n�mero do servi�o que deseja editar.");
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
			System.out.println("1 - Nome do servi�o.");
			System.out.println("2 - Valor do servi�o.");
			System.out.println("3 - Deseja deletar o servi�o.");
			System.out.println("0 - Sair.");
			Entrada entrada = new Entrada();
			m = entrada.receberNumeroInteiro();
			if (m == 0) {
				break;
			}
			if (m <= casos) {
				switch (m) {
				case 1:
					System.out.println("Por favor informe o nome do servi�o:");
					entrada = new Entrada();
					String nome = entrada.receberTexto();
					editarservico.setNomeServico(nome);
					break;
				case 2:
					System.out.println("Por favor informe o valor do servi�o:");
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