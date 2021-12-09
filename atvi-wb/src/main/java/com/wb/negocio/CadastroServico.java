package com.wb.negocio;



import java.util.List;
import com.wb.io.Entrada;
import com.wb.modelo.Servico;

public class CadastroServico extends Cadastro {
	private List<Servico> servicos;
	private Entrada entrada;


	public CadastroServico(List<Servico> servicos) {
		this.servicos = servicos;
		this.entrada = new Entrada();
	}

	@Override
	public void cadastrar() {
		System.out.println("Inicio do cadastro de servico");
		System.out.println("Por favor informe o nome do servico:");
		String nome = entrada.receberTexto();
		System.out.println("Por favor informe o valor do servico:");
		String valor= entrada.receberTexto();
		Servico servico = new Servico(nome,valor);
		this.servicos.add(servico);
	}
}