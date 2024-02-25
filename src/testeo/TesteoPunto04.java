package testeo;
import implementacionesEjercicios.*;
import interfaces.*;

public class TesteoPunto04 {
	
	public static void main(String[] args) {
		
		DiccionarioSimpleModTDA diccionarioMod = new Ejercicio4_DiccionarioSimpleMod();
		diccionarioMod.inicializarDiccionario();
		
		diccionarioMod.agregar(1, 2);
		diccionarioMod.agregar(2, 2);
		diccionarioMod.agregar(3, 2);
		diccionarioMod.agregar(2, 1);
		diccionarioMod.agregar(3, 1);
		diccionarioMod.agregar(6, 2);
		diccionarioMod.agregar(1, 6);
		diccionarioMod.agregar(1, 7);
		diccionarioMod.agregar(1, 29);
		
		diccionarioMod.recuperar(1);
		diccionarioMod.recuperar(2);
		diccionarioMod.recuperar(3);
		diccionarioMod.recuperar(6);
		
		diccionarioMod.recuperarMod(1);
		diccionarioMod.recuperarMod(2);
		diccionarioMod.recuperarMod(3);
		diccionarioMod.recuperarMod(6);
		
		
	}

}
