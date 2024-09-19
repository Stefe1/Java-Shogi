package Jatek;

import java.util.Random;

//Egy szál, ami megvárja a saját körét, amit a paraméterben dönt el, az boolean értéke alapján, majd pedig az előbb ismertetett osztály segítségével lép egyet.
public class Robot extends Thread {
	private Robot_lepes rl;
	private Tabla jatekter;
	private boolean feher;
	private int hanyadik;
	public Robot(Tabla jatekter,boolean feher, Robot_lepes rl) {
		this.jatekter=jatekter;
		this.feher=feher;
		if(feher) {
			hanyadik=1;
		}
		else {
			hanyadik=0;
		}
		this.rl=rl;
	}



	public void vege() {
		while(!jatekter.vege_lekerdezes()) {
			while(jatekter.lepes_lekerdezes()%2!=hanyadik||jatekter.vege_lekerdezes()) {
				try {
					Thread.sleep(100);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			rl.lepes( jatekter, feher);
			
		}
	}
	
	@Override
	public void run() {
		vege();
	}
}
