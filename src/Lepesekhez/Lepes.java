package Lepesekhez;

import Babuk.Babu;
import Jatek.Tabla;

public class Lepes extends Mozgas {
	public Lepes(Tabla tabla,Babu mozgatni_valo ,int uj_sor, int uj_oszlop) {
		super(tabla,mozgatni_valo,uj_sor,uj_oszlop);
	}
	//Megnézi, hogy a mozgatni való bábu az ellenfelének az első 3 sorába lépett-e be. Ha igen akkor meghívja a bábu eloleptetes függvényét, és azzá változik át.
	private Babu eloleptetes(Babu mozgatni_valo ,int uj_sor, int uj_oszlop) {
		if(uj_sor<=2&&mozgatni_valo.feher_e()||uj_sor>=6&&!mozgatni_valo.feher_e()) {
			Babu elolepes=mozgatni_valo.eloleptetes();
			if(elolepes!=mozgatni_valo) {
				mozgatni_valo=elolepes;
			}
		}
		return mozgatni_valo;
	}
	//Kicseréli az cél mező tartalmát a mozgatni való bábuval, és befejezi a lépést.
	private void babuk_cserelese(Babu mozgatni_valo ,int uj_sor, int uj_oszlop) {
		jatekter.mezo_modositas(null, mozgatni_valo.sor_lekerdezes(), mozgatni_valo.oszlop_lekerdezes());
		jatekter.mezo_modositas(mozgatni_valo, uj_sor, uj_oszlop);
		jatekter.lepes_befejezese();
	}

	//Megnézi, hogy az egy érvényes lépés lenne-e, csak akkor végzi el a lépést, ha nem foglalt a mező, vagy ha foglalt, akkor nem egy csapattársa.
	public void lepes() {
		if(mozgatni_valo.ervenyes_lepes(uj_sor, uj_oszlop)) {
			if(jatekter.foglalt_mezo_e(uj_sor, uj_oszlop)&&jatekter.mezo_lekerdezes(uj_sor, uj_oszlop).feher_e()!=mozgatni_valo.feher_e()||!jatekter.foglalt_mezo_e(uj_sor, uj_oszlop)) {
				mozgatni_valo=eloleptetes(mozgatni_valo, uj_sor, uj_oszlop);
				if(jatekter.foglalt_mezo_e(uj_sor, uj_oszlop)) {
					jatekter.mezo_lekerdezes(uj_sor, uj_oszlop).leutve();
				}
				babuk_cserelese(mozgatni_valo, uj_sor, uj_oszlop);
				Sakk_matt_ellenorzo.Check_ellenorzes(jatekter);
			}
		}
	}
	//Ugyan azt csinálja, mint a lepes() függvény, csak itt a lepes_szabaly() függvényt használja, hogy a lepes_ellenorzo() ellenőrizni tudja, hogy eltűnt a sakk.
	public void proba_lepes() {
		if(mozgatni_valo.lepes_szabaly(uj_sor, uj_oszlop)) {
			if(jatekter.foglalt_mezo_e(uj_sor, uj_oszlop)&&jatekter.mezo_lekerdezes(uj_sor, uj_oszlop).feher_e()!=mozgatni_valo.feher_e()||!jatekter.foglalt_mezo_e(uj_sor, uj_oszlop)) {
				mozgatni_valo=eloleptetes(mozgatni_valo, uj_sor, uj_oszlop);
				babuk_cserelese(mozgatni_valo, uj_sor, uj_oszlop);
				Sakk_matt_ellenorzo.Kissebb_eroforrasu_check_ellenorzes(jatekter,mozgatni_valo);
			}
		}
	}
}
