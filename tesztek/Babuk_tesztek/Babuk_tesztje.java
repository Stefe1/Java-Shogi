
package Babuk_tesztek;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Babuk.Eloleptetett_gyalog;
import Babuk.Gyalog;
import Fajl_kezeles.Kep_beolvaso;
import Jatek.Tabla;

public class Babuk_tesztje {
	Gyalog gyalogos;
	Eloleptetett_gyalog eloleptetett;
	@Before
	public void setUp() throws Exception {
		gyalogos=new Gyalog(0, 0, false, new Kep_beolvaso(), new Tabla());
		eloleptetett=new Eloleptetett_gyalog(0, 0, false, new Kep_beolvaso(), new Tabla());
	}
	//Teszt arra, hogy a bábunak megfelelő-e a lépés szabálya
	@Test
	public void lepes_test() {
		Assert.assertTrue(gyalogos.lepes_szabaly(1, 0));
	}
	
	//Teszt arra, hogy a helyes bábut adja-e vissza, ha meghívódik az előléptetés
	@Test
	public void eloleptetes_test() {
		Assert.assertEquals("eloleptetett_gyalog",gyalogos.eloleptetes().tipus_lekerdezes());
	}
	//Teszt, ha az adott bábunak nincs eloleptetett_verziója
	@Test
	public void eloleptetes_nelkuli_teszt() {
		Assert.assertSame(eloleptetett,eloleptetett.eloleptetes());
	}
}
