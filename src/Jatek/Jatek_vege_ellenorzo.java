package Jatek;

import Kepernyo.My_Frame;
//egy száll ami nézi, hogy vége van e a játéknak
public class Jatek_vege_ellenorzo extends Thread {
	private Tabla jatek;
	private My_Frame program;
	private Jatek_vege jv;
	public Jatek_vege_ellenorzo(My_Frame mf,Tabla jatekter, Jatek_vege jv) {
		jatek=jatekter;
		program=mf;
		this.jv=jv;
	}
	
	
	public void run() {
		while(!jatek.vege_lekerdezes()) {
			jv.vege(jatek, program);
		}
	}
}
