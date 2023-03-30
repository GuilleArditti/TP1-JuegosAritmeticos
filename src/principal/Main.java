package principal;

import interfaz.VentanaJuego;
import interfaz.VentanaPrincipal;
import logica.LogicaDelTablero;
import objeto.Tablero;

public class Main {

	public static void main(String[] args) {
//		Tablero t= new Tablero(5);
//		LogicaDelTablero ldt= new LogicaDelTablero();
//		ldt.MostrarTablero(t);
//		System.out.println(" ");
//		ldt.llenarTablero(t);
//		ldt.MostrarTablero(t);
//		System.out.println(ldt.verificarTableroCompleto(t));
		VentanaPrincipal ventana= new VentanaPrincipal();
		ventana.initialize();
		
		

	}

}
