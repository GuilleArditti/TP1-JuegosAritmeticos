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
		this.dimension=4;
		this.cuadricula = new int[dimension][dimension];
		this.resultadosFilas = new int[dimension];
		this.resultadosColumnas = new int[dimension];
		this.maximoPosible = 4;													//Revisar maximos y minimos por la dificultad
		this.minimoPosible = dimension;
		generarResultadosFilas();
		generarResultadosColumnas();
	}
	
	public Tablero(int dimension) {
		validarDimension(dimension);
		this.dimension = dimension;
		this.cuadricula = new int[dimension][dimension];
		this.maximoPosible = dimension*4;
		this.minimoPosible = dimension;
		generarResultadosFilasYColumnas();
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
		int[][] tablero= new int[dimension][dimension];
		int[] resultadosFilas= new int[dimension];
		int[] resultadosColumnas= new int[dimension];
		int suma;
		for (int i = 0; i < tablero.length; i++) {
			suma=0;
			for (int j = 0; j < tablero[0].length; j++) {
				int numero = (int)(Math.random()*10+1);
				tablero[i][j] = numero;
				suma=suma+numero;
			}
			resultadosFilas[i]=suma;
		}
		setResultadosFilas(resultadosFilas);;
		
		for (int j = 0; j < tablero.length; j++) {
			suma=0;
			for (int i = 0; i < tablero.length; i++) {
				suma=suma+tablero[i][j];
			}
			resultadosColumnas[j]=suma;
		}
		setResultadosColumnas(resultadosColumnas);;
		MostrarTablero(tablero,resultadosFilas,resultadosColumnas);
	}

	public void MostrarTablero(int [][] tablero, int[] filas, int[] columnas) {					//Metodo de Prueba para consola
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
		for(int i=0;i<getResultadosColumnas().length;i++) {
			System.out.print(getResultadosColumnas()[i] +" ");
		}
	}

}
