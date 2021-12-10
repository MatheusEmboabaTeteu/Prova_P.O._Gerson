package com.wb.negocio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.CPF;
import com.wb.modelo.Cliente;
import com.wb.modelo.RG;
import com.wb.modelo.Telefone;

public class SelecionarCliente extends Listagem {
	private List<Cliente> clientes;
	int n = 0;
	int g = 0;

	public SelecionarCliente(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	@Override
	public void listar() {
		System.out.println("Lista de todos os clientes:");
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
		
		Cliente editarcliente = null;
		while (true) {
			Entrada entrada = new Entrada();
			System.out.println("\n\n Escolha o numero do cliente que deseja editar.");
			num = entrada.receberNumeroInteiro();
			
			if (num <= n) {
				editarcliente = clientes.get(num);
				break;
			}
		}

		// EDITANDO

		int casos = 7;
		int m = 0;
		int f = 0;
		while (true) {
			System.out.println("Por favor informe o que deseja editar:");
			System.out.println("1 - Nome.");
			System.out.println("2 - Nome social.");
			System.out.println("3 - Genero.");
			System.out.println("4 - CPF e Data de emissao.");
			System.out.println("5 - RG e Data de emissao.");
			System.out.println("6 - Telefones.");
			System.out.println("7 - Deseja deletar o cliente.");
			System.out.println("0 - Sair.");

			Entrada entrada = new Entrada();
			m = entrada.receberNumeroInteiro();
			if (m == 0) {break;}
			if (m <= casos) {
				DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				switch (m) {
				case 1:
					System.out.println("Por favor informe o nome do cliente:");
					entrada = new Entrada();
					String nome = entrada.receberTexto();
					editarcliente.setNome(nome);
					break;
				case 2:
					System.out.println("Por favor informe o nome social do cliente:");
					entrada = new Entrada();
					String nomeSocial = entrada.receberTexto();
					editarcliente.nomeSocial = nomeSocial; 
					break;
				case 3:
					System.out.println("Por favor informe genero do cliente:");
					System.out.println("1 - Masculino");
					System.out.println("2 - Feminino");
					String genero = null;
					n=0;
					while (n == 0) {
						entrada = new Entrada();
						n = entrada.receberNumeroInteiro();
						if (n == 1) {
							genero = "Masculino";
							n = 0;
							break;
						}

						if (n == 2) {
							genero = "Feminino";
							n = 0;
							break;
						} else {
							System.out.println("Por favor escolha uma das opcoes:");
							System.out.println("1 - Masculino");
							System.out.println("2 - Feminino");
						}
					}
					editarcliente.genero = genero;
					break;
				case 4:
					System.out.println("Por favor informe o numero do CPF:");
					entrada = new Entrada ();
					String cpfcodigo = entrada.receberTexto();
					
					System.out.println("Por favor informe a data de emissao do CPF, no padrao dd/mm/yyyy:");
					entrada = new Entrada ();
					String datacpf = entrada.receberTexto();
					
					LocalDate dataEmissaocpf = LocalDate.parse(datacpf, formato);
					CPF cpfnovo = new CPF(dataEmissaocpf, cpfcodigo);
					editarcliente.setCpf(cpfnovo);
					break;
					
				case 5:
					n = 0;
					while (true) {
						System.out.println("Por favor escolha uma opcao:");
						System.out.println("1 - Deseja editar um RG.");
						System.out.println("2 - Deseja adicionar mais um RG.");
						System.out.println("0 - Sair.");
												
						List<RG> rgs = editarcliente.getRgs();
						
						entrada = new Entrada();
						n = entrada.receberNumeroInteiro();
						if (n == 0) {break;}
						
						if (n == 1) {
							f = 0;
							n = 0;
							List<RG> rgnumero = editarcliente.getRgs();
							for (RG rgnum : rgnumero){
								System.out.println("RG Numero " + f);
								System.out.println("RG - "+ rgnum.getRgcodigo() + "  " + rgnum.getDataEmissao());
								f = f + 1;
								}
							while (true) {
								System.out.println("Por favor informe o numero do RG que deseja editar:");
								entrada = new Entrada();
								n = entrada.receberNumeroInteiro();
								if (n <= f) {
									System.out.println("Por favor informe rg do cliente:");
									entrada = new Entrada();
									String rgcodigo = entrada.receberTexto();
									System.out.println("Por favor informe a data de emissao do rg, no padrao dd/mm/yyyy:");
									entrada = new Entrada();
									String datarg20 = entrada.receberTexto();
									LocalDate dataEmissaorg = LocalDate.parse(datarg20, formato);
									
									RG rgslist = rgs.get(n);
									rgslist.setRg(dataEmissaorg,rgcodigo);								
									
									n = 0;
									break;
								} else {
									System.out.println("Por favor escolha uma das opcoes acima");
									n = 0;
								}
							}
						}

						if (n == 2) {
							System.out.println("Por favor informe rg do cliente:");
							entrada = new Entrada();
							String rgcodigo1 = entrada.receberTexto();
							System.out.println("Por favor informe a data de emissao do rg, no padrao dd/mm/yyyy:");
							entrada = new Entrada();
							String datarg1 = entrada.receberTexto();
							
							LocalDate dataEmissaorg1 = LocalDate.parse(datarg1, formato);
							RG rgnovo = new RG (dataEmissaorg1,rgcodigo1);
							editarcliente.getRgs().add(rgnovo);
							
							n = 0;
						}

						else {
							System.out.println("Por favor escolha uma das opcoes acima:");
							n = 0;
							}
					}
					break;
				case 6:
					n = 0;
					while (true) {
						System.out.println("Por favor escolha uma opcao:");
						System.out.println("1 - Deseja editar um numero.");
						System.out.println("2 - Deseja adicionar mais um numero.");
						System.out.println("0 - Sair.");
						
						List<Telefone> telefones = editarcliente.getTelefones();

						entrada = new Entrada();
						n = entrada.receberNumeroInteiro();
						if(n==0) {break;}
						if (n == 1) {
							f = 0;
							for (Telefone tellnumero : telefones) {
								System.out.println("Telefone - Numero " + f + " - " + tellnumero.getDdd() + " " + tellnumero.getNumero());
								f = f + 1;
							}
							n = 0;
							while (true) {
								System.out.println("Qual dos Telefones deseja editar? Por favor informe o numero:");
								entrada = new Entrada();
								n = entrada.receberNumeroInteiro();
								if (n <= f) {
									System.out.println("Por favor informe o ddd do telefone do cliente:");
									entrada = new Entrada();
									String ddd = entrada.receberTexto();
									System.out.println("Por favor informe o numero do telefone do cliente:");
									entrada = new Entrada();
									String numero = entrada.receberTexto();
									Telefone tel = telefones.get(n);
									tel.setTelefone(ddd, numero);
									n = 0;
									break;
								} else {
									System.out.println("Por favor escolha uma das opcoes acima:");
									n = 0;
								}
							}
						}

						if (n == 2) {
							System.out.println("Por favor informe o ddd do telefone do cliente:");
							entrada = new Entrada();
							String ddd1 = entrada.receberTexto();
							System.out.println("Por favor informe o numero do telefone do cliente:");
							entrada = new Entrada();
							String numero1 = entrada.receberTexto();
							Telefone tel = new Telefone(ddd1, numero1);
							editarcliente.getTelefones().add(tel);
							n = 0;
						}

						else {
							System.out.println("Por favor escolha uma das opcoes acima:");
							n = 0;
						}
					}break;
				case 7:
					clientes.remove(num);
					m=1;
					break;
				
				}
				if (m==1) {break;}
				}	
			
		}
		
	}
	}