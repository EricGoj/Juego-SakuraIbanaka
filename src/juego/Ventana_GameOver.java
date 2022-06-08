package juego;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entorno.Herramientas;

import javax.swing.JLabel;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana_GameOver extends JFrame {

	private JPanel contentPane;
	
	static private Ventana_GameOver frame3;
	
	private Image fondo_gameover;
	
	private Image Volver_a_jugar1;
	
	private Image Volver_al_menu1;

	private Clip clip = Sonido.cargarSonido("NarutoSadness.wav");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame3 = new Ventana_GameOver();
					frame3.setVisible(true);
					frame3.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ventana_GameOver() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 533);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		clip.loop(4);
		
		fondo_gameover=Herramientas.cargarImagen("sakura_ganaste.png");
		Volver_a_jugar1=Herramientas.cargarImagen("Volverajugar4.png");
		Volver_al_menu1=Herramientas.cargarImagen("Volveralmenu4.png");
		
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(fondo_gameover));
		lblNewLabel.setBounds(0, 0, 784, 494);
		contentPane.add(lblNewLabel);
		
		JButton Volver_a_jugar = new JButton("New button");
		Volver_a_jugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Juego.main(null);
				frame3.dispose();
				clip.stop();
			}
		});
		Volver_a_jugar.setIcon(new ImageIcon(Volver_a_jugar1));
		Volver_a_jugar.setBorder(null);
		Volver_a_jugar.setBounds(119, 130, 265, 53);
		contentPane.add(Volver_a_jugar);
		
		JButton Volver_al_menu = new JButton("New button");
		Volver_al_menu.setBorder(null);
		Volver_al_menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu.main(null);
				frame3.dispose();
				clip.stop();
			}
		});
		Volver_al_menu.setIcon(new ImageIcon(Volver_al_menu1));
		Volver_al_menu.setBounds(134, 205, 275, 53);
		contentPane.add(Volver_al_menu);
	}
}