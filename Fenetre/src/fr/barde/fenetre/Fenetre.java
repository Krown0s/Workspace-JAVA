package fr.barde.fenetre;

import javax.swing.JFrame;

public class Fenetre extends JFrame{

	public Fenetre(){
		this.setTitle("Test");
		this.setSize(720, 480);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setContentPane(new Panneau());
		this.setVisible(true);
	}
	
}
