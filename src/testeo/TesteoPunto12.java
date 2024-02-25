package testeo;
import interfaces.*;
import algoritmosEjercicios.Ejercicio12_SumaDeElementosImparesABB;
import imlementacionesAuxiliares.*;

public class TesteoPunto12 {
	
	public static void main(String[] args) {
        ABBTDA abb = new ABB();
        abb.inicializarArbol();

        // Agregar elementos
        abb.agregarElem(10);
        abb.agregarElem(5);
        abb.agregarElem(15);
        abb.agregarElem(3);
        abb.agregarElem(8);
        abb.agregarElem(12);
        abb.agregarElem(18);

        System.out.println("La suma de elementos impares del ABB es: " + Ejercicio12_SumaDeElementosImparesABB.algoritmo(abb));
    }
	
}
