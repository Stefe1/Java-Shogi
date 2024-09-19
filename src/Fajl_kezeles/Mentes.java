package Fajl_kezeles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import Jatek.Tabla;

public final class Mentes {
	//Lementi a játék jelenlegi helyzetét
	public static void mentes(Tabla jatekter) throws IOException {
		FileWriter fw=new FileWriter("jatekmenet.txt");
		PrintWriter pw =new PrintWriter(fw);
		pw.println(jatekter.lepes_lekerdezes());
		

		for(int i=0;i<9;i++) {
			String sor=new String();
			for(int c=0;c<9;c++) {
				if(jatekter.foglalt_mezo_e(i, c)) {
					sor+=jatekter.mezo_lekerdezes(i, c).tipus_lekerdezes()+",";
					sor+=jatekter.mezo_lekerdezes(i, c).sor_lekerdezes()+",";
					sor+=jatekter.mezo_lekerdezes(i, c).oszlop_lekerdezes()+",";
					if(jatekter.mezo_lekerdezes(i, c).feher_e()) {
						sor+="feher";
					}
					else {
						sor+="fekete";
					}

				}
				else {
					sor+=",,,";
				}
				if(c!=8) {
					sor+=";";
				}
			}
			pw.println(sor);
		}
		jatekter.leutott_lekerdezes().feher_leutottek.forEach((k,v)->pw.println(k+";"+v));
		jatekter.leutott_lekerdezes().fekete_leutottek.forEach((k,v)->pw.println(k+";"+v));
		pw.close();
	}
	//Betölti a jatekmenet.txt file tartalmát
	public static void betoltes(Tabla jatekter) throws FileNotFoundException{
    	File myObj = new File("jatekmenet.txt");
	    if(myObj.exists()) {
	    	Scanner myReader = new Scanner(myObj);
	    	String data=myReader.nextLine();
	    	jatekter.lepes_modositas(Integer.parseInt(data));
	    	for(int i=0;i<9;i++) {
	    		String szoveg=myReader.nextLine();
	    		String[] babuk=szoveg.split(";");
	    		for(int c=0;c<9;c++) {
	    			if(babuk[c].equals(",,,")) {
	    				jatekter.mezo_modositas(null, i, c);
	    			}
	    			else {
	    				String[] parameterek=babuk[c].split(",");
	    				String tipus=parameterek[0];
	    				int sor=Integer.parseInt(parameterek[1]), oszlop=Integer.parseInt(parameterek[2]);
	    				boolean feher;
	    				if(parameterek[3].equals("feher")) {
	    					feher=true;
	    				}
	    				else {
	    					feher=false;
	    				}
	    				jatekter.mezo_modositas(Beolvaso.atalakitas(tipus, sor, oszlop, feher, jatekter.kep_beolvaso_lekerdezese(), jatekter), sor, oszlop);
	    			}
	    		}
	    	}
		    for(int i=0;i<7;i++) {
	    		String szoveg=myReader.nextLine();
	    		String[] parameterek=szoveg.split(";");
		    	jatekter.leutott_lekerdezes().feher_leutottek.put(parameterek[0], Integer.parseInt(parameterek[1]));
		    }
		    for(int i=0;i<7;i++) {
	    		String szoveg=myReader.nextLine();
	    		String[] parameterek=szoveg.split(";");
		    	jatekter.leutott_lekerdezes().fekete_leutottek.put(parameterek[0], Integer.parseInt(parameterek[1]));
		    }
		    myReader.close();
	    }
	    else {
	    	return;
	    }
	   
	    
	    
	}
}
