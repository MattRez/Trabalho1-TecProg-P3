package br.edu.univas.vo;

import java.util.ArrayList;

public class Titulo {
	
	private String nome = "Nome";
	private ArrayList<Pessoa> elenco = new ArrayList<>();
	private String descricao = "Descrição";
	private String genero = "Gênero";
	private Pessoa diretor = new Pessoa();
	private int classificacao = 0;
	private ArrayList<Player> players = new ArrayList<>();
	
	// 
	
	private int duracao = 0;
	
	@Override
	public String toString() {
		System.out.println(
				"Nome = " + nome + 
				"\nDuração (min) = " + duracao + 
				"\nElenco = " + elenco.toString() + 
				"\nDescrição = " + descricao + 
				"\nGenero = " + genero + 
				"\nDiretor = " + diretor.toString() + 
				"\nClassificação Indicativa = " + classificacao + 
				"\nPlataformas = " + players.toString());
		return super.toString();
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ArrayList<Pessoa> getElenco() {
		return elenco;
	}
	public void setElenco(ArrayList<Pessoa> elenco) {
		this.elenco = elenco;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Pessoa getDiretor() {
		return diretor;
	}
	public void setDiretor(Pessoa diretor) {
		this.diretor = diretor;
	}
	public int getClassificacao() {
		return classificacao;
	}
	public void setClassificacao(int classificacao) {
		this.classificacao = classificacao;
	}
	public ArrayList<Player> getPlayers() {
		return players;
	}
	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	public int getDuracao() {
		return duracao;
	}
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	
	public void popularListas() {
		Pessoa pessoa = new Pessoa();
		elenco.add(pessoa);
		
		Player player = new Player();
		players.add(player);
	}
}