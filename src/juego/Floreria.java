package juego;

import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;

public class Floreria {
	private int x;
	private int y;
	Image img_floreria;
	
	public Floreria (int x,int y) {
		this.x=x;
		this.y=y;
		
		img_floreria = Herramientas.cargarImagen("floreria.png");
	}
	public void dibujar(Entorno entorno) {
		entorno.dibujarImagen(img_floreria, this.x, this.y, 0, 1);
	}

}
