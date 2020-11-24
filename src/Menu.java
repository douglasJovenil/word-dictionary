public class Menu {
	public void esperaTecla() {
		try {
			System.out.print("\nPressione qualquer tecla para continuar...");
			System.in.read();
		} catch (Exception e)  {}
	}

	public void limpaTela() {
		System.out.print("\033[H\033[2J");
	}
}
