
package Jatek;

import java.awt.Color;
import java.awt.Graphics2D;

public final class Rajzolok {
	private static int mezomeret=70;
	//Zöld négyzetet rak a kiválasztott mezőre, pirosat pedig a veszélyben levő királyra
	public static void mezo_rajzolasa(Graphics2D g2d, Tabla jatekter,int sor, int oszlop) {
		if(jatekter.feher_checkelve&&jatekter.kiraly_kereso(true).sor_lekerdezes()==sor&&jatekter.kiraly_kereso(true).oszlop_lekerdezes()==oszlop) {
			g2d.setColor(new Color(255,0,40));
		}
		else if(jatekter.fekete_checkelve&&jatekter.kiraly_kereso(false).sor_lekerdezes()==sor&&jatekter.kiraly_kereso(false).oszlop_lekerdezes()==oszlop) {
			g2d.setColor(new Color(255,0,40));
	}
		else if(jatekter.kivalasztott_lekerdezese()!=null&&jatekter.kivalasztott_lekerdezese().sor_lekerdezes()==sor&&jatekter.kivalasztott_lekerdezese().oszlop_lekerdezes()==oszlop) {
			if((jatekter.feher_checkelve&&jatekter.kivalasztott_lekerdezese().feher_e())||(jatekter.fekete_checkelve&&!jatekter.kivalasztott_lekerdezese().feher_e())) {
				g2d.setColor(new Color(255,0,40));
			}
			else {
				g2d.setColor(new Color(124,252,0));
			}
		}
		else if((sor+oszlop)%2==0) {
			g2d.setColor(new Color(250,223,173));
		}
		else {
			g2d.setColor(new Color(139,69,19));
		}
		g2d.fillRect(120+oszlop*mezomeret, 85+sor*mezomeret, mezomeret, mezomeret);
		if(jatekter.foglalt_mezo_e(sor, oszlop)) {
			jatekter.mezo_lekerdezes(sor, oszlop).paint(g2d);
		}
	}
	//Zöld kört rajzol azokra a mezőkre, amelyek érvényes lépésnek számítana a kiválasztott bábunak.
	//Pirost kört meg azokra, ahova tudna lépni, azonban nem tud, mert azzal sakkba helyezné a királyt
	public static void kivalasztott_rajzolasa(Graphics2D g2d, Tabla jatekter,int sor, int oszlop) {
		if(jatekter.kivalasztott_lekerdezese()!=null) {
			if(jatekter.kivalasztott_lekerdezese().ervenyes_lepes(sor, oszlop)) {
				if(jatekter.foglalt_mezo_e(sor, oszlop)&&jatekter.mezo_lekerdezes(sor, oszlop).feher_e()!=jatekter.kivalasztott_lekerdezese().feher_e()||!jatekter.foglalt_mezo_e(sor, oszlop)) {
					g2d.setColor(new Color(124,252,0));
					g2d.fillOval(120+oszlop*mezomeret+20, 85+sor*mezomeret+20, 30, 30);
				}
				
			}
			else if(!jatekter.kivalasztott_lekerdezese().ervenyes_lepes(sor, oszlop)&&jatekter.kivalasztott_lekerdezese().lepes_szabaly(sor, oszlop)) {
				if(jatekter.foglalt_mezo_e(sor, oszlop)&&jatekter.mezo_lekerdezes(sor, oszlop).feher_e()!=jatekter.kivalasztott_lekerdezese().feher_e()||!jatekter.foglalt_mezo_e(sor, oszlop)) {
					g2d.setColor(new Color(255,0,40));
					g2d.fillOval(120+oszlop*mezomeret+20, 85+sor*mezomeret+20, 30, 30);
				}
			}
		}
	}

}
