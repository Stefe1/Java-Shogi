package Babuk_tesztek;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Babuk.Gyalog;
import Fajl_kezeles.Kep_beolvaso;
import Jatek.Tabla;

public class Tabla_teszt {
	Tabla jatekter;
	@Before
	public void setUp() throws Exception {
		jatekter=new Tabla();
	}

	//Babu elhelyezese
	@Test
	public void Babu_elhelyezese_teszt() {
		Gyalog gyalog=new Gyalog(0, 0, false, new Kep_beolvaso(), jatekter);
		jatekter.mezo_modositas(gyalog, 0, 0);
		Assert.assertSame(gyalog, jatekter.mezo_lekerdezes(0, 0));
	}
	//Foglalt mezo check
	@Test
	public void Foglalt_mezo_teszt() {
		Gyalog gyalog=new Gyalog(0, 0, false, new Kep_beolvaso(), jatekter);
		jatekter.mezo_modositas(gyalog, 0, 0);
		Assert.assertTrue(jatekter.foglalt_mezo_e(0, 0));
	}

}
