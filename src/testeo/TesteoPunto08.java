package testeo;
import interfaces.*;
import algoritmosEjercicios.*;
import imlementacionesAuxiliares.*;


public class TesteoPunto08 {
	
	public static void main(String[] args) {
        
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

        // Repite los elementos
        cola.acolar(1);
        cola.acolar(2);
        cola.acolar(3);
        // Puedes realizar operaciones con la cola generada...
        
        ColaTDA colaTest = Ejercicio08_ColaSinRepeticiones.algoritmo(cola);
        
        while (!colaTest.estaVacia()) {
        	System.out.println(colaTest.primero());
        	colaTest.desacolar();
        }
    }
    
}
