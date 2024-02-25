package testeo;

import algoritmosEjercicios.*;
import imlementacionesAuxiliares.ABB;
import interfaces.ABBTDA;

public class TesteoPunto13 {
	
	public static void main(String[] args) {
        
		ABBTDA abb = new ABB();
        abb.inicializarArbol();

        // Agregar elementos
        abb.agregarElem(10);
        abb.agregarElem(5);
        abb.agregarElem(15);
        abb.agregarElem(3);
        abb.agregarElem(8);
        abb.agregarElem(16);
        abb.agregarElem(18);

        System.out.println("La cantidad de elementos pares es: " + Ejercicio13_CantHojasParesABB.algoritmo(abb));
    }
	
}
