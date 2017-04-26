/**
 * 
 */
package fr.barde.fenetre;

import javax.swing.JFrame;

/**
 * @author Alexandre
 * TODO
 * 8 mars 2017:15:07:42
 */
public class Fenetre extends JFrame{

	public Fenetre(){
		this.setTitle("Test");
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setUndecorated(false);
		this.setVisible(true);
		
		//Objet JPanel
		this.setContentPane(new Panneau());
		this.setVisible(true);
	}
	
}
