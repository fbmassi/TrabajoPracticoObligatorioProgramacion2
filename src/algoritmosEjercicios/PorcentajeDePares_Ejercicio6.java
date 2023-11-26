package algoritmosEjercicios;

import imlementacionesAuxiliares.PilaEstatica;
import interfaces.PilaTDA;

public class PorcentajeDePares_Ejercicio6 {
	
	/*
	 Se define un método que reciba una PilaTDA y devuelva un float (número real) con el 
	 porcentaje de cantidad de elementos pares de la pila.
	 */
	
	public static float algoritmo(PilaTDA pila) {
		
		// ETAPA 1: declaramos todos los elementos que vamos a usar en ele algoritmo:
		//
		//			1) El valor a devolver 
		//			2) Un contador para la cantidad de elementos de la pila.
		//			3) Un contador para la cantidad de elementos pares de la pila.
		//			2) Una pila auxiliar.
		
		float devolver = 0;
		
	    int cant_elementos = 0;
	    int contador_pares = 0;

	    PilaTDA pilAux = new PilaEstatica();
	    pilAux.inicializar();

		// ETAPA 2: pasamos los valores de la pila a la pila auxiliar, mientras contamos
		// la cantidad de elementos que posee.
	    while (!pila.estaVacia()) {
	        cant_elementos++;
	        pilAux.apilar(pila.tope());
	        pila.desapilar();
	    }
	    
	    // ETAPA 3: pasamos los valores de la pila auxiliar a la orignal de nuevo, mientras
	 	// contamos la cantidad de elementos pares que posee.
	    while (!pilAux.estaVacia()) {
	        if (pilAux.tope() % 2 == 0) {
	            contador_pares++;
	        }
	        pila.apilar(pilAux.tope());
	        pilAux.desapilar();
	    }
	    
	    // ETAPA 4: calculamos el porcentaje de pares sobre el total (a excepcion de que la 
	 	// pila haya estado vacía.
	    if (cant_elementos != 0) {
	    	devolver = ((float) contador_pares / cant_elementos) * 100;
	    }
	    
	    return devolver;
	}
}
