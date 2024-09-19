package Babuk_tesztek;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Babuk.Gyalog;
import Fajl_kezeles.Kep_beolvaso;
import Jatek.Tabla;
import Lepesekhez.Lepes;
import Lepesekhez.Lerakas;

public class Lerakas_teszt {
	private Tabla jatekter;
	@Before
	public void setUp() throws Exception {
		jatekter=new Tabla(new Kep_beolvaso());
	}
	//leutott_babuk működésének tesztje
	@Test
	public void leutott_babuk_teszt() {
		jatekter.mezo_modositas(new Gyalog(6, 7, false, new Kep_beolvaso(), jatekter), 6, 7);
		jatekter.kivalasztott_modositasa(jatekter.mezo_lekerdezes(7, 7));
		Lepes hibas=new Lepes(jatekter, jatekter.mezo_lekerdezes(7, 7), 6, 7);
		Assert.assertTrue(!jatekter.leutott_lekerdezes().van_belole("gyalog", true));
		hibas.lepes();
		Assert.assertTrue(jatekter.leutott_lekerdezes().van_belole("gyalog", true));
	}
	//Ket gyalog szabálynak az ellenőrzése
	@Test
	public void ket_gyalog_teszt() {
		jatekter.leutott_lekerdezes().hozzadas(true, "gyalog");
		jatekter.leutott_kivalasztott_modositasa("gyalog");
		jatekter.leutott_kivalasztott_feher_e_modositasa(true);
		Lerakas ket_gyalog=new Lerakas(jatekter, "gyalog", 5, 4);
		ket_gyalog.lepes();
		Assert.assertFalse(jatekter.foglalt_mezo_e(5, 4));
	}
	//Sikeres elhelyezés teszt
	@Test
	public void sikeres_lerakas_teszt() {
		jatekter.mezo_modositas(null, 6, 4);
		jatekter.leutott_lekerdezes().hozzadas(true, "gyalog");
		jatekter.leutott_kivalasztott_modositasa("gyalog");
		jatekter.leutott_kivalasztott_feher_e_modositasa(true);
		Lerakas ket_gyalog=new Lerakas(jatekter, "gyalog", 5, 4);
		ket_gyalog.lepes();
		Assert.assertTrue(jatekter.foglalt_mezo_e(5, 4));
		Assert.assertEquals("gyalog", jatekter.mezo_lekerdezes(5, 4).tipus_lekerdezes());
	}

}
