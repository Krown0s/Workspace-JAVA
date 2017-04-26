import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Alexandre
 * TODO
 * 24 févr. 2017:11:11:31
 */
public class TestPointColore {

	private final PointColore PO = PointColore.POINT_ORIGINE;
	private PointColore pc = new PointColore(1.0, 2.0, 0, 255, 0); //Point test
	
	@Test
	public void test1(){ //Vérification coordonnées POINT_ORIGINE.
		assertEquals(0.0, PO.getAbscisse(), 0);
		assertEquals(0.0, PO.getOrdonnee(), 0);
	}
	
	@Test
	public void test2(){ //Vérification couleurs POINT_ORIGINE.
		assertEquals(0, PO.getBleu());
		assertEquals(0, PO.getRouge());
		assertEquals(0, PO.getVert());
	}
	
	@Test
	public void test3(){ //Modification et vérification couleur de PointColore test.
		assertEquals(0, pc.getRouge());
		assertEquals(255, pc.getVert());
		assertEquals(0, pc.getBleu());
		pc.setRouge(255);
		pc.setVert(0);
		pc.setBleu(255);
		assertEquals(255, pc.getRouge());
		assertEquals(0, pc.getVert());
		assertEquals(255, pc.getBleu());
	}
	
	@Test
	public void test4(){ //Vérification de la méthode translater
		pc.translater(2, 2);
		assertEquals(3, pc.getAbscisse(), 0);
		assertEquals(4, pc.getOrdonnee(), 0);
	}
	
	@Test
	public void test5(){ //Vérification de la méthode mettre à échelle
		pc.mettreAEchelle(2);
		assertEquals(2, pc.getAbscisse(), 0);
		assertEquals(4, pc.getOrdonnee(), 0);
	}
	
	@Test(expected = IllegalArgumentException.class) //Vérification de la valeur négative de la couleur rouge
	public void valeurNégativeCouleurR(){
		@SuppressWarnings("unused")
		Point p = new PointColore(1.0, 2.0, -1, 255, 0);
	}
	
	@Test(expected = IllegalArgumentException.class) //Vérification de la valeur négative de la couleur vert
	public void valeurNégativeCouleurV(){
		@SuppressWarnings("unused")
		Point p = new PointColore(1.0, 2.0, 0, -255, 0);
	}
	
	@Test(expected = IllegalArgumentException.class) //Vérification de la valeur négative de la couleur bleu
	public void valeurNégativeCouleurB(){
		@SuppressWarnings("unused")
		Point p = new PointColore(1.0, 2.0, 0, 255, -1);
	}
}
