public class Arvore {
	private NodoArvore raiz;

	public Arvore() {
		this.raiz = null;
	}

	public void insert(String palavra, String sinonimo) {
		NodoArvore novo = new NodoArvore();
		novo.setPalavra(palavra);
		novo.setSinonimo(sinonimo);

		if (this.raiz == null) {
			this.raiz = novo;
		} else {
			this.insert(this.raiz, novo);
		}
	}

	private void insert(NodoArvore raiz, NodoArvore novo) {
		if (raiz != null) {
			if (novo.getPalavra().compareTo(raiz.getPalavra()) < 0) {
				if (raiz.getEsquerda() == null) {
					raiz.setEsquerda(novo);
					raiz.getEsquerda().setPai(raiz);
				} else {
					this.insert(raiz.getEsquerda(), novo);
				}
			} else {
				if (raiz.getDireita() == null) {
					raiz.setDireita(novo);
					raiz.getDireita().setPai(raiz);
				} else {
					this.insert(raiz.getDireita(), novo);
				}
			}
		}
	}

	public int contaPalavra() {
		return this.contaPalavra(this.raiz);
	}

	private int contaPalavra(NodoArvore raiz) {
		int retorno = 0;

		if (raiz == null) {
			return retorno;
		}

		retorno++;
		retorno += this.contaPalavra(raiz.getEsquerda());
		retorno += this.contaPalavra(raiz.getDireita());

		return retorno;
	}

	public NodoArvore pesquisa(String palavra) {
		return this.pesquisa(this.raiz, palavra);
	}

	private NodoArvore pesquisa(NodoArvore raiz, String palavra) {
		NodoArvore retorno = null;

		if (raiz != null) {
			if (raiz.getPalavra().equals(palavra)) {
				retorno = raiz;
			} else {
				if (palavra.compareTo(raiz.getPalavra()) < 0) {
					retorno = this.pesquisa(raiz.getEsquerda(), palavra);
				} else {
					retorno = this.pesquisa(raiz.getDireita(), palavra);
				}
			}
		}
		return retorno;
	}

	public void remove(String palavra) {
		NodoArvore nodo = this.pesquisa(palavra);

		if (nodo != null) {
			if (nodo.getEsquerda() == null && nodo.getDireita() == null) {
				this.removeFolha(nodo);
			} else {
				if (nodo.getEsquerda() != null && nodo.getDireita() != null) {
					this.removeDoisFilhos(nodo);
				} else {
					this.removeUmFilho(nodo);
				}
			}
		}
	}

	private void removeFolha(NodoArvore nodo) {
		NodoArvore pai = nodo.getPai();

		if (pai == null) {
			this.raiz = null;
		} else {
			if (pai.getEsquerda() == nodo) {
				pai.setEsquerda(null);
			} else {
				pai.setDireita(null);
			}
		}
	}

	private void removeUmFilho(NodoArvore nodo) {
		NodoArvore pai = nodo.getPai();

		if (pai == null) {
			if (nodo.getEsquerda() != null) {
				this.raiz = nodo.getEsquerda();
			} else {
				this.raiz = nodo.getDireita();
			}
			nodo.setPai(null);
		} else {
			if (nodo.getEsquerda() == null) {
				if (pai.getDireita() == nodo) {
					pai.setDireita(nodo.getDireita());
				} else {
					pai.setEsquerda(nodo.getDireita());
				}
				nodo.getDireita().setPai(pai);
			}else {
				if (pai.getEsquerda() == nodo) {
					pai.setEsquerda(nodo.getEsquerda());
				} else {
					pai.setDireita(nodo.getEsquerda());
				}
				nodo.getEsquerda().setPai(pai);
			}
		}
	}

	private void removeDoisFilhos(NodoArvore nodo) {
		NodoArvore aux = nodo.getEsquerda();
		NodoArvore pai = null;

		while (aux.getDireita() != null) {
			aux = aux.getDireita();
		}

		nodo.setPalavra(aux.getPalavra());
		nodo.setSinonimo(aux.getSinonimo());

		if (aux.getEsquerda() == null && aux.getDireita() == null) {
			this.removeFolha(aux);
		} else {
			this.removeUmFilho(aux);
		}
	}

	public void prefixadoEsquerda() {
		this.prefixadoEsquerda(this.raiz);
	}

	private void prefixadoEsquerda(NodoArvore raiz) {
		if(raiz == null) {
			return;
		}

		System.out.println(raiz.getPalavra());
		this.prefixadoEsquerda(raiz.getEsquerda());
		this.prefixadoEsquerda(raiz.getDireita());
	}

	public void prefixadoDireita() {
		this.prefixadoDireita(this.raiz);
	}

	private void prefixadoDireita(NodoArvore raiz) {
		if (raiz == null) {
			return;
		}

		System.out.println(raiz.getPalavra());
		this.prefixadoDireita(raiz.getDireita());
		this.prefixadoDireita(raiz.getEsquerda());
	}

	public void posfixadoEsquerda() {
		this.posfixadoEsquerda(this.raiz);
	}

	private void posfixadoEsquerda(NodoArvore raiz) {
		if (raiz == null) {
			return;
		}

		this.posfixadoEsquerda(raiz.getEsquerda());
		this.posfixadoEsquerda(raiz.getDireita());
		System.out.println(raiz.getPalavra());
	}

	public void posfixadoDireita() {
		this.posfixadoDireita(this.raiz);
	}

	private void posfixadoDireita(NodoArvore raiz) {
		if (raiz == null) {
			return;
		}

		this.posfixadoDireita(raiz.getDireita());
		this.posfixadoDireita(raiz.getEsquerda());
		System.out.println(raiz.getPalavra());
	}

	public void central(boolean palavra) {
		this.central(this.raiz, palavra);
	}

	private void central(NodoArvore raiz, boolean palavra) {
		if (raiz == null) {
			return;
		}

		this.central(raiz.getEsquerda(), palavra);

		if (palavra) {
			System.out.println(raiz.getPalavra());
		} else {
			if (raiz.getEsquerda() != null) {
				System.out.print(" | ");
			}
			System.out.print(raiz.getPalavra());
			System.out.print(" -> ");
			System.out.print(raiz.getSinonimo());
			if (raiz.getDireita() != null) {
				System.out.print(" | ");
			}
		}
		this.central(raiz.getDireita(), palavra);
	}

	public NodoArvore getRaiz() {
		return this.raiz;
	}
}
