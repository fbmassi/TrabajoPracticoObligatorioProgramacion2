package interfaces;

public interface ColaTDA {
	
	public void inicializar(); //TODOS los TDA tienen que tener un método para inicializar.
	
	/* La cola debe estar inicializada. */
	public void acolar(int valor);
	
	/* No debe estar vacia. */
	public void desacolar();
	
	/* No debe estar vacia. */
	public int primero();
	
	/* La cola debe estar inicializada. */
	public boolean estaVacia();
	
}
