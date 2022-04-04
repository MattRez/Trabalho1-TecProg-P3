package br.edu.univas.vo;

public class Serie extends Titulo {
	
	private boolean completo;
	private int episodios;
	
	@Override
	public String toString() {
		System.out.println(
				"Completo = " + completo + 
				"Episódios = " + episodios);
		return super.toString();
	}
	
	
	public boolean isCompleto() {
		return completo;
	}
	public void setCompleto(boolean completo) {
		this.completo = completo;
	}
	public int getEpisodios() {
		return episodios;
	}
	public void setEpisodios(int episodios) {
		this.episodios = episodios;
	}
}