package imlementacionesAuxiliares;

import interfaces.ConjuntoTDA;
import interfaces.DiccionarioSimpleTDA;

public class DiccionarioSimpleDinamico implements DiccionarioSimpleTDA {

	private class NodoClave { //la c�lula de la estructura de claves
		int clave; //la clave
		int valor; //el valor
		NodoClave sigClave; //la referencia a la siguiente clave
	}
	
	private NodoClave nodOrigen; //la referencia de la estructura
	
	public void inicializar() {
		nodOrigen = null;
	}
	
	public void agregar(int clave, int valor) {
		NodoClave nodoClave = Clave2NodoClave(clave);
		if (nodoClave == null) { //la clave no existe
			nodoClave = new NodoClave();
			nodoClave.clave = clave;
			nodoClave.sigClave = nodOrigen;
			nodOrigen = nodoClave; //nuevo origen
		}
		nodoClave.valor = valor;
	}
	
	private NodoClave Clave2NodoClave(int clave){
		NodoClave nodoAuxiliar = nodOrigen; //el nodo viajero
		while (nodoAuxiliar != null && nodoAuxiliar.clave != clave) {
			nodoAuxiliar = nodoAuxiliar.sigClave;
		}
		return nodoAuxiliar;
	}
	
	public void eliminar(int clave) {
		if (nodOrigen != null) {
			if (nodOrigen.clave == clave) { //es el primero
				nodOrigen = nodOrigen.sigClave;
			}
			else { //es alg�n otro
				NodoClave nodoAuxiliar = nodOrigen; //el nodo viajero
				while (nodoAuxiliar.sigClave != null && nodoAuxiliar.sigClave.clave != clave){
					nodoAuxiliar = nodoAuxiliar.sigClave;
				}
				if (nodoAuxiliar.sigClave != null) {
					nodoAuxiliar.sigClave = nodoAuxiliar.sigClave.sigClave;
				}
			}
		}
	}
	
	public int recuperar(int clave) {
		NodoClave nodoClave = Clave2NodoClave(clave);
		return nodoClave.valor;
	}
	
	public ConjuntoTDA claves() {
		ConjuntoTDA Conjunto = new ConjuntoEstatico();
		Conjunto.inicializarConjunto();
		NodoClave nodoAuxiliar = nodOrigen; //el nodo viajero
		while (nodoAuxiliar != null) {
			Conjunto.agregar(nodoAuxiliar.clave);
			nodoAuxiliar = nodoAuxiliar.sigClave;
		}
		return Conjunto;
	}

}
