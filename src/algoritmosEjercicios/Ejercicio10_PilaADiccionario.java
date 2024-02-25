package algoritmosEjercicios;

import imlementacionesAuxiliares.*;
import interfaces.*;

public class Ejercicio10_PilaADiccionario {
	
	/*
	 * Se define un método que reciba una PilaTDA y devuelva
	 * un DiccionarioSimpleTDA, en el cual se guardarán los 
	 * elementos de la pila como claves, y la cantidad de 
	 * apariciones de dicho elemento en la pila, como valores.
	 */
	
	public static DiccionarioSimpleTDA algoritmo(PilaTDA pila) {
		
		DiccionarioSimpleTDA diccionarioADevolver = new DiccionarioSimpleDinamico();
		diccionarioADevolver.inicializar();
		
		int[] elementos;
		int cantElementos = 0;
		
		PilaTDA pilAux = new PilaDinamica();
		pilAux.inicializar();
		
		while (!pila.estaVacia()) {
			pilAux.apilar(pila.tope());
			cantElementos++;
			pila.desapilar();
		}
		
		elementos = new int[cantElementos];
		
		for (int puntero = 0; puntero<cantElementos; puntero++) {
			pila.apilar(pilAux.tope());
			elementos[puntero] = pilAux.tope();
			pilAux.desapilar();
		}
		
		for (int elementoPila = 0; elementoPila < cantElementos; elementoPila++) {
			int elementoAContar = elementos[elementoPila];
			int cantApariciones = 0;
			for (int elementoAComparar = 0; elementoAComparar < cantElementos; elementoAComparar++) {
				if (elementoAContar == elementos[elementoAComparar]) {
					cantApariciones++;
				}
			}
			diccionarioADevolver.agregar(elementoAContar, cantApariciones);
		}
		
		
		return diccionarioADevolver;
		
	}
}
