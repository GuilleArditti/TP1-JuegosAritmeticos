package logica;

import java.util.Scanner;

import objeto.Tablero;

public class LogicaDelTablero {
	
	Scanner scan = new Scanner(System.in);

	public void llenarTablero(Tablero t) {
		for (int i = 0; i < t.getCuadricula().length; i++) {
			for (int j = 0; j < t.getCuadricula()[0].length; j++) {
				System.out.println("Ingrese un numero para la posición "+ i + ", " + j);
				t.getCuadricula()[i][j] = scan.nextInt();
			}
		}
	}
	
	private boolean sumaFilasCorrectas(Tablero t) {
		boolean sumaCorrecta=true;
		int suma;
		for(int i=0;i<t.getCuadricula().length;i++) {
			suma=0;
			for(int j=0;j<t.getCuadricula()[0].length;j++) {
				suma=suma+t.getCuadricula()[i][j];
			}
			sumaCorrecta= sumaCorrecta && suma==t.getResultadosFilas()[i];
		}
		return sumaCorrecta;
	}
	
	private boolean sumaColumnasCorrectas(Tablero t) {
		boolean sumaCorrecta=true;
		int suma;
		for(int i=0;i<t.getCuadricula()[0].length;i++) {
			suma=0;
			for(int j=0;j<t.getCuadricula().length;j++) {
				suma=suma+t.getCuadricula()[j][i];
			}
			sumaCorrecta= sumaCorrecta && suma==t.getResultadosColumnas()[i];
		}
		return sumaCorrecta;
	}

	public void MostrarTablero(Tablero t) {
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
		for(int i=0;i<t.getResultadosColumnas().length;i++) {
			System.out.print(t.getResultadosColumnas()[i] +" ");
		}
	}


	public boolean verificarTableroCompleto(Tablero t) {
		return sumaFilasCorrectas(t) && sumaColumnasCorrectas(t);
	}

}
