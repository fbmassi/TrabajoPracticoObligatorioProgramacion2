package algoritmosEjercicios;

import interfaces.ABBTDA;

public class ArbolHojasPares_Ejercicio13 {
	
	/*
	 Se define un método que calcule la suma de los elementos 
	 con un valor impar de un ABB.
	*/

	public static int algoritmo(ABBTDA abb) {
		
		// Simplemente se recorre el arbol con un algoritmo
		// PRE-ORDER y cada elememento lo suma a un contador
		// si el miemos es impar.
		
	    int contador = 0;

	    if (!abb.arbolVacio()) {
	        if (abb.raiz() % 2 == 0) {
	            contador++;
	        }
	        contador += algoritmo(abb.hijoIzq());
	        contador += algoritmo(abb.hijoDer());
	    }

	    return contador;
	}

}