package juego;

import java.awt.Color;
import java.awt.Image;
import java.awt.Point;

import javax.sound.sampled.Clip;

import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;
public class Juego extends InterfaceJuego
{
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	private Sakura sakura;
	private Rasengan rasengan;
	private int mov;
	private Flor flor;
	private Image fondo;
	private Image flor_puntos;
	private Image ninjas_muertos;
	private Ninjas[] ninja;
	private Casas[] casas;
	private Floreria floreria;
	private Flecha flecha;
	private int numero;
	private boolean florAtrapada;
	private int ninjaMuerto;
	private int timer;
	private int ninjasMuertos = 0;	
	public int puntosFlores = 0;
	private int aux=0;
	private int cantR;	
	private CantR r1;
	private CantR r2;
	private CantR r3;
	private Ramen ramen;
	private int tiempoRamen=0;
	private int r=0;
	private int t=0;
	private Image tiendaRamen;
	private Clip clip = Sonido.cargarSonido("CancionEditada.wav");
	Point puntoA;
	// Variables y métodos propios de cada grupo

	Juego()
	{
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Sakura Ikebana Delivery - Grupo 2 - v1", 800, 600);		


		ninja=new Ninjas[5];

		ninja[0]=new Ninjas(166,50,2);
		ninja[1]=new Ninjas(634,580,1);
		ninja[2]=new Ninjas(600,99,3);
		ninja[3]=new Ninjas(300,367,4);
		ninja[4]=new Ninjas(780,501,3);


		//Floreria
		floreria = new Floreria(220,455);

		casas=new Casas[42];

		casas[0]= new Casas(200,160,1);
		casas[1]= new Casas(435,160,1);
		casas[2]= new Casas(670,160,1);        
		casas[3]= new Casas(435,430,1);
		casas[4]= new Casas(670,430,1);
		//Casas parate de atras      
		casas[5]= new Casas(60,140,2);
		casas[6]= new Casas(280,140,2);
		casas[7]= new Casas(520,140,2);
		casas[8]= new Casas(750,140,2);        
		casas[9]= new Casas(220,275,2);
		casas[10]= new Casas(455,275,2);
		casas[11]= new Casas(690,275,2);        
		casas[12]= new Casas(60,405,2);
		casas[13]= new Casas(280,405,2);
		casas[14]= new Casas(520,405,2);
		casas[15]= new Casas(750,405,2);    
		casas[16]= new Casas(220,540,2);
		casas[17]= new Casas(455,540,2);
		casas[18]= new Casas(690,540,2);
		//Casas de frente       
		casas[19] = new Casas(60,45,3);
		casas[20] = new Casas(280,45,3);
		casas[21] = new Casas(520,45,3);
		casas[22] = new Casas(750,45,3);        
		casas[23] = new Casas(60,313,3);
		casas[24] = new Casas(280,313,3);
		casas[25] = new Casas(520,313,3);
		casas[26] = new Casas(750,313,3);    
		//Casas mirando hacia la derecha       
		casas[27] = new Casas (595,300,4);
		casas[28] = new Casas (595,430,4);
		casas[29] = new Casas (595,550,4);
		casas[30] = new Casas (595,165,4);
		casas[31] = new Casas (595,40,4);        
		casas[32] = new Casas (363,300,4);
		casas[33] = new Casas (363,430,4);
		casas[34] = new Casas (363,550,4);
		casas[35] = new Casas (363,165,4);
		casas[36] = new Casas (363,40,4);        
		casas[37] = new Casas (128,300,4);
		casas[38] = new Casas (128,430,4);
		casas[39] = new Casas (128,550,4);
		casas[40] = new Casas (128,165,4);
		casas[41] = new Casas (128,40,4);

		numero = (int) (Math.random() * casas.length);

		flecha= new Flecha(casas[numero].getX(), casas[numero].getY()-30);

		florAtrapada=false;
	
		sakura= new Sakura(400, 300);

		flor=new Flor(235,495) ;	

		mov=4;
		
		Herramientas.cargarImagen("rasengan.png");
		
		tiendaRamen = Herramientas.cargarImagen("tienda_ramen.png");
		
		fondo = Herramientas.cargarImagen("aldea_sakura.png");
		
		ninjas_muertos= Herramientas.cargarImagen("Ninja.png");

		flor_puntos = Herramientas.cargarImagen("flor.png");
		// Inicia el juego!
		this.entorno.iniciar();
	}

	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y 
	 * por lo tanto es el método más importante de esta clase. Aquí se debe 
	 * actualizar el estado interno del juego para simular el paso del tiempo 
	 * (ver el enunciado del TP para mayor detalle).
	 */
	public void tick(){	
		//cuenta los tick del juego.
		timer+=1;
		
		//reproduce la cancion en loop.
		if(aux==0) {		
			clip.loop(20);
			aux=1;
		}
		//dibuja los diferentes objetos en el juego.
		entorno.dibujarImagen(fondo, entorno.ancho()/2, entorno.alto()/2, 0, 0.5);
		entorno.dibujarImagen(flor_puntos, 730, 580, 0, 3);
		entorno.dibujarImagen(ninjas_muertos, 30, 575, 0, 1);			
		floreria.dibujar(entorno);
		
		for ( int i=0; i < casas.length ;i++) {
			if (casas[i].getDireccion()==1) {
				casas[i].dibujar1(entorno);
			}
			if (casas[i].getDireccion()==2) {
				casas[i].dibujar3(entorno);
			}
			if (casas[i].getDireccion()==3) {
				casas[i].dibujar2(entorno);
			}
			if (casas[i].getDireccion()==4) {

				casas[i].dibujar(entorno);
			}
		}
		
		entorno.dibujarImagen(tiendaRamen, 520, 192, 0, 1);
		sakura.dibujar(entorno);
		
		//Elige un indice random del array casas y crea una flecha nueva en las coordenadas de esa casa.
		if (florAtrapada) {
			numero = (int) (Math.random() * casas.length);
			flecha= new Flecha(casas[numero].getX(), casas[numero].getY()-30);
			florAtrapada= false;
		}
		
		flecha.dibujar(entorno);


		//recorre el array ninja y los dibuja.
		for(int i =0;i < ninja.length;i++) {	
			
			if(!ninja[i].getMuerto()) {
				ninja[i].dibujar(entorno);			
				ninja[i].mover();	

			}
			//si estan muertos los hace reaparecer en las cooredenadas asignadas cuando el timer es multiplo de 300. 
			else {
				if (timer%300==0) {
					if(i==0) {
						ninja[i].setMuerto(false);
						ninja[i].setX(166);
						ninja[i].setY(0);
					}
					if(i==1) {
						ninja[i].setMuerto(false);
						ninja[i].setX(634);
						ninja[i].setY(600);
					}
					if(i==2) {
						ninja[i].setMuerto(false);
						ninja[i].setX(800);
						ninja[i].setY(99);
					}					
					if(i==3) {
						ninja[i].setMuerto(false);
						ninja[i].setX(0);
						ninja[i].setY(367);
					}					
					if(i==4) {
						ninja[i].setMuerto(false);
						ninja[i].setX(800);
						ninja[i].setY(501);
					}

				}

			}
		}

		// accion de sakura cuando aggara una flor.
		if (flor.agarrarFlor(sakura)) {		
			flor=null;			
		}
		
		// acciones que realiza el rasengan
		if(rasengan != null) {
			rasengan.dibujar(entorno);
			rasengan.mover();			
			ninjaMuerto=rasengan.impactasteNinja(ninja);
			
			if(ninjaMuerto !=-1) {	
				ninjasMuertos=ninjasMuertos+1;
				ninja[ninjaMuerto].setMuerto(true);
				rasengan=null;				
			}
			else {
				if(rasengan.chocoConEntorno(entorno)){					
					rasengan = null;
				}				
			}	
		}

		// moviemiento de sakura
		if (entorno.estaPresionada('a')&&!sakura.chocasteConBordeI(entorno)&&sakura.moverHorizontal()) {
			sakura.moverIzquierda();
			mov=1;
		}
		
		if (entorno.estaPresionada('d')&&!sakura.chocasteConBordeD(entorno)&&sakura.moverHorizontal()) {
			sakura.moverDerecha();
			mov=2;
		}
		
		if (entorno.estaPresionada('w')&&!sakura.chocasteConArriba(entorno)&&sakura.moverVertical()) {
			sakura.moverArriba();
			mov=3;
		}
		
		if (entorno.estaPresionada('s')&&!sakura.chocasteConAbajo(entorno)&&sakura.moverVertical()) {
			sakura.moverAbajo();
			mov=4;
		}
		//se fija si se apreto la tecla espacio y si no hay otro rasengan creado, de ser asi crea un nuevo rasengan
		if (entorno.sePresiono(entorno.TECLA_ESPACIO)&&cantR<3) {
			if(rasengan == null) {
				rasengan= new Rasengan(sakura.getX(),sakura.getY(),mov);
				cantR=cantR+1;
			}			
		}

		//crea el ramen
		if(r==0&&timer>=50) {
			tiempoRamen=0;
			ramen = new Ramen(520,230);				
			ramen.dibujar(entorno);					
		}
		
		if(r==1) {
			t=t+1;
		}
		//si un ramen fue agarrado hace aparecer otro cada 1500 ticks(30seg)
		if(t==1500) {
			r=0;
			t=0;
		}
		//si sakura agarra un ramen su velocidad se duplica por un periodo de 250 ticks(5seg)
		if(ramen!=null&&ramen.agarrarRamen(sakura)) {
			sakura.setVelocidad(2);
			r=1;
			ramen=null;		
		}
		if(sakura.getVelocidad()==2) {
			tiempoRamen=tiempoRamen+1;
			if(tiempoRamen>=250) {
				sakura.setVelocidad(1);				
			}
		}	


		// crea a la flor en las coordenadas de Sakura y la dibuja.
		if (flor==null) {
			flor=new Flor(sakura.getX(),sakura.getY());
			flor.dibujar(entorno);
			
			//se fija si las coordenadas de Sakura coinciden con las de la casa asignada y edja la flor si estas coinciden
			if(casas[numero].getDireccion()==4&&sakura.dejarFLorD(flecha)) {
				puntosFlores=puntosFlores+5;
				cantR=0;
				flor=new Flor(235,495);	
				florAtrapada=true;			
			}
			
			if(casas[numero].getDireccion()==3&&sakura.dejarFLorF(flecha)) {
				puntosFlores=puntosFlores+5;
				cantR=0;
				flor=new Flor(235,495);	
				florAtrapada=true;
			}
			
			if(casas[numero].getDireccion()==2&&sakura.dejarFLorA(flecha)) {
				puntosFlores=puntosFlores+5;
				cantR=0;
				flor=new Flor(235,495);	
				florAtrapada=true;			
			}
			
			if(casas[numero].getDireccion()==1&&sakura.dejarFLorI(flecha)) {
				puntosFlores=puntosFlores+5;
				cantR=0;
				flor=new Flor(235,495);	
				florAtrapada=true;
			}
		}

		//muestra la cantidad de rasengan disponibles
		r1=new CantR(sakura.getX()-12,sakura.getY()-22);
		
		r2=new CantR(sakura.getX(),sakura.getY()-22);
		
		r3=new CantR(sakura.getX()+12,sakura.getY()-22);

		if(cantR<3&&r1!=null&&r2!=null&&r3!=null) {
			r1=new CantR(sakura.getX()-12,sakura.getY()-22);
			r1.dibujar(entorno);

			if(cantR<2) {			
				r2=new CantR(sakura.getX(),sakura.getY()-22);
				r2.dibujar(entorno);	
			}
			if(cantR<1) {						
				r3=new CantR(sakura.getX()+12,sakura.getY()-22);
				r3.dibujar(entorno);
			}
		}

		entorno.cambiarFont("8BIT WONDER", 20 , Color.BLACK);

		entorno.escribirTexto(""+puntosFlores, 755, 590);

		entorno.escribirTexto(""+ninjasMuertos, 50, 590);
		//aumenta la dificultad segun los puntos alcanzados
		if(puntosFlores==25) {
			for(int i =0;i < ninja.length;i++) {
				ninja[i].setN(2);
			}
		}
		
		if(puntosFlores==50) {
			for(int i =0;i < ninja.length;i++) {
				ninja[i].setN(3);
			}
		}
		
		//si un ninja alcanza a Sakura se termina el juego
		if (sakura.chocasteConNinjaEnX(ninja)||sakura.chocasteConNinjaEnY(ninja)){
			Ventana_GameOver.main(null);
			clip.stop();
			entorno.dispose();				
		}
		//si se llega a la suma de 75 puntos se gana el juego
		if(puntosFlores==75) {
			Ventana_Ganaste.main(null);
			clip.stop();
			entorno.dispose();			
		}
	}	

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
		
	}
}
