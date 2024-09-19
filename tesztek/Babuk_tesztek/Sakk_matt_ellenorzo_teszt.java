package Babuk_tesztek;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Babuk.Bastya;
import Babuk.Eloleptetett_gyalog;
import Babuk.Kiraly;
import Fajl_kezeles.Kep_beolvaso;
import Jatek.Tabla;
import Lepesekhez.Lepes;
import Lepesekhez.Lepes_ellenorzo;

public class Sakk_matt_ellenorzo_teszt {
	Tabla jatekter;
	//A fehér bástyá sakkot ad a fekete királynak
	@Test
	public void sakk_adas_teszt() {
		jatekter=new Tabla(new Kep_beolvaso());
		jatekter.mezo_modositas(null, 2, 4);
		jatekter.mezo_modositas(null, 6, 4);
		jatekter.kivalasztott_modositasa(jatekter.mezo_lekerdezes(7, 7));
		Lepes sakkolo=new Lepes(jatekter, jatekter.mezo_lekerdezes(7, 7),7, 4);
		Assert.assertTrue(!jatekter.fekete_checkelve);
		sakkolo.lepes();
		Assert.assertTrue(jatekter.fekete_checkelve);
	}
	//Teszt, hogy nem léphet olyan helyre, ahol veszítene
	@Test
	public void sakk_kerules_teszt() {
		jatekter=new Tabla(new Kep_beolvaso());
		jatekter.mezo_modositas(null, 2, 4);
		jatekter.mezo_modositas(null, 6, 4);
		jatekter.kivalasztott_modositasa(jatekter.mezo_lekerdezes(7, 7));
		Lepes sakkolo=new Lepes(jatekter, jatekter.mezo_lekerdezes(7, 7),7, 4);
		sakkolo.lepes();
		jatekter.kivalasztott_modositasa(jatekter.mezo_lekerdezes(0, 4));
		Assert.assertFalse(jatekter.mezo_lekerdezes(0, 4).ervenyes_lepes(1, 4));
	}
	//Sakk-matt teszt
	@Test
	public void sakk_matt_teszt() {
		jatekter=new Tabla();
		jatekter.mezo_modositas(new Kiraly(0, 4, false, new Kep_beolvaso(), jatekter), 0, 4);
		jatekter.mezo_modositas(new Kiraly(8, 4, true, new Kep_beolvaso(), jatekter), 8, 4);
		jatekter.mezo_modositas(new Eloleptetett_gyalog(1, 2, true, new Kep_beolvaso(), jatekter), 1, 2);
		jatekter.mezo_modositas(new Eloleptetett_gyalog(0, 6, true, new Kep_beolvaso(), jatekter), 0, 6);
		jatekter.mezo_modositas(new Bastya(7, 8, true, new Kep_beolvaso(), jatekter), 7, 8);
		jatekter.kivalasztott_modositasa(jatekter.mezo_lekerdezes(7, 8));
		Lepes sakk_matt=new Lepes(jatekter, jatekter.kivalasztott_lekerdezese(), 1, 8);
		sakk_matt.lepes();
		Assert.assertTrue(jatekter.vege_lekerdezes());
		
	}

}
