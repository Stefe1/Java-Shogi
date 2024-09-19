package Jatek;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import Lepesekhez.Lepes_ellenorzo;
import Lepesekhez.Lerakas_szabalyok;

public class Leutot_rajzolo {
	private static int mezomeret=70;
	//kirajzolja az ablak bal oldalára a feketéknek a leutott bábuikat (amik eredetileg fehérek voltak)
	public static void fekete_leutottek_rajzolasa(Graphics2D g2d, Tabla jatekter) {
		int sor=0;
		int kezdo_szelesseg=25,veg_szelesseg=95;
		
		g2d.setColor(new Color(0,0,0));
		g2d.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		if(jatekter.leutott_lekerdezes().van_belole("gyalog",false)) {
			g2d.drawImage(jatekter.kep_beolvaso_lekerdezese().kepek.get("gyalog"), kezdo_szelesseg, sor*mezomeret+85, veg_szelesseg, sor*mezomeret+155, 0, 0, mezomeret, mezomeret, null);
			g2d.drawString(Integer.toString(jatekter.leutott_lekerdezes().fekete_leutottek.get("gyalog")), veg_szelesseg, sor++*mezomeret+155);
		}
		else {
			g2d.drawImage(jatekter.kep_beolvaso_lekerdezese().kepek.get("szurke_gyalog"), kezdo_szelesseg, sor*mezomeret+85, veg_szelesseg, (sor++)*mezomeret+155, 0, 0, mezomeret, mezomeret, null);
		}
		if(jatekter.leutott_lekerdezes().van_belole("futo",false)) {
			g2d.drawImage(jatekter.kep_beolvaso_lekerdezese().kepek.get("futo"), kezdo_szelesseg, sor*mezomeret+85, veg_szelesseg, sor*mezomeret+155, 0, 0, mezomeret, mezomeret, null);
			g2d.drawString(Integer.toString(jatekter.leutott_lekerdezes().fekete_leutottek.get("futo")), veg_szelesseg, sor++*mezomeret+155);
		}
		else {
			g2d.drawImage(jatekter.kep_beolvaso_lekerdezese().kepek.get("szurke_futo"), kezdo_szelesseg, sor*mezomeret+85, veg_szelesseg, (sor++)*mezomeret+155, 0, 0, mezomeret, mezomeret, null);
		}
		if(jatekter.leutott_lekerdezes().van_belole("bastya",false)) {
			g2d.drawImage(jatekter.kep_beolvaso_lekerdezese().kepek.get("bastya"), kezdo_szelesseg, sor*mezomeret+85, veg_szelesseg, sor*mezomeret+155, 0, 0, mezomeret, mezomeret, null);
			g2d.drawString(Integer.toString(jatekter.leutott_lekerdezes().fekete_leutottek.get("bastya")), veg_szelesseg, sor++*mezomeret+155);
		}
		else {
			g2d.drawImage(jatekter.kep_beolvaso_lekerdezese().kepek.get("szurke_bastya"), kezdo_szelesseg, sor*mezomeret+85, veg_szelesseg, (sor++)*mezomeret+155, 0, 0, mezomeret, mezomeret, null);
		}

		if(jatekter.leutott_lekerdezes().van_belole("jari",false)) {
			g2d.drawImage(jatekter.kep_beolvaso_lekerdezese().kepek.get("jari"), kezdo_szelesseg, sor*mezomeret+85, veg_szelesseg, sor*mezomeret+155, 0, 0, mezomeret, mezomeret, null);
			g2d.drawString(Integer.toString(jatekter.leutott_lekerdezes().fekete_leutottek.get("jari")), veg_szelesseg, sor++*mezomeret+155);
		}
		else {
			g2d.drawImage(jatekter.kep_beolvaso_lekerdezese().kepek.get("szurke_jari"), kezdo_szelesseg, sor*mezomeret+85, veg_szelesseg, (sor++)*mezomeret+155, 0, 0, mezomeret, mezomeret, null);
		}
		if(jatekter.leutott_lekerdezes().van_belole("lovas",false)) {
			g2d.drawImage(jatekter.kep_beolvaso_lekerdezese().kepek.get("lovas"), kezdo_szelesseg, sor*mezomeret+85, veg_szelesseg, sor*mezomeret+155, 0, 0, mezomeret, mezomeret, null);
			g2d.drawString(Integer.toString(jatekter.leutott_lekerdezes().fekete_leutottek.get("lovas")), veg_szelesseg, sor++*mezomeret+155);
		}
		else {
			g2d.drawImage(jatekter.kep_beolvaso_lekerdezese().kepek.get("szurke_lovas"), kezdo_szelesseg, sor*mezomeret+85, veg_szelesseg, (sor++)*mezomeret+155, 0, 0, mezomeret, mezomeret, null);
		}
		if(jatekter.leutott_lekerdezes().van_belole("ezust_tabornok",false)) {
			g2d.drawImage(jatekter.kep_beolvaso_lekerdezese().kepek.get("ezust_tabornok"), kezdo_szelesseg, sor*mezomeret+85, veg_szelesseg, sor*mezomeret+155, 0, 0, mezomeret, mezomeret, null);
			g2d.drawString(Integer.toString(jatekter.leutott_lekerdezes().fekete_leutottek.get("ezust_tabornok")), veg_szelesseg, sor++*mezomeret+155);
		}
		else {
			g2d.drawImage(jatekter.kep_beolvaso_lekerdezese().kepek.get("szurke_ezust_tabornok"), kezdo_szelesseg, sor*mezomeret+85, veg_szelesseg, (sor++)*mezomeret+155, 0, 0, mezomeret, mezomeret, null);
		}
		if(jatekter.leutott_lekerdezes().van_belole("arany_tabornok",false)) {
			g2d.drawImage(jatekter.kep_beolvaso_lekerdezese().kepek.get("arany_tabornok"), kezdo_szelesseg, sor*mezomeret+85, veg_szelesseg, sor*mezomeret+155, 0, 0, mezomeret, mezomeret, null);
			g2d.drawString(Integer.toString(jatekter.leutott_lekerdezes().fekete_leutottek.get("arany_tabornok")), veg_szelesseg, sor++*mezomeret+155);
		}
		else {
			g2d.drawImage(jatekter.kep_beolvaso_lekerdezese().kepek.get("szurke_arany_tabornok"), kezdo_szelesseg, sor*mezomeret+85, veg_szelesseg, (sor++)*mezomeret+155, 0, 0, mezomeret, mezomeret, null);
		}
	}
	//kirajzolja az ablak jobb oldalára a fehéreknek a leutott bábuikat (amik eredetileg feketék voltak)
	public static void feher_leutottek_rajzolasa(Graphics2D g2d, Tabla jatekter) {
		int sor=0;
		int kezdo_szelesseg=775,veg_szelesseg=845;
		
		g2d.setColor(new Color(245,255,250));
		g2d.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		if(jatekter.leutott_lekerdezes().van_belole("arany_tabornok",true)) {
			g2d.drawImage(jatekter.kep_beolvaso_lekerdezese().kepek.get("arany_tabornok"), kezdo_szelesseg, sor*mezomeret+225, veg_szelesseg, sor*mezomeret+295, 0, 0, mezomeret, mezomeret, null);
			g2d.drawString(Integer.toString(jatekter.leutott_lekerdezes().feher_leutottek.get("arany_tabornok")), kezdo_szelesseg-5, sor++*mezomeret+295);
		}
		else {
			g2d.drawImage(jatekter.kep_beolvaso_lekerdezese().kepek.get("szurke_arany_tabornok"), kezdo_szelesseg, sor*mezomeret+225, veg_szelesseg, (sor++)*mezomeret+295, 0, 0, mezomeret, mezomeret, null);
		}
		if(jatekter.leutott_lekerdezes().van_belole("ezust_tabornok",true)) {
			g2d.drawImage(jatekter.kep_beolvaso_lekerdezese().kepek.get("ezust_tabornok"), kezdo_szelesseg, sor*mezomeret+225, veg_szelesseg, sor*mezomeret+295, 0, 0, mezomeret, mezomeret, null);
			g2d.drawString(Integer.toString(jatekter.leutott_lekerdezes().feher_leutottek.get("ezust_tabornok")), kezdo_szelesseg-5, sor++*mezomeret+295);
		}
		else {
			g2d.drawImage(jatekter.kep_beolvaso_lekerdezese().kepek.get("szurke_ezust_tabornok"), kezdo_szelesseg, sor*mezomeret+225, veg_szelesseg, (sor++)*mezomeret+295, 0, 0, mezomeret, mezomeret, null);
		}
		if(jatekter.leutott_lekerdezes().van_belole("lovas",true)) {
			g2d.drawImage(jatekter.kep_beolvaso_lekerdezese().kepek.get("lovas"), kezdo_szelesseg, sor*mezomeret+225, veg_szelesseg, sor*mezomeret+295, 0, 0, mezomeret, mezomeret, null);
			g2d.drawString(Integer.toString(jatekter.leutott_lekerdezes().feher_leutottek.get("lovas")), kezdo_szelesseg-5, sor++*mezomeret+295);
		}
		else {
			g2d.drawImage(jatekter.kep_beolvaso_lekerdezese().kepek.get("szurke_lovas"), kezdo_szelesseg, sor*mezomeret+225, veg_szelesseg, (sor++)*mezomeret+295, 0, 0, mezomeret, mezomeret, null);
		}
		if(jatekter.leutott_lekerdezes().van_belole("jari",true)) {
			g2d.drawImage(jatekter.kep_beolvaso_lekerdezese().kepek.get("jari"), kezdo_szelesseg, sor*mezomeret+225, veg_szelesseg, sor*mezomeret+295, 0, 0, mezomeret, mezomeret, null);
			g2d.drawString(Integer.toString(jatekter.leutott_lekerdezes().feher_leutottek.get("jari")), kezdo_szelesseg-5, sor++*mezomeret+295);
		}
		else {
			g2d.drawImage(jatekter.kep_beolvaso_lekerdezese().kepek.get("szurke_jari"), kezdo_szelesseg, sor*mezomeret+225, veg_szelesseg, (sor++)*mezomeret+295, 0, 0, mezomeret, mezomeret, null);
		}

		if(jatekter.leutott_lekerdezes().van_belole("bastya",true)) {
			g2d.drawImage(jatekter.kep_beolvaso_lekerdezese().kepek.get("bastya"), kezdo_szelesseg, sor*mezomeret+225, veg_szelesseg, sor*mezomeret+295, 0, 0, mezomeret, mezomeret, null);
			g2d.drawString(Integer.toString(jatekter.leutott_lekerdezes().feher_leutottek.get("bastya")), kezdo_szelesseg-5, sor++*mezomeret+295);
		}
		else {
			g2d.drawImage(jatekter.kep_beolvaso_lekerdezese().kepek.get("szurke_bastya"), kezdo_szelesseg, sor*mezomeret+225, veg_szelesseg, (sor++)*mezomeret+295, 0, 0, mezomeret, mezomeret, null);
		}
		if(jatekter.leutott_lekerdezes().van_belole("futo",true)) {
			g2d.drawImage(jatekter.kep_beolvaso_lekerdezese().kepek.get("futo"), kezdo_szelesseg, sor*mezomeret+225, veg_szelesseg, sor*mezomeret+295, 0, 0, mezomeret, mezomeret, null);
			g2d.drawString(Integer.toString(jatekter.leutott_lekerdezes().feher_leutottek.get("futo")), kezdo_szelesseg-5, sor++*mezomeret+295);
		}
		else {
			g2d.drawImage(jatekter.kep_beolvaso_lekerdezese().kepek.get("szurke_futo"), kezdo_szelesseg, sor*mezomeret+225, veg_szelesseg, (sor++)*mezomeret+295, 0, 0, mezomeret, mezomeret, null);
		}
		if(jatekter.leutott_lekerdezes().van_belole("gyalog",true)) {
			g2d.drawImage(jatekter.kep_beolvaso_lekerdezese().kepek.get("gyalog"), kezdo_szelesseg, sor*mezomeret+225, veg_szelesseg, sor*mezomeret+295, 0, 0, mezomeret, mezomeret, null);
			g2d.drawString(Integer.toString(jatekter.leutott_lekerdezes().feher_leutottek.get("gyalog")), kezdo_szelesseg-5, sor++*mezomeret+295);
		}
		else {
			g2d.drawImage(jatekter.kep_beolvaso_lekerdezese().kepek.get("szurke_gyalog"), kezdo_szelesseg, sor*mezomeret+225, veg_szelesseg, (sor++)*mezomeret+295, 0, 0, mezomeret, mezomeret, null);
		}
	}
	private static void kor_rajzolasa(Graphics2D g2d, Tabla jatekter,int sor, int oszlop) {
		if(!jatekter.foglalt_mezo_e(sor, oszlop)&&Lerakas_szabalyok.szabalyos(jatekter.leutott_kivalasztott_lekerdezese(), sor, oszlop, jatekter)) {
			g2d.setColor(new Color(124,252,0));
			g2d.fillOval(120+oszlop*mezomeret+20, 85+sor*mezomeret+20, 30, 30);
		}
	}
	//ha kiválasztott egy adott bábut, akkor megmutatja, hogy hova lehet őket lerakni
	public static void leutott_kivalasztott_rajzolo(Graphics2D g2d, Tabla jatekter,int sor, int oszlop) {
		if(jatekter.leutott_kivalasztott_lekerdezese()!=null) {
			if(!jatekter.fekete_checkelve&&!jatekter.feher_checkelve) {
				kor_rajzolasa(g2d, jatekter, sor, oszlop);
			}
			else {
				if(jatekter.feher_checkelve&&jatekter.leutott_kivalasztott_feher_e_lekerdezese()&&Lepes_ellenorzo.megmento_lerakas(new Tabla(jatekter), sor, oszlop)) {
					kor_rajzolasa(g2d,jatekter,sor,oszlop);
				}
				else if(jatekter.fekete_checkelve&&!jatekter.leutott_kivalasztott_feher_e_lekerdezese()&&Lepes_ellenorzo.megmento_lerakas(new Tabla(jatekter), sor, oszlop)) {
					kor_rajzolasa(g2d, jatekter, sor, oszlop);
				}
			}
			
		}
	}
}
