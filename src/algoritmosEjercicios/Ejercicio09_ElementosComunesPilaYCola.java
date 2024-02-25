package algoritmosEjercicios;

import imlementacionesAuxiliares.ConjuntoEstatico;
import imlementacionesAuxiliares.*;
import interfaces.*;

public class Ejercicio09_ElementosComunesPilaYCola {
	
	public static ConjuntoTDA algoritmo(PilaTDA pila, ColaTDA cola) {
		
		/*
		 * Se define un método que reciba una PilaTDA y una ColaTDA y
		 * devuelva un ConjuntoTDA con los elementos comunes de la pila
		 * y de la cola.
		 */
		
		//Declaro las variables a usar.
		ConjuntoEstatico conjuntoADevolver = new ConjuntoEstatico();
		conjuntoADevolver.inicializarConjunto();
		
		PilaEstatica pilAux = new PilaEstatica();
		pilAux.inicializar();
		int[] elementosPila;
		int contadorPila = 0;
		
		ColaEstatica colAux = new ColaEstatica();
		colAux.inicializar();
		int[] elementosCola;
		int contadorCola = 0;
		
		while (!pila.estaVacia()) { //Vacío la pila en la pila auxiliar
			pilAux.apilar(pila.tope());
			pila.desapilar();
			contadorPila++; //Cuento la cantidad de elementos.
		}
		
		elementosPila = new int[contadorPila]; //Inicializo un arreglo con
		//la cantidad de elementos de la pila pasada por paramero
		
		while (!cola.estaVacia()) { //Vacío la cola en la cola auxiliar
			colAux.acolar(cola.primero());
			cola.desacolar();
			contadorCola++; //Cuento la cantidad de elementos.
		}
		
		elementosCola = new int[contadorCola]; //Inicializo un arreglo con
		//la cantidad de elementos de la pila pasada por paramero
		
		for (int elementoPila = 0; elementoPila < contadorPila; elementoPila++) { //construyo el arreglo con los elementos de la pila
			pila.apilar(pilAux.tope());//Recupero la estructura original. 
			elementosPila[elementoPila] = pilAux.tope();//meto los elementos en el arreglo
			pilAux.desapilar();
		}
		
		for (int elementoCola = 0; elementoCola < contadorCola; elementoCola++) { //construyo el arreglo con los elementos de la cola
			cola.acolar(colAux.primero());//Recupero la estructura original. 
			elementosCola[elementoCola] = colAux.primero();//meto los elementos en el arreglo
			colAux.desacolar();
		}
		
		
		
		for (int elementoPila = 0; elementoPila < contadorPila; elementoPila++) { //Agrego al conjunto los elementos que se encuentran en ambos conjuntos. 
			int elementoAContar = elementosPila[elementoPila];
			int cantVecesElemento = 0;
			for (int elementoCola = 0; elementoCola < contadorCola; elementoCola++) {
				if (elementoAContar == elementosCola[elementoCola]) {
					cantVecesElemento++;
				}
			}
			if (cantVecesElemento >= 1) {
				conjuntoADevolver.agregar(elementoAContar);
			}
		}
		
		return conjuntoADevolver;
	}
	
}
