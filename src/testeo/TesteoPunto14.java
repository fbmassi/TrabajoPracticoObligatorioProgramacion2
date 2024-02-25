package testeo;
import interfaces.*;
import algoritmosEjercicios.Ejercicio14_ConjuntoVerticesPuente;
import imlementacionesAuxiliares.*;

public class TesteoPunto14 {
    public static void main(String[] args) {
        GrafoTDA grafo = new Grafo(); // Reemplaza con la implementación real de GrafoTDA
        ConjuntoTDA verticesPuentes;

        // Agrega algunos vértices y aristas al grafo
        grafo.inicializarGrafo();
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);
        grafo.agregarVertice(5);
        grafo.agregarArista(1, 2, 1);
        grafo.agregarArista(2, 3, 2);
        grafo.agregarArista(1, 4, 1);
        grafo.agregarArista(4, 3, 2);
        grafo.agregarArista(1, 5, 1);
        grafo.agregarArista(5, 3, 2);

        // Vertices de ejemplo
        int verticeOrigen = 1;
        int verticeDestino = 3;

        // Ejecuta el algoritmo
        verticesPuentes = Ejercicio14_ConjuntoVerticesPuente.algoritmo(grafo, verticeOrigen, verticeDestino);

        // Imprime el resultado
        System.out.println("Vértices puente entre " + verticeOrigen + " y " + verticeDestino + ": ");
        while (!verticesPuentes.conjuntoVacio()) {
            int verticePuente = verticesPuentes.elegir();
            System.out.println(verticePuente);
            verticesPuentes.sacar(verticePuente);
        }
    }
}
