package br.edu.univas.vo;

public class Player {
	
	private String nome = "Nome";
	private String site = "Site";
	
	@Override
	public String toString() {
		return nome + " - " + site;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
}