package Jatek;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Babuk.Babu;
import Lepesekhez.Lepes;
import Lepesekhez.Lepes_ellenorzo;
import Lepesekhez.Lerakas;
import Lepesekhez.Lerakas_szabalyok;
import Lepesekhez.Mozgas;

public class Robot_lepes {
	public Robot_lepes() {
		
	}
	//Kigyűjti a paraméterek által meghatározott mezőből indítható érvényes lépéseket.
	private synchronized List<Mozgas> egy_mezohoz_tartozo_lepesek(int sor, int oszlop,Tabla jatekter,boolean feher){
		List<Mozgas> lepesek=new ArrayList<Mozgas>();
		
		for(int i=0;i<9;i++) {
			for(int c=0;c<9;c++) {
				Tabla klon=new Tabla(jatekter);
				Babu kivalaszotott=jatekter.mezo_lekerdezes(sor, oszlop);
				klon.kivalasztott_modositasa(klon.mezo_lekerdezes(sor, oszlop));
				if(Lepes_ellenorzo.megmenti(klon, i, c)) {
					lepesek.add(new Lepes(jatekter,kivalaszotott , i, c));
				}
			}
		}
		
		
		return lepesek;
	}
	//Összegyűjti az összes érvényes lerakásos lépést.
	private synchronized List<Mozgas> leutottek_felrakasa(String tipus,Tabla jatekter,boolean feher){
		List<Mozgas> lepesek=new ArrayList<Mozgas>();
		for(int i=0;i<9;i++) {
			for(int c=0;c<9;c++) {
				jatekter.leutott_kivalasztott_modositasa(tipus);
				jatekter.leutott_kivalasztott_feher_e_modositasa(feher);
				if(Lerakas_szabalyok.szabalyos(tipus, i, c, jatekter)) {
					lepesek.add(new Lerakas(jatekter, tipus, i, c));
				}
			}
		}
		return lepesek;
	}
	//Kigyűjti a paraméter által meghatározott színű csapatnak az összes érvényes lépését, majd azt el is végzi.
	public synchronized void lepes(Tabla jatekter,boolean feher) {
		List<Mozgas> lepesek=new ArrayList<Mozgas>();
		for(int i=0;i<9;i++) {
			for(int c=0;c<9;c++) {
				if(jatekter.foglalt_mezo_e(i, c)&&jatekter.mezo_lekerdezes(i, c).feher_e()==feher) {
					lepesek.addAll(egy_mezohoz_tartozo_lepesek(i, c,jatekter,feher));
				}
			}
		}

		if(jatekter.leutott_lekerdezes().van_belole("gyalog", feher)) {
			lepesek.addAll(leutottek_felrakasa("gyalog",jatekter,feher));
		}
		if(jatekter.leutott_lekerdezes().van_belole("jari", feher)) {
			lepesek.addAll(leutottek_felrakasa("jari",jatekter,feher));
		}
		if(jatekter.leutott_lekerdezes().van_belole("lovas", feher)) {
			lepesek.addAll(leutottek_felrakasa("lovas",jatekter,feher));
		}
		if(jatekter.leutott_lekerdezes().van_belole("futo", feher)) {
			lepesek.addAll(leutottek_felrakasa("futo",jatekter,feher));
		}
		if(jatekter.leutott_lekerdezes().van_belole("bastya", feher)) {
			lepesek.addAll(leutottek_felrakasa("bastya",jatekter,feher));
		}
		if(jatekter.leutott_lekerdezes().van_belole("ezust_tabornok", feher)) {
			lepesek.addAll(leutottek_felrakasa("ezust_tabornok",jatekter,feher));
		}
		if(jatekter.leutott_lekerdezes().van_belole("arany_tabornok", feher)) {
			lepesek.addAll(leutottek_felrakasa("arany_tabornok",jatekter,feher));
		}
		Random rnd=new Random();
		if(lepesek.size()!=0&&!jatekter.vege_lekerdezes()) {
			
			int melyiket=rnd.nextInt(lepesek.size());
			jatekter.kivalasztott_modositasa(lepesek.get(melyiket).mozgatni_valo_lekerdezese());
			jatekter.leutott_kivalasztott_modositasa(lepesek.get(melyiket).tipus_lekerdezes());
			jatekter.leutott_kivalasztott_feher_e_modositasa(feher);
			lepesek.get(melyiket).lepes();
			jatekter.kivalasztott_modositasa(null);
			jatekter.leutott_kivalasztott_modositasa(null);
			if(!jatekter.vege_lekerdezes()) {
				jatekter.repaint();
			}

		}
		else {
			jatekter.vege_modositas(true);
			if(jatekter.vege_lekerdezes()) {
				Thread.currentThread().interrupt();
			}
		}
	}
}
