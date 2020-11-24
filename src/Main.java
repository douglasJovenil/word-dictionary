import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Lista minhaLista = new Lista();
		Scanner teclado = new Scanner(System.in);
		Menu meuMenu = new Menu();
		String opcao;
		String palavra;
		String sinonimo;
		char letra;

		minhaLista.setList();

		do {
			System.out.println("0 - Sair");
			System.out.println("1 - Mostrar dicionário");
			System.out.println("2 - Inserir palavra");
			System.out.println("3 - Buscar sinonimo");
			System.out.println("4 - Remover palavra");
			System.out.println("5 - Número de palavras de determinada letra");
			System.out.println("6 - Número total de palavras");
			System.out.println("7 - Exibe palavras de determinada letra");
			System.out.println("8 - Exibe palavras de determinada letra (preFixEsquerda)");
			System.out.println("9 - Exibe palavras de determinada letra (preFixDireita)");
			System.out.println("10 - Exibe palavras de determinada letra (posFixEsquerda)");
			System.out.println("11 - Exibe palavras de determinada letra (posFixDireita)");
			System.out.print("Informe sua opção: ");
			opcao = teclado.next();

			try {
				switch(opcao) {
					case "0":
						System.out.println("Saindo...");
						return;
					case "1":
						meuMenu.limpaTela();
						minhaLista.show();
						meuMenu.esperaTecla();
						break;
					case "2":
						System.out.print("Informe a palavra: ");
						palavra = teclado.next();
						System.out.print("Informe o sinonimo: ");
						sinonimo = teclado.next();
						minhaLista.insert(palavra, sinonimo, true);
						meuMenu.esperaTecla();
						break;
					case "3":
						System.out.println("Informe o sinonimo: ");
						sinonimo = teclado.next();
						minhaLista.pesquisaSinonimo(sinonimo);
						meuMenu.esperaTecla();
						break;
					case "4":
						System.out.print("Informe a palavra: ");
						palavra = teclado.next();
						minhaLista.remove(palavra);
						break;
					case "5":	
						System.out.print("Informe a letra: ");
						letra = teclado.next().charAt(0);
						System.out.println(minhaLista.contaPalavra(letra));
						meuMenu.esperaTecla();
						break;
					case "6":
						System.out.println(minhaLista.contaTodos());
						meuMenu.esperaTecla();
						break;
					case "7":
						System.out.print("Informe a letra: ");
						letra = teclado.next().charAt(0);
						minhaLista.centralLetra(letra);
						meuMenu.esperaTecla();
						break;
					case "8":
						System.out.println("Informe a letra: ");
						letra = teclado.next().charAt(0);
						minhaLista.prefixadoEsquerda(letra);
						meuMenu.esperaTecla();
						break;
					case "9":
						System.out.println("Informe a letra: ");
						letra = teclado.next().charAt(0);
						minhaLista.prefixadoDireita(letra);
						meuMenu.esperaTecla();
						break;
					case "10":
						System.out.println("Informe a letra: ");
						letra = teclado.next().charAt(0);
						minhaLista.posfixadoEsquerda(letra);
						meuMenu.esperaTecla();
						break;
					case "11":
						System.out.println("Informe a letra: ");
						letra = teclado.next().charAt(0);
						minhaLista.posfixadoDireita(letra);
						meuMenu.esperaTecla();
						break;
					default:
						System.out.println("Opção inválida!");
						break;
				}	
			} catch (NullPointerException e) {}
			
			meuMenu.limpaTela();
		} while(opcao != "0");
	}
}
