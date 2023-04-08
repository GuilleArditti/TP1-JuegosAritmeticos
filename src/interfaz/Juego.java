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
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import java.awt.Font;
import logica.LogicaDelTablero;
import objeto.Tablero;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

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
	private JButton botonRendirse;
	private JPanel panel;
	private JTextField[][] camposDeTexto;
	private LogicaDelTablero utilidades = new LogicaDelTablero();
	private Tablero tablero;
	private int contador = 3;


	public Juego(Tablero tablero) {
		this.tablero = tablero;
		inicializar();
	}

	private void inicializar() {

		// Ventana
		crearVentana();

		// Barra menu
		crearMenu();

		// Tiempos
		mostrarTiempo();

		// Tablero
		mostrarGrilla(tablero);

		// Resultados
		mostrarValoresDeLaGrilla(tablero);

		// Botones
		crearBotones();

	}

	// Funciones

	private void crearVentana() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 450);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Tablero");
		frame.getContentPane().setBackground(new Color(128, 0, 0));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// Icono ventana
				ImageIcon image = new ImageIcon("descarga.png");
				frame.setIconImage(image.getImage());
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
		comoJugar = new JMenuItem("¿Como Jugar?");
		comoJugar.addActionListener(this);

		acercaDe = new JMenuItem("Acerca De");
		acercaDe.addActionListener(this);

		ayuda.add(comoJugar);
		ayuda.add(acercaDe);
	}

	private void mostrarGrilla(Tablero tablero) {

		panel = new JPanel();
		panel.setPreferredSize(new Dimension(tablero.getDimension(), tablero.getDimension()));
		panel.setMinimumSize(new Dimension(tablero.getDimension(), tablero.getDimension()));
		panel.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panel.setBackground(Color.BLACK);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(20, 50, 300, 200);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(tablero.getDimension(), tablero.getDimension(), 1, 1));

		camposDeTexto = new JTextField[tablero.getDimension()][tablero.getDimension()];
		for (int i = 0; i < camposDeTexto.length; i++) {
			for (int j = 0; j < camposDeTexto[0].length; j++) {
				camposDeTexto[i][j] = new JTextField();
				camposDeTexto[i][j].setFont(new Font("Tahoma", Font.PLAIN, 12));
				camposDeTexto[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(camposDeTexto[i][j]);
				camposDeTexto[i][j].setColumns(tablero.getDimension());
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

	private void mostrarValoresDeLaGrilla(Tablero tablero) {
		
		// Representacion numeros filas
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.BLACK);
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(325, 50, 50, 200);
		panel_3.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
		frame.getContentPane().add(panel_3);

		for (int i = 0; i < tablero.getResultadosFilas().length; i++) {
			JButton valor = new JButton(String.valueOf(tablero.getResultadosFilas()[i]));
			valor.setMinimumSize(new Dimension(10, 10));
			valor.setMaximumSize(new Dimension(70, 27));
			valor.setPreferredSize(new Dimension(45, 70));
			valor.setEnabled(false);
			panel_3.add(valor);
		}

		// Representacion numeros columnas
		JPanel panel_4 = new JPanel();
		panel_4.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panel_4.setBackground(Color.BLACK);
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBounds(20, 255, 300, 30);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
		frame.getContentPane().add(panel_4);

		for (int i = 0; i < tablero.getResultadosColumnas().length; i++) {
			JButton valor = new JButton(String.valueOf(tablero.getResultadosColumnas()[i]));
			valor.setMinimumSize(new Dimension(10, 10));
			valor.setMaximumSize(new Dimension(75, 70));
			valor.setPreferredSize(new Dimension(65, 90));
			valor.setEnabled(false);
			panel_4.add(valor);
		}
	}

	private void crearBotones() {
		
		botonComprobar = new JButton("Comprobar");
		botonComprobar.setBounds(345, 270, 104, 25);
		frame.getContentPane().add(botonComprobar);
		botonComprobar.addActionListener(this);
		
		botonRendirse= new JButton("Rendirse?");
		botonRendirse.setBounds(345, 310, 104, 25);
		frame.getContentPane().add(botonRendirse);
		botonRendirse.addActionListener(this);
	}

	private void volcarResultadosDeCamposEnTablero() {
		for (int i = 0; i < camposDeTexto.length; i++) {
			for (int j = 0; j < camposDeTexto[0].length; j++) {
				tablero.getCuadricula()[i][j] = Integer.parseInt(camposDeTexto[i][j].getText());
			}
		}	
	}

	private void marcarSumasCorrectas() {
		cambiarColorFilasCorrectas();
		cambiarColorColumnasCorrectas();
	}

	private void mostrarSolucion() {
		for (int i = 0; i < camposDeTexto.length; i++) {
			for (int j = 0; j < camposDeTexto[0].length; j++) {
				camposDeTexto[i][j].setText(String.valueOf(tablero.getSolucionDelTablero()[i][j]));
				camposDeTexto[i][j].setFont(new Font("Tahoma", Font.BOLD, 12));
				camposDeTexto[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(camposDeTexto[i][j]);
				camposDeTexto[i][j].setColumns(tablero.getDimension());
				camposDeTexto[i][j].setBackground(Color.BLUE);
				camposDeTexto[i][j].setEnabled(false);
			}
		}
	}	

	private void cambiarColorFilasCorrectas() {
		int suma;
		for (int i = 0; i < camposDeTexto.length; i++) {
			suma = 0;
			for (int j = 0; j < camposDeTexto[0].length; j++) {
				suma = suma + Integer.parseInt(camposDeTexto[i][j].getText());
			}
			if (suma == tablero.getResultadosFilas()[i]) {
				for (int j = 0; j < camposDeTexto[0].length; j++) {
					camposDeTexto[i][j].setBackground(Color.GREEN);
				}
			} else {
				for (int j = 0; j < camposDeTexto[0].length; j++) {
					camposDeTexto[i][j].setBackground(Color.RED);
				}
			}
		}
	}

	private void cambiarColorColumnasCorrectas() {
		int suma;
		for (int i = 0; i < camposDeTexto[0].length; i++) {
			suma = 0;
			for (int j = 0; j < camposDeTexto.length; j++) {
				suma = suma + Integer.parseInt(camposDeTexto[j][i].getText());
			}
			if (suma == tablero.getResultadosColumnas()[i]) {
				for (int j = 0; j < camposDeTexto[0].length; j++) {
					camposDeTexto[j][i].setBackground(Color.GREEN);
				}
			} else {
				for (int j = 0; j < camposDeTexto[0].length; j++) {
					if (!(camposDeTexto[j][i].getBackground().equals(Color.GREEN)))
						camposDeTexto[j][i].setBackground(Color.RED);
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == botonComprobar) {
				volcarResultadosDeCamposEnTablero();
				marcarSumasCorrectas();
				if (utilidades.verificarTableroCompleto(tablero) && contador >= 0) {
					JOptionPane.showMessageDialog(null, "Felicidades, Ganaste!", "Felicitaciones!",
							JOptionPane.PLAIN_MESSAGE);
					botonComprobar.setEnabled(false);
					botonRendirse.setEnabled(false);
				}
				if (!utilidades.verificarTableroCompleto(tablero) && contador > 0) {
					JOptionPane.showMessageDialog(null, "Intentos restantes: " + contador, "ERROR!  Sumas incorrectas",
							JOptionPane.ERROR_MESSAGE);
					contador--;
				} else {
					if (!utilidades.verificarTableroCompleto(tablero) && contador == 0) {
						JOptionPane.showMessageDialog(null, "Las sumas son incorrectas y te quedaste sin intentos! :(",
								"Segui participando", JOptionPane.ERROR_MESSAGE);
						botonComprobar.setEnabled(false);
					}
				}
			}

		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "El tablero aun no esta completo!!", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
		}
		
		if(e.getSource()==botonRendirse) {
			int respuesta=JOptionPane.showConfirmDialog(null, "Desea rendirse y mostrar una solución?", "Rendirse", JOptionPane.YES_NO_OPTION);
			if(respuesta==JOptionPane.YES_OPTION) {
				botonComprobar.setEnabled(false);
				botonRendirse.setEnabled(false);
				mostrarSolucion();
			}
		}

		if (e.getSource() == reiniciar) {
			frame.dispose();
			VentanaPrincipal nuevaVentana = new VentanaPrincipal();
		}
		if (e.getSource() == salir) {
			frame.dispose();
		}
		if (e.getSource() == comoJugar) {
			JOptionPane.showMessageDialog(null, "El jugador debe adivinar que numero poner en cada casillero de la grilla, de modo\n"
					+ "tal que la suma de los numeros de cada fila y columna sea igual al valor dado respectivamente.", "¿Como Jugar?",
					JOptionPane.INFORMATION_MESSAGE);
		}
		if (e.getSource() == acercaDe) {
			JOptionPane.showMessageDialog(null,
					"	Juegos Aritmeticos ® \n" + "		Devs: Guillermo Arditti, Marcelo Palacios, Nancy Nores. \n",
					"Acerca de", JOptionPane.PLAIN_MESSAGE);
		}
	}
}
