package br.up.dominio;

import java.util.Scanner;

public class Item {
	
	private String nome;
	private double preco;
	
	private Scanner leitor = new Scanner(System.in);
	
	
	
	public Item() {
		
		System.out.println("\nDigite o nome do item:");
		nome = leitor.nextLine();
		System.out.println("\nDigite o preco do item:");
		preco = Double.parseDouble(leitor.nextLine());
	}

	public Item(String nome, double preco) {
		this.nome = nome;
		this.preco = preco;
	}

	public Item(String nome, String preco) {
		this.nome = nome;
		this.preco = Double.parseDouble(preco);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	@Override
	public String toString() {
		return nome + ";" + preco;
	}
	

}