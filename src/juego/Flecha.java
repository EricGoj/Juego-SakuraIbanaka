package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Flecha {
	private int x;
    private int y;
    Image imgflecha;

    public Flecha (int x,int y) {
        this.x=x;
        this.y=y;

        imgflecha = Herramientas.cargarImagen("flecha_abajo.png");
    }
    public void dibujar(Entorno entorno) {
        entorno.dibujarImagen(imgflecha, this.x, this.y, 0, 2.5);
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }


}

