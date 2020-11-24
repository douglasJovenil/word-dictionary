public class NodoArvore {
	private String palavra;
	private String sinonimo;
	private NodoArvore esquerda;
	private NodoArvore direita;
	private NodoArvore pai;

	public NodoArvore() {
		this.esquerda = null;
		this.direita = null;
		this.pai = null;
	}

	public String getPalavra() {
		return this.palavra;
	}

	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}

	public String getSinonimo() {
		return this.sinonimo;
	}

	public void setSinonimo(String sinonimo) {
		this.sinonimo = sinonimo;
	}

	public NodoArvore getEsquerda() {
		return this.esquerda;
	}

	public void setEsquerda(NodoArvore esquerda) {
		this.esquerda = esquerda;
	}

	public NodoArvore getDireita() {
		return this.direita;
	}

	public void setDireita(NodoArvore direita) {
		this.direita = direita;
	}

	public NodoArvore getPai() {
		return this.pai;
	}

	public void setPai(NodoArvore pai) {
		this.pai = pai;
	}
}
