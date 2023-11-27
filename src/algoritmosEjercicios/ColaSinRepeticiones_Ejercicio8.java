package algoritmosEjercicios;

import imlementacionesAuxiliares.ColaEstatica;
import imlementacionesAuxiliares.ConjuntoEstatico;
import implementacionesEjercicios.ConjuntoMamushka_Ejercicio2;
import interfaces.ColaTDA;
import interfaces.ConjuntoMamushkaTDA;
import interfaces.ConjuntoTDA;

public class ColaSinRepeticiones_Ejercicio8 {
	
	/*
	 Se define un método que reciba una ColaTDA y devuelva una nueva ColaTDA 
	 con los elementos de la original, sin ninguna repetición. Se debe dejar 
	 el primer representante de cada uno de los repetidos, respetando el orden 
	 en que aparecen todos los elementos en la original.
	 */
	
	public static ColaTDA algoritmo(ColaTDA cola) {
		
		
		// ETAPA 1: inicializamos 1 cola auxiliar y una cola resultado para devolver.
		
		ColaTDA colAux = new ColaEstatica();
		colAux.inicializar();
		
		ColaTDA colaResultado = new ColaEstatica();
		colaResultado.inicializar();
		
		
		// ETAPA 2: copiamos la cola original a la cola auxiliar 
		
		
		while (!cola.estaVacia()) {
			colAux.acolar(cola.primero());
			cola.desacolar();
		}
		
		// ETAPA 3: agregamos al conjunto resultado solo aquellos que no hayan 
		// sido agregados antes. A su vez recuperamos la cola original. 
		
		while (!colAux.estaVacia()) {
			if (!seEncuentraYaAcolado(colaResultado, colAux.primero())) {
				colaResultado.acolar(colAux.primero());
			}
			cola.acolar(colAux.primero());
			colAux.desacolar();
		}
		
	
		return colaResultado;
	}
	
	
	private static boolean seEncuentraYaAcolado(ColaTDA cola, int valor) {
		
		boolean devolver =  false;
		
		ColaTDA colAux = new ColaEstatica();
		colAux.inicializar();
		
		while (!cola.estaVacia()) {
			if (valor == cola.primero()) {
				devolver = true;
			}
			colAux.acolar(cola.primero());
			cola.desacolar();
		}
		
		while (!colAux.estaVacia()) {
			cola.acolar(colAux.primero());
			colAux.desacolar();
		}
		
		return devolver;
		
	}
}
