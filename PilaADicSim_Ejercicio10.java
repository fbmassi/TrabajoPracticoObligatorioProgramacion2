package algoritmosEjercicios;

import imlementacionesAuxiliares.DiccionarioSimple;
import imlementacionesAuxiliares.PilaEst;
import interfaces.DiccionarioSimpleTDA;
import interfaces.PilaTDA;

public class PilaADicSim_Ejercicio10 {
	/*
	 * Se define un método que reciba una PilaTDA y devuelva un DiccionarioSimpleTDA, en el cual se guardarán los elementos
	 * de la pila como claves, y la cantidad de apariciones de dicho elemento en la pila, como valores. 
	 */
	
	public static DiccionarioSimpleTDA contarApariciones(PilaTDA pila) {
        DiccionarioSimpleTDA diccionario = new DiccionarioSimple();

        diccionario.inicializar(); // Inicializar el diccionario
        
        PilaTDA pilaAux = new PilaEst();
        pilaAux.inicializarPila();
        
        PilaTDA pilaAux2 = new PilaEst();
        pilaAux2.inicializarPila();
        
        while (!pila.isEmpty()) { // Contar las apariciones de cada elemento en la pila
            int elemento = pila.tope();
            pilaAux.apilar(elemento);
            pila.desapilar();

            int apariciones = diccionario.recuperar(elemento); // Obtener la cantidad de apariciones actual del elemento en el diccionario

            diccionario.agregar(elemento, apariciones + 1); // Incrementar la cantidad de apariciones
        }
        
        
        while(!pilaAux.isEmpty()) {
        	pilaAux2.apilar(pilaAux.tope());
        	pilaAux.desapilar();
        }
        
        while(!pilaAux2.isEmpty()) {
        	pila.apilar(pilaAux2.tope());
        	pilaAux2.desapilar();
        }
        
        /*while (!diccionario.claves().conjuntoVacio()) { // Restaurar la pila original
            int clave = diccionario.claves().elegir();
            int valor = diccionario.recuperar(clave);

            for (int i = 0; i < valor; i++) {
                pila.apilar(clave);
            }

            diccionario.eliminar(clave);
        }*/

        return diccionario;
    }

}
