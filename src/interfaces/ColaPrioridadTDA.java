package interfaces;

public interface ColaPrioridadTDA {

	void inicializar();
	void acolarPrioridad(int elemento, int prioridad);
	void desacolar();
	int primero();
	int prioridad();
	boolean colaVacia();
	
}
