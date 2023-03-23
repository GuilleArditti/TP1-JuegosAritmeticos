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
	
	public Tablero(int tamanio) {
		this.cuadricula = new int[tamanio][tamanio];
		this.resultadosFilas = new int[tamanio];
		this.resultadosColumnas = new int[tamanio];
		generarResultadosFilas();
		generarResultadosColumnas();
	}
	
	public void setCelda(int num, int fila, int col) {
		
	}
	
	public boolean sumasCorrectas() {
		throw new RuntimeException("Método no implementado");
	}
	
	private void generarResultadosFilas() {
		
	}
	
	private void generarResultadosColumnas() {
		
	}

}
