package interfaz;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Juego implements ActionListener {

	private JFrame frame;
	private JMenuBar barraMenu;
	private JMenu opciones;
	private JMenu ayuda;
	private JMenuItem reiniciar;
	private JMenuItem salir;
	private JMenuItem acercaDe;
	private JMenuItem comoJugar;
	private JButton botonIniciar;
	private JPanel panel;
	private JTextField[][] textFields;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Juego window = new Juego();
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
	public Juego() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		// Ventana
		crearVentana();

		// Barra menu
		crearMenu();

		// Tiempos
		mostrarTiempo();

		// Tablero
		crearTablero();

		// Resultados
		crearResultados();
		
		//Boton Iniciar!
		crearBotonInicio();

	}

	// Funciones
	private void crearVentana() {
		frame = new JFrame();
		frame.setBounds(100, 100, 480, 350);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Tablero");
		frame.getContentPane().setBackground(new Color(128, 0, 0));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	}

	private void crearMenu() {
		barraMenu = new JMenuBar();
		opciones = new JMenu("Opciones");
		ayuda = new JMenu("Ayuda");
		frame.setJMenuBar(barraMenu);
		frame.setVisible(true);

		barraMenu.add(opciones);
		barraMenu.add(ayuda);

		// Item Opciones
		reiniciar = new JMenuItem("Reiniciar");
		reiniciar.addActionListener(this);

		salir = new JMenuItem("Salir");
		salir.addActionListener(this);

		opciones.add(reiniciar);
		opciones.add(salir);

		// Item Ayuda
		comoJugar = new JMenuItem("Como Jugar?");
		comoJugar.addActionListener(this);

		acercaDe = new JMenuItem("Acerca De");
		acercaDe.addActionListener(this);

		ayuda.add(comoJugar);
		ayuda.add(acercaDe);
	}

	private void crearTablero() {
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(4, 4));
		panel.setMinimumSize(new Dimension(4, 4));
		panel.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panel.setBackground(Color.YELLOW);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(20, 50, 259, 188);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(4, 4, 1, 1));

		textFields = new JTextField[4][4];
		for (int i = 0; i < textFields.length; i++) {
			for (int j = 0; j < textFields[0].length; j++) {
				textFields[i][j] = new JTextField();
				textFields[i][j].setFont(new Font("Tahoma", Font.PLAIN, 12));
				textFields[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(textFields[i][j]);
				textFields[i][j].setColumns(4);
			}
		}
	}

	private void mostrarTiempo() {
		// Mejor tiempo - Record actual
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(20, 11, 130, 25);
		frame.getContentPane().add(panel_1);

		// Cronometro partida
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(182, 11, 130, 25);
		frame.getContentPane().add(panel_2);
	}
	
	private void crearResultados() {
		// Representacion numeros filas
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(287, 50, 25, 188);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(new GridLayout(1, 0, 0, 0));

		// Representacion numeros columnas
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(20, 246, 259, 25);
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(new GridLayout(1, 0, 0, 0));
		frame.setVisible(true);
	}
	

	private void crearBotonInicio() {
		botonIniciar = new JButton("Iniciar!");
		botonIniciar.setBounds(341, 246, 104, 25);
		frame.getContentPane().add(botonIniciar);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botonIniciar) {

		}
		if (e.getSource() == reiniciar) {

		}
		if (e.getSource() == salir) {
			frame.dispose();
		}
		if (e.getSource() == comoJugar) {

		}
		if (e.getSource() == acercaDe) {

		}
	}

}
