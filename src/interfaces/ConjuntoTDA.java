package interfaces;

public interface ConjuntoTDA {
	
	void inicializarConjunto();
	void agregar(int x);
	boolean conjuntoVacio();
	boolean pertenece(int x);
	int elegir();
	void sacar(int x);
	
}

