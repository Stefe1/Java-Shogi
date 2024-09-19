package Babuk;

import Fajl_kezeles.Kep_beolvaso;
import Jatek.Tabla;

public class Lovas extends Babu{
	public Lovas(int sor, int oszlop, boolean feher, Kep_beolvaso kep_hash,Tabla jatekter) {
		super(sor, oszlop, feher,kep_hash,"lovas",jatekter);
	}
	//típus lekérdezése
	public String tipus_lekerdezes() {
		return "lovas";
	}
	//a bábuhoz tartozó lépészabályt vizsgálja meg
	public boolean lepes_szabaly( int uj_sor,int uj_oszlop) {
		if(this.feher) {
			if (this.sor-2==uj_sor&&uj_oszlop==this.oszlop-1||this.sor-2==uj_sor&&uj_oszlop==this.oszlop+1) {
				return true;
			}
		}
		else {
			if (this.sor+2==uj_sor&&uj_oszlop==this.oszlop-1||this.sor+2==uj_sor&&uj_oszlop==this.oszlop+1) {
				return true;
			}
		}
		return false;
	}
	//Ha eléri a másik oldal utolsó 3 sorát, akkor előléptetődik egy erősebb bábura
	public Babu eloleptetes() {
		return new Eloleptetett_lovas(this.sor, this.oszlop, this.feher, elolepeshez,jatekter);
	}
	//Ha leütődik, akkor hozzá adódik az ellenkező szín leütött bábujai közé
	public void leutve() {
		this.jatekter.leutott_lekerdezes().hozzadas(!this.feher, tipus_lekerdezes());
	}
}
