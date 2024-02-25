package implementacionesEjercicios;

public class Ejercicio1_ConjuntoEspecial implements interfaces.ConjuntoEspecialTDA {
	
	/*
	 * Se define un nuevo TDA denominado ConjuntoEspecialTDA basado en ConjuntoTDA,
	 * con la particularidad de permitir determinar si las operaciones se realizan
	 * correctamente o no. Algunos de sus metodos devuelven el objeto Respuesta, que
	 * contiene dos elementos: un booleano que determina la correctitud de ejecucion
	 * y un entero que informa lo solicitado por el metodo en si, si el metodo lo requiere
	 * y su ejecucion fue satisfactoria
	 */
	
	private int[] arreglo;
	private int contador;
	
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
	
	@Override
	public void inicializarConjunto() {
		arreglo = new int[100];
		contador = 0;
	}

	@Override
	public Respuesta agregar(int valor) {
		Respuesta respuesta = new Respuesta();
		if (pertenece(valor)) {
			respuesta.error = true;
		} else {
			if (contador < arreglo.length) { //verifico que el conjunto no este lleno
				arreglo[contador] = valor;
				contador++;
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
		respuesta.error = true;
		int elemento = 0;
		while (elemento < contador && valor != arreglo[elemento]) { //recorro el conjunto buscando el valor
			elemento++;
		}
		if (valor == arreglo[elemento]) { //si encuentro el valor
			respuesta.error = false;
			respuesta.rta = valor;
			arreglo[elemento] = arreglo[contador - 1];
			contador--;
		}
		return respuesta;
		}
		

	@Override
	public Respuesta elegir() {
		Respuesta respuesta = new Respuesta();
		int max = contador - 1;
		int min = 0;
		int elemento = (int) (Math.random() * (max - min + 1) + min);
		if (this.conjuntoVacio()) {  //chequeo que no este vacio
			respuesta.error = true;
		} else {
			respuesta.error = false;
			respuesta.rta = arreglo[elemento];
		}
		return respuesta;
	}

	@Override
	public boolean pertenece(int valor) {
		int elemento = 0;
		boolean devolver = false;
		while (elemento < contador && valor != arreglo[elemento]) {
			elemento++;
		}
		if (valor == arreglo[elemento]){
			devolver = true;
		}
		return devolver;
	}

	@Override
	public boolean conjuntoVacio() {
		return (contador == 0);
	}

}
