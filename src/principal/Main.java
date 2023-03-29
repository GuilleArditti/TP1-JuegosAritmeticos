package principal;

import logica.LogicaDelTablero;
import objeto.Tablero;

public class Main {
	static int[] resultadosFilas= {7,12,9,4};
	static int[] resultadosColumnas= {4,8,9,11};
	static int[][] cuadricula= {{1,1,1,4},{1,3,3,5},{1,3,4,1},{1,1,1,1}};
	
	static public boolean sumasCorrectas() {
		
		return sumaFilasCorrectas(cuadricula) && sumaColumnasCorrectas(cuadricula);
	}
	
	static private boolean sumaFilasCorrectas(int [][] cuadricula) {
		boolean sumaCorrecta=true;
		int suma;
		for(int i=0;i<cuadricula.length;i++) {
			suma=0;
			for(int j=0;j<cuadricula[0].length;j++) {
				suma=suma+cuadricula[i][j];
			}
			sumaCorrecta= sumaCorrecta && suma==resultadosFilas[i];
		}
		return sumaCorrecta;
	}
	
	static private boolean sumaColumnasCorrectas(int [][] cuadricula) {
		boolean sumaCorrecta=true;
		int suma;
		for(int i=0;i<cuadricula[0].length;i++) {
			suma=0;
			for(int j=0;j<cuadricula.length;j++) {
				suma=suma+cuadricula[j][i];
			}
			sumaCorrecta= sumaCorrecta && suma==resultadosColumnas[i];
		}
		return sumaCorrecta;
	}

	public static void main(String[] args) {
		Tablero t= new Tablero();
		//Tablero t1= new Tablero(6);
		LogicaDelTablero ldt= new LogicaDelTablero();
		ldt.MostrarTablero(t);
		//ldt.MostrarTablero(t1);
		System.out.println(" ");
		ldt.llenarTablero(t);
		
		ldt.MostrarTablero(t);
		

	}

}
