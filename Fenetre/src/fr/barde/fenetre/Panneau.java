package fr.barde.fenetre;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Panneau extends JPanel{

	public void paintComponent(Graphics g){
		g.setColor (Color.gray);
		g.draw3DRect (25, 10, 50, 75, true);
		g.draw3DRect (25, 110, 50, 75, false);
		g.fill3DRect (100, 10, 50, 75, true);
		g.fill3DRect (100, 110, 50, 75, false);
		g.
	}
	
}
