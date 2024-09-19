package Babuk;

import Fajl_kezeles.Kep_beolvaso;
import Jatek.Tabla;

public class Ezust_tabornok extends Babu{
	public Ezust_tabornok(int sor, int oszlop, boolean feher, Kep_beolvaso kep_hash,Tabla jatekter) {
		super(sor, oszlop, feher,kep_hash,"ezust_tabornok",jatekter);
	}
	//típus lekérdezése
	public String tipus_lekerdezes() {
		return "ezust_tabornok";
	}
	//a bábuhoz tartozó lépészabályt vizsgálja meg
	public boolean lepes_szabaly( int uj_sor,int uj_oszlop) {
		if(feher) {
			if ((this.sor-1<=uj_sor&&this.sor+1>=uj_sor&&this.oszlop-1<=uj_oszlop&&this.oszlop+1>=uj_oszlop)&&!(this.sor==uj_sor&&this.oszlop==uj_oszlop)&&!(this.sor==uj_sor&&this.oszlop-1==uj_oszlop)&&!(this.sor==uj_sor&&this.oszlop+1==uj_oszlop)&&!(this.sor+1==uj_sor&&this.oszlop==uj_oszlop)) {
				return true;
			}
		}
		else {
			if ((this.sor-1<=uj_sor&&this.sor+1>=uj_sor&&this.oszlop-1<=uj_oszlop&&this.oszlop+1>=uj_oszlop)&&!(this.sor==uj_sor&&this.oszlop==uj_oszlop)&&!(this.sor==uj_sor&&this.oszlop-1==uj_oszlop)&&!(this.sor==uj_sor&&this.oszlop+1==uj_oszlop)&&!(this.sor-1==uj_sor&&this.oszlop==uj_oszlop)) {
				return true;
			}
		}
		return false;
	}
	//Ha eléri a másik oldal utolsó 3 sorát, akkor előléptetődik egy erősebb bábura
	public Babu eloleptetes() {
		return new Eloleptetett_ezust_tabornok(this.sor, this.oszlop, this.feher, elolepeshez,jatekter);
	}
	//Ha leütődik, akkor hozzá adódik az ellenkező szín leütött bábujai közé
	public void leutve() {
		this.jatekter.leutott_lekerdezes().hozzadas(!this.feher, tipus_lekerdezes());
	}
}
