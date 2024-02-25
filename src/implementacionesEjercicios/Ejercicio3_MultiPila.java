package implementacionesEjercicios;

import imlementacionesAuxiliares.PilaDinamica;
import interfaces.MultiPilaTDA;
import interfaces.PilaTDA;

public class Ejercicio3_MultiPila implements MultiPilaTDA{

	private class Nodo {
		int elemento;
		Nodo siguienteNodo;
	}

	private Nodo primerNodo;

	@Override
	public void apilar(PilaTDA valores) {
		
		PilaTDA pilAux = new PilaDinamica();
		pilAux.inicializar();
		
		 while (!valores.estaVacia()){
			pilAux.apilar(valores.tope());
			pilAux.desapilar();
		 }

		while (!pilAux.estaVacia()) {
			int valor = pilAux.tope();
			Nodo nuevoNodo = new Nodo();
			nuevoNodo.elemento = valor;
			nuevoNodo.siguienteNodo = primerNodo;
			primerNodo = nuevoNodo;
			valores.apilar(valor);
			pilAux.desapilar();
		}
		
	}

	@Override
	public void desapilar(PilaTDA valores) {
		
		PilaTDA pilAux = new PilaDinamica();
		pilAux.inicializar();

		int[] elementosPila;
		int contadorElementos = 0;

		while (!valores.estaVacia()){
			pilAux.apilar(valores.tope());
			pilAux.desapilar();
			contadorElementos++;
		}

		elementosPila = new int[contadorElementos];

		for (int posicion = 0; posicion < contadorElementos; posicion++) {
			int valor = valores.tope();
			valores.apilar(valor);
			elementosPila[posicion] = valor;
			pilAux.desapilar();
		}
		
		int coincidenciasTotales = contadorElementos;
		int coincide = 0;

		for (int posicion = contadorElementos - 1; posicion >= 0 ;posicion--) {
			int valor = valores.tope();
			if (elementosPila[posicion] == valor){
				coincide++;
			}
			pilAux.apilar(valor);
			valores.desapilar();
		}

		if (coincidenciasTotales == coincide) {
			while (!pilAux.estaVacia()) {
				int valor = pilAux.tope();
				primerNodo = primerNodo.siguienteNodo;
				valores.apilar(valor);
				pilAux.desapilar();
			}
		} else {
			while (!pilAux.estaVacia()) {
				valores.apilar(pilAux.tope());
				pilAux.desapilar();
			}
		}
	}

	@Override
	public PilaTDA tope(int cantidad) {
		
		PilaTDA pilaADevolver = new PilaDinamica();
		pilaADevolver.inicializar();

		PilaTDA pilAux = new PilaDinamica();
		pilAux.inicializar();

		for (int iteraciones = 0; iteraciones < cantidad || primerNodo.siguienteNodo == null; iteraciones++) {
			pilAux.apilar(primerNodo.elemento);
			primerNodo = primerNodo.siguienteNodo;
		}

		while (!pilAux.estaVacia()) {
			pilaADevolver.apilar(pilAux.tope());
			pilaADevolver.desapilar();
		}

		pilAux = pilaADevolver;

		this.apilar(pilAux);

		return pilaADevolver;
	}

	@Override
	public void inicializarPila() {
		primerNodo = null;
	}

	@Override
	public boolean pilaVacia() {
		// TODO Auto-generated method stub
		return primerNodo == null;
	}

}
