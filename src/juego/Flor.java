package juego;

import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;
 
public class Flor {
	private int x;
	private int y;
	Image imgF;
		
	public Flor(int x, int y) {
		this.x=x;
		this.y=y;
		imgF = Herramientas.cargarImagen("flor.png");

}	
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void dibujar(Entorno entorno) {
		entorno.dibujarImagen(imgF, x, y, 0, 1);
		
}
	
	
	public boolean agarrarFlor(Sakura sakura) {
		 if (sakura.getX()+10>= this.x-5 && sakura.getY()+15>=this.y+5&&sakura.getX()-10<= this.x+5 && sakura.getY()-15<=this.y-5){
			 return true;
		 }
		 return false;
	 }
	

	
	


}