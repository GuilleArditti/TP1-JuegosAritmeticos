package objeto;

import java.util.Random;

public class Tablero {

	private int dimension;
	private int[] resultadosFilas;
	private int[] resultadosColumnas;
	private int[][] cuadricula;
	private int maximoPosible;
	private int minimoPosible;

	public Tablero() { //Tablero estandar de 4x4
		this.dimension=4;
		this.cuadricula = new int[dimension][dimension];
		this.resultadosFilas = new int[dimension];
		this.resultadosColumnas = new int[dimension];
		this.maximoPosible = 36;													//Revisar maximos y minimos por la dificultad
		this.minimoPosible = dimension;
		generarResultadosFilas();
		generarResultadosColumnas();
	}
	
	public Tablero(int dimension) { 													// Tablero cuadrado de dimension introducida por el user
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
	
	private void validarDimension(int dimension) {

		if (dimension < 4)
			throw new IllegalArgumentException("La dimension no puede ser menor que 4");
		if (dimension > 10)
			throw new IllegalArgumentException("La dimension no puede ser mayor que 10");
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

	public int getDimension() {
		return dimension;
	}

	public void setDimension(int dimension) {
		this.dimension = dimension;
	}

}
