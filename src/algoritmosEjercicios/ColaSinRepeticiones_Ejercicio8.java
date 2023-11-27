package algoritmosEjercicios;

import imlementacionesAuxiliares.*;
import interfaces.*;
import implementacionesEjercicios.*;

public class ColaSinRepeticiones_Ejercicio8 {
	
	/*
	 Se define un método que reciba una ColaTDA y devuelva una nueva ColaTDA 
	 con los elementos de la original, sin ninguna repetición. Se debe dejar 
	 el primer representante de cada uno de los repetidos, respetando el orden 
	 en que aparecen todos los elementos en la original.
	 */
	
	public static ColaTDA algoritmo(ColaTDA cola) {
		
		
		// ETAPA 1: inicializamos 2 colas auxiliares y una cola resultado para devolver.
		
		ColaTDA colAux1 = new ColaEstatica();
		colAux1.inicializar();
		
		ColaTDA colAux2 = new ColaEstatica();
		colAux2.inicializar();
		
		ColaTDA colaResultado = new ColaEstatica();
		colaResultado.inicializar();
		
		
		// ETAPA 2: copiamos la cola original a las colas auxiliares e inicializamos  
		// un ConjuntoMamushkaTDA, reciclado del punto 2. Este conjunto tiene la
		// particularidad de admitir más de un ingreso del mismo elemento y, además,
		// tiene un método con el que se puede contar la cantidad de veces que aparece
		// en la estructura.
		
		while (!cola.estaVacia()) {
			colAux1.acolar(cola.primero());
			colAux2.acolar(cola.primero());
			cola.desacolar();
		}
		
		ConjuntoMamushkaTDA conjuntoMamushka = new ConjuntoMamushka_Ejercicio2();
		conjuntoMamushka.inicializar();
		
		
		// ETAPA 3: agregamos todos los elementos de la primera cola auxiliar al 
		// ConjuntoMamushkaTDA, a la vez que la desacolamos. Posteriormente, vaciamos
		// vamos acolamos los elementos de la segunda cola auxiliar a la original para 
		// recuperar la estructura original. A su vez, desacolamos la cola auxiliar y 
		// acolamos los elementos en la cola resultado, si y solo si, los mismos NO se
		// repiten en el ConjuntoMamushkaTDA.
		
		while (!colAux1.estaVacia()) {
			conjuntoMamushka.guardar(colAux1.primero());
			colAux1.desacolar();
		}
		
		while (!colAux2.estaVacia()) {
			cola.acolar(colAux2.primero());
			if (conjuntoMamushka.perteneceCant(colAux2.primero()) == 1) {
				colaResultado.acolar(colAux2.primero());
			}
			colAux2.desacolar();
		}
		
		return colaResultado;
	}
}
