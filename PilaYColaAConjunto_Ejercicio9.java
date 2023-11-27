package algoritmosEjercicios;

import imlementacionesAuxiliares.ConjuntoDin;
import interfaces.ColaTDA;
import interfaces.ConjuntoTDA;
import interfaces.PilaTDA;

public class PilaYColaAConjunto_Ejercicio9 {
	/*
	 * Se define un método que reciba una PilaTDA y una ColaTDA y devuelva un ConjuntoTDA con los elementos comunes de la pila y de la cola.
	 */
	
	public static ConjuntoTDA elementosComunes(PilaTDA pila, ColaTDA cola) {
        ConjuntoTDA conjuntoComunes = new ConjuntoDin();
        conjuntoComunes.inicializarConjunto();

        ConjuntoTDA conjuntoPila = new ConjuntoDin();
        conjuntoPila.inicializarConjunto();

        while (!pila.isEmpty()) { // Agregar elementos de la pila al conjunto de la pila
            int elemento = pila.tope();
            conjuntoPila.agregar(elemento);
            pila.desapilar();
        }

        while (!cola.estaVacia()) { // Verificar elementos comunes con la cola y agregarlos al conjunto de comunes
            int elemento = cola.primero();
            cola.desacolar();

            if (conjuntoPila.pertenece(elemento)) {
                conjuntoComunes.agregar(elemento);
            }
        }

        while (!conjuntoPila.conjuntoVacio()) { // Restaurar la pila original
            pila.apilar(conjuntoPila.elegir());
            conjuntoPila.sacar(conjuntoPila.elegir());
        }

        return conjuntoComunes;
    }

}
