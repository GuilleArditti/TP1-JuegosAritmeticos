package interfaz;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Cursor;
import javax.swing.SwingConstants;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class VentanaPrincipal implements ActionListener {

	private JFrame frame;
	JButton BotonIniciarJuego;
	JButton BotonSalir;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaPrincipal() {	
		initialize();
	}

	public void initialize() {
		
		
		//Ventana Principal
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLUE);
		frame.setTitle("Bienvenido a Juegos Aritméticos");
		frame.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		
		//Icono ventana
		ImageIcon image= new ImageIcon("descarga.png");
		frame.setIconImage(image.getImage());
		
		//Titulo
		JLabel lblNewLabel = new JLabel("Juegos Aritmeticos");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 29));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(75, 24, 287, 48);
		frame.getContentPane().add(lblNewLabel);
		
		//Boton Jugar!
		BotonIniciarJuego = new JButton("Jugar!");
		BotonIniciarJuego.setBorder(null);
		BotonIniciarJuego.setBounds(170, 150, 89, 23);
		BotonIniciarJuego.addActionListener(this);
		frame.getContentPane().add(BotonIniciarJuego);
		
		//Boton Salir
		BotonSalir = new JButton("Salir");
		BotonSalir.addActionListener(this);
		BotonSalir.setBorder(null);
		BotonSalir.setBounds(170, 195, 89, 23);
		frame.getContentPane().add(BotonSalir);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	//Acciones que realizan los botones
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==BotonIniciarJuego) {
			VentanaJuego ventana= new VentanaJuego();
			
		}
		if(e.getSource()==BotonSalir) {
			frame.dispose();
		}
		
	}
}
