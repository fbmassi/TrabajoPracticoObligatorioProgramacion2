package interfaces;

public interface DiccionarioMultipleTDA {
	
	public void inicializar(); // Este método inicializa el diccionario, preparándolo para su uso.
	public void agregar(int clave, int elemento); // Agrega el elemento junto con su clave al diccionario. Asumimnos que el diccionario ya fua inicializado antes de agregar elementos.
	public void eliminar(int clave); // Elimina el conjunto asociado a la clave. La eliminación solo es posible si el diccionario ya ha sido inicializado.
	public void eliminarValor(int clave, int valor); //Elimina el valor del conjunto asociado a la clave. El diccionario debe estar inicalizado. 
	public ConjuntoTDA recuperar(int clave); //Dado una clave, este método devuelve el valor asociado a esa clave. Se requiere que el diccionario esté inicializado y que la clave exista en el conjunto de claves.
	public ConjuntoTDA claves(); //Devuelve el conjunto de todas las claves definidas en el diccionario. Para utilizar este método, es necesario que el diccionario esté previamente inicializado.
	
}