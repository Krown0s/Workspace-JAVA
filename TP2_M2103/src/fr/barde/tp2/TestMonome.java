/**
 * 
 */
package fr.barde.tp2;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Alexandre 3 mars 2017:09:55:36
 */
public class TestMonome {

	Monome m = new Monome(0.0F, 1);
	Monome m2 = new Monome(1.0F, 1);
	Monome test = new Monome(m.getCoefficient(), m.getExposant()); // Pour
																	// vérifier
																	// le
																	// .equals

	@Test
	public void getCoefficient() {
		assertEquals(0.0F, m.getCoefficient(), 0);
	}

	@Test
	public void getExposant() {
		assertEquals(1, m.getExposant());
	}

	@Test
	public void somme() {
		assertEquals(1.0F, m.somme(m2).getCoefficient(), 0);
		assertEquals(1, m.somme(m2).getExposant());

	}

	@Test
	public void produit() {
		assertEquals(0.0F, m.produit(m2).getCoefficient(), 0);
		assertEquals(2, m.produit(m2).getExposant());
	}

	@Test
	public void deriveeEgal0() {
		assertEquals(0.0F, m.derivee().getCoefficient(), 0);
		assertEquals(0, m.derivee().getExposant());
	}

	@Test
	public void deriveeDifferent0() {
		assertEquals(1.0F, m2.derivee().getCoefficient(), 0);
		assertEquals(0, m2.derivee().getExposant());
	}

	@Test
	public void equals() {
		assertEquals(true, m.equals(test));
	}

	@Test
	public void estNul() {
		assertEquals(true, m.estNul());
	}

	@Test
	public void setCoefficient() {
		m.setCoefficient(3.0F);
		assertEquals(3.0F, m.getCoefficient(), 0);
	}

	@Test
	public void setExposant() {
		m.setExposant(3);
		assertEquals(3, m.getExposant());
	}

	@Test(expected = IllegalArgumentException.class)
	public void monomeNegatif() {
		@SuppressWarnings("unused")
		Monome negatif = new Monome(0.0F, -1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void exposantsDifferent() {
		Monome diff = new Monome(1.0F, 3);
		m.somme(diff);
	}

}
