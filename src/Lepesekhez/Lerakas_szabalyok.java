package Lepesekhez;

import Jatek.Tabla;

public final class Lerakas_szabalyok {
	//Ellenőrzi, hogy a típus az gyalog vagy jari, vagy lovas,
	//mert ezeket nem lehet lerakni az utolsó sorban, vagy a lovas esetében még az utolsó előttibe se, mert onnan nem tudnának elmozdulni.
	public static boolean lepes_nelkuliek_szabaly(String tipus,int uj_sor,int uj_oszlop,Tabla jatekter) {
		if(tipus.equals("gyalog")||tipus.equals("jari")||tipus.equals("lovas")) {
			if(jatekter.leutott_kivalasztott_feher_e_lekerdezese()&&(uj_sor==0||tipus.equals("lovas")&&uj_sor==1)) {
				return false;
			}
			if(!jatekter.leutott_kivalasztott_feher_e_lekerdezese()&&(uj_sor==8||tipus.equals("lovas")&&uj_sor==7)) {
				return false;
			}
		}
		return true;
	}
	//Ellenőrzi, hogy van-e más gyalog bábu a kiválasztott oszlopban, ugyan olyan színben.
	public static boolean ket_gyalog_szabaly(String tipus,int uj_oszlop,Tabla jatekter) {
		if(tipus.equals("gyalog")) {
			for(int i=0;i<9;i++) {
				if(jatekter.foglalt_mezo_e(i, uj_oszlop)&&jatekter.mezo_lekerdezes(i, uj_oszlop).tipus_lekerdezes().equals("gyalog")&&jatekter.mezo_lekerdezes(i, uj_oszlop).feher_e()==jatekter.leutott_kivalasztott_feher_e_lekerdezese()) {
					return false;
				}
			}
		}
		return true;
	}
	//Megnézi, hogy a lerakás betartja-e ezeket a szabályokat, és hogy van-e olyan típusú bábu a paraméter által meghatározott leütöttek Hash-ben.
	public static boolean szabalyos(String tipus,int uj_sor,int uj_oszlop,Tabla jatekter) {
		return !jatekter.foglalt_mezo_e(uj_sor, uj_oszlop)&&jatekter.leutott_lekerdezes().van_belole(tipus, jatekter.leutott_kivalasztott_feher_e_lekerdezese())&&ket_gyalog_szabaly(tipus, uj_oszlop, jatekter)&&lepes_nelkuliek_szabaly(tipus, uj_sor, uj_oszlop, jatekter);
	}
}
