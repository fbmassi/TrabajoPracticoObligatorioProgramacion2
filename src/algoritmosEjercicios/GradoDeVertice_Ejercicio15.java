package algoritmosEjercicios;

import interfaces.ConjuntoTDA;
import interfaces.GrafoTDA;

public class GradoDeVertice_Ejercicio15 {
	
	/*
	 Se define un método que reciba un GrafoTDA y un entero que represente un vértice, 
	 y devuelva el grado del vértice recibido por parámetro. Se define el grado de un 
	 vértice v como el entero que es igual a la resta entre la cantidad de aristas que
	 salen de v menos la cantidad de aristas que llegan a v.
	 */
	
	public static int algoritmo(GrafoTDA grafo, int nodo) {
		
		// ETAPA 1: inicializamos las esrtucturas que vamos a usar. Usaremos 3 enteros
		// para calcular el grado del vertice. Un contador para las aristas que salen
		// del nodo, otro para las que llegan y el contador final.
		int grado_positivo = 0;
		int grado_negativo = 0;
		int grado_total;
		
		
		// ETAPA 2: inicializamos un conjuntoTDA para guardar el conjunto de todos los
		// nodos. Vamos vaciando y recorriendo el conjunto de nodos del grafo y sumamos 
		// 1 al contador grado_positivo si existe una arista que vaya desde el nodo 
		// el nodo pasado por parametro, hasta el seleccionado.
		ConjuntoTDA nodos = grafo.vertices();
		
		while (!nodos.conjuntoVacio()) {
			
			int nodo_aleatorio = nodos.elegir();
			
			if (nodo_aleatorio != nodo && grafo.existeArista(nodo, nodo_aleatorio)) {
				grado_positivo++;
			}
			
			nodos.sacar(nodo_aleatorio);
		}
		
		// ETAPA 3: mismo, pero con aristas entrantes.
		nodos = grafo.vertices();
		
		while (!nodos.conjuntoVacio()) {
			
			int nodo_aleatorio = nodos.elegir();
			
			if (nodo_aleatorio != nodo && grafo.existeArista(nodo_aleatorio, nodo)) {
				grado_negativo++;
			}
			
			nodos.sacar(nodo_aleatorio);
		}
		
		// ETAPA 4: calculamos el grado.
		grado_total = grado_positivo - grado_negativo;
		
		return grado_total;
		
	}
}
