package Fajl_kezeles;

import Babuk.Arany_tabornok;
import Babuk.Babu;
import Babuk.Bastya;
import Babuk.Eloleptetett_bastya;
import Babuk.Eloleptetett_ezust_tabornok;
import Babuk.Eloleptetett_futo;
import Babuk.Eloleptetett_gyalog;
import Babuk.Eloleptetett_jari;
import Babuk.Eloleptetett_lovas;
import Babuk.Ezust_tabornok;
import Babuk.Futo;
import Babuk.Gyalog;
import Babuk.Jari;
import Babuk.Kiraly;
import Babuk.Lovas;
import Jatek.Tabla;

public  final  class Beolvaso {
	//Létrehoz a paraméterkként megadott értékekkel egy új bábut
	public static Babu atalakitas(String tipus, int sor, int oszlop,boolean feher_e,Kep_beolvaso kep_hash, Tabla tabla) {
		switch (tipus) {
			case "arany_tabornok": {
				return new Arany_tabornok(sor, oszlop, feher_e,kep_hash , tabla);
			}
			case "bastya": {
				return new Bastya(sor, oszlop, feher_e,kep_hash , tabla);
			}
			case "eloleptetett_bastya": {
				return new Eloleptetett_bastya(sor, oszlop, feher_e,kep_hash , tabla);
			}
			case "eloleptetett_ezust_tabornok": {
				return new Eloleptetett_ezust_tabornok(sor, oszlop, feher_e,kep_hash , tabla);
			}
			case "eloleptetett_futo": {
				return new Eloleptetett_futo(sor, oszlop, feher_e,kep_hash , tabla);
			}
			case "eloleptetett_gyalog": {
				return new Eloleptetett_gyalog(sor, oszlop, feher_e,kep_hash , tabla);
			}
			case "eloleptetett_jari": {
				return new Eloleptetett_jari(sor, oszlop, feher_e,kep_hash , tabla);
			}
			case "eloleptetett_lovas": {
				return new Eloleptetett_lovas(sor, oszlop, feher_e,kep_hash , tabla);
			}
			case "ezust_tabornok": {
				return new Ezust_tabornok(sor, oszlop, feher_e,kep_hash , tabla);
			}
			case "futo": {
				return new Futo(sor, oszlop, feher_e,kep_hash , tabla);
			}
			case "gyalog": {
				return new Gyalog(sor, oszlop, feher_e,kep_hash , tabla);
			}
			case "jari": {
				return new Jari(sor, oszlop, feher_e,kep_hash , tabla);
			}
			case "kiraly": {
				return new Kiraly(sor, oszlop, feher_e,kep_hash , tabla);
			}
			case "lovas": {
				return new Lovas(sor, oszlop, feher_e,kep_hash , tabla);
			}
			default:
				return null;
			}
	}
}
