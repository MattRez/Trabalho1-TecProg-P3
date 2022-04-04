package br.edu.univas.vo;

public class Pessoa {
	
	private String nome = "Nome";
	
	@Override
	public String toString() {
		return nome;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}