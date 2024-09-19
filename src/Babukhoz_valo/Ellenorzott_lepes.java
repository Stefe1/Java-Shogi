package Babukhoz_valo;

import Babuk.Babu;
import Jatek.Tabla;
import Lepesekhez.Lepes_ellenorzo;

public final class Ellenorzott_lepes {
	//Megnézi, hogy ha az adott mezőre lépne, az megfelelne-e a lépés szabálynak, és hogy azzal nem-e teszi sakkba a saját királyát
	public static boolean ervenyes_lepes(Babu babu,int uj_sor,int uj_oszlop) {
		if(babu.feher_e()) {
			return babu.lepes_szabaly(uj_sor, uj_oszlop)&&Lepes_ellenorzo.megmenti(new Tabla(babu.tabla_lekerdezes()),uj_sor, uj_oszlop);
		}
		else if(!babu.feher_e()) {
			return babu.lepes_szabaly(uj_sor, uj_oszlop)&&Lepes_ellenorzo.megmenti(new Tabla(babu.tabla_lekerdezes()),uj_sor, uj_oszlop);
		}
		return false;
	}
}
