package listas;

public class ListaSeq {
	private int dados[]; // Vetor que contém os dados da lista 
	private int tamAtual; 
	private int tamMax;
    
    public ListaSeq(){
    		tamMax = 100;
    		tamAtual = 0;
    		dados = new int[tamMax];
    }
    
    public ListaSeq(int n){
    		tamMax = n;
    		tamAtual = 0;
		dados = new int[tamMax];
    }

    /** Verifica se a Lista está vazia */
    public boolean vazia(){
		if (tamAtual == 0 )
			return true;
		else
			return false;
	}
	
    /**Verifica se a Lista está cheia */
    public boolean cheia(){
		if (tamAtual == tamMax)
			return true;
		else
			return false;
	}
	
    /**Obtém o tamanho da Lista*/
    public int tamanho(){
		return tamAtual;
	}
    
    /** Obtém o i-ésimo elemento de uma lista.
    		Retorna -1 se a posição for inválida. */
    public int elemento(int pos){
        int dado;
        
    		/* Se posição estiver fora dos limites <= 0 
         * ou > tamanho da lista */
        if ((pos > tamAtual) || (pos <= 0))
            return -1;

       dado = dados[pos-1];
       return dado;
	}

    /**	Retorna a posição de um elemento pesquisado.
    		Retorna -1 caso não seja encontrado */
	public int posicao (int dado){
	    /* Procura elemento a elemento, se o dado está na
	    		lista. Se estiver, retorna a sua posição no array+1 */
	    for (int i = 0; i < tamAtual; i++){
	        if (dados[i] == dado){
	            return (i + 1);
	        }
	    }

	    return -1;
	}
	/**Insere um elemento em uma determinada posição
    		Retorna false se a lista estiver cheia ou
    		a posição for inválida. Caso contrário retorna true */
	public boolean insere (int pos, int dado){
	    /* Verifica se a lista está cheia ou se a posicao a ser
	    inserida eh invalida (i.e., > tamanho da lista+1*/
	    if (cheia() || (pos > tamAtual+1) || (pos <=0)){
	        return false;
	    }

	    /* Desloca os elementos após pos, uma posicao a
	    direita. Isso serve para abrir espaço para insercao
	    do novo elemento */
	    for (int i = tamAtual; i >= pos; i--){
	 		 dados[i] = dados[i-1];
	    }

	    /* Insere o dado na posicao correta */
	    dados[pos - 1] = dado;

	 	/* Incrementa o numero de elementos na lista */
	    tamAtual++;
	    return true;
	}
	
	/**Remove um elemento de uma determinada posição
    Retorna o valor do elemento removido. -1 caso a remoção falhe  */
	public int remove(int pos){
	    int dado;
		/* Verifica se a posicao eh valida */
	    if ((pos > tamAtual) || (pos < 1 ))
			   return -1;

	    /* Armazena o dado a ser removido na var "dado" */
	    dado = dados[pos-1];

	    /* Desloca todos os elementos após 'pos', uma
	    posicao a esquerda */
	    for (int i = pos - 1; i < tamAtual - 1; i++){
	 		  dados[i] = dados[i+1];
		  }

	   /* Decrementa o numero de elementos na lista */
	    tamAtual--;
	    return dado;
	}
}
