package logica;

import objeto.Tablero;

public class LogicaDelTablero {


	public Tablero generarTablero(int dimension) {
		return new Tablero(dimension);
	}

	private boolean sumaFilasCorrectas(Tablero t) {
		verificarRangoNumerico(t);
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
	
	private void verificarRangoNumerico(Tablero t) {
		for (int i = 0; i < t.getCuadricula()[0].length; i++) {
			for (int j = 0; j < t.getCuadricula().length; j++) {
				if(t.getCuadricula()[i][j]>9 || t.getCuadricula()[i][j]<1) {
					throw new IllegalArgumentException("El tablero solo admite numeros del 1 al 9!");
				}
			}	
		}

	}

	public boolean verificarTableroCompleto(Tablero t) {
		return sumaFilasCorrectas(t) && sumaColumnasCorrectas(t);
	}

}
