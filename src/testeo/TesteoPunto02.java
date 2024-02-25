package testeo;
import implementacionesEjercicios.*;
import interfaces.*;

public class TesteoPunto02 {

	public static void main(String[] args) {

		ConjuntoMamushkaTDA conjuntoMamushka = new Ejercicio2_ConjuntoMamushka();
		conjuntoMamushka.inicializar();
		
		System.out.println("AGREGAMOS ELEMENTOS AL CONJUNTO MAMUSHKA: ");
		for (int i = 0; i < 10; i++) {
			conjuntoMamushka.guardar(i);
		}
		conjuntoMamushka.guardar(1);
		conjuntoMamushka.guardar(5);
		conjuntoMamushka.guardar(1);
		conjuntoMamushka.guardar(6);
		conjuntoMamushka.guardar(1);
		conjuntoMamushka.guardar(9);
		conjuntoMamushka.guardar(3);
		conjuntoMamushka.guardar(7);
		conjuntoMamushka.guardar(1);
		conjuntoMamushka.guardar(5);
		((Ejercicio2_ConjuntoMamushka) conjuntoMamushka).mostrarConjuntoMamushka();
		
		
		System.out.println("\n");
		System.out.println("CONTAMOS LA CANTIDAD DE VECES QUE APARECE UN NUMERO EN EL CONJUNTO MAMUSHKA: ");
		System.out.println("El numero '1' se encuentra " + conjuntoMamushka.perteneceCant(1) + " veces en el conjunto.");
		System.out.println("El numero '6' se encuentra " + conjuntoMamushka.perteneceCant(6) + " veces en el conjunto.");
		System.out.println("El numero '0' se encuentra " + conjuntoMamushka.perteneceCant(0) + " veces en el conjunto.");
		System.out.println("El numero '5' se encuentra " + conjuntoMamushka.perteneceCant(5) + " veces en el conjunto.");
		

		System.out.println("\n");
		System.out.println("SACAMOS ELEMENTOS AL CONJUNTO MAMUSHKA. ");
		conjuntoMamushka.sacar(1);
		conjuntoMamushka.sacar(0);
		conjuntoMamushka.sacar(5);
		conjuntoMamushka.sacar(1);
		conjuntoMamushka.sacar(1);
		
		System.out.println("\n");
		System.out.println("CONTAMOS LA CANTIDAD DE VECES QUE APARECE UN NUMERO EN EL CONJUNTO MAMUSHKA: ");
		System.out.println("El numero '1' se encuentra " + conjuntoMamushka.perteneceCant(1) + " veces en el conjunto.");
		System.out.println("El numero '6' se encuentra " + conjuntoMamushka.perteneceCant(6) + " veces en el conjunto.");
		System.out.println("El numero '0' se encuentra " + conjuntoMamushka.perteneceCant(0) + " veces en el conjunto.");
		System.out.println("El numero '5' se encuentra " + conjuntoMamushka.perteneceCant(5) + " veces en el conjunto.");
		
	}
}
