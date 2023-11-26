package imlementacionesAuxiliares;

import interfaces.PilaTDA;

public class PilaEstatica implements PilaTDA {
	
	
	private int[] pila;
	private int cantidad; 

	@Override
	public void inicializar() {
		pila = new int[100];
		cantidad = 0;
	}

	@Override
	public void apilar(int valor) {
		pila[cantidad] = valor;
		cantidad++;
	}

	@Override
	public void desapilar() {
		cantidad--;
	}

	@Override
	public int tope() {
		return pila[cantidad - 1];
	}

	@Override
	public boolean estaVacia() {
		return cantidad == 0;
	}

}
