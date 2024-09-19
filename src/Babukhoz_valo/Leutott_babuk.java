package Babukhoz_valo;

import java.util.HashMap;

//Struktúra, amivel eltárolom, a leütött bábukból mennyi van színenként külön szedve
public class Leutott_babuk {
	public HashMap<String, Integer> feher_leutottek;
	public HashMap<String, Integer> fekete_leutottek;
	public Leutott_babuk() {
		feher_leutottek=new HashMap<String, Integer>();
		fekete_leutottek=new HashMap<String, Integer>();
		feher_leutottek.put("arany_tabornok", 0);
		fekete_leutottek.put("arany_tabornok", 0);
		
		feher_leutottek.put("bastya", 0);
		fekete_leutottek.put("bastya", 0);
		
		feher_leutottek.put("ezust_tabornok", 0);
		fekete_leutottek.put("ezust_tabornok", 0);
		
		feher_leutottek.put("futo", 0);
		fekete_leutottek.put("futo", 0);
		
		feher_leutottek.put("gyalog", 0);
		fekete_leutottek.put("gyalog", 0);
		
		feher_leutottek.put("jari", 0);
		fekete_leutottek.put("jari", 0);
		
		feher_leutottek.put("lovas", 0);
		fekete_leutottek.put("lovas", 0);
	}
	public Leutott_babuk(Leutott_babuk lb) {
		feher_leutottek=new HashMap<String, Integer>();
		fekete_leutottek=new HashMap<String, Integer>();
		feher_leutottek.put("arany_tabornok", lb.feher_leutottek.get("arany_tabornok"));
		fekete_leutottek.put("arany_tabornok", lb.fekete_leutottek.get("arany_tabornok"));
		
		
		feher_leutottek.put("bastya", lb.feher_leutottek.get("bastya"));
		fekete_leutottek.put("bastya", lb.fekete_leutottek.get("bastya"));
		
		feher_leutottek.put("ezust_tabornok", lb.feher_leutottek.get("ezust_tabornok"));
		fekete_leutottek.put("ezust_tabornok", lb.fekete_leutottek.get("ezust_tabornok"));
		
		feher_leutottek.put("futo", lb.feher_leutottek.get("futo"));
		fekete_leutottek.put("futo", lb.fekete_leutottek.get("futo"));
		
		feher_leutottek.put("gyalog", lb.feher_leutottek.get("gyalog"));
		fekete_leutottek.put("gyalog", lb.fekete_leutottek.get("gyalog"));
		
		feher_leutottek.put("jari", lb.feher_leutottek.get("jari"));
		fekete_leutottek.put("jari", lb.fekete_leutottek.get("jari"));
		
		feher_leutottek.put("lovas", lb.feher_leutottek.get("lovas"));
		fekete_leutottek.put("lovas", lb.fekete_leutottek.get("lovas"));
	}
	//A paraméterként megadott szín és típus által meghatározott bábuhoz hozzáad 1-t
	public void hozzadas(boolean feher,String tipus) {
		if(feher&&feher_leutottek.containsKey(tipus)) {
			feher_leutottek.compute(tipus, (k,v)->v+1);
		}
		else if(!feher&&feher_leutottek.containsKey(tipus)) {
			fekete_leutottek.compute(tipus, (k,v)->v+1);
		}
	}
	//A paraméterként megadott szín és típus által meghatározott bábuhoz kivon 1-t
	public void kivonas(boolean feher, String tipus) {
		if(feher&&feher_leutottek.containsKey(tipus)&&feher_leutottek.get(tipus)!=0) {
			feher_leutottek.compute(tipus, (k,v)->v-1);
		}
		else if(!feher&&fekete_leutottek.containsKey(tipus)&&fekete_leutottek.get(tipus)!=0) {
			fekete_leutottek.compute(tipus, (k,v)->v-1);
		}
	}
	//A paraméterként megadott szín és típus által meghatározott bábuból van-e
	public boolean van_belole(String tipus,boolean feher) {
		if(feher&&feher_leutottek.get(tipus)!=0) {
			return true;
		}
		else if(!feher&&fekete_leutottek.get(tipus)!=0) {
			return true;
		}
		return false;
	}
}
