package Babuk;

import Fajl_kezeles.Kep_beolvaso;
import Jatek.Tabla;

public class Eloleptetett_jari extends Babu {
	public Eloleptetett_jari(int sor, int oszlop, boolean feher, Kep_beolvaso kep_hash,Tabla jatekter) {
		super(sor, oszlop, feher,kep_hash,"eloleptetett_jari",jatekter);
	}
	//típus lekérdezése
	public String tipus_lekerdezes() {
		return "eloleptetett_jari";
	}
	//a bábuhoz tartozó lépészabályt vizsgálja meg
	public boolean lepes_szabaly( int uj_sor,int uj_oszlop) {
		if(feher) {
			if ((this.sor-1<=uj_sor&&this.sor+1>=uj_sor&&this.oszlop-1<=uj_oszlop&&this.oszlop+1>=uj_oszlop)&&!(this.sor==uj_sor&&this.oszlop==uj_oszlop)&&!(this.sor+1==uj_sor&&this.oszlop-1==uj_oszlop)&&!(this.sor+1==uj_sor&&this.oszlop+1==uj_oszlop)) {
				return true;
			}
		}
		else {
			if ((this.sor-1<=uj_sor&&this.sor+1>=uj_sor&&this.oszlop-1<=uj_oszlop&&this.oszlop+1>=uj_oszlop)&&!(this.sor==uj_sor&&this.oszlop==uj_oszlop)&&!(this.sor-1==uj_sor&&this.oszlop-1==uj_oszlop)&&!(this.sor-1==uj_sor&&this.oszlop+1==uj_oszlop)) {
				return true;
			}
		}
		return false;
	}
	//Ha leütődik, akkor hozzá adódik az ellenkező szín leütött bábujai közé
	public void leutve() {
		this.jatekter.leutott_lekerdezes().hozzadas(!this.feher, "jari");
	}
}
