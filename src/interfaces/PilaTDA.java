package interfaces;

public interface PilaTDA {
	
	public void inicializar(); 								// Método - Algo que se puede hacer
															//Cuando declaramos un método en Java, siempre declaramos:
															//		Primero, si es publica o privada (En programacion II, casi siempre es publica)
															//		Segundo, el tipo de dato que devuelve
															//		Tercero, el nombre de la función y, entre paréntesis, los parametros que recibe (con sus tipos de dato).
														
														
															/*
															 * PRECONDICIONES PARA EL RESTO DE METODOS: para que estos métodos funcionen, la pila debe estar inicializada. 
															 */

	public void apilar(int valor);

	/*
	 * PRECONDICIONES PARA DESAPILAR Y TOPE DE PILA: la pila NO debe estar vacía. 
	 */

	public void desapilar();
	
	public int tope();
	
	public boolean estaVacia();
}
