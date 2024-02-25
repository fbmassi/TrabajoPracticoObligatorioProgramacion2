package testeo;
import interfaces.*;
import algoritmosEjercicios.*;
import imlementacionesAuxiliares.*;

public class TesteoPunto11 {
	public static void main(String[] args) {
        // Crear un diccionario múltiple y agregar algunos valores
        DiccionarioMultipleTDA diccionario = new DiccionarioMultipleEstatico();
        diccionario.inicializar();

        diccionario.agregar(1, 10);
        diccionario.agregar(1, 20);
        diccionario.agregar(2, 30);
        diccionario.agregar(2, 40);
        diccionario.agregar(3, 50);
        diccionario.agregar(6, 40);
        diccionario.agregar(7, 50);

        // Ejecutar el algoritmo
        ColaTDA resultado = Ejercicio11_DiccionarioMultipleACola.algoritmo(diccionario);

        // Mostrar los resultados
        System.out.println("Valores únicos en el diccionario:");
        while (!resultado.estaVacia()) {
            System.out.print(resultado.primero() + " ");
            resultado.desacolar();
        }
    }
}
