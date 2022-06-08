package juego;

import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;
public class Ninjas {
	private int x;
	private int y;
	private double direccion;
	private boolean muerto;
	private int n=1;
	Image imgN;
	
	
	public Ninjas(int x, int y,double direccion) {
		this.x=x;
		this.y=y;
		this.direccion=direccion;
		this.muerto=false;
		imgN = Herramientas.cargarImagen("Ninja.png");
	}
	

	public void mover() {
		if (direccion == 1) {
			y = y -=n;
			if (y < 0) {
				y= 600;
			}		
			return; 			
		}
		if (direccion == 2) {
			y = y +=n;
			if (y > 600) {
				y= 0;
			}		
			return; 			
		}
		if (direccion == 3) {
			x = x -=n;
			if (x < 0) {
				x= 800;
			}			
			return; 			
		}
		if (direccion == 4) {
			x = x +=n;
			if (x > 800) {
				x= 0;
			}		
			return; 			
		}
	
	}
	
	
	public void dibujar(Entorno entorno) {
		entorno.dibujarImagen(imgN, x, y, 0, 0.7);
	}
	
	
	public boolean chocoConEntorno(Entorno e) {
		
		if(this.x < 0 || this.x > e.ancho() || this.y < 0 || this.y > e.alto()) {
			
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
	
	public double getDireccion() {
		return direccion;
	}
	
	public void setMuerto(boolean muerto) {
		this.muerto=muerto;
	}
	
	public boolean getMuerto() {
		return muerto;
	}
	
	public void setX(int x) {
		this.x=x;
	}
	
	public void setY(int y) {
		this.y=y;
	}	
	
	public void setN(int n) {
		this.n=n;
	}
	
}