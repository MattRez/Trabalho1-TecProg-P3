package br.edu.univas.main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import br.edu.univas.vo.*;

public class StartApp {
	
	/*
	Crie um projeto em Java que tenha 2 tipos de cadastro:
	1. Cadastro de Player:
	a. Considere que Player poderá ser: Disney+, Netflix, Amazon Prime, Globo Play, entre outras.
	Para isso você deverá salvar os seguintes dados:
		i. Nome
		ii. Site
	2. Cadastro de título:
	a. Considere que um título poderá ser filme ou série.
	Para isso você deverá salvar os seguintes dados:
		i. Tipo (filme ou série)
		ii. Título
		iii. Elenco
		iv. Descrição
		v. Gênero
		vi. Diretor
		vii. Classificação etária
		viii. Plataforma (pode ser um ou mais players)
	
	Além do cadastro seu programa deverá permitir um usuário fazer buscas sobre os títulos 
	(pensem nos mais diversos filtros possíveis) e fazer recomendações seguindo as seguintes opções:
	1. Recomendação aleatória (qualquer título – independentemente de qualquer característica)
	2. Recomendação por gênero (o usuário escolhe o gênero e seu programa faz uma recomendação)
	O trabalho deverá ser feito em dupla ou sozinho.
	Os critérios para a avaliação do projeto serão:
		1. Funcionamento
		2. Uso correto dos conceitos aprendidos sobre orientação a objetos
		3. Nomenclatura para nome de classes, métodos, variáveis e atributos
		4. Reutilização de código
	
	Data da Entrega: 03/04/2022
	Forma de Entrega: 
		enviar para o e-mail rodrigolfsi@univas.edu.br o link do Github com o código fonte.
	Ainda no corpo do e-mail é necessário enviar o nome e o sobrenome de cada membro da dupla.
	*/
	
	static ArrayList<Player> players = new ArrayList<>();
	static ArrayList<Titulo> titulos = new ArrayList<>();
	static Player playerPadrao = cadastrarPlayerPadrao();
	static Titulo tituloPadrao = cadastrarTituloPadrao();
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int opt;//option
		
		do {
			printMenu();
			opt = readInt(scan);
			calcOpt(opt, scan);
			
			
		} while(opt != 0);
		
		
		scan.close();
	}
	
	public static void printMenu() {
		System.out.println("Sistema de Catalogo de Streaming\n");
		System.out.println("Por Favor, Digite uma Opção:");
		System.out.println("1. Cadastrar Player (" + players.size() + ")");
		System.out.println("2. Cadastrar Titulo (" + titulos.size() + ")");
		System.out.println("3. Pesquisar");
		System.out.println("4. Aleatório");
		System.out.println("0. Finalizar Programa");
	}
	
	public static void calcOpt(int opt, Scanner scan) {
		switch (opt) {
			case 0:
				System.out.println("Programa Finalizado :)");
				break;
			case 1:
				cadastrarPlayer(scan);
				break;
			case 2:
				cadastrarTitulo(scan);
				break;
			case 3:
				pesquisar(scan);
				break;
			case 4:
				aleatorio(scan);
				break;
			default:
				System.out.println("Opção Invalida, Por Favor Tente Novamente");
		}
	}
	
	public static void cadastrarPlayer(Scanner scan) {
		
		Player player = new Player();
		System.out.println("Por Favor, Digite o Nome do Player: ");
		player.setNome(scan.nextLine());
		System.out.println("Por Favor, Digite o Site do Player: ");
		player.setSite(scan.nextLine());
		
		players.add(player);
	}
	
	public static void cadastrarTitulo(Scanner scan) {
		System.out.println("Por Favor, Digite o Tipo: ");
		System.out.println("1. Filme");
		System.out.println("2. Série");
		int aux;
		
		do {
			aux = readInt(scan);
			if(aux == 1) {
				System.out.println("Filme: ");
				titulos.add(cadastrarFilme(aux, scan));
			} else if (aux == 2) {
				System.out.println("Série: ");
				titulos.add(cadastrarSerie(aux, scan));
			} else {
				System.out.println("Opção Invalida, Por Favor tente Novamente");
			}
		} while (aux !=1 && aux !=2);
		
	}
	
	public static Filme cadastrarFilme(int aux, Scanner scan) {
		Filme filme = new Filme();
		System.out.println("Por Favor, Digite o Nome do Filme: ");
		filme.setNome(scan.nextLine());
		
		filme.setElenco(cadastrarElenco(aux, scan));
		
		System.out.println("Por Favor, Digite uma Descrição do Filme: ");
		filme.setDescricao(scan.nextLine());
		
		System.out.println("Por Favor, Digite o Gênero do Filme: ");
		filme.setGenero(scan.nextLine());
		
		System.out.println("Cadastrar o(a) Diretor(a) do Filme: ");
		filme.setDiretor(cadastrarPessoa(scan));
		
		System.out.println("Por Favor, Digite a Classificação Indicativa do Filme: ");
		filme.setClassificacao(readInt(scan));
		
		filme.setPlayers(regPlayers(aux, scan));
		return filme;
	}
	
	public static Serie cadastrarSerie(int aux, Scanner scan) {
		Serie serie = new Serie();
		System.out.println("Por Favor, Digite o Nome da Serie: ");
		serie.setNome(scan.nextLine());
		
		serie.setElenco(cadastrarElenco(aux, scan));
		
		System.out.println("Por Favor, Digite uma Descrição da Serie: ");
		serie.setDescricao(scan.nextLine());
		
		System.out.println("Por Favor, Digite o Gênero da Serie: ");
		serie.setGenero(scan.nextLine());
		
		System.out.println("Cadastrar o(a) Diretor(a) da Serie: ");
		serie.setDiretor(cadastrarPessoa(scan));
		
		System.out.println("Por Favor, Digite a Classificação Indicativa da Serie: ");
		serie.setClassificacao(readInt(scan));
		
		System.out.println("Por Favor, Digite a Quantidade de Episódios da Serie: ");
		serie.setEpisodios(readInt(scan));
		
		do {
			System.out.println("Por Favor, Digite se a Séria está Completa: ");
			System.out.println("1. Sim");
			System.out.println("2. Não");
			aux = readInt(scan);
			
			if(aux == 1) {
				serie.setCompleto(true);
			} else if (aux == 2) {
				serie.setCompleto(false);
			} else {
				System.out.println("Opção Invalida, Por Favor tente Novamente");
			}
		} while (aux!=1 && aux!=2);
		
		serie.setPlayers(regPlayers(aux, scan));
		return serie;
	}
	
	public static ArrayList<Pessoa> cadastrarElenco(int aux, Scanner scan) {
		System.out.println("Cadastrar Elenco: ");
		ArrayList<Pessoa> elenco = new ArrayList<>();
		
		aux = 1;
		Pessoa pessoa = null;
		
		do {
			System.out.println("Cadastrar " + aux + "a Pessoa: ");
			pessoa = cadastrarPessoa(scan);
			
			if(pessoa.getNome().equals("")) {
				System.out.println("Cadastro de Elenco Finalizado");
			} else {
				elenco.add(pessoa);
			}
			
			aux++;
		}while(!pessoa.getNome().equals(""));
		return elenco;
	}
	
	public static ArrayList<Player> regPlayers(int aux, Scanner scan) {
		aux = 1;
		ArrayList<Player> playerList = new ArrayList<>();
		String str;
		boolean confirm;
		
		System.out.println("Registrar Player(s): ");
		System.out.println("Deixe o campo vazio para terminar o Registro ");
		
		do {
			Player player = null;
			System.out.print(aux + "o Player: ");
			str = scan.nextLine();
			
			for(int i=0; i<players.size(); i++) {
				if(str.equals(players.get(i).getNome())) {
					player = players.get(i);
				}
			}
			
			if(player != null) {
				confirm = true;
				playerList.add(player);
			} else {
				confirm = false;
				System.out.println("Registro de Players Finalizado");
			}
			
		} while (confirm);
		return playerList;
	}
	
	//
	
	public static void pesquisar(Scanner scan) {
		System.out.println("Pesquisa por Nome: ");
		System.out.println("Pesquisar Titulos ou Plataformas?");
		System.out.println("1. Titulos");
		System.out.println("2. Players");
		System.out.println("3. Voltar");
		int opt = readInt(scan);
		String str = null;
		
		switch(opt) {
		case 1:
			if(pesqTitulos(opt, str, scan)!=null) {
				pesqTitulos(opt, str, scan).toString();
			} else {
				switch(opt) {
				case 1:
					System.out.println("Filme não Encontrado");
					break;
				case 2:
					System.out.println("Serie não Encontrado");
					break;
				}
			}
			break;
		case 2:
			System.out.println("Pesquisar Players: ");
			if(pesqPlayer(opt, str, scan)!=null) {
				pesqPlayer(opt, str, scan).toString();
			} else {
				System.out.println("Player não Encontrado");
			}
			break;
		}
	}
	
	public static Titulo pesqTitulos(int opt, String str, Scanner scan) {
		System.out.println("Pesquisar Titulos: ");
		System.out.println("1. Filmes");
		System.out.println("2. Séries");
		System.out.println("3. Voltar");
		
		opt = readInt(scan);
		
		switch(opt) {
		case 1:
			Titulo filme = pesqFilme(str, scan);
			if(filme != null) {
				return pesqFilme(str, scan);
			}
		case 2:
			Titulo serie = pesqSerie(str, scan);
			if(serie != null) {
				return pesqSerie(str, scan);
			}
		}
		return null;
	}
	
	public static Titulo pesqFilme(String str, Scanner scan) {
		System.out.println("Pesquisar Filme: ");
		System.out.println("Por Favor, Digite o Nome do Filme: ");
		str = scan.nextLine();
		
		for(int i=0; i<titulos.size(); i++) {
			if(titulos.get(i) instanceof Filme) {
				if(str.equals(titulos.get(i).getNome())) {
					return titulos.get(i);
				}
			}
		}
		return null;
	}
	
	public static Titulo pesqSerie(String str, Scanner scan) {
		System.out.println("Pesquisar Serie: ");
		System.out.println("Por Favor, Digite o Nome do Serie: ");
		str = scan.nextLine();
		
		for(int i=0; i<titulos.size(); i++) {
			if(titulos.get(i) instanceof Serie) {
				if(str.equals(titulos.get(i).getNome())) {
					return titulos.get(i);
				}
			}
		}
		return null;
	}
	
	public static Player pesqPlayer(int opt, String str, Scanner scan) {
		System.out.println("Por Favor, Digite o Nome do Player: ");
		
		for(int i=0; i<players.size(); i++) {
			if(str.equals(players.get(i).getNome())) {
				return players.get(i);
			}
		}
		return null;
	}
	
	public static void aleatorio(Scanner scan) {
		System.out.println("Pesquisar Aleatoriamente: ");
		System.out.println("1. Filme");
		System.out.println("2. Série");
		System.out.println("3. Voltar");
		int aux = readInt(scan);
		
		Random rand = new Random();
		
		switch(aux) {
		case 1:
			if(aleatorioFilme(rand)!=null) {
				aleatorioFilme(rand).toString();
			} else {
				System.out.println("Não há nenhum Filme cadastrado");
			}
			break;
		case 2:
			if(aleatorioSerie(rand)!=null) {
				aleatorioSerie(rand).toString();
			} else {
				System.out.println("Não há nenhuma Série cadastrada");
			}
			break;
		}
	}
	
	public static Titulo aleatorioFilme(Random rand) {
		System.out.println("Pesquisar Filme Aleatório: ");
		
		if(titulos.get(rand.nextInt(titulos.size())) instanceof Filme) {
			return titulos.get(rand.nextInt(titulos.size()));
		}
		return null;
	}
	
	public static Titulo aleatorioSerie(Random rand) {
		System.out.println("Pesquisar Série Aleatória: ");
		
		if(titulos.get(rand.nextInt(titulos.size())) instanceof Serie) {
			return titulos.get(rand.nextInt(titulos.size()));
		}
		return null;
	}
	
	public static Pessoa cadastrarPessoa(Scanner scan) {
		Pessoa pessoa = new Pessoa();
		
		System.out.println("Por Favor, Digite o Nome da Pessoa: ");
		pessoa.setNome(scan.nextLine());
		
		return pessoa;
	}
	
	public static Player cadastrarPlayerPadrao() {
		Player player = new Player();
		return player;
	}
	
	public static Titulo cadastrarTituloPadrao() {
		Titulo titulo = new Titulo();
		titulo.popularListas();
		return titulo;
	}
	
	public static int readInt(Scanner scanner) {
        int num = scanner.nextInt();
        scanner.nextLine();
        return num;
    }
}