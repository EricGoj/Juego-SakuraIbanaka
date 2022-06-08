package juego;


import java.awt.EventQueue;
import java.awt.Image;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import entorno.Herramientas;



public class menu extends JFrame {
	

	private Image fondo;		
	
	private Image salir;
	
	private Image controles;

	private JPanel contentPane;

	static private menu frame;
	
	private Clip clip = Sonido.cargarSonido("NarutoAfternoon.wav");
	
	
	
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {		
				try {
					frame = new menu();					
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);					
				} catch (Exception e) {
					e.printStackTrace();
				}				
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public menu() {			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		clip.loop(5);
		
		fondo= Herramientas.cargarImagen("fondo1.png");
		salir= Herramientas.cargarImagen("salir1.png");
		controles= Herramientas.cargarImagen("Controles.png");
		
		
		JButton btnNewButton= new JButton("Jugar\r\n");
		btnNewButton.setBorder(null);
		btnNewButton.setIcon(new ImageIcon(fondo));
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {
		    	Juego.main(null);
		    	frame.dispose();
		    	clip.stop();
		    }
		});
		btnNewButton.setBounds(354, 255, 111, 50);
		contentPane.add(btnNewButton);
		
		JLabel lblFondo = new JLabel("fondo");
		lblFondo.setBounds(0, 0, 784, 561);
		lblFondo.setIcon(new ImageIcon(fondo));
		contentPane.add(lblFondo);
		
		
		
		JButton btnNewButton_1 = new JButton("salir");
		btnNewButton_1.setBorder(null);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(salir));
		
		btnNewButton_1.setBounds(362, 351, 72, 40);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Controles");
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setIcon(new ImageIcon(controles));
		btnNewButton_2.setBounds(330, 300, 142, 34);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Controles.main(null);
				frame.dispose();
				clip.stop();
			}
		});	
    }
}

