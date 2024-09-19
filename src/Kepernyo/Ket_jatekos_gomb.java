package Kepernyo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Fajl_kezeles.Kep_beolvaso;
import Jatek.Bemenet;
import Jatek.Jatek_vege;
import Jatek.Jatek_vege_ellenorzo;
import Jatek.Tabla;

public class Ket_jatekos_gomb implements ActionListener{
	private My_Frame program;
	public Ket_jatekos_gomb(My_Frame program) {
		this.program=program;
	}
	//Létrehoz egy új játékmenetet két játékossal. A menüben található gombokat láthatatlanná teszi, és kikapcsolja azokat.
	public void actionPerformed(ActionEvent e)  {
		program.jatek=new Tabla(new Kep_beolvaso());
		Jatek_vege jv=new Jatek_vege();
		Jatek_vege_ellenorzo jatekfigyelo=new Jatek_vege_ellenorzo(program,program.jatek,jv);
		program.jatek.addMouseListener(new Bemenet(program.jatek,false,false));
		program.add(program.jatek);
		jatekfigyelo.start();
		program.nulla_jatekos.setVisible(false);
		program.egy_jatekos.setVisible(false);
		program.ketto_jatekos.setVisible(false);
		program.nulla_jatekos.setEnabled(false);
		program.egy_jatekos.setEnabled(false);
		program.ketto_jatekos.setEnabled(false);
		program.repaint();
		
	}
}
