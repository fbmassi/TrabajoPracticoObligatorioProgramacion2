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
	
	//RESUMEN DE LA IMPLEMENTACION:
	// En su mayoría es la misma implementacion que un Conjunto Estático, 
	// la principal diferencia radiga en los metodos guardar(int elemento)
	// y perteneceCant(int elemento).
	
	@Override
	public void inicializar() {
		conjuntoMamushka = new int[100];
		indice = 0;
	}

	@Override
	public void guardar(int dato) {
		// A diferencia de un conjunto normal, en este no es condicion 
		// que el elemento no se encuentre en el conjunto antes de 
		// agregarlo. Simplemente agrega el elemento. 
		conjuntoMamushka[indice] = dato;
		indice++;
	}

	@Override
	public void sacar(int dato) {
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
	public int elegir() {
		int max = indice - 1;
		int min = 0;
		int posicion = (int) (Math.random() * (max - min + 1) + min);
		return conjuntoMamushka[posicion];
	}

	@Override
	public int perteneceCant(int dato) {
		// En este caso, el arreglo se debe recorrer completamente y 
		// anotar en un contador las coincidencias con el elemento
		// que se busca. 
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
	public boolean estaVacio() {
		return indice == 0;
	}
	
	public void mostrarConjuntoMamushka() {
		for (int i = 0; i < indice; i++) {
			System.out.println(conjuntoMamushka[i]);
		}
	}

}
