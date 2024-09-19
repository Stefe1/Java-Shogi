package Babuk_tesztek;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Babuk.Gyalog;
import Fajl_kezeles.Kep_beolvaso;
import Jatek.Tabla;
import Lepesekhez.Lepes;

public class Lepes_teszt {
	private Tabla jatekter;
	@Before
	public void setUp() throws Exception {
		jatekter=new Tabla(new Kep_beolvaso());
	}

	//Teszt, hogy szabad mezőre lép
	@Test
	public void ures_teszt() {
		jatekter.kivalasztott_modositasa(jatekter.mezo_lekerdezes(7, 7));
		Lepes ures=new Lepes(jatekter, jatekter.mezo_lekerdezes(7, 7), 7, 6);
		ures.lepes();
		Assert.assertEquals(jatekter.mezo_lekerdezes(7, 6).tipus_lekerdezes(), "bastya");
		Assert.assertFalse(jatekter.foglalt_mezo_e(7, 7));
		
	}
	@Test
	public void baratsagos_teszt() {
		jatekter.kivalasztott_modositasa(jatekter.mezo_lekerdezes(7, 7));
		Lepes hibas=new Lepes(jatekter, jatekter.mezo_lekerdezes(7, 7), 6, 7);
		hibas.lepes();
		Assert.assertEquals(jatekter.mezo_lekerdezes(7, 7).tipus_lekerdezes(), "bastya");
		Assert.assertEquals(jatekter.mezo_lekerdezes(6, 7).tipus_lekerdezes(), "gyalog");
	}
	//Teszt ugyan ott, ha egy ellenséges bábu van ott
	@Test
	public void ellenseges_teszt() {
		jatekter.mezo_modositas(new Gyalog(6, 7, false, new Kep_beolvaso(), jatekter), 6, 7);
		jatekter.kivalasztott_modositasa(jatekter.mezo_lekerdezes(7, 7));
		Lepes hibas=new Lepes(jatekter, jatekter.mezo_lekerdezes(7, 7), 6, 7);
		hibas.lepes();
		Assert.assertEquals(jatekter.mezo_lekerdezes(6, 7).tipus_lekerdezes(), "bastya");
	}
}
