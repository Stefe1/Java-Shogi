package Jatek;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;
import javax.swing.JPanel;

import Babuk.Arany_tabornok;
import Babuk.Babu;
import Babuk.Bastya;
import Babuk.Ezust_tabornok;
import Babuk.Futo;
import Babuk.Gyalog;
import Babuk.Jari;
import Babuk.Kiraly;
import Babuk.Lovas;
import Babukhoz_valo.Leutott_babuk;
import Fajl_kezeles.Beolvaso;
import Fajl_kezeles.Betoltes_gomb;
import Fajl_kezeles.Kep_beolvaso;
import Fajl_kezeles.Mentes_gomb;

public class Tabla extends JPanel{
	private JButton mentes;
	private JButton betoltes;
	private int lepesszam;
	private Babu jatekter[][];
	private Babu kivalasztott;
	private Kep_beolvaso kep_hash;
	public boolean fekete_checkelve;
	public boolean feher_checkelve;
	private boolean vege;
	private Leutott_babuk leutottek;
	private String leutott_kivalasztott;
	private boolean leutott_kivalasztott_feher_e;
	public Tabla() {
		leutott_kivalasztott=null;
		leutott_kivalasztott_feher_e=false;
		leutottek=new Leutott_babuk();
		vege=false;
		fekete_checkelve=false;
		feher_checkelve=false;
		lepesszam=1;
		this.kivalasztott=null;
		this.setSize(870,800);
		jatekter=new Babu[9][9];
		kep_hash=new Kep_beolvaso();
		for(int i=0;i<9;i++) {
			for(int c=0;c<9;c++) {
				jatekter[i][c]=null;
			}
		}
		
	}
	public Tabla(Kep_beolvaso k)  {
		mentes=new JButton("Mentés");
		betoltes=new JButton("Betöltés");
		leutott_kivalasztott=null;
		leutott_kivalasztott_feher_e=false;
		leutottek=new Leutott_babuk();
		vege=false;
		fekete_checkelve=false;
		feher_checkelve=false;
		lepesszam=1;
		this.kivalasztott=null;
		this.setSize(870,800);
		jatekter=new Babu[9][9];
		kep_hash=k;
		for(int i=0;i<9;i++) {
			for(int c=0;c<9;c++) {
				jatekter[i][c]=null;
			}
		}
		for(int i=0;i<9;i++) {
			jatekter[2][i]=new Gyalog(2, i, false, kep_hash,this);
			jatekter[6][i]=new Gyalog(6, i, true, kep_hash,this);
			
		}
		jatekter[1][1]=new Bastya(1, 1, false, kep_hash, this);
		jatekter[7][7]=new Bastya(7, 7, true, kep_hash, this);
		
		jatekter[1][7]=new Futo(1, 7, false, kep_hash, this);
		jatekter[7][1]=new Futo(7, 1, true, kep_hash, this);
		
		jatekter[0][0]=new Jari(0, 0, false, kep_hash, this);
		jatekter[0][8]=new Jari(0, 8, false, kep_hash, this);
		jatekter[8][0]=new Jari(8, 0, true, kep_hash, this);
		jatekter[8][8]=new Jari(8, 8, true, kep_hash, this);
		
		jatekter[0][1]=new Lovas(0, 1, false, kep_hash,this);
		jatekter[0][7]=new Lovas(0, 7, false, kep_hash,this);
		jatekter[8][1]=new Lovas(8, 1, true, kep_hash,this);
		jatekter[8][7]=new Lovas(8, 7, true, kep_hash,this);
		
		jatekter[0][2]=new Ezust_tabornok(0, 2, false, kep_hash,this);
		jatekter[0][6]=new Ezust_tabornok(0, 6, false, kep_hash,this);
		jatekter[8][2]=new Ezust_tabornok(8, 2, true, kep_hash,this);
		jatekter[8][6]=new Ezust_tabornok(8, 6, true, kep_hash,this);
		
		jatekter[0][3]=new Arany_tabornok(0, 3, false, kep_hash,this);
		jatekter[0][5]=new Arany_tabornok(0, 5, false, kep_hash,this);
		jatekter[8][3]=new Arany_tabornok(8, 3, true, kep_hash,this);
		jatekter[8][5]=new Arany_tabornok(8, 5, true, kep_hash,this);
		
		jatekter[0][4]=new Kiraly(0, 4, false, kep_hash,this);
		jatekter[8][4]=new Kiraly(8, 4, true, kep_hash,this);
		this.setLayout(null);
		mentes.setBounds(760, 40, 90, 50);
		betoltes.setBounds(760, 110, 90, 50);
		betoltes.setBackground(new Color(250,223,173));
		betoltes.setBorderPainted(false);
		mentes.setBackground(new Color(250,223,173));
		mentes.setBorderPainted(false);
		betoltes.addActionListener(new Betoltes_gomb(this));
		mentes.addActionListener(new Mentes_gomb(this));
		this.add(mentes);
		this.add(betoltes);
	}
	public Tabla(Tabla tabla) {
		this.lepesszam=tabla.lepes_lekerdezes();
		this.vege=false;
		this.fekete_checkelve=tabla.fekete_checkelve;
		this.feher_checkelve=tabla.feher_checkelve;
		this.kep_hash=tabla.kep_beolvaso_lekerdezese();
		this.leutottek=new Leutott_babuk(tabla.leutott_lekerdezes());
		this.leutott_kivalasztott=tabla.leutott_kivalasztott_lekerdezese();
		this.leutott_kivalasztott_feher_e=tabla.leutott_kivalasztott_feher_e;
		this.jatekter=new Babu[9][9];
		for(int i=0;i<9;i++) {
			for(int c=0;c<9;c++) {
				jatekter[i][c]=null;
			}
		}
		for(int i=0;i<9;i++) {
			for(int c=0;c<9;c++) {
				if(tabla.foglalt_mezo_e(i, c)) {
					this.jatekter[i][c]=Beolvaso.atalakitas(tabla.mezo_lekerdezes(i, c).tipus_lekerdezes(),tabla.mezo_lekerdezes(i, c).sor_lekerdezes(),tabla.mezo_lekerdezes(i, c).oszlop_lekerdezes(),tabla.mezo_lekerdezes(i, c).feher_e(), tabla.mezo_lekerdezes(i,c).kep_beolvaso_lekerdezes(),this);
				}
			}
		}
		if(tabla.kivalasztott!=null) {
			this.kivalasztott=this.mezo_lekerdezes(tabla.kivalasztott.sor_lekerdezes(), tabla.kivalasztott_lekerdezese().oszlop_lekerdezes());
		}
	}
	//Megváltoztatja a jelenlegi kör értékét a paraméterként kapott számra.
	// Az egyetlen hely, ahol ki van használva az a mentés betöltése, mert ott nem csak 1-el kell növelni a jelenlegi kört.
	public void lepes_modositas(int i) {
		lepesszam=i;
	}
	//Lekérdezi a jelenlegi kör értékét.
	public int lepes_lekerdezes() {
		return lepesszam;
	}
	//Növeli egyel a jelenlegi kört.
	public void lepes_befejezese() {
		lepesszam++;
	}
	//Ellenőrzi, hogy van-e bábu a paraméterként megadott mezőn.
	public boolean foglalt_mezo_e(int sor, int oszlop) {
		if(jatekter[sor][oszlop]!=null) {
			return true;
		}
		return false;
	}
	//lekérdezi a paraméterek által meghatározott mező tartalmát 
	public Babu mezo_lekerdezes(int sor, int oszlop) {
		return  jatekter[sor][oszlop];
	}
	//Megváltoztatja a paraméterként megadott mező tartalmát egy új bábura.
	public void mezo_modositas(Babu uj, int sor, int oszlop) {
		if(uj!=null) {
			uj.sor_modositas(sor);
			uj.oszlop_modositas(oszlop);
		}
		jatekter[sor][oszlop]=uj;
	}
	//Megváltoztatja a kiválasztottat a paraméterként kapott bábura.
	public void kivalasztott_modositasa(Babu uj) {
		kivalasztott=uj;
	}
	//Lekérdezi a kiválasztott bábut.
	public Babu kivalasztott_lekerdezese() {
		return kivalasztott;
	}
	//Megváltoztatja a leütött kiválasztott értékét.
	public void leutott_kivalasztott_modositasa(String tipus) {
		leutott_kivalasztott=tipus;
	}
	//Lekérdezi a leütött kiválasztott típusát.
	public String leutott_kivalasztott_lekerdezese() {
		return leutott_kivalasztott;
	}
	//Módosítja, hogy a leütött kiválasztott melyik csapathoz tartozik
	public void leutott_kivalasztott_feher_e_modositasa(boolean feher) {
		leutott_kivalasztott_feher_e=feher;
	}
	//Lekérdezi, hogy a leütött kiválasztott melyik csapathoz tartozik.
	public boolean leutott_kivalasztott_feher_e_lekerdezese() {
		return leutott_kivalasztott_feher_e;
	}
	//Megkeresi a paraméterként megadott csapat királyát.
	public Babu kiraly_kereso(boolean feher) {
		for(int i=0;i<9;i++) {
			for(int c=0;c<9;c++) {
				if(foglalt_mezo_e(i, c)&&mezo_lekerdezes(i, c).feher_e()==feher&&mezo_lekerdezes(i, c).tipus_lekerdezes().equals("kiraly")) {
					return mezo_lekerdezes(i, c);
					
				}
			}
		}
		return null;
	}
	//Lekérdezi a Kep_beolvaso-t.
	public Kep_beolvaso kep_beolvaso_lekerdezese() {
		return kep_hash;
	}
	//Lekérdezi a leütött bábuk strukturáját.
	public Leutott_babuk leutott_lekerdezes() {
		return leutottek;
	}
	//Lekéredzi, hogy vége van-e a játéknak.
	public boolean vege_lekerdezes() {
		return vege;
	}
	//Megváltoztatja a vege változó értékét.
	public void vege_modositas(boolean vege) {
		this.vege=vege;
	}
	//Kirajzolja a Tabla-hoz tartozó elemeket.
	public synchronized void paint(Graphics g) {
		Graphics2D g2d=(Graphics2D) g;
		g2d.setColor(new Color(186,135,89));
		g2d.fill(getBounds());
		mentes.repaint();
		betoltes.repaint();
		for(int i=0;i<9;i++) {
			for(int c=0;c<9;c++) {
				Rajzolok.mezo_rajzolasa(g2d, this, i, c);
				Rajzolok.kivalasztott_rajzolasa(g2d, this, i, c);
				Leutot_rajzolo.leutott_kivalasztott_rajzolo(g2d, this, i, c);
			}
			Leutot_rajzolo.fekete_leutottek_rajzolasa(g2d, this);
			Leutot_rajzolo.feher_leutottek_rajzolasa(g2d, this);
		}
	}
	
}
