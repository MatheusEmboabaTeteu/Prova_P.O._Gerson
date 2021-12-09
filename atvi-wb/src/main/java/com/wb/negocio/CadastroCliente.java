package com.wb.negocio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.CPF;
import com.wb.modelo.Cliente;
import com.wb.modelo.RG;
import com.wb.modelo.Telefone;

public class CadastroCliente extends Cadastro {
	private List<Cliente> clientes;
	private Entrada entrada;
	int m;
	
	public CadastroCliente(List<Cliente> clientes) {
		this.clientes = clientes;
		this.entrada = new Entrada();
	}

	@Override
	public void cadastrar() {
		System.out.println("Inicio do cadastro do cliente");
		System.out.println("Por favor informe o nome do cliente:");
		String nome = entrada.receberTexto();
		System.out.println("Por favor informe o nome social do cliente:");
		String nomeSocial = entrada.receberTexto();
		System.out.println("Por favor informe genero do cliente:");
		System.out.println("1 - Masculino");
		System.out.println("2 - Feminino");
		String genero =null;
		while (m==0) {		
	    	int m = entrada.receberNumeroInteiro();
			if (m==1) {
			genero = "Masculino";
			m=0;
			break;
		}
		
		if (m==2) {
			genero = "Feminino";
			m=0;
			break;
		}
		else {
			System.out.println("Por favor escolha uma das opcoes:");
			System.out.println("1 - Masculino");
			System.out.println("2 - Feminino");
		}
	                  }
	
		System.out.println("Por favor informe o ddd do telefone do cliente");
		entrada = new Entrada ();
		String ddd = entrada.receberTexto();
		System.out.println("Por favor informe o numero do telefone do cliente");
		entrada = new Entrada ();
		String numero = entrada.receberTexto();

		
		ArrayList<Telefone> listanumero = new ArrayList<>();
		Telefone numtelefones= new Telefone ( ddd, numero);
		listanumero.add(numtelefones);
		 
		
		System.out.println("Deseja adicionar outro numero ?");
		System.out.println("1 - Sim");
		System.out.println("2 - Nao");
		
		while (m==0) {		
	    	int m = entrada.receberNumeroInteiro();
			if (m==1) {
				System.out.println("Por favor informe o ddd do telefone do cliente");
				entrada = new Entrada ();
				String ddd1 = entrada.receberTexto();
				System.out.println("Por favor informe o numero do telefone do cliente");
				entrada = new Entrada ();
				String numero1 = entrada.receberTexto();
				numtelefones = new Telefone(ddd1, numero1);
				listanumero.add(numtelefones);
				m=0;
				}
		
		if (m==2) {
			m=0;
			break;
		}
		else {
			System.out.println("Deseja adicionar outro numero ?");
			System.out.println("1 - Sim");
			System.out.println("2 - Nao");
		}
	                  }
				
		
		System.out.println("Por favor informe o numero do rg:");
		entrada = new Entrada ();
		String rgcodigo = entrada.receberTexto();
		
		System.out.println("Por favor informe a data de emissao do rg, no padrao dd/mm/yyyy:");
		entrada = new Entrada ();
		String datarg = entrada.receberTexto();
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataEmissaorg = LocalDate.parse(datarg, formato);
		
		ArrayList<RG>listrg = new ArrayList<>();
		RG numrg = new RG (dataEmissaorg, rgcodigo);
		listrg.add(numrg);
		
		System.out.println("Deseja adicionar outro rg ?");
		System.out.println("1 - Sim");
		System.out.println("2 - Nao");
		
		while (m==0) {		
	    	int m = entrada.receberNumeroInteiro();
	    if (m==1) {
				System.out.println("Por favor informe o numero do rg:");
				entrada = new Entrada ();
				String rgcodigo1 = entrada.receberTexto();
				System.out.println("Por favor informe a data de emissao do rg, no padrao dd/mm/yyyy:");
				entrada = new Entrada ();
				String datarg1 = entrada.receberTexto();
				LocalDate dataEmissaorg1 = LocalDate.parse(datarg1, formato);
				numrg = new RG( dataEmissaorg1, rgcodigo1);
				listrg.add(numrg);
				m=0;
				}
		if (m==2) {
			m=0;
			break;
		}
		else {
			System.out.println("Deseja adicionar outro rg ?");
			System.out.println("1 - Sim");
			System.out.println("2 - Nao");
		}
	                  }
	
		System.out.println("Por favor informe o numero do cpf:");
		entrada = new Entrada ();
		String valor = entrada.receberTexto();
		System.out.println("Por favor informe a data de emissao do cpf, no padrao dd/mm/yyyy:");
		entrada = new Entrada ();
		String data = entrada.receberTexto();
		
		LocalDate dataEmissao = LocalDate.parse(data, formato);
		CPF cpf = new CPF(dataEmissao, valor);
		Cliente cliente = new Cliente(nome, nomeSocial, genero, cpf, listrg, listanumero);
		this.clientes.add(cliente);
	}
}
	