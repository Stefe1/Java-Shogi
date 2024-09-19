package Jatek;

import Kepernyo.My_Frame;

public class Jatek_vege{
	//Ha vége a játéknak, akkor leveszi a képernyőröl a játékot
	public void vege(Tabla jatek, My_Frame program) {
		while(!jatek.vege_lekerdezes()) {
			try {
				Thread.sleep(50);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		Thread.currentThread().interrupt();
		program.remove(jatek);
		program.nulla_jatekos.setVisible(true);
		program.egy_jatekos.setVisible(true);
		program.ketto_jatekos.setVisible(true);
		program.nulla_jatekos.setEnabled(true);
		program.egy_jatekos.setEnabled(true);
		program.ketto_jatekos.setEnabled(true);
		program.repaint();
		
	}

}
