package implementacionesEjercicios;

import imlementacionesAuxiliares.ConjuntoEstatico;
import interfaces.ConjuntoTDA;
import interfaces.DiccionarioSimpleModTDA;

public class Ejercicio4_DiccionarioSimpleMod implements DiccionarioSimpleModTDA {
	
	
	private class Elemento {
		int clave;
		int valor;
		int factorMod;
	}
	private Elemento[] elementos;
	private int contador;
	
	/*
	 * Se define un nuevo TDA denominado DiccionarioSimpleModTDA basado en DiccionarioSimpleTDA, con la particularidad de
	 * registrar la cantidad de veces que el valor se ve modificado (entrada: clave-valor-factorMod). Su especificación se
	 * muestra en el anexo, leer detenidamente los comentarios de cada método.
	 */
	
	/*
	 * Funciones inicializar(), clave2Indice(), eliminar(), recuperar() y conjunto de claves siguen igual
	 * 
	 * ELEMENTO = se le agrega el factorMod al elemento
	 * 
	 * AGREGAR() = Misma funcion, simplemente se agregar el factorMod en 0 si la clave no existe, o se incrementa +1 si ya existe y se modifica
	 * 
	 * RECUPERARMOD() = Igual que la funcion recuperar original pero en vez de devolver el valor devuelve el numero de modificaciones
	 * 
	 */
	
	@Override
	public void inicializarDiccionario() {
		elementos = new Elemento[100];
		contador = 0;
	}

	@Override
	public void agregar(int clave, int valor) {
		if (!this.claves().pertenece(clave)) {
			Elemento elemento = new Elemento();
			elemento.clave = clave;
			elemento.valor = valor;
			elemento.factorMod = 0;
			elementos[contador] = elemento;
			contador++;
		} else {
			int posicion = 0;
			while (posicion < contador && elementos[posicion].clave != clave) {
				posicion++;
			}
			elementos[posicion].valor = valor;
			elementos[posicion].factorMod++;
		}
	}

	@Override
	public void eliminar(int clave) {
		if (this.claves().pertenece(clave)) {
			int posicion = 0;
			while (posicion < contador && elementos[posicion].clave != clave) {
				posicion++;
			}
			elementos[posicion] = elementos[contador];
			contador--;
		}
	}

	@Override
	public int recuperar(int clave) {
		int posicion = 0;
		while (posicion < contador && elementos[posicion].clave != clave) {
			posicion++;
		}
		return elementos[posicion].valor;
	}

	@Override
	public int recuperarMod(int clave) {
		int posicion = 0;
		while (posicion < contador && elementos[posicion].clave != clave) {
			posicion++;
		}
		return elementos[posicion].factorMod;
	}
	
	@Override
	public ConjuntoTDA claves() {
		ConjuntoEstatico claves = new ConjuntoEstatico();
		claves.inicializarConjunto();
		for (int elemento = 0; elemento < contador; elemento++) {
			claves.agregar(elementos[elemento].clave); 
		}
		return claves;
	}
}
