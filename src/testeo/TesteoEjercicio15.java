package testeo;
import algoritmosEjercicios.GradoDeVertice_Ejercicio15;
import imlementacionesAuxiliares.Grafo;
import interfaces.GrafoTDA;

public class TesteoEjercicio15 {
	
	public static void main(String[] args) {
        // Crear una instancia de tu implementación de Grafo (asegúrate de tenerla)
        GrafoTDA grafo = new Grafo();
        grafo.inicializarGrafo();

        // Agregar nodos y aristas al grafo para crear un escenario de prueba
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);
        grafo.agregarVertice(5);

        grafo.agregarArista(1, 2, 7);
        grafo.agregarArista(2, 3, 6);
        grafo.agregarArista(2, 4, 3);
        grafo.agregarArista(2, 5, 4);

        // Llamar al método para calcular el grado de un vértice específico (por ejemplo, 2)
        int grado = GradoDeVertice_Ejercicio15.algoritmo(grafo, 2);

        // Imprimir el resultado
        System.out.println("El grado del vértice 2 es: " + grado);
    }
	
}
