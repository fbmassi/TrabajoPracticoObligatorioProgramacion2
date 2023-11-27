package interfaces;

public interface ColaPrioridadTDA {

	void inicializar();
	void acolarPrioridad(int prioridad, int elemento);
	void desacolar();
	int primero();
	int prioridad();
	boolean colaVacia();
	
}
