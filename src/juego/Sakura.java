package juego;


import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;

public class Sakura {
	private int x;
	private int y;
	private double velocidad;
	Image img;	
	

	public Sakura(int x, int y) {
		this.x = x;
		this.y = y;
		this.velocidad = 1;
		img = Herramientas.cargarImagen("sakura.png");
		
	}


	public void dibujar(Entorno entorno) {

		entorno.dibujarImagen(img, x, y, 0, 0.10);
	}


	
	public boolean chocasteConBordeD(Entorno entorno) {
		return x > entorno.ancho() - 17  ;
	}
	
	public boolean chocasteConBordeI(Entorno entorno) {
		return  x <  +17 ;
	}	
	
	public boolean chocasteConArriba(Entorno entorno) {
		return y <  +27  ;
	}
	
	public boolean chocasteConAbajo(Entorno entorno) {
		return  y > entorno.alto() - 27;
	}


	public boolean chocasteConNinjaEnX(Ninjas[] ninja) {	
		for(int i =0;i < ninja.length;i++) {
			if(!ninja[i].getMuerto()) {
				if (ninja[i].getX()+10>=this.x-10 && ninja[i].getY()<=this.y+15&&ninja[i].getX()-10<=this.x+10 && ninja[i].getY()>=this.y-15) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean chocasteConNinjaEnY(Ninjas[] ninja) {
		for(int i =0;i < ninja.length;i++) {
			if(!ninja[i].getMuerto()) {
				if (ninja[i].getY()+15>=this.y-15 && ninja[i].getX()<=this.x+10&&ninja[i].getY()-15<=this.y+15 && ninja[i].getX()>=this.x-10) {
					return true;
				}
			}					
		}
		return false;
	}


	//parametros para que deje la flor en la puerta de la casa derecha
	public boolean dejarFLorD(Flecha flecha) {
		if (this.x+20>=flecha.getX()+20&&this.y+15>=flecha.getY()+30&&this.x-20<=flecha.getX()+20&&this.y-15<=flecha.getY()+30){
			return true;
		}
		return false;
	}
	
	//parametros para que deje la flor en la puerta de la casa izquierda
	public boolean dejarFLorI(Flecha flecha) {
		if (this.x+20>=flecha.getX()-15&&this.y+15>=flecha.getY()+30&&this.x-20<=flecha.getX()-15&&this.y-15<=flecha.getY()+30){
			return true;
		}		
		return false;	
	}
	
	//parametros para que deje la flor en la puerta de la casa que esta dada vuelta
	public boolean dejarFLorA(Flecha flecha) {
		if (this.x+20>=flecha.getX()&&this.y+25>=flecha.getY()+5&&this.x-20<=flecha.getX()&&this.y-25<=flecha.getY()+5){
			return true;
		}
		return false;
	}
	
	//parametros para que deje la flor en la puerta de la casa que esta de frente
	public boolean dejarFLorF(Flecha flecha) {
		if (this.x+20>=flecha.getX()&&this.y-35<=flecha.getY()+84&&this.x-20<=flecha.getX()&&this.y+35>=flecha.getY()+84){
			return true;
		}
		return false;
	}


	public boolean moverVertical() {
		if ((x>=150&&x<=180)||(x>=390 &&x<=415)||(x>=620&&x<=645) && y<=600) {
			return true;
		}
		return false;
	}

	
	public boolean moverHorizontal() {
		if ((y>=85&&y<=105)||(y>=220&&y<=245)||(y>=355&&y<=375)||(y>=490&&y<=510) && x<=800) {
			return true;
		}
		return false;
	}



	public void moverIzquierda() {
		x -= velocidad;
	}

	public void moverDerecha() {
		x += velocidad;
	}
	
	public void moverArriba() {
		y -= velocidad;
	}

	public void moverAbajo() {
		y += velocidad;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;

	}
	public double getVelocidad(){
		return velocidad;
	}
	
	public double setVelocidad(double velocidad) {
		 return this.velocidad=velocidad;
	}

}
