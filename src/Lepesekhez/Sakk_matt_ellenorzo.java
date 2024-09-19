package Lepesekhez;

import Babuk.Babu;
import Jatek.Tabla;

public final class Sakk_matt_ellenorzo {
	//megnézi, hogy ennek a bábunak van e olyan lépése ami megmentené a csapatát
	private static boolean Sakk_matt_check_belseje(Tabla jatekter,boolean feher, int sor, int oszlop) {
		for(int i=0;i<9;i++) {
			for(int c=0;c<9;c++) {
				Tabla klon=new Tabla(jatekter);
				klon.kivalasztott_modositasa(klon.mezo_lekerdezes(sor, oszlop));
				if(Lepes_ellenorzo.megmenti(klon, i, c)) {
					return true;
				}
			}
		}
		
		
		return false;
	}
	//megnézi, hogy van-e olyan lerakás, amely megmentené a csapatát
	private static boolean Sakk_matt_check_leutottes_belseje(Tabla jatekter,String tipus, boolean feher) {
		for(int i=0;i<9;i++) {
			for(int c=0;c<9;c++) {
				Tabla klon=new Tabla(jatekter);
				klon.leutott_kivalasztott_modositasa(tipus);
				klon.leutott_kivalasztott_feher_e_modositasa(feher);
				if(Lepes_ellenorzo.megmento_lerakas(klon, i, c)) {
					return true;
				}
			}
		}
		
		
		return false;
	}
	//Addig fut, amíg nem talál egy olyan lépést/lerakást, ami meg tudná menteni a csapatát. Ha nem talált egy ilyen lépést, akkor visszajelez, hogy sakk-matt van.
	public static boolean Sakk_matt_check(Tabla jatekter,boolean feher) {
		for(int i=0;i<9;i++) {
			for(int c=0;c<9;c++) {
				if(jatekter.foglalt_mezo_e(i, c)&&jatekter.mezo_lekerdezes(i, c).feher_e()==feher) {
					if(Sakk_matt_check_belseje(jatekter,feher, i, c)) {
						return false;
					}
				}
			}
		}
		if(jatekter.leutott_lekerdezes().van_belole("gyalog", feher)) {
			if(Sakk_matt_check_leutottes_belseje(jatekter,"gyalog", feher)) return false;
		}
		if(jatekter.leutott_lekerdezes().van_belole("jari", feher)) {
			if(Sakk_matt_check_leutottes_belseje(jatekter,"jari", feher)) return false;
		}
		if(jatekter.leutott_lekerdezes().van_belole("lovas", feher)) {
			if(Sakk_matt_check_leutottes_belseje(jatekter,"lovas", feher)) return false;
		}
		if(jatekter.leutott_lekerdezes().van_belole("futo", feher)) {
			if(Sakk_matt_check_leutottes_belseje(jatekter,"futo", feher)) return false;
		}
		if(jatekter.leutott_lekerdezes().van_belole("bastya", feher)) {
			if(Sakk_matt_check_leutottes_belseje(jatekter,"bastya", feher)) return false;
		}
		if(jatekter.leutott_lekerdezes().van_belole("ezust_tabornok", feher)) {
			if(Sakk_matt_check_leutottes_belseje(jatekter,"ezust_tabornok", feher)) return false;
		}
		if(jatekter.leutott_lekerdezes().van_belole("arany_tabornok", feher)) {
			if(Sakk_matt_check_leutottes_belseje(jatekter,"arany_tabornok", feher)) return false;
		}
		
		return true;
	}
	//Megnézi, hogy van-e olyan bábuja a paraméter által meghatározott csapatban, ami veszélyezteti az ellenséges királyt.
	private static boolean Kiraly_checkelve( Tabla jatekter,boolean feher) {
		Babu kiraly=jatekter.kiraly_kereso(!feher);
		if(kiraly==null) return true;
		for(int i=0;i<9;i++) {
			for(int c=0;c<9;c++) {
				if(jatekter.foglalt_mezo_e(i, c)&&jatekter.mezo_lekerdezes(i, c).feher_e()==feher&&jatekter.mezo_lekerdezes(i, c).lepes_szabaly(kiraly.sor_lekerdezes(), kiraly.oszlop_lekerdezes())) {
					return true;
				}
			}
		}
		return false;
	}
	//Megnézi, hogy a mozgatni való bábu a lépésével sakk-ba keríti a csapatát, vagy kikeríti magát onnan.
	public static void Kissebb_eroforrasu_check_ellenorzes(Tabla jatekter,Babu mozgatnivalo) {
		if(mozgatnivalo.feher_e()) {
			if(Kiraly_checkelve(jatekter,false)) {
				jatekter.feher_checkelve=true;
			}
			else {
				jatekter.feher_checkelve=false;
			}
		}
		else {
			if(Kiraly_checkelve(jatekter,true)) {
				jatekter.fekete_checkelve=true;
			}
			else {
				jatekter.fekete_checkelve=false;
			}
		}
//		
	}
	//Megnézi mind a két színre, hogy sakkban van-e és attól függetlenül mind a két színre futattat egy sakk-matt checket is.
	public static void Check_ellenorzes(Tabla jatekter) {
		if(Kiraly_checkelve(jatekter,true)) {
			jatekter.fekete_checkelve=true;
			if(Sakk_matt_ellenorzo.Sakk_matt_check(jatekter,false)) {
				jatekter.vege_modositas(true);
			}
			
		}
		else {
			if(Sakk_matt_ellenorzo.Sakk_matt_check(jatekter,false)) {
				jatekter.vege_modositas(true);
			}
			jatekter.fekete_checkelve=false;
		}
		if(Kiraly_checkelve(jatekter,false)) {
			jatekter.feher_checkelve=true;
			if(Sakk_matt_ellenorzo.Sakk_matt_check(jatekter,true)) {
				jatekter.vege_modositas(true);
			}
			
		}
		else {
			if(Sakk_matt_ellenorzo.Sakk_matt_check(jatekter,true)) {
				jatekter.vege_modositas(true);
			}
			jatekter.feher_checkelve=false;
		}
	}
}
