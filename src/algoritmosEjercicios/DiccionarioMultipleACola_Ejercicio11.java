package algoritmosEjercicios;

import imlementacionesAuxiliares.*;
import implementacionesEjercicios.ConjuntoMamushka_Ejercicio2;
import interfaces.*;

public class DiccionarioMultipleACola_Ejercicio11 {
	
	/*
	 Se define un método que reciba un DiccionarioMultipleTDA 
	 y devuelva una ColaTDA con todos los valores del diccionario,
	 sin ninguna repetición.
	 */
	
	public static ColaTDA algoritmo(DiccionarioMultipleTDA diccionarioMult) {
		
		
		// ETAPA 1: inicializamos 1 cola auxiliar, una cola resultado 
		// para devolver y un ConjuntoMamushkaTDA, que reutilizamos del
		// ejercicio 2.
		
		ColaTDA colaResultado = new ColaEstatica();
		colaResultado.inicializar();
		
		ColaTDA colAux = new ColaEstatica();
		colAux.inicializar();
		
		ConjuntoMamushkaTDA conjuntoMamushka = new ConjuntoMamushka_Ejercicio2();
		
		
		// ETAPA 2: almacenamos en una variable el conjunto de claves del diccionario.
		
		ConjuntoTDA conjuntoClaves = diccionarioMult.claves();
		
		while (!conjuntoClaves.conjuntoVacio()) {
			
			// A través de un ciclo sobre este último, seleccionamos claves aleatoriamente
			// y creamos otra variable que almacene el conjunto de valores asociado a la
			// clave.
			
			int claveAleatoria = conjuntoClaves.elegir();
			ConjuntoTDA conjuntoValores = diccionarioMult.recuperar(claveAleatoria);
			
			while (!conjuntoValores.conjuntoVacio()) {
				
				// A través de otro ciclo, recorremos el conjunto de valores y, nuevamente, 
				// seleccionamos valores aleatoriamente. Agregamos dichos valores a la cola
				// auxiliar y al ConjuntoMamushkaTDA. Por ultimo, sacamos el valor del conjunto.
				
				int valorAleatorio = conjuntoValores.elegir();
				conjuntoMamushka.guardar(valorAleatorio);
				colAux.acolar(valorAleatorio);
				conjuntoValores.sacar(valorAleatorio);
			}
			
			//sacamos la clave asociada del conjunto de claves.
			conjuntoClaves.sacar(claveAleatoria);
		}
		
		
		// ETAPA 3: teniendo en cuanta que, tanto la cola auxiliar, como el ConjuntoMamushkaTDA, 
		// tienen los mismos elementos, solo acolaremos a la cola resultado los elementos que no
		// se repitan en el ConjuntoMamushkaTDA.
		
		while(!colAux.estaVacia()) {
			if (conjuntoMamushka.perteneceCant(colAux.primero()) == 1) {
				colaResultado.acolar(colAux.primero());
			}
			colAux.desacolar();
			
		}
		
		return colaResultado;
	}

}
