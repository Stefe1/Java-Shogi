package Lepesekhez;

import Fajl_kezeles.Beolvaso;
import Jatek.Tabla;

public class Lerakas extends Mozgas {
	public Lerakas(Tabla tabla,String tipus,int uj_sor, int uj_oszlop) {
		super(tabla,tipus,uj_sor,uj_oszlop);
	}
	

	private void mezo_elhelyezese() {
		jatekter.mezo_modositas(Beolvaso.atalakitas(tipus, uj_sor, uj_oszlop, jatekter.leutott_kivalasztott_feher_e_lekerdezese(), jatekter.kep_beolvaso_lekerdezese(), jatekter), uj_sor, uj_oszlop);
		jatekter.leutott_lekerdezes().kivonas(jatekter.leutott_kivalasztott_feher_e_lekerdezese(), tipus);
		jatekter.lepes_befejezese();
		Sakk_matt_ellenorzo.Check_ellenorzes(jatekter);
	}
	//Megnézi, hogy szabályos lenne-e a lerakás.
	public void lepes() {
		if(!jatekter.feher_checkelve&&!jatekter.fekete_checkelve) {
			if(Lerakas_szabalyok.szabalyos(this.tipus,this.uj_sor,this.uj_oszlop,this.jatekter)) {
				mezo_elhelyezese();
				Sakk_matt_ellenorzo.Check_ellenorzes(jatekter);
			}
			
		}
		else {
			if(Lerakas_szabalyok.szabalyos(tipus, uj_sor, uj_oszlop, jatekter)) {
				if(jatekter.feher_checkelve&&jatekter.leutott_kivalasztott_feher_e_lekerdezese()&&Lepes_ellenorzo.megmento_lerakas(new Tabla(jatekter), uj_sor, uj_oszlop)) {
					mezo_elhelyezese();
					Sakk_matt_ellenorzo.Check_ellenorzes(jatekter);

				}
				else if(jatekter.fekete_checkelve&&!jatekter.leutott_kivalasztott_feher_e_lekerdezese()&&Lepes_ellenorzo.megmento_lerakas(new Tabla(jatekter), uj_sor, uj_oszlop)) {
					mezo_elhelyezese();
					Sakk_matt_ellenorzo.Check_ellenorzes(jatekter);
				}
			}
		}

	}
	//Megnézi, hogy szabályos lenne-e a lerakás, ez a lepes_ellenorzo() miatt szükséges,
	//mert ott el is végzi a lerakást, és az alapján megnézi, hogy változott-e a sakk állapota.
	public void proba_lepes() {
		if(Lerakas_szabalyok.szabalyos(this.tipus,this.uj_sor,this.uj_oszlop,this.jatekter)) {
			mezo_elhelyezese();
		}
	}
}
