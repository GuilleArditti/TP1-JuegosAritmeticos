package interfaz;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Cursor;
import javax.swing.SwingConstants;

import logica.LogicaDelTablero;
import objeto.Tablero;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class VentanaPrincipal implements ActionListener {

	private JFrame frame;
	private JButton BotonIniciarJuego;
	private JButton BotonSalir;
	private LogicaDelTablero logica = new LogicaDelTablero();

	public VentanaPrincipal() {
		inicializar();
	}

	private void inicializar() {

		crearVentanaPrincipal();

		agregarBotones();
	}

	private void crearVentanaPrincipal() {
		frame = new JFrame();
		frame.setLocationRelativeTo(null);
		frame.setBounds(100, 100, 500, 500);
		frame.getContentPane().setBackground(Color.BLUE);
		frame.setTitle("Bienvenido a Juegos Aritmeticos");
		frame.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

		// Icono ventana
		ImageIcon image = new ImageIcon("descarga.png");
		frame.setIconImage(image.getImage());

		// Titulo
		JLabel titulo = new JLabel("Juegos Aritmeticos");
		titulo.setForeground(Color.WHITE);
		titulo.setBackground(Color.WHITE);
		titulo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 29));
		titulo.setHorizontalTextPosition(SwingConstants.CENTER);
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setBounds(75, 24, 287, 48);
		frame.getContentPane().add(titulo);
	}
	
	private void agregarBotones() {
		// Boton Jugar!
		BotonIniciarJuego = new JButton("Jugar!");
		BotonIniciarJuego.setBorder(null);
		BotonIniciarJuego.setBounds(170, 150, 89, 23);
		BotonIniciarJuego.addActionListener(this);
		frame.getContentPane().add(BotonIniciarJuego);

		// Boton Salir
		BotonSalir = new JButton("Salir");
		BotonSalir.addActionListener(this);
		BotonSalir.setBorder(null);
		BotonSalir.setBounds(170, 195, 89, 23);
		frame.getContentPane().add(BotonSalir);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private int mostrarOpciones() {
		String[] opciones = { "4", "5", "6" };
		String input = (String) JOptionPane.showInputDialog(null, "Elija la dimension del tablero:",
				"Una eleccion importante...", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
		int eleccion = Integer.parseInt(input);
		return eleccion;
	}

	// Acciones que realizan los botones

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == BotonIniciarJuego) {
			int tamanioDelTablero = mostrarOpciones();
			Tablero tablero = logica.generarTablero(tamanioDelTablero);
			frame.dispose();
			Juego juego = new Juego(tablero);
		}
		if (e.getSource() == BotonSalir) {
			frame.dispose();
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.frame.setLocationRelativeTo(null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
