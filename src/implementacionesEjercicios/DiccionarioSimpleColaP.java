package implementacionesEjercicios;

import interfaces.*;
import interfaces.DiccionarioSimpleTDA;
import imlementacionesAuxiliares.*;

public class DiccionarioSimpleColaP implements DiccionarioSimpleTDA {
	
	private ColaPrioridadTDA elementos;

	@Override
	public void inicializar() {
		elementos = new ColaPrioridadEstatica();
		elementos.inicializar();
	}

	@Override
	public void agregar(int clavePrioridad, int dato) {
		
		ConjuntoTDA conjuntoClaves = claves();
		if (!conjuntoClaves.pertenece(clavePrioridad)) {
			elementos.acolarPrioridad(clavePrioridad, dato);
		} else {
			this.eliminar(clavePrioridad);
			elementos.acolarPrioridad(clavePrioridad, dato);
		}
	}

	@Override
	public void eliminar(int clavePrioridad) {
		
		ColaPrioridadTDA elementosAux = new ColaPrioridadEstatica();
		elementosAux.inicializar();
		
		while (!elementos.colaVacia()) {
			elementosAux.acolarPrioridad(elementos.primero(), elementos.prioridad());
			elementos.desacolar();
		}
		
		while (!elementosAux.colaVacia() && elementosAux.prioridad() != clavePrioridad) {
			elementos.acolarPrioridad(elementosAux.primero(), elementosAux.prioridad());
			elementosAux.desacolar();
		}
		
		if (!elementosAux.colaVacia() && elementosAux.prioridad() == clavePrioridad) {
			elementosAux.desacolar();
			while (!elementosAux.colaVacia()) {
				elementos.acolarPrioridad(elementosAux.primero(), elementosAux.prioridad());
				elementosAux.desacolar();
			}
		}
		
	}

	@Override
	public int recuperar(int clavePrioridad) {
		
		int devolver = 0;
		ColaPrioridadTDA elementosAux = new ColaPrioridadEstatica();
		elementosAux.inicializar();
		
		while (!elementos.colaVacia()) {
			elementosAux.acolarPrioridad(elementos.primero(), elementos.prioridad());
			elementos.desacolar();
		}
		
		while (elementosAux.prioridad() != clavePrioridad) {
			elementos.acolarPrioridad(elementosAux.primero(), elementosAux.prioridad());
			elementosAux.desacolar();
		}
		
		devolver = elementosAux.primero();
		
		while (!elementosAux.colaVacia()) {
			elementos.acolarPrioridad(elementosAux.primero(), elementosAux.prioridad());
			elementosAux.desacolar();
		}
		
		return devolver;
	}
	
	@Override
	public ConjuntoTDA claves() {
		
		ConjuntoTDA conjunto_claves = new ConjuntoEstatico();
		conjunto_claves.inicializarConjunto();
		
		ColaPrioridadTDA elementosAux = new ColaPrioridadEstatica();
		elementosAux.inicializar();
		
		while (!elementos.colaVacia()) {
			elementosAux.acolarPrioridad(elementos.primero(), elementos.prioridad());
			conjunto_claves.agregar(elementos.prioridad());
			elementos.desacolar();
		}
		
		while (!elementosAux.colaVacia()) {
			elementos.acolarPrioridad(elementosAux.primero(), elementosAux.prioridad());
			elementosAux.desacolar();
		}
		
		return conjunto_claves;
	}

}
