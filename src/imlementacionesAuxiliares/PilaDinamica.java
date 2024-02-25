package imlementacionesAuxiliares;

import interfaces.PilaTDA;

public class PilaDinamica implements PilaTDA {

		private class Nodo { //la c�lula de la estructura
			int valor; //el valor almacenado
			Nodo siguienteNodo; //la referencia al siguiente nodo
		}
		
		private Nodo primerElemento; //la referencia a la estructura
		
		public void inicializar() {
			primerElemento = null;
		}
		
		public void apilar(int elemento) { //el nuevo elemento se agrega al inicio
			Nodo nuevo = new Nodo();
			nuevo.valor = elemento;
			nuevo.siguienteNodo = primerElemento;
			primerElemento = nuevo; //nueva referencia a la estructura
		}
		
		public void desapilar() {
			primerElemento = primerElemento.siguienteNodo; //nueva referencia a la estructura
		}
		
		public int tope() {
			return primerElemento.valor;
		}

		public boolean estaVacia() {
			return primerElemento == null;
		}
		
	}