package objeto;

public class Tablero {

	private int filas;
	private int columnas;
	private int[] resultadoFilas;
	private int[] resultadoColumnas;
	private int[][] cuadricula;

	public Tablero() {
	}

	public int getFilas() {
		return filas;
	}

	public void setFilas(int filas) {
		this.filas = filas;
	}

	public int getColumnas() {
		return columnas;
	}

	public void setColumnas(int columnas) {
		this.columnas = columnas;
	}

	public int[] getResultadoFilas() {
		return resultadoFilas;
	}

	public void setResultadoFilas(int[] resultadoFilas) {
		this.resultadoFilas = resultadoFilas;
	}

	public int[] getResultadoColumnas() {
		return resultadoColumnas;
	}

	public void setResultadoColumnas(int[] resultadoColumnas) {
		this.resultadoColumnas = resultadoColumnas;
	}

	public int[][] getCuadricula() {
		return cuadricula;
	}

	public void setCuadricula(int[][] cuadricula) {
		this.cuadricula = cuadricula;
	}

}
