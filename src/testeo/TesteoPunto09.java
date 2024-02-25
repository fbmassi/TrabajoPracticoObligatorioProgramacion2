package testeo;
import algoritmosEjercicios.*;
import imlementacionesAuxiliares.*;
import interfaces.*;

public class TesteoPunto09 {

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
        
        ColaTDA cola = new ColaEstatica();
        cola.inicializar();

        // Agrega elementos a la cola
        cola.acolar(1);
        cola.acolar(2);
        cola.acolar(3);
        cola.acolar(4);
        cola.acolar(5);
        cola.acolar(6);
        cola.acolar(7);
        cola.acolar(8);
        cola.acolar(9);
        
        ConjuntoTDA resultado = Ejercicio09_ElementosComunesPilaYCola.algoritmo(pila, cola);
        
        while (!resultado.conjuntoVacio()) {
        	int imprimir = resultado.elegir();
        	System.out.println(imprimir);
        	resultado.sacar(imprimir);
        	
        }

	}

}
