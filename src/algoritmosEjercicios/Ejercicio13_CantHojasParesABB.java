package algoritmosEjercicios;

import interfaces.ABBTDA;

public class Ejercicio13_CantHojasParesABB {
	
	public static int algoritmo(ABBTDA abb) {
		
		/*
		 * Se define un método que calcule la cantidad de hojas
		 *  con un valor par de un ABB.
		 */
		
	    int suma = 0;
	
	    if (!abb.arbolVacio()) {
	        if (abb.raiz() % 2 == 0) {
	            suma += 1;
	        }
	        suma += algoritmo(abb.hijoIzq());
	        suma += algoritmo(abb.hijoDer());
	    }
	
	    return suma;
	}

}
