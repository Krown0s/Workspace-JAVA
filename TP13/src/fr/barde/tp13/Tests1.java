package fr.barde.tp13;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Tests1 {

	protected FabriqueADuree yolo;
	
	private DureeEnHeuresMinutesSecondes d, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d13, d14, d15, d16, d17, d18;
	
	@Before
	public void setUp() throws Exception{
		this.d = new DureeEnHeuresMinutesSecondes(5, 25, 45);
		this.d2 = new DureeEnHeuresMinutesSecondes(5, 25, 45);
	}
	
	@After
	public void tearDown() throws Exception{
		this.d = null;
		this.d2 = null;
		this.d3 = null;
		this.d4 = null;
		this.d5 = null;
		this.d6 = null;
		this.d7 = null;
		this.d8 = null;
		this.d9 = null;
		this.d10 = null;
		this.d11 = null;
		this.d12 = null;
		this.d13 = null;
		this.d14 = null;
		this.d15 = null;
		this.d16 = null;
		this.d17 = null;
		this.d18 = null;
	}
	
	@Test
	public void testGetters(){
		assertEquals(5, d.getHeures());
		assertEquals(25, d.getMinutes());
		assertEquals(45, d.getSecondes());
	}
	
	@Test(expected = IllegalArgumentException.class) 
	public void testHeuresNegative() {
		this.d3 = new DureeEnHeuresMinutesSecondes(-1, 1, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMinutesNegative(){
		this.d4 = new DureeEnHeuresMinutesSecondes(1, -1, 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSecondesNegative(){
		this.d5 = new DureeEnHeuresMinutesSecondes(1, 1, -1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testMinutesSuperieur59(){
		this.d6 = new DureeEnHeuresMinutesSecondes(1, 60, 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSecondesSuperieur59(){
		this.d7 = new DureeEnHeuresMinutesSecondes(1, 1, 60);
	}
	
	@Test
	public void testEqualsValeursEgales(){
		this.d8 = new DureeEnHeuresMinutesSecondes(1, 1, 1);
		this.d9 = new DureeEnHeuresMinutesSecondes(1, 1, 1);
		assertEquals(true, d8.equals(d9));
	}
	
	@Test
	public void testEqualsValeursNonEgales(){
		this.d10 = new DureeEnHeuresMinutesSecondes(1, 1, 1);
		this.d11 = new DureeEnHeuresMinutesSecondes(2, 1, 1);
		this.d12 = new DureeEnHeuresMinutesSecondes(1, 2, 1);
		this.d13 = new DureeEnHeuresMinutesSecondes(1, 1, 2);
		assertEquals(false, d10.equals(d11));
		assertEquals(false, d10.equals(d12));
		assertEquals(false, d10.equals(d13));
	}
	
	@Test
	public void testAjouterUneSeconde(){
		this.d13 = new DureeEnHeuresMinutesSecondes(1, 1, 1);
		d13.ajouterUneSeconde();
		assertEquals(2, d13.getSecondes());
		this.d14 = new DureeEnHeuresMinutesSecondes(1, 1, 59);
		d14.ajouterUneSeconde();
		assertEquals(2, d14.getMinutes());
		this.d15 = new DureeEnHeuresMinutesSecondes(1, 59, 59);
		d15.ajouterUneSeconde();
		assertEquals(2, d15.getHeures());
	}

	
	@Test
	public void testCompareTo(){
		this.d16 = new DureeEnHeuresMinutesSecondes(1, 1, 1);
		this.d17 = new DureeEnHeuresMinutesSecondes(1, 1, 2);
		assertEquals(-1, d16.compareTo(d17));
		d16.ajouterUneSeconde();
		assertEquals(0, d16.compareTo(d17));
		d16.ajouterUneSeconde();
		assertEquals(1, d16.compareTo(d17));
	}
	
	@Test
	public void testToString(){
		this.d18 = new DureeEnHeuresMinutesSecondes(1, 1, 1);
		assertEquals("1:1:1", d18.toString());
	}

	
}
