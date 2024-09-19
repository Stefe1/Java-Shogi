package Babuk;

import java.awt.Graphics2D;
import java.awt.Image;

import Babukhoz_valo.Ellenorzott_lepes;
import Fajl_kezeles.Kep_beolvaso;
import Jatek.Tabla;

public abstract class Babu {
	protected int sor,oszlop;
	protected boolean feher;
	protected Image kep;
	protected Kep_beolvaso elolepeshez;
	protected Tabla jatekter;
	
	public Babu(int sor, int oszlop, boolean feher, Kep_beolvaso kep_hash, String tipus, Tabla jatekter) {
		this.sor=sor;
		this.oszlop=oszlop;
		this.feher=feher;
		this.kep=kep_hash.kepek.get(tipus);
		elolepeshez=kep_hash;
		this.jatekter=jatekter;
	}
	
	//Ezt a függvényt minden leszármazottjának meg kell valósítani, mert ez a függvény felelős a lepések szabályos levezetéséért
	public abstract boolean lepes_szabaly( int uj_sor,int uj_oszlop);
	//Az előző lepes_szabaly függvény segítségével ellenőrzi,
	//hogy helyes volt a lépés, azonban még kiegészül azzal is, hogy ellenőrzi, hogy sakkba kerülne-e a lépés miatt a saját királya.
	public boolean ervenyes_lepes( int uj_sor,int uj_oszlop) {
		return Ellenorzott_lepes.ervenyes_lepes(this, uj_sor, uj_oszlop);
	}
	//Lekérdezi a függvény a bábu pontos típusát.
	public abstract String tipus_lekerdezes();//fontos lesz, a mentes szempontjából
	//Ha leütik, akkor az ellenfél csapatának a leütött bábújaihoz kerül.
	public abstract void leutve();
	//Ha a bábu eléri az ellenfél első 3 sorát, akkor előléptetődik egy erősebb bábuvá.
	//Ez a függvény azért nem abstract, mert vannak bábuk pl: akik már elő lettek léptetve, így már nem tudnak mit tenni.
	//A leszármaztatott osztályok, amelyeknél van lehetőség az előléptetésre, azok override-olják.
	public Babu eloleptetes() {
		return this;
	}
	//Kirajzolja a bábut a sor és oszlop értéke által meghatározott mezőre a táblán.
	public void paint(Graphics2D g) {
		if(feher) {
			g.drawImage(kep, 120+oszlop*70, 85+sor*70,120+oszlop*70+70, 85+sor*70+70,  0, 0, 70, 70, null);
		}
		else {
			g.drawImage(kep, 120+oszlop*70+70, 85+sor*70+70, 120+oszlop*70, 85+sor*70,  0, 0, 70, 70, null);
		}
	}
	//Átváltoztatja a sor értékét a paraméterként kapott értékre.
	public void sor_modositas(int uj) {
		this.sor=uj;
	}
	//Átváltoztatja az oszlop értékét a paraméterként kapott értékre.
	public void oszlop_modositas(int uj) {
		this.oszlop=uj;
	}
	public int sor_lekerdezes() {
		return sor;
	}
	public int oszlop_lekerdezes() {
		return oszlop;
	}
	public boolean feher_e() {
		//segít lekérdezni, majd hogy az egy színűt akarja-e leutni vagy sem
		return feher;
	}
	public Kep_beolvaso kep_beolvaso_lekerdezes() {
		return elolepeshez;
	}
	public Tabla tabla_lekerdezes() {
		return jatekter;
	}
}
