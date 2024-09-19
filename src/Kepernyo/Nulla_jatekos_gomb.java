package Kepernyo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Fajl_kezeles.Kep_beolvaso;
import Jatek.Jatek_vege;
import Jatek.Jatek_vege_ellenorzo;
import Jatek.Robot;
import Jatek.Robot_lepes;
import Jatek.Tabla;

public class Nulla_jatekos_gomb implements ActionListener{
	private My_Frame program;
	public Nulla_jatekos_gomb(My_Frame program) {
		this.program=program;
	}
	//Létrehoz egy új játékmenetet 2 bottal. A menüben található gombokat láthatatlanná teszi, és kikapcsolja azokat.
	public void actionPerformed(ActionEvent e)  {
		program.jatek=new Tabla(new Kep_beolvaso());
		Jatek_vege jv=new Jatek_vege();
		Jatek_vege_ellenorzo jatekfigyelo=new Jatek_vege_ellenorzo(program,program.jatek,jv);
		Robot_lepes rl=new Robot_lepes();
		Robot botketto=new Robot(program.jatek, false,rl);
		Robot botegy=new Robot(program.jatek, true,rl);
		botegy.start();
		botketto.start();
		jatekfigyelo.start();
		program.nulla_jatekos.setVisible(false);
		program.egy_jatekos.setVisible(false);
		program.ketto_jatekos.setVisible(false);
		program.nulla_jatekos.setEnabled(false);
		program.egy_jatekos.setEnabled(false);
		program.ketto_jatekos.setEnabled(false);
		program.add(program.jatek);
		program.repaint();
	}
}
