package Babuk;

import Fajl_kezeles.Kep_beolvaso;
import Jatek.Tabla;

public class Jari extends Babu {
	public Jari(int sor, int oszlop, boolean feher, Kep_beolvaso kep_hash,Tabla tabla) {
		super(sor, oszlop, feher,kep_hash,"jari",tabla);
	}
	//típus lekérdezése
	public String tipus_lekerdezes() {
		return "jari";
	}
	//a bábuhoz tartozó lépészabályt vizsgálja meg
	public boolean lepes_szabaly( int uj_sor,int uj_oszlop) {
		if(this.feher_e()) {
			int temp_sor=this.sor-1;
			while(temp_sor>=0) {
				if(temp_sor==uj_sor&&this.oszlop==uj_oszlop) {
					return true;
				}
				if(jatekter.foglalt_mezo_e(temp_sor, this.oszlop)) {
					if(jatekter.mezo_lekerdezes(temp_sor, this.oszlop).feher_e()!=this.feher&&temp_sor==uj_sor&&this.oszlop==uj_oszlop) {
						return true;
					}
					else {
						break;
					}
				}
				temp_sor--;
				
			}
		}
		else {
			int temp_sor=this.sor+1;
			while(temp_sor<=8) {
				if(temp_sor==uj_sor&&this.oszlop==uj_oszlop) {
					return true;
				}
				if(jatekter.foglalt_mezo_e(temp_sor, this.oszlop)) {
					if(jatekter.mezo_lekerdezes(temp_sor, this.oszlop).feher_e()!=this.feher&&temp_sor==uj_sor&&this.oszlop==uj_oszlop) {
						return true;
					}
					else {
						break;
					}
				}

				temp_sor++;
				
			}
		}
		return false;
	}
	//Ha eléri a másik oldal utolsó 3 sorát, akkor előléptetődik egy erősebb bábura
	public Babu eloleptetes() {
		return new Eloleptetett_jari(this.sor, this.oszlop, this.feher, elolepeshez,jatekter);
	}
	//Ha leütődik, akkor hozzá adódik az ellenkező szín leütött bábujai közé
	public void leutve() {
		this.jatekter.leutott_lekerdezes().hozzadas(!this.feher, tipus_lekerdezes());
	}
}
