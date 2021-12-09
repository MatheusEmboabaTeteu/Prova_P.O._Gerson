package com.wb;

import com.wb.io.Entrada;
import com.wb.modelo.Empresa;
import com.wb.negocio.Cadastro;
import com.wb.negocio.CadastroCliente;
import com.wb.negocio.CadastroConsumo;
import com.wb.negocio.CadastroProduto;
import com.wb.negocio.CadastroServico;
import com.wb.negocio.Listagem;
import com.wb.negocio.ListarTodosClientes;
import com.wb.negocio.ListarTodosConsumos;
import com.wb.negocio.ListarTodosGeneros;
import com.wb.negocio.ListarTodosProdutos;
import com.wb.negocio.ListarTodosServicos;
import com.wb.negocio.SelecionarCliente;
import com.wb.negocio.SelecionarProduto;
import com.wb.negocio.SelecionarServico;

public class App {
	public static void main(String[] args) {
		System.out.println("Bem-vindo ao cadastro de clientes do Grupo World Beauty");
		Empresa empresa = new Empresa();
		boolean execucao = true;
		while (execucao) {
			System.out.println("Que tipo de operacao voce deseja fazer:");
			System.out.println("1 - Cadastrar cliente");
			System.out.println("2 - Cadastrar produto");
			System.out.println("3 - Cadastrar servico");
			System.out.println("4 - Cadastrar consumo");
			System.out.println("5 - Listar todos os clientes");
			System.out.println("6 - Listar todos os produtos");
			System.out.println("7 - Listar todos os servicos");
			System.out.println("8 - Listar todos de consumo");
			System.out.println("9 - Listar clientes por genero");
			System.out.println("10 - Editar ou deletar cadastro de cliente");
			System.out.println("11 - Editar ou deletar cadastro de produto");
			System.out.println("12 - Editar ou deletar cadastro de servico");
			System.out.println("0 - Sair");

			Entrada entrada = new Entrada();
			int operacao = entrada.receberNumeroInteiro();

			switch (operacao) {
			case 0:
				execucao = false;
				System.out.println("Ate mais!\n");
				break;
			case 1:
				Cadastro cadastrocliente = new CadastroCliente(empresa.getClientes());
				cadastrocliente.cadastrar();
				break;
			case 2:
				Cadastro cadastroproduto = new CadastroProduto(empresa.getProdutos());
				cadastroproduto.cadastrar();
				break;
			case 3:
				Cadastro cadastroservico = new CadastroServico(empresa.getServicos());
				cadastroservico.cadastrar();
				break;
			case 4:
				Cadastro cadastroconsumo = new CadastroConsumo(empresa.getClientes(),empresa.getProdutos(),empresa.getServicos());
				cadastroconsumo.cadastrar();
				break;
			case 5:
				Listagem listagemcliente = new ListarTodosClientes(empresa.getClientes());
				listagemcliente.listar();
				break;
			case 6:
				Listagem listagemproduto = new ListarTodosProdutos(empresa.getProdutos());
				listagemproduto.listar();
				break;
			case 7:
				Listagem listagemservico = new ListarTodosServicos(empresa.getServicos());
				listagemservico.listar();
				break;
			case 8:
				Listagem listagemConsumo = new ListarTodosConsumos(empresa.getClientes());
				listagemConsumo.listar();
				break;
			case 9:
				Listagem listagemgenero = new ListarTodosGeneros(empresa.getClientes());
				listagemgenero.listar();
				break;
			case 10:
				Listagem listagemselec = new SelecionarCliente(empresa.getClientes());
				listagemselec.listar();
				break;
			case 11:
				Listagem listagemselecproduto = new SelecionarProduto(empresa.getProdutos());
				listagemselecproduto.listar();
				break;
			case 12:
				Listagem listagemselecservico = new SelecionarServico(empresa.getServicos());
				listagemselecservico.listar();
				break;
			default:
				System.out.println("Operacao nao entendida");
			}
		}
	}
}