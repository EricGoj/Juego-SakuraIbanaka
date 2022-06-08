package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class CantR {
	private int x;
	private int y;	
	Image imgR;

	public CantR(int x, int y) {
		this.x=x;
		this.y=y;
		

		imgR = Herramientas.cargarImagen("rasengan.png");
	}

	public void dibujar(Entorno entorno) {
		entorno.dibujarImagen(imgR, x, y, 0, 0.015);
	}
}
