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
			System.out.println("Gênero: " + cliente.genero);
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
		
		Cliente editarcliente = null;
		while (num == 0) {
			Entrada entrada = new Entrada();
			System.out.println("\n\n Escolha o número do cliente que deseja editar.");
			num = entrada.receberNumeroInteiro();
			
			if (num <= n) {
				editarcliente = clientes.get(num);
				break;
			}
		}

		// EDITANDO

		int casos = 7;
		int m = 10;
		int f = 0;
		while (m == 10) {
			System.out.println("Por favor informe o que deseja editar:");
			System.out.println("1 - Nome.");
			System.out.println("2 - Nome social.");
			System.out.println("3 - Gênero.");
			System.out.println("4 - CPF e Data de emissão.");
			System.out.println("5 - RG e Data de emissão.");
			System.out.println("6 - Telefones.");
			System.out.println("7 - Deseja deletar o cliente.");
			System.out.println("0 - Sair.");

			Entrada entrada = new Entrada();
			m = entrada.receberNumeroInteiro();
			if (m == 0) {break;}
			if (m <= casos) {
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
					System.out.println("Por favor informe gênero do cliente:");
					System.out.println("1 - Masculino");
					System.out.println("2 - Feminino");
					entrada = new Entrada();
					String genero = null;
					while (n == 0) {
						int n = entrada.receberNumeroInteiro();
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
							System.out.println("Por favor escolha uma das opções:");
							System.out.println("1 - Masculino");
							System.out.println("2 - Feminino");
						}
					}
					editarcliente.genero = genero;
					break;
				case 4:
					System.out.println("Por favor informe o número do CPF:");
					entrada = new Entrada ();
					String cpfcodigo = entrada.receberTexto();
					
					System.out.println("Por favor informe a data de emissão do CPF, no padrão dd/mm/yyyy:");
					entrada = new Entrada ();
					String datacpf = entrada.receberTexto();
					
					DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					LocalDate dataEmissaocpf = LocalDate.parse(datacpf, formato);
					CPF cpfnovo = new CPF(dataEmissaocpf, cpfcodigo);
					editarcliente.setCpf(cpfnovo);
					break;
					
				case 5:
					n = 0;
					while (n == 0) {
						System.out.println("Por favor escolha uma opção:");
						System.out.println("1 - Deseja editar um RG.");
						System.out.println("2 - Deseja adicionar mais um RG.");
						
						List<RG> rgs = editarcliente.getRgs();
						
						entrada = new Entrada();
						int n = entrada.receberNumeroInteiro();
						if (n == 1) {
							f = 0;
							for (RG rgnumero : editarcliente.getRgs()) {
								System.out.println(
										"RG - Número " + f + " - " + rgnumero.getRgcodigo() + "  " + rgnumero.getDataEmissao());
								f = f + 1;
							}
							n = 0;
							while (n == 0) {
								System.out.println("Qual dos RGs deseja editar ? Por favor informe o número:");
								entrada = new Entrada();
								n = entrada.receberNumeroInteiro();
								if (n <= f) {
									System.out.println("Por favor informe rg do cliente:");
									entrada = new Entrada();
									String rgcodigo = entrada.receberTexto();
									System.out.println("Por favor informe a data de emissão do rg, no padrão dd/mm/yyyy:");
									entrada = new Entrada();
									String datarg = entrada.receberTexto();
									DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
									LocalDate dataEmissaorg = LocalDate.parse(datarg, formato2);
									RG rgslist = rgs.get(n);
									rgslist.setRg(dataEmissaorg,rgcodigo);
									n = 0;
									break;
								} else {
									System.out.println("Por favor escolha uma das opções acima");
									n = 0;
									continue;
								}
							}
						}

						if (n == 2) {
							System.out.println("Por favor informe rg do cliente:");
							entrada = new Entrada();
							String rgcodigo1 = entrada.receberTexto();
							System.out.println("Por favor informe a data de emissão do rg, no padrão dd/mm/yyyy:");
							entrada = new Entrada();
							String datarg1 = entrada.receberTexto();
							DateTimeFormatter formato3 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
							LocalDate dataEmissaorg1 = LocalDate.parse(datarg1, formato3);
							RG rgnovo = new RG (dataEmissaorg1,rgcodigo1);
							editarcliente.getRgs().add(rgnovo);
							
							n = 0;
						}

						else {
							System.out.println("Por favor escolha uma das opções acima:");
							n = 0;
							continue;
						}
						int a = 0;
						while (n == 0) {
							System.out.println("Deseja editar ou adicionar outro rg ?");
							System.out.println("1 - Sim");
							System.out.println("2 - Não");
							entrada = new Entrada();
							n = entrada.receberNumeroInteiro();
							if (n == 1) {
								break;
							}
							if (n == 2) {
								a = 1;
								break;
							}
							n = 0;
						}
						if (a == 1) {
							a=0;
							break;
						}
					}
					break;
				case 6:
					n = 0;
					while (n == 0) {
						System.out.println("Por favor escolha uma opção:");
						System.out.println("1 - Deseja editar um número.");
						System.out.println("2 - Deseja adicionar mais um número.");
						
						List<Telefone> telefones = editarcliente.getTelefones();
						

						entrada = new Entrada();
						int n = entrada.receberNumeroInteiro();
						if (n == 1) {
							f = 0;
							for (Telefone tellnumero : editarcliente.getTelefones()) {
								System.out.println(
										"Telefone - Número " + f + " - " + tellnumero.getDdd() + " " + tellnumero.getNumero());
								f = f + 1;
							}
							n = 0;
							while (n == 0) {
								System.out.println("Qual dos Telefones deseja editar? Por favor informe o número:");
								entrada = new Entrada();
								n = entrada.receberNumeroInteiro();
								if (n <= f) {
									System.out.println("Por favor informe o ddd do telefone do cliente:");
									entrada = new Entrada();
									String ddd = entrada.receberTexto();
									System.out.println("Por favor informe o número do telefone do cliente:");
									entrada = new Entrada();
									String numero = entrada.receberTexto();
									Telefone tel = telefones.get(n);
									tel.setTelefone(ddd, numero);
									n = 0;
									break;
								} else {
									System.out.println("Por favor escolha uma das opções acima:");
									n = 0;
									continue;
								}
							}
						}

						if (n == 2) {
							System.out.println("Por favor informe o ddd do telefone do cliente:");
							entrada = new Entrada();
							String ddd1 = entrada.receberTexto();
							System.out.println("Por favor informe o número do telefone do cliente:");
							entrada = new Entrada();
							String numero1 = entrada.receberTexto();
							Telefone tel = new Telefone(ddd1, numero1);
							editarcliente.getTelefones().add(tel);
							n = 0;
						}

						else {
							System.out.println("Por favor escolha uma das opções acima:");
							n = 0;
							continue;
						}
						int a = 0;
						while (n == 0) {
							System.out.println("Deseja editar ou adicionar outro número ?");
							System.out.println("1 - Sim");
							System.out.println("2 - Não");
							entrada = new Entrada();
							n = entrada.receberNumeroInteiro();
							if (n == 1) {
								break;
							}
							if (n == 2) {
								a = 1;
								break;
							}
							n = 0;
						}
						if (a == 1) {
							a=0;
							break;
						}
					}break;
				case 7:
					clientes.remove(num);
					m=1;
					break;
				
				}
				if (m==1) {break;}
				m = 10;
			}	
			
		}
		
	}
	}