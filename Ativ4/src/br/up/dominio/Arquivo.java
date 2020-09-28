package br.up.dominio;

public class Arquivo {
	
	private String diretorio;
	private String separador;
	private int posicaoNome;
	private int posicaoPreco;
	
	public Arquivo(String diretorio, String separador, int posicaoNome, int posicaoPreco) {
		super();
		this.diretorio = diretorio;
		this.separador = separador;
		this.posicaoNome = posicaoNome;
		this.posicaoPreco = posicaoPreco;
	}

	public String getDiretorio() {
		return diretorio;
	}

	public void setDiretorio(String nome) {
		this.diretorio = nome;
	}

	public String getSeparador() {
		return separador;
	}

	public void setSeparador(String separador) {
		this.separador = separador;
	}

	public int getPosicaoNome() {
		return posicaoNome;
	}

	public void setPosicaoNome(int posicaoNome) {
		this.posicaoNome = posicaoNome;
	}

	public int getPosicaoPreco() {
		return posicaoPreco;
	}

	public void setPosicaoPreco(int posicaoPreco) {
		this.posicaoPreco = posicaoPreco;
	}

}
