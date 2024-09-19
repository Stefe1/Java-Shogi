package Fajl_kezeles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Jatek.Tabla;

final public class Mentes_gomb implements ActionListener {
	Tabla jatekter;
	public Mentes_gomb(Tabla jatekter) {
		this.jatekter=jatekter;
	}
	//Gomb nyomására lementi a tábla jelenlegi helyzetét
	@Override
	public void actionPerformed(ActionEvent e)  {
		try {
			Mentes.mentes(jatekter);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
}
