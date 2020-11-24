public class Lista {
	private NodoLista inicio;
	private NodoLista fim;

	public Lista() {
		this.inicio = null;
		this.fim = null;
	}

	public void insert(char letra) {
		NodoLista novo = new NodoLista();
		novo.setLetra(letra);

		if (this.inicio == null) {
			this.inicio = novo;
			this.fim = novo;
		} else {
			this.fim.setBaixo(novo);
			this.fim = novo; 
		}
	}

	public void insert(String palavra, String sinonimo, boolean flagNull) {
		NodoLista auxLista = this.getNodoLista(palavra);


		if (auxLista.getArvore() == null) {
			Arvore arvore = new Arvore();
			arvore.insert(palavra, sinonimo);
			auxLista.setArvore(arvore);
			this.insert(sinonimo, palavra, false);
			return;
		} else if (auxLista.getArvore().pesquisa(palavra) == null) {
			auxLista.getArvore().insert(palavra, sinonimo);
			this.insert(sinonimo, palavra, true);
			return;
		} else if(auxLista.getArvore().pesquisa(sinonimo) == null && flagNull == true) {
			auxLista = this.getNodoLista(sinonimo);
			if (auxLista.getArvore() == null) {
				Arvore arvore = new Arvore();
				arvore.insert(sinonimo, palavra);
				auxLista.setArvore(arvore);
			} else if (auxLista.getArvore().pesquisa(sinonimo) == null) {
				auxLista.getArvore().insert(sinonimo, palavra);
			}
			
		}
	}

	public void remove(String palavra) {
		NodoLista auxLista = this.getNodoLista(palavra);
		String auxSinonimo = auxLista.getArvore().pesquisa(palavra).getSinonimo();
		auxLista.getArvore().remove(palavra);
		auxLista = this.getNodoLista(auxSinonimo);
		auxLista.getArvore().remove(auxSinonimo);
	}

	public int contaPalavra(char letra) {
		NodoLista auxLista = this.getNodoLista(letra);

		if (auxLista.getArvore() != null) {
			return auxLista.getArvore().contaPalavra();
		} else {
			return 0;
		}
		
	}

	public int contaTodos() {
		int retorno = 0;
		for (int i=97; i<=122; i++) {
			retorno += this.contaPalavra((char) i);
		}
		return retorno;
	}

	public void centralLetra(char letra) {
		NodoLista auxLista = this.getNodoLista(letra);
		
		if (auxLista.getArvore() != null) {
			auxLista.getArvore().central(true);
		}
	}

	public void prefixadoEsquerda(char letra) {
		NodoLista auxLista = this.getNodoLista(letra);
		auxLista.getArvore().prefixadoEsquerda();
	}

	public void prefixadoDireita(char letra) {
		NodoLista auxLista = this.getNodoLista(letra);
		auxLista.getArvore().prefixadoDireita();
	}

	public void posfixadoEsquerda(char letra) {
		NodoLista auxLista = this.getNodoLista(letra);
		auxLista.getArvore().posfixadoEsquerda();
	}

	public void posfixadoDireita(char letra) {
		NodoLista auxLista = this.getNodoLista(letra);
		auxLista.getArvore().posfixadoDireita();;
	}

	public void pesquisaSinonimo(String sinonimo) {
		NodoLista auxLista = this.getNodoLista(sinonimo);
		System.out.println();
		auxLista.getArvore().central(false);
	}

	private NodoArvore pesquisaPalavra(String palavra) {
		NodoLista auxLista = this.getNodoLista(palavra);
		return auxLista.getArvore().pesquisa(palavra);
	}

	private NodoLista getNodoLista(String palavra) {
		NodoLista aux = this.inicio;

		while(aux.getLetra() != palavra.charAt(0)) {
			aux = aux.getBaixo();
		}
		return aux;
	}

	private NodoLista getNodoLista(char letra) {
		NodoLista aux = this.inicio;

		while (aux.getLetra() != letra) {
			aux = aux.getBaixo();
		}

		return aux;
	}

	public void setList() {
		for (int i=97; i<=122; i++) {
			this.insert((char) i);
		}
	}

	public void show() {
		NodoLista aux = this.inicio;

		while (aux != null) {
			System.out.print(aux.getLetra() + " -> ");
			if (aux.getArvore() != null) {
				aux.getArvore().central(false);
			}
			System.out.println("");
			aux = aux.getBaixo();
		}
	}
}
