package br.up.dominio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cardapio {
	
	private static List<Item> listaDePratos;
	private static List<Item> listaDeBebidas;
	private static List<Item> listaDeVinhos;
	
	private static Arquivo arquivoPratos = new Arquivo("C:\\_ws\\Ativ4\\arquivos\\pratos.csv",";",0,1);
	private static Arquivo arquivoBebidas = new Arquivo("C:\\_ws\\Ativ4\\arquivos\\bebidas-tabuladas2.txt","	",1,0);
	private static Arquivo arquivoVinhos = new Arquivo("C:\\_ws\\Ativ4\\arquivos\\vinhos-tabulados.txt","	",0,1);
	
	static {		
		listaDePratos = new ArrayList<Item>();
		listaDePratos = carregarLista(arquivoPratos);
		
		listaDeBebidas = new ArrayList<Item>();
		listaDeBebidas = carregarLista(arquivoBebidas);
		
		listaDeVinhos = new ArrayList<Item>();
		listaDeVinhos = carregarLista(arquivoVinhos);
	}

	private static List<Item> carregarLista(Arquivo arquivoCarregar) {
		
		List<Item> listaRetorno = new ArrayList<>();
		try {
			File arquivo = new File(arquivoCarregar.getDiretorio());
			Scanner leitor = new Scanner(new FileInputStream(arquivo));
			leitor.nextLine();
			
			
			while(leitor.hasNext()) {
				String linha = leitor.nextLine();
				String[] partes = linha.split(arquivoCarregar.getSeparador());
				Item item = new Item(partes[arquivoCarregar.getPosicaoNome()], partes[arquivoCarregar.getPosicaoPreco()]);
				listaRetorno.add(item);
				
			}
		} catch (FileNotFoundException e) {
			System.out.println("Ocorreu um erro na leitura do arquivo");
			//e.printStackTrace();
		}
		
		return listaRetorno;
	}

	public static List<Item> listarPratos() {
		return listaDePratos;
	}
	
	public static List<Item> listarBebidas() {
		return listaDeBebidas;
	}
	
	public static List<Item> listarVinhos() {
		return listaDeVinhos;
	}

	public static List<Item> listar() {
	
		List<Item> listaDeItens = new ArrayList<Item>();
		listaDeItens.addAll(listaDePratos);
		listaDeItens.addAll(listaDeBebidas);
		listaDeItens.addAll(listaDeVinhos);
		
		return listaDeItens;
	}

	public static void incluir(int opcao, Item item) {
		switch(opcao) {
		case 1:
			listaDePratos.add(item);
			incluirNoArquivo(item,arquivoPratos);
			break;
		case 2:
			listaDeBebidas.add(item);
			incluirNoArquivo(item,arquivoBebidas);
			break;
		case 3:
			listaDeVinhos.add(item);
			incluirNoArquivo(item,arquivoVinhos);
			break;
		}
			
	}

	private static void incluirNoArquivo(Item item, Arquivo arquivoGravar) {
		try {
			FileWriter arquivo = new FileWriter(arquivoGravar.getDiretorio(),true);
			PrintWriter gravador = new PrintWriter(arquivo);
			gravador.println(item.getNome() + arquivoGravar.getSeparador() + item.getPreco());
			gravador.close();
		} catch (IOException e) {
			System.out.println("Erro na gravação do arquivo!");
			e.printStackTrace();
		}
		
	}
	
	public static Item buscarPorNome(String query, int opcao) {
		Item itemRetornar = null;
		
		switch(opcao) {
		case 1:
			for (Item item : listaDePratos) {
				if (item.getNome().contains(query)) {
					itemRetornar = item;
					break;
				}
			}
			break;
		case 2:
			for (Item item : listaDeBebidas) {
				if (item.getNome().contains(query)) {
					System.out.println("\n\n achoo\n\n");
					itemRetornar = item;
					break;
				}
			}
			break;
		case 3:
			for (Item item : listaDeVinhos) {
				if (item.getNome().contains(query)) {
					System.out.println("\n\n achoo\n\n");
					itemRetornar = item;
					break;
				}
			}
		}	
				
		return itemRetornar;
	}
	
	private static void gravarListaAtualizada(List<Item> listaDeItem, Arquivo arquivoAtualizar) {		

		try {
			FileWriter arquivo = new FileWriter(arquivoAtualizar.getDiretorio());
			PrintWriter gravador = new PrintWriter(arquivo);
			for (Item item : listaDeItem) {
				gravador.println(item.getNome() + arquivoAtualizar.getSeparador() + item.getPreco());
			}
			gravador.close();
		} catch (IOException e) {
			System.out.println("Erro na gravação do arquivo!");
			e.printStackTrace();
		}
		
	}
	
	public static void excluir(Item item, int opcao) {
		
		switch(opcao) {
		case 1:
			listaDePratos.remove(item);
			gravarListaAtualizada(listaDePratos, arquivoPratos);
			break;
		case 2:
			listaDeBebidas.remove(item);
			gravarListaAtualizada(listaDeBebidas, arquivoBebidas);
			break;
		case 3:
			listaDeVinhos.remove(item);
			gravarListaAtualizada(listaDeVinhos, arquivoVinhos);
			break;
		}	
	}
	
	public static void atualizar(Item item, int opcao) {
		
		switch(opcao) {
		case 1:
			for (Item itemAtualizar : listaDePratos) {
				if (itemAtualizar.getNome().contentEquals(item.getNome())) {
					itemAtualizar.setNome(item.getNome());
					itemAtualizar.setPreco(item.getPreco());
					break;
				}
			}
			gravarListaAtualizada(listaDePratos, arquivoPratos);
			break;
			
			
		case 2:
			for (Item itemAtualizar : listaDeBebidas) {
				if (itemAtualizar.getNome().contentEquals(item.getNome())) {
					itemAtualizar.setNome(item.getNome());
					itemAtualizar.setPreco(item.getPreco());
					break;
				}
			}
			gravarListaAtualizada(listaDeBebidas, arquivoBebidas);
			break;
		case 3:
			for (Item itemAtualizar : listaDeVinhos) {
				if (itemAtualizar.getNome().contentEquals(item.getNome())) {
					//System.out.println("\n\n achouc");
					itemAtualizar.setNome(item.getNome());
					itemAtualizar.setPreco(item.getPreco());
					break;
				}
			}
			gravarListaAtualizada(listaDeVinhos, arquivoVinhos);
			break;
		}	
		
	}

}
