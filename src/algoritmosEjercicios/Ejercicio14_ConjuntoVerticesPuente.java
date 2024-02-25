package algoritmosEjercicios;

import imlementacionesAuxiliares.ConjuntoEstatico;
import interfaces.ConjuntoTDA;
import interfaces.GrafoTDA;

public class Ejercicio14_ConjuntoVerticesPuente {
	
	/*
	 Se define un método que reciba un GrafoTDA y dos enteros que representen vértices, 
	 y devuelva un ConjuntoTDA con todos los vértices puente entre los vértices recibidos
	 por parámetro. Se define que un vértice p es puente entre dos vértices o y d, si hay
	 una arista que comienza en o y termina en p y otra que comienza en p y termina en d.
	 */
	
	public static ConjuntoTDA algoritmo(GrafoTDA grafo, int verticeOrigen, int verticeDestino) {
	    
		// ETAPA 1: inicializamos el conjunto de vertices puente y guardamos el conjunto de 
		// vertices del grafo en una variable llamada nodosDelGrafo.
		
		ConjuntoTDA verticesPuentes = new ConjuntoEstatico(); // Reemplaza con la implementación real de ConjuntoTDA
		verticesPuentes.inicializarConjunto();
		
		ConjuntoTDA nodosDelGrafo = grafo.vertices();
		
		// ETAPA 2: recorremos el conjunto de nodos del grafo mediante un ciclo y agregamos
		// al conjunto de vertices puente aquellos nodos que tengan una arista que los 
		// conecte al vertice origen y al vertice destino.
		
		while (!nodosDelGrafo.conjuntoVacio()) {
			
			// Elegimos un vertice
			int verticeActual = nodosDelGrafo.elegir();
			 
			if (verticeActual != verticeOrigen && verticeActual != verticeDestino 
					&& grafo.existeArista(verticeOrigen, verticeActual) && grafo.existeArista(verticeActual, verticeDestino)) {
				 verticesPuentes.agregar(verticeActual);
			}
			// Sacamos el vertice
			nodosDelGrafo.sacar(verticeActual);
		}
		
		return verticesPuentes;
	}
}