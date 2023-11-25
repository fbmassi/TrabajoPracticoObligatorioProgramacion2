package imlementacionesAuxiliares;

import interfaces.ConjuntoTDA;

public class ConjuntoEstatico implements ConjuntoTDA {

	private int indice;
	private int[] conjunto;
	
	@Override
	public void inicializarConjunto() {
		conjunto = new int[100];
		indice = 0;
	}

	@Override
	public void agregar(int elemento) {
		if (!this.pertenece(elemento)) {
			conjunto[indice] = elemento;
			indice++;
		}
	}

	@Override
	public boolean conjuntoVacio() {
		return (indice == 0);
	}

	@Override
	public boolean pertenece(int elemento) {
		int posicion = 0;
		while (posicion < indice && conjunto[posicion] != elemento) {
			posicion++;
		}
		return (posicion < indice);
	}

	@Override
	public int elegir() {
		int max = indice - 1;
		int min = 0;
		int posicion = (int) (Math.random() * (max - min + 1) + min);
		return conjunto[posicion];
	}

	@Override
	public void sacar(int elemento) {
		int posicion = 0;
		while (posicion < indice && conjunto[posicion] != elemento) {
			posicion++;
		}
		if (posicion < indice) {
			conjunto[posicion] = conjunto[indice - 1];
			indice--;
		}
	}
}
