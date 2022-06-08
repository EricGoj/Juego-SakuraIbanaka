package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Casas {
	private int x;
	private int y;
	private int direccion; 
	Image imgCasasDerecha;
	Image imgCasasIzq;
	Image imgCasasFrente;
	Image imgCasasTrasera;

	public Casas (int x,int y,int direccion) {
		this.x=x;
		this.y=y;
		this.direccion=direccion;


		imgCasasDerecha = Herramientas.cargarImagen("casa_derecha.png");
		imgCasasIzq = Herramientas.cargarImagen("casa_izquierda.png");
		imgCasasFrente = Herramientas.cargarImagen("casa_frente.png");
		imgCasasTrasera = Herramientas.cargarImagen("casa_trasera.png");
	}
	public void dibujar(Entorno entorno) {
		entorno.dibujarImagen(imgCasasDerecha, this.x, this.y, 0, 1);
	}
	public void dibujar1(Entorno entorno) {
		entorno.dibujarImagen(imgCasasIzq, this.x, this.y, 0, 1);

	}
	public void dibujar2(Entorno entorno) {
		entorno.dibujarImagen(imgCasasFrente, this.x, this.y, 0, 1);

	}
	public void dibujar3(Entorno entorno) {
		entorno.dibujarImagen(imgCasasTrasera, this.x, this.y, 0, 1);
	}


	public int getDireccion() {
		return direccion;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}