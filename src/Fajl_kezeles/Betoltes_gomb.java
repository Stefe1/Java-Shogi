package Fajl_kezeles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Jatek.Tabla;

final public class Betoltes_gomb implements ActionListener {
	private Tabla jatekter;
	public Betoltes_gomb(Tabla jatekter) {
		this.jatekter=jatekter;
	}
	//Gomb nyomásra betölti a mentést
	@Override
	public void actionPerformed(ActionEvent e)  {
		try {
			Mentes.betoltes(jatekter);
			jatekter.repaint();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
}
