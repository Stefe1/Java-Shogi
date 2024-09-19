package Lepesekhez;

import Jatek.Tabla;

public final class Lepes_ellenorzo {
	//megnézi, hogy a kiválasztott bábu adott lépése megmenti-e a sakktól a saját királyát
	public static boolean megmenti(Tabla jatekter,int sor, int oszlop) {
		if(jatekter.kivalasztott_lekerdezese().lepes_szabaly(sor, oszlop)&&jatekter.kivalasztott_lekerdezese().feher_e()) {
			Lepes mozgas=new Lepes(jatekter,jatekter.kivalasztott_lekerdezese(), sor, oszlop);
			mozgas.proba_lepes();
			if(!jatekter.feher_checkelve) {
				return true;
			}
		}
		else if(jatekter.kivalasztott_lekerdezese().lepes_szabaly(sor, oszlop)&&!jatekter.kivalasztott_lekerdezese().feher_e()) {
			Lepes mozgas=new Lepes(jatekter,jatekter.kivalasztott_lekerdezese(), sor, oszlop);
			mozgas.proba_lepes();
			if(!jatekter.fekete_checkelve) {
				return true;
			}
		}
		return false;
	}
	//megnézi, hogy a kiválasztott bábu lerakása megmenti-e a sakktól a saját királyát
	public static boolean megmento_lerakas(Tabla jatekter,int sor, int oszlop) {
		if(jatekter.leutott_kivalasztott_feher_e_lekerdezese()) {
			Lerakas mozgas=new Lerakas(jatekter, jatekter.leutott_kivalasztott_lekerdezese(),sor, oszlop);
			mozgas.proba_lepes();
			if(!jatekter.feher_checkelve) {
				return true;
			}
		}
		else if(!jatekter.leutott_kivalasztott_feher_e_lekerdezese()) {
			Lerakas mozgas=new Lerakas(jatekter, jatekter.leutott_kivalasztott_lekerdezese(),sor, oszlop);
			mozgas.proba_lepes();
			if(!jatekter.fekete_checkelve) {
				return true;
			}
		}
		return false;
	}
}
