package Babuk;


import Fajl_kezeles.Kep_beolvaso;
import Jatek.Tabla;

public class Gyalog extends Babu {
	public Gyalog(int sor, int oszlop, boolean feher, Kep_beolvaso kep_hash,Tabla jatekter) {
		super(sor, oszlop, feher,kep_hash,"gyalog",jatekter);
	}
	//típus lekérdezése
	public String tipus_lekerdezes() {
		return "gyalog";
	}
	//a bábuhoz tartozó lépészabályt vizsgálja meg
	public boolean lepes_szabaly( int uj_sor,int uj_oszlop) {
		if(this.feher) {
			if(uj_sor==this.sor-1&&this.oszlop==uj_oszlop) {
				return true;
			}
		}
		else {
			if(uj_sor==this.sor+1&&this.oszlop==uj_oszlop) {
				return true;
			}
		}
		return false;
	}
	//Ha eléri a másik oldal utolsó 3 sorát, akkor előléptetődik egy erősebb bábura
	public Babu eloleptetes() {
		return new Eloleptetett_gyalog(this.sor, this.oszlop, this.feher, elolepeshez,jatekter);
	}
	//Ha leütődik, akkor hozzá adódik az ellenkező szín leütött bábujai közé
	public void leutve() {
		this.jatekter.leutott_lekerdezes().hozzadas(!this.feher, tipus_lekerdezes());
	}
}
