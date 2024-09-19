package Babuk;

import Fajl_kezeles.Kep_beolvaso;
import Jatek.Tabla;

public class Futo extends Babu {
	public Futo(int sor, int oszlop, boolean feher, Kep_beolvaso kep_hash,Tabla tabla) {
		super(sor, oszlop, feher,kep_hash,"futo",tabla);
	}
	//típus lekérdezése
	public String tipus_lekerdezes() {
		return "futo";
	}
	//a bábuhoz tartozó lépészabályt vizsgálja meg
	public boolean lepes_szabaly( int uj_sor,int uj_oszlop) {
		//fel-balra csekkolás
		int temp_sor=this.sor-1;
		int temp_oszlop=this.oszlop-1;
		while(temp_sor>=0&&temp_oszlop>=0) {
			if(temp_sor==uj_sor&&temp_oszlop==uj_oszlop) {
				return true;
			}
			if(jatekter.foglalt_mezo_e(temp_sor, temp_oszlop)) {
				if(jatekter.mezo_lekerdezes(temp_sor, temp_oszlop).feher_e()!=this.feher&&temp_sor==uj_sor&&temp_oszlop==uj_oszlop) {
					return true;
				}
				else {
					break;
				}
			}
			temp_sor--;
			temp_oszlop--;
		}
		//le-balra csekkolas
		temp_sor=this.sor+1;
		temp_oszlop=this.oszlop-1;
		while(temp_sor<=8&&temp_oszlop>=0) {
			if(temp_sor==uj_sor&&temp_oszlop==uj_oszlop) {
				return true;
			}
			if(jatekter.foglalt_mezo_e(temp_sor, temp_oszlop)) {
				if(jatekter.mezo_lekerdezes(temp_sor, temp_oszlop).feher_e()!=this.feher&&temp_sor==uj_sor&&temp_oszlop==uj_oszlop) {
					return true;
				}
				else {
					break;
				}
			}
			temp_sor++;
			temp_oszlop--;
		}
		//fel-jobbra csekkolás
		temp_sor=this.sor-1;
		temp_oszlop=this.oszlop+1;
		while(temp_oszlop<=8&&temp_sor>=0) {
			if(temp_oszlop==uj_oszlop&&temp_sor==uj_sor) {
				return true;
			}
			if(jatekter.foglalt_mezo_e(temp_sor, temp_oszlop)) {
				if(jatekter.mezo_lekerdezes(temp_sor, temp_oszlop).feher_e()!=this.feher&&temp_sor==uj_sor&&temp_oszlop==uj_oszlop) {
					return true;
				}
				else {
					break;
				}
			}
			temp_sor--;
			temp_oszlop++;
		}
		//le-jobbra csekkolás
		temp_sor=this.sor+1;
		temp_oszlop=this.oszlop+1;
		while(temp_oszlop<=8&&temp_sor<=8) {
			if(temp_oszlop==uj_oszlop&&temp_sor==uj_sor) {
				return true;
			}
			if(jatekter.foglalt_mezo_e(temp_sor, temp_oszlop)) {
				if(jatekter.mezo_lekerdezes(temp_sor, temp_oszlop).feher_e()!=this.feher&&temp_sor==uj_sor&&temp_oszlop==uj_oszlop) {
					return true;
				}
				else {
					break;
				}
			}
			temp_sor++;
			temp_oszlop++;
		}
		return false;
	}
	//Ha eléri a másik oldal utolsó 3 sorát, akkor előléptetődik egy erősebb bábura
	public Babu eloleptetes() {
		return new Eloleptetett_futo(this.sor, this.oszlop, this.feher, elolepeshez,this.jatekter);
	}
	//Ha leütődik, akkor hozzá adódik az ellenkező szín leütött bábujai közé
	public void leutve() {
		this.jatekter.leutott_lekerdezes().hozzadas(!this.feher, tipus_lekerdezes());
	}
}
