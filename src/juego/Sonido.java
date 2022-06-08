package juego;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sonido {
	
	
	public static Clip cargarSonido(String file) {
		AudioInputStream audioIn;
		Clip clip = null;
		try 
		{			
			audioIn = AudioSystem.getAudioInputStream(ClassLoader.getSystemResource(file));			
			clip = AudioSystem.getClip();
			clip.open(audioIn); 			
			
		} 
		catch (Exception  e) {
			e.printStackTrace();
		}

		return clip;			
		}	
	}	


