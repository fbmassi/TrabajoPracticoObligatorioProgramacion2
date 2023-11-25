package imlementacionesAuxiliares;

import interfaces.ColaTDA;

public class ColaEstatica implements ColaTDA {

	private int[] cola;
	private int indice;
	
	@Override
	public void inicializar() { 									//Costo Constante
		cola = new int[100];										//C - Asignacion de variable
	} 																//C

	@Override
	public void acolar(int elemento) {								//Costo Constante
		cola[indice] = elemento; 									//C - Asignacion de variable
		indice++; 													//C - Operacion arimetica
	}																//C

	@Override
	public void desacolar() { 										//Costo Lineal
		for(int posicion=0;posicion<indice; posicion++) {
			cola[posicion] = cola[posicion+1];
		} 															//L - ciclo sobre arreglo. Depende de la cantidad de elementos
		indice--;													//C - operacion arimetica
	}																//L + C = L -> Tomamos el peor caso posible.

	@Override		
	public int primero() { 											//Costo Constante
		return cola[0]; 											//C Acceso directo a memoria
	} 																//C 

	@Override
	public boolean estaVacia() { 									//Costo Constasnte
		return indice == 0; 										//C - condicion booleana
	}

}
