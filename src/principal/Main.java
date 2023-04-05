package principal;

import interfaz.VentanaPrincipal;
import objeto.Tablero;


public class Main {

	public static void main(String[] args) {
//		VentanaPrincipal ventana = new VentanaPrincipal();
//		ventana.initialize();
		Tablero t= new Tablero();
		t.generarResultadosFilasYColumnas();
		

	}

}
