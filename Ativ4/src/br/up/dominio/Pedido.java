package br.up.dominio;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

import br.up.sistema.Programa;


public class Pedido {
	
	private static Item prato;
	private static Item bebida;
	private static Item vinho;
		
	private static char opcao;

	public static void realizarPed () throws IOException {
				
/*------------------------- PEDIDO VINHO --------------------------------------------------*/
		
		System.out.println("Deseja vinho? (S/N)");
		
		Scanner entrada = null;
		entrada = new Scanner(System.in);
		opcao = entrada.nextLine().charAt(0);
		
		if(opcao == 'S' || opcao == 's')
		{
			//Mostra os itens			
			List<Item> listaItens = Cardapio.listarVinhos();
			for(Item item : listaItens)
			{
				System.out.println("Nome: " + item.getNome() + " Preço: - " + item.getPreco());
			}
			
			System.out.println("Escreva o nome do Vinho:");
			String nomeVinho = entrada.nextLine();
						
			Item vinho = Cardapio.buscarPorNome(nomeVinho, 3);
			
			FileWriter novo_pedido = new FileWriter("C:\\Users\\Vilas Boas\\Desktop\\Trab Prog\\novo_pedido.txt");
			PrintWriter gravador = new PrintWriter(novo_pedido);		
			gravador.println("Vinho: " + vinho.getNome() + "  Preço: " + vinho.getPreco());
			gravador.close();
		
			System.out.println("\n \n ");
		}
		/*------------------------- PEDIDO BEBIDA --------------------------------------------------*/
		System.out.println("Deseja bebida? (S/N)");
		
		opcao = entrada.next().charAt(0);
		if(opcao == 'S' || opcao == 's')
		{
			//Mostra os itens			
			List<Item> listaItens = Cardapio.listarBebidas();
			for(Item item : listaItens)
			{
				System.out.println("Nome: " + item.getNome() + " Preço: - " + item.getPreco());
			}
			
			System.out.println("Escreva o nome da Bebida:");
			
			entrada.nextLine();
			String nomeBebida = entrada.nextLine();
						
			Item bebida = Cardapio.buscarPorNome(nomeBebida, 2);
			
			FileWriter novo_pedido = new FileWriter("C:\\Users\\Vilas Boas\\Desktop\\Trab Prog\\novo_pedido.txt", true);
			PrintWriter gravador = new PrintWriter(novo_pedido);		
			gravador.println("Bebida: " + bebida.getNome() + "  Preço: " + bebida.getPreco());
			gravador.close();
		
			System.out.println("\n \n ");
			
		}
		
		/*------------------------- PEDIDO PRATO --------------------------------------------------*/
		System.out.println("Deseja um prato? (S/N)");
		
		opcao = entrada.next().charAt(0);
		if(opcao == 'S' || opcao == 's')
		{
			//Mostra os itens			
			List<Item> listaItens = Cardapio.listarPratos();
			for(Item item : listaItens)
			{
				System.out.println("Nome: " + item.getNome() + " Preço: - " + item.getPreco());
			}
			
			System.out.println("Escreva o nome do Prato:");
			entrada.nextLine();
			
			String nomePrato = entrada.nextLine();
						
			Item prato = Cardapio.buscarPorNome(nomePrato, 1);
			
			FileWriter novo_pedido = new FileWriter("C:\\Users\\Vilas Boas\\Desktop\\Trab Prog\\novo_pedido.txt", true);
			PrintWriter gravador = new PrintWriter(novo_pedido);		
			gravador.println("Prato: " + prato.getNome() + "  Preço: " + prato.getPreco());
			gravador.close();
		
			System.out.println("\n \n ");
		}
		
		Programa.inicio();	
	}
}
			
		
	
	