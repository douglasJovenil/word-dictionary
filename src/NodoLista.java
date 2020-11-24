public class NodoLista {
	private Arvore arvore;
	private char letra;
	private NodoLista baixo;

	public NodoLista() {
		this.baixo = null;
	}

	public Arvore getArvore() {
		return this.arvore;
	}

	public void setArvore(Arvore arvore) {
		this.arvore = arvore;
	}

	public char getLetra() {
		return this.letra;
	}

	public void setLetra(char letra) {
		this.letra = letra;
	}	

	public NodoLista getBaixo() {
		return this.baixo;
	}

	public void setBaixo(NodoLista baixo) {
		this.baixo = baixo;
	}
}
