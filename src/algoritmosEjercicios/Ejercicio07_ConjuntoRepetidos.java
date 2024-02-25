package algoritmosEjercicios;

import imlementacionesAuxiliares.*;
import interfaces.*;

public class Ejercicio07_ConjuntoRepetidos {
	
	/*
	 * Se define un método que reciba una PilaTDA y devuelva un ConjuntoTDA 
	 * con los elementos repetidos de la pila.
	 */
	
	public static ConjuntoTDA algoritmo(PilaTDA pila) {
		
		//Declaro las variables a usar.
		
		int[] elementosPila;
		int cantElementos = 0;
		int posicion = 0;
		
		ConjuntoEstatico conjuntoADevolver = new ConjuntoEstatico();
		conjuntoADevolver.inicializarConjunto();
		
		PilaEstatica pilAux = new PilaEstatica();
		pilAux.inicializar();
		
		while (!pila.estaVacia()) { //Vacío la pila en la pila auxiliar
			pilAux.apilar(pila.tope());
			pila.desapilar();
			cantElementos++; //Cuento la cantidad de elementos.
		}
		
		elementosPila = new int[cantElementos]; //Inicializo un arreglo con
		//la cantidad de elementos de la pila pasada por paramero
		
		while (!pilAux.estaVacia()){ //Agrego los elementos de la pila auxiliar al arreglo
			pila.apilar(pilAux.tope());//Recupero la estructura original. 
			elementosPila[posicion] = pilAux.tope();
			posicion++;
			pilAux.desapilar();
		}
		
		for (int i = 0; i < posicion; i++) { //Agrego al conjunto los elementos repetidos mas de una vez. 
			int elementoAContar = elementosPila[i];
			int cantVecesElemento = 0;
			for (int j = 0; j < posicion; j++) {
				if (elementoAContar == elementosPila[j]) {
					cantVecesElemento++;
				}
			}
			if (cantVecesElemento > 1) { //Al conjunto no se agregan elementos que ya pertenecen.
				conjuntoADevolver.agregar(elementoAContar);
			}
		}
		
		return conjuntoADevolver;
	}
}
