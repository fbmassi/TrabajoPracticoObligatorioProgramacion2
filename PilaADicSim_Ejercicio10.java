package algoritmosEjercicios;

import imlementacionesAuxiliares.DiccionarioSimple;
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
      
        while (!pila.isEmpty()) { // Contar las apariciones de cada elemento en la pila
            int elemento = pila.tope();
            pila.desapilar();

            int apariciones = diccionario.recuperar(elemento); // Obtener la cantidad de apariciones actual del elemento en el diccionario

            diccionario.agregar(elemento, apariciones + 1); // Incrementar la cantidad de apariciones
        }
        
        while (!diccionario.claves().conjuntoVacio()) { // Restaurar la pila original
            int clave = diccionario.claves().elegir();
            int valor = diccionario.recuperar(clave);

            for (int i = 0; i < valor; i++) {
                pila.apilar(clave);
            }

            diccionario.eliminar(clave);
        }

        return diccionario;
    }

}
