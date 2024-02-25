package testeo;

import algoritmosEjercicios.*;
import imlementacionesAuxiliares.*;
import interfaces.*;

public class TesteoPunto07 {
	
	public static void main(String[] args) {
        
		PilaTDA pila = new PilaEstatica();
        pila.inicializar();

        // Agregar algunos elementos a la pila
        pila.apilar(2);
        pila.apilar(1);
        pila.apilar(7);
        pila.apilar(3);
        pila.apilar(3);
        pila.apilar(1);
        pila.apilar(4);
        pila.apilar(4);
        pila.apilar(5);
        pila.apilar(6);
        pila.apilar(6);

        ConjuntoTDA resultado = Ejercicio07_ConjuntoRepetidos.algoritmo(pila);
        
        while (!resultado.conjuntoVacio()) {
        	int imprimir = resultado.elegir();
        	System.out.println(imprimir);
        	resultado.sacar(imprimir);
        	
        }
    }
	
}
