package logica;

import objeto.Tablero;

public class LogicaDelTablero {


	public Tablero generarTablero(int dimension) {
		return new Tablero(dimension);
	}

	private boolean sumaFilasCorrectas(Tablero t) {
		boolean sumaCorrecta = true;
		int suma;
		for (int i = 0; i < t.getCuadricula().length; i++) {
			suma = 0;
			for (int j = 0; j < t.getCuadricula()[0].length; j++) {
				suma = suma + t.getCuadricula()[i][j];
			}
			sumaCorrecta = sumaCorrecta && suma == t.getResultadosFilas()[i];
		}
		return sumaCorrecta;
	}

	private boolean sumaColumnasCorrectas(Tablero t) {
		boolean sumaCorrecta = true;
		int suma;
		for (int i = 0; i < t.getCuadricula()[0].length; i++) {
			suma = 0;
			for (int j = 0; j < t.getCuadricula().length; j++) {
				suma = suma + t.getCuadricula()[j][i];
			}
			sumaCorrecta = sumaCorrecta && suma == t.getResultadosColumnas()[i];
		}
		return sumaCorrecta;
	}

	public boolean verificarTableroCompleto(Tablero t) {
		return sumaFilasCorrectas(t) && sumaColumnasCorrectas(t);
	}

	public void MostrarTablero(Tablero t) { // Metodo de Prueba para consola
		for (int i = 0; i < t.getCuadricula().length; i++) {
			System.out.print("[");
			for (int j = 0; j < t.getCuadricula()[0].length; j++) {
				System.out.print(t.getCuadricula()[i][j] + "  ");
				if (j == t.getCuadricula()[0].length - 1) {
					System.out.print("] ");
					System.out.print(t.getResultadosFilas()[i]);
					System.out.println("");
				}
			}
		}
		System.out.println(" ");
		System.out.print(" ");
		for (int i = 0; i < t.getResultadosColumnas().length; i++) {
			System.out.print(t.getResultadosColumnas()[i] + " ");
		}
	}

}
