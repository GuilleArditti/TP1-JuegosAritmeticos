package objeto;

public class Tablero {

	private int dimension;
	private int[] resultadosFilas;
	private int[] resultadosColumnas;
	private int[][] cuadricula;

	public Tablero(int dimension) {
		this.dimension = dimension;
		this.cuadricula = new int[dimension][dimension];
		generarResultadosFilasYColumnas();
	}

	public int[][] getCuadricula() {
		return cuadricula;
	}

	public void setCuadricula(int[][] cuadricula) {
		this.cuadricula = cuadricula;
	}

	public int[] getResultadosFilas() {
		return resultadosFilas;
	}

	public int[] getResultadosColumnas() {
		return resultadosColumnas;
	}

	public void setResultadosFilas(int[] resultadosFilas) {
		this.resultadosFilas = resultadosFilas;
	}

	public void setResultadosColumnas(int[] resultadosColumnas) {
		this.resultadosColumnas = resultadosColumnas;
	}

	public int getDimension() {
		return dimension;
	}

	public void setDimension(int dimension) {
		this.dimension = dimension;
	}

	public void generarResultadosFilasYColumnas() {
		int[][] tablero = new int[dimension][dimension];
		int[] resultadosFilas = new int[dimension];
		int[] resultadosColumnas = new int[dimension];
		int suma;
		for (int i = 0; i < tablero.length; i++) {
			suma = 0;
			for (int j = 0; j < tablero[0].length; j++) {
				int numero = (int) (Math.random() * 10 + 1);
				tablero[i][j] = numero;
				suma = suma + numero;
			}
			resultadosFilas[i] = suma;
		}
		setResultadosFilas(resultadosFilas);
		;

		for (int j = 0; j < tablero.length; j++) {
			suma = 0;
			for (int i = 0; i < tablero.length; i++) {
				suma = suma + tablero[i][j];
			}
			resultadosColumnas[j] = suma;
		}
		setResultadosColumnas(resultadosColumnas);
		MostrarTablero(tablero, resultadosFilas, resultadosColumnas);
	}

	public void MostrarTablero(int[][] tablero, int[] filas, int[] columnas) { // Metodo de Prueba para consola
		for (int i = 0; i < tablero.length; i++) {
			System.out.print("[");
			for (int j = 0; j < tablero[0].length; j++) {
				System.out.print(tablero[i][j] + "  ");
				if (j == tablero[0].length - 1) {
					System.out.print("] ");
					System.out.print(getResultadosFilas()[i]);
					System.out.println("");

				}
			}
		}
		System.out.println(" ");
		for (int i = 0; i < getResultadosColumnas().length; i++) {
			System.out.print(getResultadosColumnas()[i] + " ");
		}
	}

}
