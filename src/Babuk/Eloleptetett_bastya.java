package Babuk;

import Fajl_kezeles.Kep_beolvaso;
import Jatek.Tabla;

public class Eloleptetett_bastya extends Babu{
	public Eloleptetett_bastya(int sor, int oszlop, boolean feher, Kep_beolvaso kep_hash,Tabla tabla) {
		super(sor, oszlop, feher,kep_hash,"eloleptetett_bastya",tabla);
	}
	//típus lekérdezése
	public String tipus_lekerdezes() {
		return "eloleptetett_bastya";
	}
	//a bábuhoz tartozó lépészabályt vizsgálja meg
	public boolean lepes_szabaly( int uj_sor,int uj_oszlop) {
		if ((this.sor-1<=uj_sor&&this.sor+1>=uj_sor&&this.oszlop-1<=uj_oszlop&&this.oszlop+1>=uj_oszlop)&&!(this.sor==uj_sor&&this.oszlop==uj_oszlop)) {
			return true;
		}
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
	//Ha leütődik, akkor hozzá adódik az ellenkező szín leütött bábujai közé
	public void leutve() {
		this.jatekter.leutott_lekerdezes().hozzadas(!this.feher, "bastya");
	}

}
