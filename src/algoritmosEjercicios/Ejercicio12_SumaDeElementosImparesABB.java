package algoritmosEjercicios;

import interfaces.ABBTDA;

public class Ejercicio12_SumaDeElementosImparesABB {
	
	/*
	 Se define un método que calcule la suma de los elementos 
	 con un valor impar de un ABB.
	*/

	public static int algoritmo(ABBTDA abb) {
		
		// Simplemente se recorre el arbol con un algoritmo
		// PRE-ORDER y cada elememento lo suma a un contador
		// si el miemos es impar.
		
	    int suma = 0;

	    if (!abb.arbolVacio()) {
	        if (abb.raiz() % 2 != 0) {
	            suma += abb.raiz();
	        }
	        suma += algoritmo(abb.hijoIzq());
	        suma += algoritmo(abb.hijoDer());
	    }

	    return suma;
	}

}
