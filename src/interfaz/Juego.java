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
import logica.LogicaDelTablero;
import objeto.Tablero;
import javax.swing.BoxLayout;

public class Juego implements ActionListener {

	private JFrame frame;
	private JMenuBar barraMenu;
	private JMenu opciones;
	private JMenu ayuda;
	private JMenuItem reiniciar;
	private JMenuItem salir;
	private JMenuItem acercaDe;
	private JMenuItem comoJugar;
	private JButton botonComprobar;
	private JPanel panel;
	private JTextField[][] textFields;
	private LogicaDelTablero utilidades= new LogicaDelTablero();
	private Tablero tablero=utilidades.generarTablero4x4();
	

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
		crearBotonComprobar();

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
		panel.setPreferredSize(new Dimension(tablero.getDimension(),tablero.getDimension()));
		panel.setMinimumSize(new Dimension(tablero.getDimension(),tablero.getDimension()));
		panel.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panel.setBackground(Color.BLACK);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(20, 50, 259, 188);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(tablero.getDimension(),tablero.getDimension(), 1, 1));

		textFields = new JTextField[tablero.getDimension()][tablero.getDimension()];
		for (int i = 0; i < textFields.length; i++) {
			for (int j = 0; j < textFields[0].length; j++) {
				textFields[i][j] = new JTextField();
				textFields[i][j].setFont(new Font("Tahoma", Font.PLAIN, 12));
				textFields[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(textFields[i][j]);
				textFields[i][j].setColumns(tablero.getDimension());
			}
		}
	}

	private void mostrarTiempo() {
		// Mejor tiempo - Record actual
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(20, 11, 104, 25);
		panel_1.setBackground(Color.BLACK);
		frame.getContentPane().add(panel_1);

		// Cronometro partida
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(175, 11, 104, 25);
		panel_2.setBackground(Color.BLACK);
		frame.getContentPane().add(panel_2);
	}
	
	private void crearResultados() {
		// Representacion numeros filas
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.BLACK);
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(287, 50, 50, 188);
		panel_3.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
		frame.getContentPane().add(panel_3);
		
		for(int i=0;i<tablero.getResultadosFilas().length;i++) {
			JButton valor= new JButton(String.valueOf(tablero.getResultadosFilas()[i]));
			valor.setMinimumSize(new Dimension(10,10));
			valor.setMaximumSize(new Dimension(65,30));
			valor.setPreferredSize(new Dimension(45,70));
			valor.setEnabled(false);
			panel_3.add(valor);
		}
		
		
		// Representacion numeros columnas
		JPanel panel_4 = new JPanel();
		panel_4.setPreferredSize(new Dimension(tablero.getResultadosFilas().length, 1));
		panel_4.setMinimumSize(new Dimension(tablero.getResultadosFilas().length, 1));
		panel_4.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panel_4.setBackground(Color.BLACK);
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBounds(20, 246, 259, 32);
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
		
		for(int i=0;i<tablero.getResultadosColumnas().length;i++) {
			JButton valor= new JButton(String.valueOf(tablero.getResultadosColumnas()[i]));
			valor.setMinimumSize(new Dimension(10,10));
			valor.setMaximumSize(new Dimension(65,30));
			valor.setPreferredSize(new Dimension(45,70));
			valor.setEnabled(false);
			panel_4.add(valor);
		}
		
	}
	

	private void crearBotonComprobar() {
		botonComprobar = new JButton("Comprobar");
		botonComprobar.setBounds(341, 246, 104, 25);
		frame.getContentPane().add(botonComprobar);
		botonComprobar.addActionListener(this);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botonComprobar) {
			for(int i=0;i<textFields.length;i++) {
				for(int j=0;j<textFields[0].length;j++) {
					tablero.getCuadricula()[i][j]=Integer.parseInt(textFields[i][j].getText());
				}
			}
	
			utilidades.MostrarTablero(tablero);
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
}
