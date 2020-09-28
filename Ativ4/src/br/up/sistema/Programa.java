package br.up.sistema;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import br.up.dominio.Cardapio;
import br.up.dominio.Item;
import br.up.dominio.Pedido;

public class Programa {
	private static int opcao;

	public static void main(String[] args) throws IOException {

		inicio();

	}

	public static void inicio() throws IOException {

		System.out.println("\n1 - Listar itens cardápio\n");
		System.out.println("2 - Incluir itens cardápio\n");
		System.out.println("3 - Atualizar itens cardápio\n");
		System.out.println("4 - Excluir itens cardápio\n");
		System.out.println("5 - Realizar pedido\n");

		Scanner entrada = new Scanner(System.in);

		switch (entrada.nextInt()) {
		case 1:
			List<Item> listaItens = Cardapio.listar();
			for(Item item : listaItens)
			{
				System.out.println("Nome: " + item.getNome() + " Preço: - " + item.getPreco());
			}
			inicio();
			break;
		case 2:
			System.out.println("\nIncluir : 1 - Prato\n2 - Bebida\n3 - Vinho:");
			opcao = entrada.nextInt();
			Item novoItem = new Item();
			Cardapio.incluir(opcao, novoItem);
			inicio();
			break;
		case 3:
			System.out.println("\nAtualizar : 1 - Prato\n2 - Bebida\n3 - Vinho:");
			opcao = entrada.nextInt();
			entrada.nextLine();
			System.out.println("\nDigite todo ou parte do nome do item:\n");
			String nome = entrada.nextLine();
			//entrada.nextLine();
			System.out.println("\nDigite o valor atualizado do item:\n");
			String preco = entrada.nextLine();
			Item updateItem = new Item(nome,preco);
			Cardapio.atualizar(updateItem, opcao);
			inicio();
			break;
		case 4:
			System.out.println("\nExcluir : 1 - Prato\n2 - Bebida\n3 - Vinho:");
			opcao = entrada.nextInt();
			entrada.nextLine();
			System.out.println("\nDigite todo ou parte do nome do item:");
			Item exItem = Cardapio.buscarPorNome(entrada.nextLine(),opcao);
			Cardapio.excluir(exItem, opcao);
			inicio();
			break;
		case 5:
			Pedido.realizarPed();
			inicio();
			break;

		default:
			break;
		}

		entrada.close();

	}

}
