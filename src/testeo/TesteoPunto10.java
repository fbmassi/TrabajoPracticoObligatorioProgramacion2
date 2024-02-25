package testeo;

import algoritmosEjercicios.Ejercicio10_PilaADiccionario;
import imlementacionesAuxiliares.*;
import interfaces.*;

public class TesteoPunto10 {

	public static void main(String[] args) {

		PilaTDA pila = new PilaEstatica();
        pila.inicializar();
		
        pila.apilar(1);
        pila.apilar(2);
        pila.apilar(2);
        pila.apilar(4);
        pila.apilar(1);
        pila.apilar(1);
        pila.apilar(4);
        
        DiccionarioSimpleTDA diccionario = Ejercicio10_PilaADiccionario.algoritmo(pila);
        ConjuntoTDA claves = diccionario.claves();
        
        while (!claves.conjuntoVacio()) {
        	int clave = claves.elegir();
        	System.out.println(clave + ": " + diccionario.recuperar(clave));
        	claves.sacar(clave);
        }
	}

}
