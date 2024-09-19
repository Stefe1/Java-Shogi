package Lepesekhez;

import Babuk.Babu;
import Jatek.Tabla;

public abstract class Mozgas {
	protected Tabla jatekter;
	protected Babu mozgatni_valo ;
	protected int uj_sor, uj_oszlop;
	protected String tipus;
	public Mozgas(Tabla tabla,Babu mozgatni_valo ,int uj_sor, int uj_oszlop) {
		jatekter=tabla;
		this.mozgatni_valo=mozgatni_valo;
		this.uj_sor=uj_sor;
		this.uj_oszlop=uj_oszlop;
		this.tipus=null;
	}
	public Mozgas(Tabla tabla,String tipus ,int uj_sor, int uj_oszlop) {
		jatekter=tabla;
		this.mozgatni_valo=null;
		this.uj_sor=uj_sor;
		this.uj_oszlop=uj_oszlop;
		this.tipus=tipus;
	}
	//Elvégzi a lépést.
	public abstract void lepes();
	//Elvégzi a lépést. Ez a két lépés fajtánál más-más dolgot végez el.
	public abstract void proba_lepes();
	//Lekérdezi, hogy melyik bábut akarja mozgatni.
	public Babu mozgatni_valo_lekerdezese() {
		return mozgatni_valo;
	}
	//Lekérdezi, hogy milyen típusú bábut akar letenni.
	public String tipus_lekerdezes() {
		return tipus;
	}
	//Lekérdezi, hogy melyik táblán akarja elvégezni.
	public Tabla jatekter_lekerdezes() {
		return jatekter;
	}
	//Lekérdezi, hogy melyik sorban akarja elvégezni a műveletet.
	public int sor_lekerdezes() {
		return uj_sor;
	}
	//Lekérdezi, hogy melyik oszlopban akarja elvégezni a műveletet.
	public int oszlop_lekerdezes() {
		return uj_sor;
	}


}