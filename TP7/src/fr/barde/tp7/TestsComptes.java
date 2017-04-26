package fr.barde.tp7;

public class TestsComptes {

	public static void main(String[] args) {
		TestsComptes test = new TestsComptes();

		// Tests classe Compte
		System.out.println();
		System.out.println("--> Tests de la classe compte");
		Compte c1 = new Compte();
		test.testP1(c1);
		test.testP2(c1); 
		test.testP3(c1);

		// Tests classe Compte bancaire
		System.out.println();
		System.out.println("--> Tests de la classe compte bancaire");
		CompteBancaire c2 = new CompteBancaire("Jus de pomme");
		test.testP1(c2);
		test.testP2(c2); 
		test.testP3CompteBancaire(c2);	
		test.testP4CompteBancaire(c2);	
		test.testP3(c2);

		// Tests classe Compte épargne
		System.out.println();
		System.out.println("--> Tests de la classe compte épargne");
		CompteEpargne c3 = new CompteEpargne("Jus de pomme",15F);
		test.testP1(c3);
		test.testP2(c3); 
		test.testP3CompteBancaire(c3);	
		test.testP4CompteBancaire(c3);	
		test.testP5CompteEpargne(c3);	
		test.testP6CompteEpargne(c3);	
		test.testP3(c3);
		test.testP8CompteEpargne(c3);	
		test.testP8BisCompteEpargne(c3);	
		test.testP9CompteEpargne();	
		 
		// Programme de test du TP
		System.out.println();
		System.out.println("--> Tests des classes ");
		Compte[] tab = new Compte[4];
		tab[0] = new Compte();
		tab[1] = new CompteBancaire("001");
		tab[2] = new CompteEpargne("002", 0.1F);
		tab[3] = new CompteEpargne("003", 0.2F);
		tab[2].deposer(45.F);
		 // Parcourir le tableau pour afficher intérêts des comptes épargnes
		 // A COMPLETER
	}

	// P1 compte
	void testP1(Compte c){
		if (c.getSolde() != 0){
			System.out.print("Propriété P1 non vérifée : ");
			System.out.println("le compte nouveau compte n'a pas un solde égal à zéro");
		}
		else
			System.out.println("Propriété P1 vérifée");			
	}

	// P2 compte
	void testP2(Compte c){
		float solde = c.getSolde();
		c.deposer((float) 321.97);
		if (c.getSolde() != solde + (float) 321.97) {
			System.out.print("Propriété P2 non vérifée : ");
			System.out.println("le compte compte n'est pas crédité des 321,97 euros");
		}
		else
			System.out.println("Propriété P2 vérifée");	
	}

	// P3 compte, P5 compte bancaire et P7 commpte épargne
	void testP3(Compte c){
		c.retirer(21.97F);
		float solde = c.getSolde();
		c.deposer(21.97F);
		c.retirer(21.97F);
		if (c.getSolde() != solde) {
			System.out.print("Propriété P3 pour Compte, P5 pour CompteBancaire et P7 pour CommpteEpargne non vérifée : ");
			System.out.println("Le compte compte n'est pas débité des 21,97 euros");
		}
		else
			System.out.println("Propriété P3 pour Compte, P5 pour CompteBancaire et P7 pour CommpteEpargne vérifée");		
	}

	// P3 Compte bancaire
	void testP3CompteBancaire(CompteBancaire c){
		if (c.getNumero() != "Jus de pomme") {
			System.out.print("Propriété P3 non vérifée : ");
			System.out.println("Le libellé du compte n'est pas \"Jus de pomme\"");
		}
		else
			System.out.println("Propriété P3 vérifée");	
	}

	// P4 Compte bancaire
	void testP4CompteBancaire(CompteBancaire c){
		c.deposer(21.97F);
		if (c.getNumero() != "Jus de pomme") {
			System.out.print("Propriété P4 non vérifée : ");
			System.out.println("Le libellé du compte n'est pas \"Jus de pomme\"");
		}
		else
			System.out.println("Propriété P4 vérifée");	
	}

	// P5 Compte épargne
	void testP5CompteEpargne(CompteEpargne c){
		if (c.getTaux() != 15) {
			System.out.print("Propriété P5 non vérifée : ");
			System.out.println("Le taux n'est pas de 15% ");
		}
		else
			System.out.println("Propriété P5 vérifée");
	}

	// P6 Compte épargne
	void testP6CompteEpargne(CompteEpargne c){
		c.deposer(21.97F);
		if (c.getTaux() != 15) {
			System.out.print("Propriété P6 non vérifée : ");
			System.out.println("Le taux n'est pas de 15% après un dépôt");
		}
		else
			System.out.println("Propriété P5 vérifée");	
	}

	// P8 Compte épargne
	void testP8CompteEpargne(CompteEpargne c){
		if (c.getInteret() != 15 * c.getSolde()) {
			System.out.print("Propriété P8 non vérifée : ");
			System.out.println("Les intérêts sur le compte ne sont pas de " + 15 * c.getSolde());
		}
		else
			System.out.println("Propriété P8 vérifée");	
	}

	// P8bis Compte épargne
	void testP8BisCompteEpargne(CompteEpargne c){
		c.retirer(10000F);
		if (c.getInteret() != 0) {
			System.out.print("Propriété P8 bis non vérifée : ");
			System.out.println("Les intérêts sur le compte ne sont pas de 0");
		}
		else
			System.out.println("Propriété P8 bis vérifée");	
	}

	// P9 Compte épargne
	void testP9CompteEpargne(){
		CompteEpargne c1 = new CompteEpargne("001",15F);
		CompteEpargne c2 = new CompteEpargne("002",15F);
		c1.deposer(100F);
		c1.ajouterInteret();
		c2.deposer(100F);
		c2.deposer(c2.getInteret());
		if (c1.getSolde() != c2.getSolde()) {
			System.out.print("Propriété P9 non vérifée : ");
			System.out.println("Le montant des deux comptes ne sont pas les mêmes après le paiement des intérêts");
		}
		else
			System.out.println("Propriété P9 vérifée");	
	}

}
