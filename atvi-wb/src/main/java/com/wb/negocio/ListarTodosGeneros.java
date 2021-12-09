package com.wb.negocio;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Cliente;
import com.wb.modelo.RG;
import com.wb.modelo.Telefone;


public class ListarTodosGeneros extends Listagem {
	private List<Cliente> clientes;

	public ListarTodosGeneros(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	@Override
	public void listar() {
		
		System.out.println("Por favor escolha o gênero:");
		System.out.println("1 - Masculino");
		System.out.println("2 - Feminino");
		String genero =null;
		int m = 0;
		while (m==0) {		
			Entrada entrada = new Entrada();
			m = entrada.receberNumeroInteiro();
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
			System.out.println("Por favor escolha uma das opções:");
			System.out.println("1 - Masculino");
			System.out.println("2 - Feminino");
		}
		}
		
		System.out.println("Lista de todos os clientes por genero:");
		for (Cliente cliente : clientes) {
			if (cliente.genero==genero){
			System.out.println("Nome: " + cliente.getNome());
			System.out.println("Nome social: " + cliente.nomeSocial);
			System.out.println("Gênero: " + cliente.genero);
			System.out.println("CPF e Data de Emissão: " + cliente.getCpf().getValor()+" " + cliente.getCpf().getDataEmissao());
			for (RG rgnumero : cliente.getRgs()){
			System.out.println("RG e Data Emissão: " + rgnumero.getRgcodigo() + " " + rgnumero.getDataEmissao());
			}
			for (Telefone tellnumero : cliente.getTelefones()){
			System.out.println("Telefones: " + tellnumero.getDdd() + " " + tellnumero.getNumero());
			}
			System.out.println("--------------------------------------");
		}
		}
	}
}