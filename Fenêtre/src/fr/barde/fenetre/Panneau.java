/**
 * 
 */
package fr.barde.fenetre;

import java.awt.Graphics;

import javax.swing.JPanel;

	//x --->
	//   |
	// y v

/**
 * @author Alexandre
 * 8 mars 2017:15:19:06
 */
public class Panneau extends JPanel{

	public void paintComponent(Graphics g){
		g.drawLine(100, 100, this.getWidth()-100, this.getHeight()-100);
		g.drawLine(100, 100, 400, 100);
		g.drawLine(100, 100, 100, 400);
	}
	
}
