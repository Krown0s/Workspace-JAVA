import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 */

/**
 * @author Alexandre
 * TODO
 * 22 févr. 2017:10:21:38
 */
public class CouleurTest {

	@Test
	public void testP1() {
		assertEquals(255, Couleur.ROUGE.getRouge());
		assertEquals(0, Couleur.ROUGE.getVert());
		assertEquals(0, Couleur.ROUGE.getBleu());
	}
	
	@Test
	public void testP2() {
		assertEquals(0, Couleur.VERT.getRouge());
		assertEquals(255, Couleur.VERT.getVert());
		assertEquals(0, Couleur.VERT.getBleu());
	}
	
	@Test
	public void testP3() {
		assertEquals(0, Couleur.BLEU.getRouge());
		assertEquals(0, Couleur.BLEU.getVert());
		assertEquals(255, Couleur.BLEU.getBleu());
	}
	
	@Test
	public void testP4P5P6Getter() {
		Couleur c = new Couleur(1, 2 ,3);
		assertEquals(1, c.getRouge());
		assertEquals(2,	c.getVert());
		assertEquals(3, c.getBleu());
	}

	@Test
	public void testP7SetterRouge() {
		Couleur c = new Couleur(1, 2, 3);
		c.setRouge(10);
		assertEquals(10, c.getRouge());
		assertEquals(2, c.getVert());
		assertEquals(3, c.getBleu());
	}
	
	@Test
	public void testP8SetterVert() {
		Couleur c = new Couleur(1, 2, 3);
		c.setVert(10);
		assertEquals(1, c.getRouge());
		assertEquals(10, c.getVert());
		assertEquals(3, c.getBleu());
	}
	
	@Test
	public void testP9SetterBleu() {
		Couleur c = new Couleur(1, 2, 3);
		c.setBleu(10);
		assertEquals(1, c.getRouge());
		assertEquals(2, c.getVert());
		assertEquals(10, c.getBleu());
	}
	
	
	public void testP10ValeurRVB() {
		Couleur c = new Couleur(1, 2, 3);
		assertEquals(66051, c.valeurRVB());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testValeurNégativeComposanteRouge(){
		Couleur c = new Couleur(-1, 2 ,3);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testValeurNégativeComposanteVert(){
		Couleur c = new Couleur(1, -2 ,3);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testValeurNégativeComposanteBleu(){
		Couleur c = new Couleur(1, 2 ,-3);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testValeurGrandeComposanteBleu(){
		Couleur c = new Couleur(1, 2 ,3000);
	}
	
}
