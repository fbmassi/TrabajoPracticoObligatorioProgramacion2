package testeo;

import imlementacionesAuxiliares.*;
import implementacionesEjercicios.*;
import interfaces.*;

public class TesteoPunto03 {

	public static void main(String[] args) {
		
		PilaTDA pila = new PilaEstatica();
        pila.inicializar();
        pila.apilar(1);
        pila.apilar(2);
        pila.apilar(3);
        pila.apilar(4);
        pila.apilar(5);
        pila.apilar(6);
        pila.apilar(7);
        
        MultiPilaTDA multiPila = new  Ejercicio3_MultiPila();
        multiPila.apilar(pila);
        
        PilaTDA pila2 = new PilaEstatica();
        pila2.inicializar();
        pila2.apilar(8);
        pila2.apilar(9);
        pila2.apilar(10);
        pila2.apilar(11);
        pila2.apilar(12);
        pila2.apilar(13);
        pila2.apilar(14);
        
        multiPila.apilar(pila2);
        
        PilaTDA pila3 = new PilaEstatica();
        pila3.inicializar();
        pila3.apilar(11);
        pila3.apilar(12);
        pila3.apilar(13);
        pila3.apilar(14);
        
        PilaTDA pilaResultado = multiPila.tope(7);
        
        while (!pilaResultado.estaVacia()) {
        	System.out.println(pilaResultado.tope());
        	pilaResultado.desapilar();
        }
        
        
        System.out.println("");
        
        
        multiPila.desapilar(pila3);
        
        PilaTDA pilaResultado2 = multiPila.tope(9);
        
        while (!pilaResultado2.estaVacia()) {
        	System.out.println(pilaResultado2.tope());
        	pilaResultado2.desapilar();
        }
	}

}
