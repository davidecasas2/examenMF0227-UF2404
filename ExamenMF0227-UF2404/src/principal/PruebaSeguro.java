package principal;

import modelo.SeguroCoche;

public class PruebaSeguro {

	public static void main(String[] args) {
		SeguroCoche s1 = new SeguroCoche();
		System.out.println("El seguro es "+s1);
		
		SeguroCoche s2 = new SeguroCoche("dede", "Juan", 
				"Martos", "3000000A", 2018, "Anual", 300, 2, 
				"2345-ABC", 2018);
		System.out.println("El seguro 2 es:" +s2);
		System.out.println("Su prima es: "+s2.calcularPrima());
		
		s2.setAnyoCarnet(2000);
		System.out.println("Cambiando año de carnet a 2000");
		System.out.println("El seguro 2 es:" +s2);
		System.out.println("Su prima es: "+s2.calcularPrima());
		
		s2.setNumSieniestrosHistorico(4);
		System.out.println("Cambiando siniestros a 4");
		System.out.println("El seguro 2 es:" +s2);
		System.out.println("Su prima es: "+s2.calcularPrima());
		}
}
