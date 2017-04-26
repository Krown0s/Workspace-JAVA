package fr.barde.tp7;

public class TestsBanques {

	public static void main(String[] args) {
		TestsBanques test = new TestsBanques();

		// Tests classe Compte
		System.out.println();
		System.out.println("--> Tests des propri�t�s de la classe Banque");
		BanqueLL banque = new BanqueLL("La banque postale");
		test.testP1();
		test.testP2(); 
		test.testP3();
		test.testP4();
		test.testP5(); 
		test.testP6();
		test.testP7();

		// Programme de test du TP
		System.out.println();
		System.out.println("--> Tests de la banque ");
		banque.ouvrir("001", 100F);
		banque.ouvrir("002", 100F);
		banque.ouvrir("003", 100F);
		banque.ouvrir("004", 100F);
		banque.ouvrir("005", 100F);
		banque.ouvrir("006", 100F);
		System.out.println("Le lib�ll� de la banque est \""+ banque.getLibell�() + "\"");
		System.out.println("Voici la liste des comptes de la banque : ");
		System.out.println(banque);
		System.out.println("Le solde de la banque est de "+ banque.solde() + " euros");
		System.out.println();
		System.out.println("* Ajout de 100 euros au compte 001");
		banque.d�poser("001", 100F);
		System.out.println("=> Le nouveau solde de la banque est de "+ banque.solde() + " euros");
		System.out.println();
		System.out.println("* Retrait de 300 euros au compte 001");
		banque.retirer("001", 300F);
		System.out.println("= > Le nouveau solde de la banque est de "+ banque.solde() + " euros");
		System.out.println();
		System.out.println("* Retrait de 200 euros aux comptes 005 et 006");
		banque.retirer("006", 200F);
		banque.retirer("005", 200F);
		System.out.println("= > Le nouveau solde de la banque est de "+ banque.solde() + " euros");
		System.out.println();
		System.out.println("Voici la liste des comptes d�biteurs de la banque : ");
		banque.afficherComptesD�biteurs();
		System.out.println();
		System.out.println("* Fermeture du compte 001");
		banque.d�poser("001",100F);
		banque.fermer("001");
		System.out.println("La nouvelle liste des comptes de la banque : ");
		System.out.println(banque);
		System.out.println("=> Le nouveau solde de la banque est de "+ banque.solde() + " euros");
	}

	// P1 
	void testP1(){			
		BanqueLL b = new BanqueLL("La banque postale");
		if (b.getLibell�()!= "La banque postale"){
			System.out.print("Propri�t� P1 non v�rif�e : ");
			System.out.println("le nom de la banque n'est pas \"La banque postale\"");
		}
		else
			System.out.println("Propri�t� P1 v�rif�e");			
	}

	// P2
	void testP2(){
		BanqueLL b = new BanqueLL("La banque postale");
		b.ouvrir("001", 100F);
		if (b.getLibell�()!= "La banque postale"){
			System.out.print("Propri�t� P2 non v�rif�e : ");
			System.out.println("le nom de la banque n'est pas \"La banque postale\"");
		}
		else
			System.out.println("Propri�t� P2 v�rif�e");			
	}

	// P3
	void testP3(){
		BanqueLL b = new BanqueLL("La banque postale");
		if (b.solde() != 0) {
			System.out.print("Propri�t� P3 non v�rif�e : ");
			System.out.println("Le solde de la banque n'est pas �gale � 0 euro");
		}
		else
			System.out.println("Propri�t� P3 v�rif�e");		
	}

	// P4
	void testP4(){
		BanqueLL b = new BanqueLL("La banque postale");
		b.ouvrir("001", 100F);
		if (b.solde() != 100F) {
			System.out.print("Propri�t� P4 non v�rif�e : ");
			System.out.println("Le solde de la banque n'est pas �gale � 100 euros");
		}
		else
			System.out.println("Propri�t� P4 v�rif�e");		
	}

	// P5
	void testP5(){
		BanqueLL b = new BanqueLL("La banque postale");
		b.ouvrir("001", 100F);
		b.retirer("001", 100F);
		if (b.solde() != 0F) {
			System.out.print("Propri�t� P5 non v�rif�e : ");
			System.out.println("L'ajout d'un compte et le retrait ne modifient pas le solde de la banque");
		}
		else
			System.out.println("Propri�t� P5 v�rif�e");	
	}

	// P6
	void testP6(){
		BanqueLL b = new BanqueLL("La banque postale");
		b.ouvrir("001", 0F);
		b.fermer("001");
		if (b.solde() != 0) {
			System.out.print("Propri�t� P6 non v�rif�e : ");
			System.out.println("L'ajout et la suppression de comptes modifient la banque");
		}
		else
			System.out.println("Propri�t� P6 v�rif�e");	
	}

	// P7
	void testP7(){
		BanqueLL b = new BanqueLL("La banque postale");
		b.ouvrir("001", 100F);
		b.d�poser("001", 50F);
		if (b.solde() != 150F) {
			System.out.print("Propri�t� P7 non v�rif�e : ");
			System.out.println("L'ajout d'un compte et le d�p�t ne modifient pas le solde de la banque");
		}
		else
			System.out.println("Propri�t� P7 v�rif�e");	
	}

}
