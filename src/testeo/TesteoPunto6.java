package testeo;
import interfaces.*;
import algoritmosEjercicios.PorcentajeDePares_Ejercicio6;
import imlementacionesAuxiliares.*;

public class TesteoPunto6 {

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
        float resultado = PorcentajeDePares_Ejercicio6.algoritmo(pila);;
        System.out.println("Porcentaje de elementos pares: " + resultado + "%");
    }

}
