import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Alexandre
 * TODO
 * 24 f�vr. 2017:11:11:31
 */
public class TestPointColore {

	private final PointColore PO = PointColore.POINT_ORIGINE;
	private PointColore pc = new PointColore(1.0, 2.0, 0, 255, 0); //Point test
	
	@Test
	public void test1(){ //V�rification coordonn�es POINT_ORIGINE.
		assertEquals(0.0, PO.getAbscisse(), 0);
		assertEquals(0.0, PO.getOrdonnee(), 0);
	}
	
	@Test
	public void test2(){ //V�rification couleurs POINT_ORIGINE.
		assertEquals(0, PO.getBleu());
		assertEquals(0, PO.getRouge());
		assertEquals(0, PO.getVert());
	}
	
	@Test
	public void test3(){ //Modification et v�rification couleur de PointColore test.
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
	public void test4(){ //V�rification de la m�thode translater
		pc.translater(2, 2);
		assertEquals(3, pc.getAbscisse(), 0);
		assertEquals(4, pc.getOrdonnee(), 0);
	}
	
	@Test
	public void test5(){ //V�rification de la m�thode mettre � �chelle
		pc.mettreAEchelle(2);
		assertEquals(2, pc.getAbscisse(), 0);
		assertEquals(4, pc.getOrdonnee(), 0);
	}
	
	@Test(expected = IllegalArgumentException.class) //V�rification de la valeur n�gative de la couleur rouge
	public void valeurN�gativeCouleurR(){
		@SuppressWarnings("unused")
		Point p = new PointColore(1.0, 2.0, -1, 255, 0);
	}
	
	@Test(expected = IllegalArgumentException.class) //V�rification de la valeur n�gative de la couleur vert
	public void valeurN�gativeCouleurV(){
		@SuppressWarnings("unused")
		Point p = new PointColore(1.0, 2.0, 0, -255, 0);
	}
	
	@Test(expected = IllegalArgumentException.class) //V�rification de la valeur n�gative de la couleur bleu
	public void valeurN�gativeCouleurB(){
		@SuppressWarnings("unused")
		Point p = new PointColore(1.0, 2.0, 0, 255, -1);
	}
}
