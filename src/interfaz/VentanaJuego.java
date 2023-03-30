package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;

public class VentanaJuego implements ActionListener{

	private JFrame frame;
	JMenuBar barraMenu;
	JMenu opciones;
	JMenu ayuda;
	JMenuItem reiniciar;
	JMenuItem salir;
	JMenuItem acercaDe;
	JMenuItem comoJugar;
	JButton BotonIniciar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaJuego window = new VentanaJuego();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaJuego() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//Ventana
		frame = new JFrame();
		frame.setTitle("Tablero");
		frame.getContentPane().setBackground(new Color(128, 0, 0));
		frame.setBounds(100, 100, 480, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Representacion del tablero
		JPanel panel = new JPanel();
		panel.setBounds(10, 47, 291, 167);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		//Mejor tiempo - Record actual
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 130, 25);
		frame.getContentPane().add(panel_1);
		
		//Cronometro partida
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(171, 11, 130, 25);
		frame.getContentPane().add(panel_2);
		
		//Boton Iniciar!
		BotonIniciar = new JButton("Iniciar!");
		BotonIniciar.setBounds(365, 227, 89, 23);
		frame.getContentPane().add(BotonIniciar);
		
		//Representacion numeros filas
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(311, 47, 25, 167);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(new GridLayout(1, 0, 0, 0));
		
		//Representacion numeros columnas
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 225, 291, 25);
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(new GridLayout(1, 0, 0, 0));
		frame.setVisible(true);
		
		//Barra menu
		barraMenu= new JMenuBar();
		opciones = new JMenu("Opciones");
		ayuda = new JMenu("Ayuda");
		frame.setJMenuBar(barraMenu);
		frame.setVisible(true);
		
		barraMenu.add(opciones);
		barraMenu.add(ayuda);
		
		//Item Opciones
		reiniciar= new JMenuItem("Reiniciar");
		reiniciar.addActionListener(this);
		
		salir= new JMenuItem("Salir");
		salir.addActionListener(this);
		
		opciones.add(reiniciar);
		opciones.add(salir);
		
		//Item Ayuda
		comoJugar= new JMenuItem("Como Jugar?");
		comoJugar.addActionListener(this);
		
		acercaDe= new JMenuItem("Acerca De");
		acercaDe.addActionListener(this);
		
		ayuda.add(comoJugar);
		ayuda.add(acercaDe);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==BotonIniciar) {
			
		}
		if(e.getSource()==reiniciar) {
			
		}
		if(e.getSource()==salir) {
			frame.dispose();
		}
		if(e.getSource()==comoJugar) {
			
		}
		if(e.getSource()==acercaDe) {
			
		}
	}

}
