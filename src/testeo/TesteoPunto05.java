package testeo;
import implementacionesEjercicios.*;
import interfaces.*;

public class TesteoPunto05 {
	public static void main(String[] args) {
        DiccionarioSimpleTDA diccionario = new Ejercicio5_DiccionarioSimpleColaP();
        diccionario.inicializar();

        // Agregar elementos
        diccionario.agregar(1, 10);
        diccionario.agregar(2, 20);
        diccionario.agregar(3, 30);

        // Mostrar claves y valores
        ConjuntoTDA claves = diccionario.claves();
        while (!claves.conjuntoVacio()) {
        	int elemento = claves.elegir();
        	 System.out.println("Claves en el diccionario: " + elemento);
        	 claves.sacar(elemento);
        }
        System.out.println("Valor asociado a la clave 1: " + diccionario.recuperar(1));

        // Eliminar un elemento
        diccionario.eliminar(1);

        // Mostrar claves después de la eliminación
        claves = diccionario.claves();
        while (!claves.conjuntoVacio()) {
        	int elemento = claves.elegir();
        	 System.out.println("Claves en el diccionario: " + elemento);
        	 claves.sacar(elemento);
        }
    }
}
