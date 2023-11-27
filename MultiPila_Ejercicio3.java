package implementacionesEjercicios;

import imlementacionesAuxiliares.PilaDin;
import interfaces.MultiPilaTDA;
import interfaces.PilaTDA;

public class MultiPila_Ejercicio3 implements MultiPilaTDA {
	/*
	 * ENUNCIADO
	 * Se define un nuevo TDA denominado MultiPilaTDA basado en PilaTDA, con la particularidad de recibir una PilaTDA 
	 * por parámetro al apilar (la misma debe apilarse a continuación de la multipila), y otra al desapilar (la misma
	 * debe chequear que los valores tope de la multipila coincidan para desapilar, sino no debe hacer nada). Tanto en
	 * el método apilar como en el método desapilar, ambas pilas vienen inicializadas y contienen cualquier cantidad de
	 * elementos (incluso cero). El método tope devuelve una PilaTDA con los primeros elementos de la multipila, se recibe
	 * por parámetro un número mayor o igual que cero, que representa la cantidad de ellos (de recibir un número superior a
	 * la cantidad de elementos de la multipila, debe devolver todos). Se solicita realizar la presente implementación con
	 * el TDA ya visto PilaTDA, o en su defecto con estructuras dinámicas (no puede realizarse la implementación con estructuras
	 * estáticas). Su especificación se muestra en el anexo, leer detenidamente los comentarios de cada método.
	 */
	
	/*
	 * Metodos inicializar() y pilaVacia() iguales a la implementacion de pila.
	 * 
	 * APILAR() = crea un nuevo nodo con los valores ingresados y lo conecta con el tope anterior, poniendo al tope anterior como siguiente
	 * e igualando tope al nodo nuevo
	 * 
	 * DESAPILAR() = compara la pila a desapilar con la pila del tope utilizando funcion sonPilasIguales(). Si son iguales se elimina el
	 * nodo tope, desconectandolo. Si no son iguales no se elimina.
	 * 
	 * TOPE() = iteraa sobre los nodos de la multipila y copia los elementos hasta alcanzar la cantidad especificada. Para cada pila, copia
	 * sus elementos en una nueva pila de resultados.
 	 */
	private NodoPila tope;

    private class NodoPila {
        public PilaTDA valores;
        public NodoPila siguiente;

        public NodoPila(PilaTDA valores) {
            this.valores = valores;
            this.siguiente = null;
        }
    }
    
    public void MultiPila() {
    	this.tope = null;
    }
    
	@Override
	public void apilar(PilaTDA valores) {
		NodoPila nuevoNodo = new NodoPila(valores); //se crea un nuevo nodo con los valores proporcionados
        nuevoNodo.siguiente = tope; //el nuevo nodo apunta al nodo que anteriormente estaba en el tope
        tope = nuevoNodo; //se conecta el nodo al tope, estableciendolo como nuevo tope
	}

	@Override
	public void desapilar(PilaTDA valores) {
		if (tope != null && sonPilasIguales(valores, tope.valores)) { //se verifica que el tope de la multipila no sea nulo y que las pilas sean iguales
            NodoPila temp = tope; //si son iguales se crea un nodo temporal con los valores del nodo tope
            tope = tope.siguiente; //se iguala tope a tope siguiente, pisando el tope anterior
            temp.siguiente = null; //se desconecta el nodo eliminado
        }
	}

	@Override
	public PilaTDA tope(int cantidad) {
		PilaTDA pilaResultado = new PilaDin();
        NodoPila actual = tope; //nuevo nodo con los elementos del tope actual

        while (actual != null) { //se itera en los nodos de la pila
            PilaTDA valores = actual.valores; //pila valores
            PilaTDA valoresCopia = clonarPila(valores); //copia pila valores

            while (!valoresCopia.isEmpty() && cantidad > 0) { //itera sobre la copia
                pilaResultado.apilar(valoresCopia.tope()); //apilan los elementos
                valoresCopia.desapilar();
                cantidad--; //se decrementa la cantidad
            }
            actual = actual.siguiente; //se meuve al siguiente nodo
        }

        return pilaResultado;

	}

	@Override
	public void inicializarPila() {
		tope = null;
	}

	@Override
	public boolean pilaVacia() {
		return tope == null;
	}
	
	private boolean sonPilasIguales(PilaTDA pila1, PilaTDA pila2) { //compara las pilas tope y parametro pasado
		while (!pila1.isEmpty() && !pila2.isEmpty()) {
            if (pila1.tope() != pila2.tope()) {
                return false;
            }
            pila1.desapilar();
            pila2.desapilar();
        }

        return pila1.isEmpty() && pila2.isEmpty();
    }

    private PilaTDA clonarPila(PilaTDA original) { //clona las pilas sin modificar la original
        PilaTDA copia = new PilaDin();
        PilaTDA auxiliar = new PilaDin();

        while (!original.isEmpty()) {
            auxiliar.apilar(original.tope());
            copia.apilar(original.tope());
            original.desapilar();
        }

        while (!auxiliar.isEmpty()) {
            original.apilar(auxiliar.tope());
            auxiliar.desapilar();
        }

        return copia;
    }
}
