package com.wb.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
	private String nome;
	public String nomeSocial;
	public String genero;
	private CPF cpf;
	private List<RG> rgs;
	private LocalDate dataCadastro;
	private List<Telefone> telefones;
	private List<Produto> produtosConsumidos;
	private List<Servico> servicosConsumidos;
	public Cliente(String nome, String nomeSocial,String  genero, CPF cpf,List<RG> listrg,List<Telefone> listanumero ) {
		this.nome = nome;
		this.nomeSocial = nomeSocial;
		this.genero = genero;
		this.cpf = cpf;
		this.rgs = new ArrayList<>();
		this.dataCadastro = LocalDate.now();
		this.telefones = new ArrayList<>();
		this.produtosConsumidos = new ArrayList<>();
		this.servicosConsumidos = new ArrayList<>();
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCpf(CPF cpfnovo){
		cpf = cpfnovo;
	}
	public CPF getCpf() {
		return cpf;
	}
	public List<RG> getRgs() {
		return rgs;
	}
	public LocalDate getDataCadastro() {
		return dataCadastro;
	}
	public List<Telefone> getTelefones() {
		return telefones;
	}
	public List<Produto> getProdutosConsumidos() {
		return produtosConsumidos;
	}
	public List<Servico> getServicosConsumidos() {
		return servicosConsumidos;
	}
}