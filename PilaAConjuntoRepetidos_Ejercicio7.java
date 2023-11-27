package algoritmosEjercicios;

import imlementacionesAuxiliares.ConjuntoDin;
import interfaces.ConjuntoTDA;
import interfaces.PilaTDA;

public class PilaAConjuntoRepetidos_Ejercicio7 {

	/*
	 * Se define un método que reciba una PilaTDA y devuelva un ConjuntoTDA con los elementos repetidos de la pila.
	 */
	
	public static ConjuntoTDA elementosRepetidos(PilaTDA pila) {
        ConjuntoTDA conjuntoRepetidos = new ConjuntoDin();
        conjuntoRepetidos.inicializarConjunto();

        ConjuntoTDA conjuntoVistos = new ConjuntoDin();
        conjuntoVistos.inicializarConjunto();

        while (!pila.isEmpty()) {
            int elemento = pila.tope();
            pila.desapilar();

            if (conjuntoVistos.pertenece(elemento)) { // El elemento ya ha sido visto, se agrega al conjunto de repetidos
                conjuntoRepetidos.agregar(elemento);
            } else { // El elemento es nuevo, se agrega al conjunto de vistos
                conjuntoVistos.agregar(elemento);
            }
        }

        while (!conjuntoVistos.conjuntoVacio()) { // Restaurar la pila original
            pila.apilar(conjuntoVistos.elegir());
            conjuntoVistos.sacar(conjuntoVistos.elegir());
        }

        return conjuntoRepetidos;
	}
}
