package implementacionesEjercicios;

import interfaces.*;
import interfaces.DiccionarioSimpleTDA;
import imlementacionesAuxiliares.*;

public class Ejercicio5_DiccionarioSimpleColaP implements DiccionarioSimpleTDA {
	
	/*
	 Se busca implementar un DiccionarioSimpleTDA usando únicamente una
	 ColaPrioridadTDA. Aclaración: se mantiene la interfaz de DiccionarioSimpleTDA;
	 en la implementación en vez de utilizar un arreglo de enteros (estructura
	 estática) o una lista enlazada (estructura dinámica), sólo puede usarse una 
	 ColaPrioridadTDA.
	 */
	
	private ColaPrioridadTDA elementos;
	
	// En lugar de usar una arreglo, usamos una ColaPrioridadTDA. Podemos pensar a 
	// la prioridad de la ColaPrioridadTDA como la clave del DiccionarioSimpleTDA. 
	
	
	@Override
	public void inicializar() {
		elementos = new ColaPrioridadEstatica();
		elementos.inicializar();
	}

	@Override
	public void agregar(int clavePrioridad, int dato) {
		
		// ETAPA 1: se guarda el conjunto de claves en una variable.
		ConjuntoTDA conjuntoClaves = claves();
		
		// ETAPA 2: se evalua si la clave existe. 
		if (!conjuntoClaves.pertenece(clavePrioridad)) {
			// Si ese fuese el caso, se agrega a la estructura.
			elementos.acolarPrioridad(clavePrioridad, dato);
		} else {
			// Si ese fuese el caso, se elimina el par Clave-Valor con el método  
			// eliminar(int clavePrioridad) y se agrega el que se pasó por  parametro. 
			this.eliminar(clavePrioridad);
			elementos.acolarPrioridad(dato, clavePrioridad);
		}
	}

	@Override
	public void eliminar(int clavePrioridad) {
		
		// ETAPA 1: se inicializa una ColaPrioridadTDA auxiliar.
		ColaPrioridadTDA elementosAux = new ColaPrioridadEstatica();
		elementosAux.inicializar();
		
		// ETAPA 2: se vacía TODA la estructura de la clase en la estructura auxiliar.
		while (!elementos.colaVacia()) {
			elementosAux.acolarPrioridad(elementos.prioridad(), elementos.primero());
			elementos.desacolar();
		}
		
		// ETAPA 3: se evalua con un ciclo si la prioridad (clave) de cada elemento de la 
		// estructura coincide con la pasada por parametro. Si ese fuese el caso, se corta
		// el ciclo, se desacola el elemento sin acolarlo en la cola original y se continua
		// recuperando el resto de la estructura. 
		while (!elementosAux.colaVacia() && elementosAux.prioridad() != clavePrioridad) {
			elementos.acolarPrioridad(elementosAux.prioridad(), elementosAux.primero());
			elementosAux.desacolar();
		}
		
		if (!elementosAux.colaVacia() && elementosAux.prioridad() == clavePrioridad) {
			elementosAux.desacolar();
			while (!elementosAux.colaVacia()) {
				elementos.acolarPrioridad(elementosAux.prioridad(), elementosAux.primero());
				elementosAux.desacolar();
			}
		}
	}

	@Override
	public int recuperar(int clavePrioridad) {
		
		// ETAPA 1: se inicializa una ColaPrioridadTDA auxiliar y una variable de entero que
		// será el valor a devolver .
		int devolver = 0;
		ColaPrioridadTDA elementosAux = new ColaPrioridadEstatica();
		elementosAux.inicializar();
		
		// ETAPA 2: se vacía TODA la estructura de la clase en la estructura auxiliar.
		while (!elementos.colaVacia()) {
			elementosAux.acolarPrioridad(elementos.prioridad(), elementos.primero());
			elementos.desacolar();
		}
		
		// ETAPA 3: se evalua con un ciclo si la prioridad (clave) de cada elemento de la 
		// estructura coincide con la pasada por parametro. 
		// 
		// ¡IMPORTANTE! RECORDAR QUE UNA DE LAS PRECONDICIONES PARA RECUPERAR EL VALOR
		// ASOCIADO A UNA CLAVE, ES QUE ESTA EXISTA PREVIAMENTE.   
		// 				Si ese ultimo NO fuese el caso, el métoodo explota.
		// 
		//
		// Hasta encontrar la coincidencia y cortar el ciclo, se continua recuperando el 
		// resto de la estructura original.
		while (elementosAux.prioridad() != clavePrioridad) {
			elementos.acolarPrioridad(elementosAux.prioridad(), elementosAux.primero());
			elementosAux.desacolar();
		}
		
		// Una vez encontrada la coincidencia de claves, asigna el valor a la variable 'devolver'.
		devolver = elementosAux.primero();
		
		// Se recupera lo que reste de la estructura.
		while (!elementosAux.colaVacia()) {
			elementos.acolarPrioridad(elementosAux.prioridad(), elementosAux.primero());
			elementosAux.desacolar();
		}
		
		return devolver;
	}
	
	@Override
	public ConjuntoTDA claves() {
		
		// ETAPA 1: se inicializa una ColaPrioridadTDA auxiliar y un conjunto de claves para
		// devolver.
		ConjuntoTDA conjunto_claves = new ConjuntoEstatico();
		conjunto_claves.inicializarConjunto();
		
		ColaPrioridadTDA elementosAux = new ColaPrioridadEstatica();
		elementosAux.inicializar();
		
		// ETAPA 2: se vacía TODA la estructura de la clase en la ColaPrioridad auxiliar.
		// A la vez se agregan las prioridades (claves) al conjunto de claves. 
		while (!elementos.colaVacia()) {
			elementosAux.acolarPrioridad(elementos.primero(), elementos.prioridad());
			conjunto_claves.agregar(elementos.prioridad());
			elementos.desacolar();
		}
		
		// ETAPA 3: se recupera la estructura original.
		while (!elementosAux.colaVacia()) {
			elementos.acolarPrioridad(elementosAux.primero(), elementosAux.prioridad());
			elementosAux.desacolar();
		}
		
		return conjunto_claves;
	}

}
