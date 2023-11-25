package imlementacionesAuxiliares;

import interfaces.ColaPrioridadTDA;

public class ColaPrioridadEstatica implements ColaPrioridadTDA {
	
		private class Elemento {
			int valor;
			int prioridad;
		}
		
		private Elemento[] colaPrioridad;
		private int indice;
		
		
		@Override
		public void inicializar() {
			indice = 0;
			colaPrioridad = new Elemento[100];
		}

		@Override
		public void acolarPrioridad(int elemento, int prioridad) {
			int posicion = indice;
			while ((posicion > 0) && (colaPrioridad[posicion - 1].prioridad >= prioridad)) {
				colaPrioridad[posicion] = colaPrioridad[posicion - 1];
				posicion--;
			}
			colaPrioridad[posicion] = new Elemento();
			colaPrioridad[posicion].valor = elemento;
			colaPrioridad[posicion].prioridad = prioridad;
			indice++;
		}

		@Override
		public void desacolar() {
			indice--;
		}

		@Override
		public int primero() {
			return colaPrioridad[indice - 1].valor;
		}

		@Override
		public int prioridad() {
			return colaPrioridad[indice - 1].prioridad;
		}

		@Override
		public boolean colaVacia() {
			return indice == 0;
		}

}
