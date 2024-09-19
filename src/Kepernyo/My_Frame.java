package Kepernyo;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import Jatek.Tabla;

//Létrehoz egy új ablakot, amelyen elhelyez 3 gombot. Ezekkel a gombokkal lehet navigálni a különböző játékmódok között.
public class My_Frame extends JFrame {
	public Tabla jatek;
	public JButton nulla_jatekos;
	public JButton egy_jatekos;
	public JButton ketto_jatekos;
	public My_Frame() {
		super("Shogi");
		nulla_jatekos=new JButton("0 játékos");
		egy_jatekos=new JButton("1 játékos");
		ketto_jatekos=new JButton("2 játékos");
		this.setLayout(null);
		nulla_jatekos.setBounds(400, 300, 100, 50);
		egy_jatekos.setBounds(400, 370, 100, 50);
		ketto_jatekos.setBounds(400, 440, 100, 50);
		nulla_jatekos.setBackground(new Color(250,223,173));
		nulla_jatekos.setBorderPainted(false);
		egy_jatekos.setBackground(new Color(250,223,173));
		egy_jatekos.setBorderPainted(false);
		ketto_jatekos.setBackground(new Color(250,223,173));
		ketto_jatekos.setBorderPainted(false);
		nulla_jatekos.addActionListener(new Nulla_jatekos_gomb(this));
		egy_jatekos.addActionListener(new Egy_jatekos_gomb(this));
		ketto_jatekos.addActionListener(new Ket_jatekos_gomb(this));
		this.add(nulla_jatekos);
		this.add(egy_jatekos);
		this.add(ketto_jatekos);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setBackground(new Color(186,135,89));
		this.setSize(870,800);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	}
}
