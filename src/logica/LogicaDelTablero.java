package logica;

import java.util.Scanner;

import objeto.Tablero;

public class LogicaDelTablero {

	Scanner scan = new Scanner(System.in);

	private Tablero llenarTablero(Tablero t) {
		int numero = 0;
		for (int i = 0; i < t.getCuadricula().length; i++) {
			for (int j = 0; j < t.getCuadricula()[0].length; j++) {
				t.getCuadricula()[i][j] = numero;
			}
		}
		return t;
	}

	public void generarYMostrarTablero() {
		Tablero t = new Tablero();
		System.out.println("Ingrese la cantidad de filas:");
		t.setFilas(scan.nextInt());
		System.out.println("Ingrese la cantidad de columnas:");
		t.setColumnas(scan.nextInt());
		t.setCuadricula(new int[t.getFilas()][t.getColumnas()]);

		llenarTablero(t);
		for (int i = 0; i < t.getCuadricula().length; i++) {
			System.out.print("[");
			for (int j = 0; j < t.getCuadricula()[0].length; j++) {
				System.out.print(t.getCuadricula()[i][j] + " ");
				if (j == t.getCuadricula()[0].length - 1) {
					System.out.print("]");
					System.out.println("");
				}
			}
		}
		System.out.println(" ");
	}

	public void nuevaPartida() {

	}

	public boolean verificarTablero(Tablero t) {
		return false;
	}

}
