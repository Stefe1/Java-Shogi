package Jatek;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Lepesekhez.Lepes;
import Lepesekhez.Lerakas;

public class Bemenet extends MouseAdapter{
	private Tabla jatekter;
	private boolean botos;
	private int hanyadik;
	public Bemenet(Tabla jatekter, boolean botos, boolean feher) {
		this.jatekter=jatekter;
		this.botos=botos;
		if(this.botos) {
			if(feher) {
				hanyadik=1;
			}
			else {
				hanyadik=0;
			}
		}
		else {
			hanyadik=-1;
		}
	}
	//Az egér gomb nyomását reagálja le, megnézi, hogy az hol történt, az alapján pedig megszerzi, hogy hanyadik sorra és oszlopra kattintott a felhasználó.
	//Ha már ki van választa egy adott bábu, akkor megpróbál a következő kattintás helyére lépni.
	private void tablan_kivalasztas(MouseEvent e) {
		if(jatekter.kivalasztott_lekerdezese()==null) {
			if(e.getY()<715&&e.getY()>85&&e.getX()>120&&e.getX()<750) {
				
				int oszlop=(e.getX()-120)/70;
				int sor=(e.getY()-85)/70;
				
				if(jatekter.foglalt_mezo_e(sor, oszlop)) {
//					ez már a kész verzió a kétszemélyehez
					if((hanyadik==-1&&jatekter.lepes_lekerdezes()%2==0&&!jatekter.mezo_lekerdezes(sor, oszlop).feher_e())||(hanyadik==0&&jatekter.lepes_lekerdezes()%2==0&&!jatekter.mezo_lekerdezes(sor, oszlop).feher_e())) {
						jatekter.kivalasztott_modositasa(jatekter.mezo_lekerdezes(sor, oszlop));
						jatekter.leutott_kivalasztott_modositasa(null);
						jatekter.repaint();
					}
					else if((hanyadik==-1&&jatekter.lepes_lekerdezes()%2==1&&jatekter.mezo_lekerdezes(sor, oszlop).feher_e())||(hanyadik==1&&jatekter.lepes_lekerdezes()%2==1&&jatekter.mezo_lekerdezes(sor, oszlop).feher_e())){
						jatekter.kivalasztott_modositasa(jatekter.mezo_lekerdezes(sor, oszlop));
						jatekter.leutott_kivalasztott_modositasa(null);
						jatekter.repaint();
					}
				}
			}
		}
		else {
			if(e.getY()<715&&e.getY()>85&&e.getX()>120&&e.getX()<750) {
				
				int oszlop=(e.getX()-120)/70;
				int sor=(e.getY()-85)/70;
				Lepes proba=new Lepes(jatekter,jatekter.kivalasztott_lekerdezese(), sor, oszlop);
				proba.lepes();
				jatekter.kivalasztott_modositasa(null);
			}
			else {
				jatekter.kivalasztott_modositasa(null);
			}
			if(!jatekter.vege_lekerdezes()) {
				jatekter.repaint();
			}
		}
	}
	//Megnézi, hogy melyik oldalt kattintott a felhasználó, az alapján pedig belövi, hogy bábura kattintott
	//Ha már ki van választva egy bábu, akkor azt megpróbálja a következő kattintás helyére letenni
	private void leutott_kivalasztas(MouseEvent e) {
		if(jatekter.leutott_kivalasztott_lekerdezese()==null) {
			if((e.getX()>=25&&e.getX()<=95&&e.getY()>=85&&e.getY()<575)||(e.getX()>=775&&e.getX()<=845&&e.getY()>=225&&e.getY()<715)) {
				int sor=-1;
				if(e.getX()>=25&&e.getX()<=95&&e.getY()>=85&&e.getY()<575&&jatekter.lepes_lekerdezes()%2==0) {
					sor=(e.getY()-85)/70;
					jatekter.leutott_kivalasztott_feher_e_modositasa(false);
				}
				else if((e.getX()>=775&&e.getX()<=845&&e.getY()>=225&&e.getY()<715&&jatekter.lepes_lekerdezes()%2==1)) {
					sor=6-(e.getY()-225)/70;
					jatekter.leutott_kivalasztott_feher_e_modositasa(true);
				}
				jatekter.kivalasztott_modositasa(null);
				if(sor==0) {
					jatekter.leutott_kivalasztott_modositasa("gyalog");
				}
				else if(sor==1) {
					jatekter.leutott_kivalasztott_modositasa("futo");
				}
				else if(sor==2) {
					jatekter.leutott_kivalasztott_modositasa("bastya");
				}
				else if(sor==3) {
					jatekter.leutott_kivalasztott_modositasa("jari");
				}
				else if(sor==4) {
					jatekter.leutott_kivalasztott_modositasa("lovas");
				}
				else if(sor==5) {
					jatekter.leutott_kivalasztott_modositasa("ezust_tabornok");
				}
				else if(sor==6) {
					jatekter.leutott_kivalasztott_modositasa("arany_tabornok");
				}
				jatekter.repaint();
			}
		}
		else {
			if(e.getY()<715&&e.getY()>85&&e.getX()>120&&e.getX()<750) {
				
				int oszlop=(e.getX()-120)/70;
				int sor=(e.getY()-85)/70;
				Lerakas proba=new Lerakas(jatekter,jatekter.leutott_kivalasztott_lekerdezese(), sor, oszlop);
				proba.lepes();
				jatekter.leutott_kivalasztott_modositasa(null);
			}
			else {
				jatekter.leutott_kivalasztott_modositasa(null);
			}
			if(!jatekter.vege_lekerdezes()) {
				jatekter.repaint();
			}
		}
	}
	public void mouseClicked(MouseEvent e) {
		tablan_kivalasztas(e);
		leutott_kivalasztas(e);
	}
}
