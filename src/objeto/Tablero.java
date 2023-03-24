package objeto;

import java.util.Random;

public class Tablero {

	private int dimension;
	private int[] resultadosFilas;
	private int[] resultadosColumnas;
	private int[][] cuadricula;
	private int maximoPosible;
	private int minimoPosible;

	public Tablero() {
		this.cuadricula = new int[4][4];
		this.resultadosFilas = new int[4];
		this.resultadosColumnas = new int[4];
		this.maximoPosible = 36;
		this.minimoPosible = 4;
		generarResultadosFilas();
		generarResultadosColumnas();
	}
	
	public Tablero(int dimension) {
		validarDimension(dimension);
		this.dimension = dimension;
		this.cuadricula = new int[dimension][dimension];
		this.resultadosFilas = new int[dimension];
		this.resultadosColumnas = new int[dimension];
		this.maximoPosible = 9 * dimension;
		this.minimoPosible = dimension;
		generarResultadosFilas();
		generarResultadosColumnas();
	}
	
	public void setCelda(int num, int fila, int col) {
		validarFila(fila);
		validarColumna(col);
		
		this.cuadricula[fila][col] = num;
	}
	
	// TODO
	public boolean sumasCorrectas() {
		throw new RuntimeException("Método no implementado");
	}
	
	/** random [(dimension), (9*dimension)] */
	private void generarResultadosFilas() {
		Random random = new Random();
		int resultado;
		
		for (int i = 0; i < resultadosFilas.length; i++) {
			do
				resultado = this.minimoPosible + random.nextInt(this.maximoPosible);
			while (resultado < this.minimoPosible || resultado > this.maximoPosible);
			
			resultadosFilas[i] = resultado;
		}
	}
	
	private void generarResultadosColumnas() {
		Random random = new Random();
		int resultado;
		
		for (int i = 0; i < resultadosColumnas.length; i++) {
			do
				resultado = this.minimoPosible + random.nextInt(this.maximoPosible);
			while (resultado < this.minimoPosible || resultado > this.maximoPosible);
			
			resultadosColumnas[i] = resultado;
		}
	}
	
	private void validarFila(int fila) {
		if (fila < 0)
			throw new IllegalArgumentException("La fila no puede ser menor que 0 (cero)");
		if (fila >= cuadricula.length)
			throw new IllegalArgumentException("La fila no puede ser mayor o igual que: " + this.dimension);
	}
	
	private void validarColumna(int col) {
		if (col < 0)
			throw new IllegalArgumentException("La columna no puede ser menor que 0 (cero)");
		if (col >= 0)
			throw new IllegalArgumentException("La columna no puede ser mayor que: " + this.dimension);
	}
	
	private void validarDimension(int dimension) {
		if (dimension < 4)
			throw new IllegalArgumentException("La dimension no puede ser menor que 4");
		if (dimension > 10)
			throw new IllegalArgumentException("La dimension no puede ser mayor que 10");
	}

}
