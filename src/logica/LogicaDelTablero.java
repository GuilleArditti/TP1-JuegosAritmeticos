package logica;	

import java.util.Scanner;

import objeto.Tablero;

public class LogicaDelTablero {
	
	Scanner scan = new Scanner(System.in);
	
	public Tablero generarTablero4x4() {
		return new Tablero();
	}
	
	public Tablero generarTableroConDimension(int dimension) {
		return new Tablero(dimension);
	}

	public void llenarTablero(Tablero t) {		//Metodo de Prueba para consola
		int numero;
		for (int i = 0; i < t.getCuadricula().length; i++) {
			for (int j = 0; j < t.getCuadricula()[0].length; j++) {
				System.out.println("Ingrese un numero para la posici�n "+ i + ", " + j);
				numero=scan.nextInt();
				validarNumeroIntroducido(numero);
				t.getCuadricula()[i][j] = numero;
			}
		}
	}
	
	public Tablero llenarTableroConNumeros(Tablero t,int num) {      //A modificar para la clase Juego, en la carga de los TextFields
		for (int i = 0; i < t.getCuadricula().length; i++) {
			for (int j = 0; j < t.getCuadricula()[0].length; j++) {
				t.getCuadricula()[i][j]=num;
			}
		}
		return t;
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

	public void MostrarTablero(Tablero t) {					//Metodo de Prueba para consola
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
	
	private void validarNumeroIntroducido(int numero) {
		if (numero < 1 || numero > 9)
			throw new IllegalArgumentException("El n�mero introducido debe estar entre 1 y 9");
	}

}
