package juego;

import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;

public class Rasengan {

	private int x;
	private int y;	
	private int movimiento;


	Image imgR;

	public Rasengan(int x, int y,int movimiento) {
		this.x=x;
		this.y=y;
		this.movimiento=movimiento;

		imgR = Herramientas.cargarImagen("rasengan.png");
	}


	public void mover() {
		if (movimiento == 3) {
			y = y -=3;
			return; 			
		}
		if (movimiento == 4) {
			y = y +=3;
			return; 			
		}
		if (movimiento == 1) {
			x = x -=3;
			return; 			
		}
		if (movimiento == 2) {
			x = x +=3;
			return; 			
		}
	}	


	public int impactasteNinja(Ninjas[] ninja) {	
		for(int i =0;i < ninja.length;i++) {
			if(!ninja[i].getMuerto()) {
				if (ninja[i].getX()+15>=this.x && ninja[i].getY()+15>=this.y&&ninja[i].getX()-15<=this.x && ninja[i].getY()-15<=this.y) {	
					return i;
				}
			}
		}
		return -1;
	}



	public boolean chocoConEntorno(Entorno e) {

		if(this.x < 0 || this.x > e.ancho() || this.y < 0 || this.y > e.alto()) {

			return true;
		}
		return false;

	}

	public void dibujar(Entorno entorno) {
		entorno.dibujarImagen(imgR, x, y, 0, 0.02);
	}
	

	public int getX() {
		return x;
	}

	public int getY() {
		return y;

	}


}
