import static org.junit.Assert.*;

import org.junit.Test;

public class TestUnMonome {

	Monome m1 = new Monome(0.0F,0);
	Monome m2 = new Monome(0.0F,0);
	
	@Test
	public void TestGetCoef(){
		assertEquals(0.0F,m1.getCoefficient(),0);
	}
	 @Test
	 public void TestGetExposant(){
		 assertEquals(0,m1.getExposant());
	 }
	 
	 @Test
	 public void TestSetCoefficent(){
		 m1.setCoefficient(2.2F);
		 assertEquals(2.2F,m1.getCoefficient(),0);
	 }
	 
	 @Test
	 public void TestSetExposant(){
		 m1.setExposant(3);
		 assertEquals(3, m1.getExposant());
	 }
	 
	 @Test
	 public void TestSomme(){
		 m1.setCoefficient(2.0F);
		 m2.setCoefficient(3.0F);
		 assertEquals(5.0F,m1.somme(m2).getCoefficient(),0);
		 assertEquals(0,m1.getExposant());
	 }
	 
	 @Test
	 public void TestProduit(){
		 m1.setCoefficient(2.0F);
		 m2.setCoefficient(3.0F);
		 m1.setExposant(2);
		 m2.setExposant(4);
		 assertEquals(6.0F,m1.produit(m2).getCoefficient(),0);
		 assertEquals(6,m1.produit(m2).getExposant());
	 }
	 
	 @Test
	 public void TestDerivee(){
		 m1.setCoefficient(2.0F);
		 m1.setExposant(2);
		 assertEquals(4.0F, m1.derivee().getCoefficient(),0);
		 assertEquals(1,m1.derivee().getExposant());
		 m1.setExposant(0);
		 assertEquals(0.0F,m1.derivee().getExposant(),0);
	 }
	 
	 @Test
	 public void TestEstNull(){
		 assertEquals(true,m1.estNul());
		 m1.setCoefficient(2.0F);
		 assertEquals(false,m1.estNul());
	 }
	 
	 @Test(expected = IllegalArgumentException.class)
	 public void TestSommeException(){
		 m1.setExposant(2);
		 m2.setExposant(3);
		 m1.somme(m2);
	 }
	 
	 @Test(expected = IllegalArgumentException.class)
	 public void TestExposantNegatif(){
		 Monome negatif = new Monome(0.0F,-1);
	 }
}
