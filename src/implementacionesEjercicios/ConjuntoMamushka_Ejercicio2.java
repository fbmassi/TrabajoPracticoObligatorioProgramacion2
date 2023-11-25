package implementacionesEjercicios;

import interfaces.ConjuntoMamushkaTDA;

public class ConjuntoMamushka_Ejercicio2 implements ConjuntoMamushkaTDA {
	
	/*
	 Se define un nuevo TDA denominado ConjuntoMamushkaTDA basado en
	 ConjuntoTDA, con la particularidad de que se permite más de una
	 acepción de cada elemento agregado. Tal cual como en ConjuntoTDA,
	 no existe orden alguno. Su especificación se muestra en el anexo,
	 leer detenidamente los comentarios de cada método.
	 */
	
	private int indice;
	private int[] conjuntoMamushka;

	@Override
	public void inicializar() { //Costo CONSTANTE
		conjuntoMamushka = new int[100];
		indice = 0;
	}

	@Override
	public void guardar(int dato) { //Costo CONSTANTE
		conjuntoMamushka[indice] = dato;
		indice++;
	}

	@Override
	public void sacar(int dato) { //Costo LINEAL
		int posicion = 0;
		while (posicion < indice && conjuntoMamushka[posicion] != dato) {
			posicion++;
		}
		if (posicion < indice) {
			conjuntoMamushka[posicion] = conjuntoMamushka[indice - 1];
			indice--;
		}
	}

	@Override
	public int elegir() { //Costo CONSTANTE
		int max = indice - 1;
		int min = 0;
		int posicion = (int) (Math.random() * (max - min + 1) + min);
		return conjuntoMamushka[posicion];
	}

	@Override
	public int perteneceCant(int dato) { //Costo LINEAL
		int posicion = 0;
		int coincidencias = 0;
		while (posicion < indice) {
			if (conjuntoMamushka[posicion] == dato) {
				coincidencias++;
			}
			posicion++;
		}
		return coincidencias;
	}

	@Override
	public boolean estaVacio() { //Costo LINEAL
		return indice == 0;
	}
	
	public void mostrarConjuntoMamushka() {
		for (int i = 0; i < indice; i++) {
			System.out.println(conjuntoMamushka[i]);
		}
	}

}
