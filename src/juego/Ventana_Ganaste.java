package juego;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entorno.Herramientas;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana_Ganaste extends JFrame {

	private JPanel contentPane;
	static private Ventana_Ganaste frame4;
	private Image Sakura_win1;
	private Image volverajugar1;
	private Image volveralmenu1;
	private Clip clip = Sonido.cargarSonido("NarutoGoGo.wav");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame4 = new Ventana_Ganaste();
					frame4.setVisible(true);
					frame4.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public Ventana_Ganaste() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		clip.loop(5);
		Sakura_win1=Herramientas.cargarImagen("Sakura_win.png");
		volverajugar1=Herramientas.cargarImagen("Volverajugar_win2.png");
		volveralmenu1=Herramientas.cargarImagen("VolverAlMenu_win.png");
		
		JButton VolverAJugar = new JButton("New button");
		VolverAJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Juego.main(null);
				frame4.dispose();
				clip.stop();
			}
		});
		VolverAJugar.setBorder(null);
		VolverAJugar.setBounds(454, 108, 279, 53);
		VolverAJugar.setIcon(new ImageIcon(volverajugar1));
		contentPane.add(VolverAJugar);
		
		JLabel fondo = new JLabel("New label");
		fondo.setBounds(0, -60, 804, 561);
		fondo.setIcon(new ImageIcon(Sakura_win1));
		contentPane.add(fondo);
		
		JButton VolverAlMenu = new JButton("New button");
		VolverAlMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu.main(null);
				frame4.dispose();
				clip.stop();
			}
		});
		VolverAlMenu.setBorder(null);
		VolverAlMenu.setIcon(new ImageIcon(volveralmenu1));
		VolverAlMenu.setBounds(454, 194, 279, 43);
		contentPane.add(VolverAlMenu);
	}

}