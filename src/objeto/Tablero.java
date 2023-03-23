package objeto;

public class Tablero {

	private int dimension;
	private int[] resultadosFilas;
	private int[] resultadosColumnas;
	private int[][] cuadricula;

	public Tablero() {
		this.cuadricula = new int[4][4];
		this.resultadosFilas = new int[4];
		this.resultadosColumnas = new int[4];
		generarResultadosFilas();
		generarResultadosColumnas();
	}
	
	public Tablero(int dimension) {
		this.dimension = dimension;
		this.cuadricula = new int[dimension][dimension];
		this.resultadosFilas = new int[dimension];
		this.resultadosColumnas = new int[dimension];
		generarResultadosFilas();
		generarResultadosColumnas();
	}
	
	public void setCelda(int num, int fila, int col) {
		validarFila(fila);
		validarColumna(col);
		
		this.cuadricula[fila][col] = num;
	}
	
	public boolean sumasCorrectas() {
		throw new RuntimeException("Método no implementado");
	}
	
	private void generarResultadosFilas() {
		
	}
	
	private void generarResultadosColumnas() {
		
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

}
