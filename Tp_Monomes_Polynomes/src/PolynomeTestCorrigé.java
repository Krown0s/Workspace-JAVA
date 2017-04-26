import static org.junit.Assert.*;

import org.junit.Test;

	public class PolynomeTestCorrigé {

	    @Test
	    public void testtoStringPolynomeNul() {
	        Polynome nul = new Polynome();
	        assertEquals("0", nul.toString());
	    }

	    @Test
	    public void testtoStringPolynomeCoefficientsPositifs() {
	        Polynome p = new Polynome();
	        p.setMonome(new Monome(8F, 4));
	        p.setMonome(new Monome(8F, 2));
	        p.setMonome(new Monome(1F, 0));
	        assertEquals("8.0xe4 + 8.0xe2 + 1.0", p.toString());
	    }

	    @Test
	    public void testtoStringPolynomeCoefficientsPositifsEtNégatifs() {
	        Polynome p = new Polynome();
	        p.setMonome(new Monome(128F, 8));
	        p.setMonome(new Monome(160F, 4));
	        p.setMonome(new Monome(-32F, 2));
	        p.setMonome(new Monome(1F, 0));
	        assertEquals("128.0xe8 + 160.0xe4 - 32.0xe2 + 1.0", p.toString());
	    }

	    @Test
	    public void testtoStringPolynomePremierCoefficientNégatif() {
	        Polynome p = new Polynome();
	        p.setMonome(new Monome(-128F, 8));
	        p.setMonome(new Monome(160F, 4));
	        p.setMonome(new Monome(-32F, 2));
	        p.setMonome(new Monome(1F, 0));
	        assertEquals("-128.0xe8 + 160.0xe4 - 32.0xe2 + 1.0", p.toString());
	    }

	    @Test
	    public void testDerivePolynome() {
	        Polynome p = new Polynome();
	        p.setMonome(new Monome(2F, 2));
	        p.setMonome(new Monome(6F, 1));
	        p.setMonome(new Monome(32F, 0));
	        assertEquals("4.0x + 6.0", p.derivee().toString());
	    }

	    @Test
	    public void testSommePolynomes() {
	        Polynome p = new Polynome();
	        p.setMonome(new Monome(-128F, 8));
	        p.setMonome(new Monome(160F, 4));
	        p.setMonome(new Monome(-32F, 2));
	        p.setMonome(new Monome(1F, 0));
	        Polynome other = new Polynome();
	        other.setMonome(new Monome(128F, 8));
	        other.setMonome(new Monome(6F, 4));
	        other.setMonome(new Monome(33F, 3));
	        assertEquals("166.0xe4 + 33.0xe3 - 32.0xe2 + 1.0",
	                p.somme(other).toString());
	    }

	    @Test
	    public void testProduitPolynomeParMonome() {
	        Polynome p = new Polynome();
	        p.setMonome(new Monome(128F, 8));
	        p.setMonome(new Monome(160F, 4));
	        p.setMonome(new Monome(-32F, 2));
	        p.setMonome(new Monome(1F, 0));
	        Monome m = new Monome(2F, 1);
	        assertEquals("256.0xe9 + 320.0xe5 - 64.0xe3 + 2.0x",
	                p.produit(m).toString());
	    }
	}
