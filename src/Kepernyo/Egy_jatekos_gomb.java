package Kepernyo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import Fajl_kezeles.Kep_beolvaso;
import Jatek.Bemenet;
import Jatek.Jatek_vege;
import Jatek.Jatek_vege_ellenorzo;
import Jatek.Robot;
import Jatek.Robot_lepes;
import Jatek.Tabla;

public class Egy_jatekos_gomb implements ActionListener{
	private My_Frame program;
	public Egy_jatekos_gomb(My_Frame program) {
		this.program=program;
	}
	//Létrehoz egy új játékmenetet egy bottal és egy játékossal.
	//A színeket egy random szám alapján dönti el. A menüben található gombokat láthatatlanná teszi, és kikapcsolja azokat.
	public void actionPerformed(ActionEvent e)  {
		program.jatek=new Tabla(new Kep_beolvaso());
		Jatek_vege jv=new Jatek_vege();
		Jatek_vege_ellenorzo jatekfigyelo=new Jatek_vege_ellenorzo(program,program.jatek,jv);
		Random rnd=new Random();
		int melyik=rnd.nextInt(2);
		if(melyik==0) {
			Robot_lepes rl=new Robot_lepes();
			Robot egy=new Robot(program.jatek, true,rl);
			program.jatek.addMouseListener(new Bemenet(program.jatek,true,false));
			egy.start();
		}
		else {
			Robot_lepes rl=new Robot_lepes();
			Robot egy=new Robot(program.jatek, false,rl);
			program.jatek.addMouseListener(new Bemenet(program.jatek,true,true));
			egy.start();
		}
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
