package testeo;
import implementacionesEjercicios.*;
import interfaces.*;
import interfaces.ConjuntoEspecialTDA.*;

public class TesteoPunto01 {
	
	public static void main(String[] args) {
		
		ConjuntoEspecialTDA conjuntoEspecial = new Ejercicio1_ConjuntoEspecial();
		conjuntoEspecial.inicializarConjunto();
		
		Respuesta r1 = conjuntoEspecial.agregar(1);
		System.out.println(r1.error);
		System.out.println(r1.rta);
		System.out.println("");
		Respuesta r2 = conjuntoEspecial.agregar(2);
		System.out.println(r2.error);
		System.out.println(r2.rta);
		System.out.println("");
		Respuesta r3 = conjuntoEspecial.agregar(1);
		System.out.println(r3.error);
		System.out.println(r3.rta);
		System.out.println("");
		Respuesta r4 = conjuntoEspecial.agregar(3);
		System.out.println(r4.error);
		System.out.println(r4.rta);
		System.out.println("");
		Respuesta r5 = conjuntoEspecial.agregar(2);
		System.out.println(r5.error);
		System.out.println(r5.rta);
		System.out.println("");
		
		
		Respuesta r6 = conjuntoEspecial.sacar(1);
		System.out.println(r6.error);
		System.out.println(r6.rta);
		System.out.println("");
		Respuesta r7 = conjuntoEspecial.sacar(1);
		System.out.println(r7.error);
		System.out.println(r7.rta);
		System.out.println("");
		Respuesta r8 = conjuntoEspecial.sacar(2);
		System.out.println(r8.error);
		System.out.println(r8.rta);
		System.out.println("");
		Respuesta r9 = conjuntoEspecial.sacar(3);
		System.out.println(r9.error);
		System.out.println(r9.rta);
		System.out.println("");
		
		
		Respuesta r10 = conjuntoEspecial.sacar(1);
		System.out.println(r10.error);
		System.out.println(r10.rta);
		System.out.println("");
		
		@SuppressWarnings("unused")
		Respuesta r11 = conjuntoEspecial.agregar(1);
		
		Respuesta r12 = conjuntoEspecial.sacar(1);
		System.out.println(r12.error);
		System.out.println(r12.rta);
		System.out.println("");
	}

}
