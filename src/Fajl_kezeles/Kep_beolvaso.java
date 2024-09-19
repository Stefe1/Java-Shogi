package Fajl_kezeles;

import java.util.HashMap;

import javax.imageio.ImageIO;

import java.awt.Image;
import java.io.File;

//Struktúra, hogy csak egy típust kelljen megadni, és meg is kapja a bábu az ő képét
public class Kep_beolvaso {
	public HashMap<String, Image> kepek;
	public Kep_beolvaso() {
		kepek=new HashMap<String, Image>();
		File path=new File("res");
		File[] fajlok=path.listFiles();
		try {
			kepek.put("arany_tabornok", ImageIO.read(fajlok[0]));
			kepek.put("bastya", ImageIO.read(fajlok[1]));
			kepek.put("eloleptetett_bastya", ImageIO.read(fajlok[2]));
			kepek.put("eloleptetett_ezust_tabornok", ImageIO.read(fajlok[3]));
			kepek.put("eloleptetett_futo", ImageIO.read(fajlok[4]));
			kepek.put("eloleptetett_gyalog", ImageIO.read(fajlok[5]));
			kepek.put("eloleptetett_jari", ImageIO.read(fajlok[6]));
			kepek.put("eloleptetett_lovas", ImageIO.read(fajlok[7]));
			kepek.put("ezust_tabornok", ImageIO.read(fajlok[8]));
			kepek.put("futo", ImageIO.read(fajlok[9]));
			kepek.put("gyalog", ImageIO.read(fajlok[10]));
			kepek.put("jari", ImageIO.read(fajlok[11]));
			kepek.put("kiraly", ImageIO.read(fajlok[12]));
			kepek.put("lovas", ImageIO.read(fajlok[13]));
			kepek.put("szurke_arany_tabornok",ImageIO.read(fajlok[14]));
			kepek.put("szurke_bastya",ImageIO.read(fajlok[15]));
			kepek.put("szurke_ezust_tabornok",ImageIO.read(fajlok[16]));
			kepek.put("szurke_futo",ImageIO.read(fajlok[17]));
			kepek.put("szurke_gyalog",ImageIO.read(fajlok[18]));
			kepek.put("szurke_jari",ImageIO.read(fajlok[19]));
			kepek.put("szurke_lovas",ImageIO.read(fajlok[20]));
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	}
	
}

