package imlementacionesAuxiliares;

import interfaces.ConjuntoTDA;
import interfaces.DiccionarioMultipleTDA;

public class DiccionarioMultipleEstatico implements DiccionarioMultipleTDA {
	

	class Elemento{
		int clave;
		int[] valores;
		int indiceValores;
	}
	
	private Elemento[] elementos;
	private int indiceClaves;
	
	public void inicializar() {
		elementos = new Elemento[100];
		indiceClaves = 0;
	}
	
	public void agregar(int clave, int valor) {
		int posicion = clave2Indice(clave);
		if (posicion == -1) { //la clave no existe
			elementos[indiceClaves] = new Elemento(); //nueva entrada
			elementos[indiceClaves].clave = clave;
			elementos[indiceClaves].valores = new int[100];
			elementos[indiceClaves].valores[0] = valor;
			elementos[indiceClaves].indiceValores = 1;
			indiceClaves++;
		} else {
			Elemento elemento = elementos[posicion];
			int posicionValor = valor2Indice(elemento, valor);
			if (posicionValor == -1) { //el valor no existe
				elemento.valores[elemento.indiceValores] = valor;
				elemento.indiceValores++;
			}
		}
	}
	
	public void eliminar(int clave) {
		int posicion = clave2Indice(clave);
		if (posicion != -1) { //la clave existe
			elementos[posicion] = elementos[indiceClaves - 1];
			indiceClaves--;
		}
	}
	
	public void eliminarValor(int clave, int valor) {
		int posicionConjunto = clave2Indice(clave);
		if (posicionConjunto != -1) { //la clave existe
			Elemento elemento = elementos[posicionConjunto];
			int posicionValores = valor2Indice(elemento, valor);
			if (posicionValores != -1) { //el valor existe
				elemento.valores[posicionValores] = elemento.valores[elemento.indiceValores - 1];
				elemento.indiceValores--;
				if (elemento.indiceValores == 0) { //verificaci�n final
					eliminar(clave); //se elimina la clave
				}
			}
		}
	}
	
	public ConjuntoTDA recuperar(int clave) {
		ConjuntoTDA conjunto = new ConjuntoEstatico();
		conjunto.inicializarConjunto();
		int posicion = clave2Indice(clave);
		if (posicion != -1) { //la clave existe
			Elemento elemento = elementos[posicion];
			for (int indice = 0; indice < elemento.indiceValores; indice++) {
				conjunto.agregar(elemento.valores[indice]);
			}
		}
		return conjunto;
	}
	
	public ConjuntoTDA claves() {
		ConjuntoTDA conjunto = new ConjuntoEstatico();
		conjunto.inicializarConjunto();
		for (int indice = 0; indice < indiceClaves; indice++) {
			conjunto.agregar(elementos[indice].clave);
		}
		return conjunto;
	}
	
	
	private int valor2Indice(Elemento elemento, int valor) {
		int indice = elemento.indiceValores - 1;
		while (indice >= 0 && elemento.valores[indice] != valor)
			indice--;
		return indice;
	}
	
	private int clave2Indice(int clave) {
		int indice = indiceClaves - 1;
		while (indice >= 0 && elementos[indice].clave != clave)
			indice--;
		return indice;
	}
	
}
