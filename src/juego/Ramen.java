package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Ramen {	
	private int x;
	private int y;	
	Image ramen;

	public Ramen(int x, int y) {
		this.x=x;
		this.y=y;


		ramen = Herramientas.cargarImagen("ramen.png");
	}

	public void dibujar(Entorno entorno) {
		entorno.dibujarImagen(ramen, x, y, 0, 0.06);
	}
	
	public boolean agarrarRamen(Sakura sakura) {
		 if (sakura.getX()+15>= this.x+7 && sakura.getY()+20>=this.y+7&&sakura.getX()-15<= this.x-7 && sakura.getY()-20<=this.y-7){
			 return true;
		 }
		 return false;
	 }
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

}



