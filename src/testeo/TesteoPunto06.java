package testeo;
import interfaces.*;
import algoritmosEjercicios.Ejercicio06_PorcentajeDePares;
import imlementacionesAuxiliares.*;

public class TesteoPunto06 {

	public static void main(String[] args) {
        PilaTDA pila = new PilaEstatica();
        pila.inicializar();

        // Agregar algunos elementos a la pila
        pila.apilar(2);
        pila.apilar(1);
        pila.apilar(1);
        pila.apilar(3);
        pila.apilar(1);

        // Llamar al método algoritmo y mostrar el resultado
        float resultado = Ejercicio06_PorcentajeDePares.algoritmo(pila);;
        System.out.println("Porcentaje de elementos pares: " + resultado + "%");
    }

}
