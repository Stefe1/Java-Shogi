package Babuk;

import Fajl_kezeles.Kep_beolvaso;
import Jatek.Tabla;

public class Bastya extends Babu {
	private Tabla jatekter;
	public Bastya(int sor, int oszlop, boolean feher, Kep_beolvaso kep_hash,Tabla tabla) {
		super(sor, oszlop, feher,kep_hash,"bastya",tabla);
		this.jatekter=tabla;
	}
	//típus lekérdezése
	public String tipus_lekerdezes() {
		return "bastya";
	}
	//a bábuhoz tartozó lépészabályt vizsgálja meg
	public boolean lepes_szabaly( int uj_sor,int uj_oszlop) {
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
		temp_sor=this.sor+1;
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
		int temp_oszlop=this.oszlop-1;
		while(temp_oszlop>=0) {
			if(temp_oszlop==uj_oszlop&&this.sor==uj_sor) {
				return true;
			}
			if(jatekter.foglalt_mezo_e(this.sor, temp_oszlop)) {
				if(jatekter.mezo_lekerdezes(this.sor, temp_oszlop).feher_e()!=this.feher&&this.sor==uj_sor&&temp_oszlop==uj_oszlop) {
					return true;
				}
				else {
					break;
				}
			}
			
			temp_oszlop--;
		}
		temp_oszlop=this.oszlop+1;
		while(temp_oszlop<=8) {
			if(temp_oszlop==uj_oszlop&&this.sor==uj_sor) {
				return true;
			}
			if(jatekter.foglalt_mezo_e(this.sor, temp_oszlop)) {
				if(jatekter.mezo_lekerdezes(this.sor, temp_oszlop).feher_e()!=this.feher&&this.sor==uj_sor&&temp_oszlop==uj_oszlop) {
					return true;
				}
				else {
					break;
				}
			}
			temp_oszlop++;
		}
		return false;
	}
	//Ha eléri a másik oldal utolsó 3 sorát, akkor előléptetődik egy erősebb bábura
	public Babu eloleptetes() {
		return new Eloleptetett_bastya(this.sor, this.oszlop, this.feher, elolepeshez,this.jatekter);
	}
	//Ha leütődik, akkor hozzá adódik az ellenkező szín leütött bábujai közé
	public void leutve() {
		this.jatekter.leutott_lekerdezes().hozzadas(!this.feher, tipus_lekerdezes());
	}
}

