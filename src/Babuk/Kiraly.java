package Babuk;

import Fajl_kezeles.Kep_beolvaso;
import Jatek.Tabla;

public class Kiraly extends Babu{
	boolean checkolva;
	public Kiraly(int sor, int oszlop, boolean feher, Kep_beolvaso kep_hash,Tabla jatekter) {
		super(sor, oszlop, feher,kep_hash,"kiraly",jatekter);
		checkolva=false;
	}
	//típus lekérdezése
	public String tipus_lekerdezes() {
		return "kiraly";
	}
	//a bábuhoz tartozó lépészabályt vizsgálja meg
	public boolean lepes_szabaly( int uj_sor,int uj_oszlop) {
		if(this.sor-1<=uj_sor&&this.sor+1>=uj_sor&&this.oszlop-1<=uj_oszlop&&this.oszlop+1>=uj_oszlop&&!(this.sor==uj_sor&&this.oszlop==uj_oszlop)) {
			return true;
		}
		if(this.jatekter.kiraly_kereso(!this.feher).sor_lekerdezes()-1<=uj_sor&&this.jatekter.kiraly_kereso(!this.feher).sor_lekerdezes()+1>=uj_sor&&this.jatekter.kiraly_kereso(!this.feher).oszlop_lekerdezes()-1<=uj_oszlop&&this.jatekter.kiraly_kereso(!this.feher).oszlop_lekerdezes()+1>=uj_oszlop&&!(this.jatekter.kiraly_kereso(!this.feher).oszlop_lekerdezes()==uj_sor&&this.jatekter.kiraly_kereso(!this.feher).oszlop_lekerdezes()==uj_oszlop)) {
			return false;
		}
		return false;
	}
	//Ha leütődik, akkor hozzá adódik az ellenkező szín leütött bábujai közé
	public void leutve() {
		this.jatekter.leutott_lekerdezes().hozzadas(!this.feher, tipus_lekerdezes());
	}
}
