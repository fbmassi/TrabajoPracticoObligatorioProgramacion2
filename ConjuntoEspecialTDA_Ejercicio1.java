package implementacionesEjercicios;

import interfaces.ConjuntoEspecialTDA;

public class ConjuntoEspecialTDA_Ejercicio1 implements ConjuntoEspecialTDA {

	/*
	 * ENUNCIADO
	 * Se define un nuevo TDA denominado ConjuntoEspecialTDA basado en ConjuntoTDA,
	 * con la particularidad de permitir determinar si las operaciones se realizan
	 * correctamente o no. Algunos de sus metodos devuelven el objeto Respuesta, que
	 * contiene dos elementos: un booleano que determina la correctitud de ejecucion
	 * y un entero que informa lo solicitado por el metodo en si, si el metodo lo requiere
	 * y su ejecucion fue satisfactoria
	 */
	/*
	 * Misma implementacion que ConjuntoTDA en inicializar(), pertenece() y esVacio().
	 * 
	 * AGREGAR() = creo una nueva respuesta. Si el valor que quiero agregar ya pertenece al conjunto,
	 * la respuesta dara error = true. Si el valor no pertenece al conjunto (primer ELSE), verifico
	 * que el conjunto no este lleno. Si no esta lleno, agrego el elemento en la ultima posicion, aumento
	 * el contador en 1 y la respuesta sera con error en false y con rta en el valor dado. Si el conjunto 
	 * se encuentra lleno, el error sera verdadero.
	 * 
	 * SACAR() = Creo una nueva respuesta y un indice para iterar (i). Bucle while = mientras el indice (i)
	 * sea menor al contador cantidad y el elemento en la posicion (i) no sea igual al valor a sacar aumento
	 * el indice en +1. Si lo encuentra elimino el valor pisandolo con cant[-1], la respuesta de error sera 
	 * false y la rta de respuesta sera el valor sacado. De lo contrario, si recorri todo el conjunto y no lo
	 * encontre, no se saca nada y error = true.
	 * 
	 * ELEGIR() = Chequeo si la esta vacio, por lo que no puedo elegir nada y error = true;
	 * Si no esta vacio, error =  false y rta = elementos[0] (primer valor)
	 */
	
	private int[] elementos;
	private int cant;
	
	@Override
	public void inicializarConjunto() {
		elementos = new int[100];
		cant = 0;
	}

	@Override
	public Respuesta agregar(int valor) {
		Respuesta respuesta = new Respuesta();
		if (this.pertenece(valor)) { //verifico que el valor no pertenezcca al conjunto
			respuesta.error = true; //pertenece asi que no lo agrego, por lo tanto error = true
		}else {
			if (cant < elementos.length) { //verifico que el conjunto no este lleno
				elementos[cant] = valor;
				cant++;
				respuesta.error = false; //no esta lleno, por lo que agrego el valor y error = false
				respuesta.rta = valor;
			} else {
				respuesta.error = true; //esta lleno, por lo cual no agrego y error = true
			}
		}
		return respuesta;
	}

	@Override
	public Respuesta sacar(int valor) {
		Respuesta respuesta = new Respuesta();
		int i = 0;
		while (i < cant && elementos[i] != valor) { //recorro el conjunto buscando el valor
			i++;
		}
		if (i < cant) { //si encuentro el valor
			elementos[i] = elementos[cant-1];
			cant--;
			respuesta.error = false; //elimino el valor, error = false y rta = valor
			respuesta.rta = valor;
		} else {
			respuesta.error = true; //no encontre el valor, error = true
		}
		return respuesta;
	}

	@Override
	public Respuesta elegir() {
		Respuesta respuesta = new Respuesta();	
		if (cant == 0) { //chequeo que no este vacio
			respuesta.error = true; //esta vacio, por lo tanto no puedo elegir nada y error = true
		}else {
			respuesta.error = false; //no esta vacio, por lo tanto error = false y rta = primer elemento
			respuesta.rta = elementos[0];
		}
		return respuesta;
	}

	@Override
	public boolean pertenece(int valor) {
		int i = 0;
		while (i < cant && elementos[i] != valor) {
			i++;
		}
		return (i < cant);
	}

	@Override
	public boolean conjuntoVacio() {
		return (cant == 0);
	}

}
