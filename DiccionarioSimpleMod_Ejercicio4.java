package implementacionesEjercicios;

import imlementacionesAuxiliares.ConjuntoEstatico;
import interfaces.ConjuntoTDA;
import interfaces.DiccionarioSimpleModTDA;

public class DiccionarioSimpleMod_Ejercicio4 implements DiccionarioSimpleModTDA {

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
	
	private class Elemento {
		int clave;
		int valor;
		int factorMod;
	}
	private Elemento[] elementos;
	private int cant;
	
	@Override
	public void inicializarDiccionario() {
		cant = 0;
		elementos = new Elemento[100];
	}

	@Override
	public void agregar(int clave, int valor) {
		int pos = this.clave2Indice(clave);
		if (pos == -1) { 
			elementos[cant] = new Elemento();
			elementos[cant].clave = clave;
			elementos[cant].valor = valor;
			elementos[cant].factorMod = 0;
			cant++;
		} else {
			elementos[pos].valor = valor;
			elementos[pos].factorMod++;
		}
	}
	
	private int clave2Indice(int clave) {
		int i = cant - 1;
		while (i >= 0 && elementos[i].clave != clave)
			i--;
		return i;
	}


	@Override
	public void eliminar(int clave) {
		int pos = clave2Indice(clave);
		if (pos != -1) { //la clave existe
			elementos[pos] = elementos[cant-1];
			cant --;
		}
	}

	@Override
	public int recuperar(int clave) {
		int pos = clave2Indice(clave);
		return elementos[pos].valor;
	}

	@Override
	public int recuperarMod(int clave) {
		int pos = clave2Indice(clave);
        return elementos[pos].factorMod;
	}

	@Override
	public ConjuntoTDA claves() {
		ConjuntoTDA c = new ConjuntoEstatico();
		c.inicializarConjunto();
		for (int i=0; i < cant; i++) {
			c.agregar(elementos[i].clave);
		}
		return c;
	}

}
