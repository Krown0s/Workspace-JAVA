package fr.barde.tp13;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test2 {

	
	@Test
	public void testGetters(){
		DureeEnSecondes d = new DureeEnSecondes(5, 25, 45);
		assertEquals(5, d.getHeures());
		assertEquals(25, d.getMinutes());
		assertEquals(45, d.getSecondes());
	}
	
	@Test(expected = IllegalArgumentException.class) 
	public void testHeuresNegative() {
		DureeEnSecondes d = new DureeEnSecondes(-1, 1, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMinutesNegative(){
		DureeEnSecondes d = new DureeEnSecondes(1, -1, 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSecondesNegative(){
		DureeEnSecondes d = new DureeEnSecondes(1, 1, -1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testMinutesSuperieur59(){
		DureeEnSecondes d = new DureeEnSecondes(1, 60, 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSecondesSuperieur59(){
		DureeEnSecondes d = new DureeEnSecondes(1, 1, 60);
	}
	
	@Test
	public void testEqualsValeursEgales(){
		DureeEnSecondes d = new DureeEnSecondes(1, 1, 1);
		DureeEnSecondes d2 = new DureeEnSecondes(1, 1, 1);
		assertEquals(true, d.equals(d2));
	}
	
	@Test
	public void testEqualsValeursNonEgales(){
		DureeEnSecondes d = new DureeEnSecondes(1, 1, 1);
		DureeEnSecondes d2 = new DureeEnSecondes(2, 1, 1);
		DureeEnSecondes d3 = new DureeEnSecondes(1, 2, 1);
		DureeEnSecondes d4 = new DureeEnSecondes(1, 1, 2);
		assertEquals(false, d.equals(d2));
		assertEquals(false, d.equals(d3));
		assertEquals(false, d.equals(d4));
	}
	
	@Test
	public void testAjouterUneSeconde(){
		DureeEnSecondes d = new DureeEnSecondes(1, 1, 1);
		d.ajouterUneSeconde();
		assertEquals(2, d.getSecondes());
		DureeEnSecondes d2 = new DureeEnSecondes(1, 1, 59);
		d2.ajouterUneSeconde();
		assertEquals(2, d2.getMinutes());
		DureeEnSecondes d3 = new DureeEnSecondes(1, 59, 59);
		d3.ajouterUneSeconde();
		assertEquals(2, d3.getHeures());
	}

	
	@Test
	public void testCompareTo(){
		DureeEnSecondes d = new DureeEnSecondes(1, 1, 1);
		DureeEnSecondes d2 = new DureeEnSecondes(1, 1, 2);
		assertEquals(-1, d.compareTo(d2));
		d.ajouterUneSeconde();
		assertEquals(0, d.compareTo(d2));
		d.ajouterUneSeconde();
		assertEquals(1, d.compareTo(d2));
	}
	
	@Test
	public void testToString(){
		DureeEnSecondes d = new DureeEnSecondes(1, 1, 1);
		assertEquals("1:1:1", d.toString());
	}

	
}
