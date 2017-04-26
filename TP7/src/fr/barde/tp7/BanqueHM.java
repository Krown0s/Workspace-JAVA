package fr.barde.tp7;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BanqueHM {
    /**
     * libellé de la banque
     */
    private String libelle;

    /**
     * 
     */
    private Map<String, CompteBancaire> comptes;

    /**
     * construit une banque vide
     * 
     * @param libellé
     *            de la banque
     */
    public BanqueHM(String libelle) {
        this.libelle = libelle;
        this.comptes = new HashMap<String, CompteBancaire>();
    }

    /**
     * renvoie le libellé d'une banque
     * 
     * @return libellé
     */
    public String getLibellé() {
        return this.libelle;
    }

    /**
     * renvoie le compte d'une banque de numéro donné
     * 
     * @param numéro
     *            numéro du compte recherché
     * @return compte bancaire ou null s'il n'existe pas
     */
    private CompteBancaire getCompte(String numéro) {
    	return this.comptes.get(numéro);
    }

    /**
     * ouvre un compte dans une banque
     * 
     * @param numéro
     *            numéro du compte bancaire à ouvrir
     * @param valeur
     *            d'initialisation du compte
     * @throws IllegalArgumentException
     *             s'il n'y a déjà un compte associé à ce numéro
     */
    public void ouvrir(String numéro, float valeur) throws IllegalArgumentException{
        if(this.comptes.containsKey(numéro)){
        	throw new IllegalArgumentException("Ce compte existe déjà.");
        }
        CompteBancaire cb = new CompteBancaire(numéro);
        cb.deposer(valeur);
        this.comptes.put(numéro, cb);
    }

    /**
     * dépose une valeur sur un compte de la banque
     * 
     * @param numéro
     *            du compte à créditer
     * @param valeur
     *            valeur à créditer
     * @throws IllegalArgumentException
     *             s'il n'y a pas de compte associé à ce numéro
     */
    public void déposer(String numéro, float valeur) throws IllegalArgumentException {
        if(!estCompteExistant(numéro)){
        	throw new IllegalArgumentException("Compte inexistant.");
        }
        this.getCompte(numéro).deposer(valeur);
    }

    /**
     * retire une valeur sur un compte de la banque
     * 
     * @param numéro
     *            du compte à débiter
     * @param valeur
     *            valeur à créditer
     * @throws IllegalArgumentException
     *             s'il n'y a pas de compte associé à ce numéro
     */
    public void retirer(String numéro, float valeur) throws IllegalArgumentException{
        if(!estCompteExistant(numéro)){
        	throw new IllegalArgumentException("Compte inexistant.");
        }
        this.getCompte(numéro).retirer(valeur);
    }

    /**
     * renvoie le solde d'une banque
     * 
     * @return solde
     */
    public float solde() {
        float solde = 0.0F;
        Collection <CompteBancaire> listeDeComptes = this.comptes.values();
        for(CompteBancaire cb : listeDeComptes){
        	solde += cb.getSolde();
        }
        return solde;
    }

    /**
     * ferme un compte de la banque
     * 
     * @param numéro
     *            du compte à fermer
     * @throws IllegalArgumentException
     *             s'il n'y a pas de compte associé à ce numéro
     * @throws IllegalArgumentException
     *             si le compte à fermer n'est pas vide
     */
    public void fermer(String numéro) {
        if(!estCompteExistant(numéro)){
        	throw new IllegalArgumentException("Compte inexistant.");
        }
        if(this.getCompte(numéro).getSolde() != 0){
        	throw new IllegalArgumentException("Compte non vide.");
        }
        this.comptes.remove(this.getCompte(numéro));
    }

    /**
     * affiche la liste de comptes dont le solde est négatif
     */
    public void afficherComptesDébiteurs() {
        System.out.println("Liste des comptes débiteurs");
        Collection <CompteBancaire> listeDeComptes = this.comptes.values();
        for(CompteBancaire cb : listeDeComptes){
        	if(cb.getSolde() < 0.0F){
        		System.out.println(cb);
        	}
        }
    }

    /**
     * vérifie si un compte appartient à la banque
     * 
     * @param numéro
     *            numéro du compte bancaire
     * @return true si le compte existe et false sinon
     */
    boolean estCompteExistant(String numéro) {
    	return this.getCompte(numéro) != null;
    }

    @Override
    public String toString() {
        String ch = "Banque :" + this.libelle;
        Collection <CompteBancaire> listeDeComptes = this.comptes.values();
        for(CompteBancaire cb : listeDeComptes){
        	ch += "\n" + cb;
        }
        return ch;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comptes == null) ? 0 : comptes.hashCode());
		result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		//Compare la réference des 2 objets
		if (this == obj)
			return true;
		//Vérifie si l'objet passé en paramètre est null (n'a pas de référence)
		if (obj == null)
			return false;
		//Vérifie que les 2 objets à comparer sont des instances de la même classe
		//à savoir BanqueHM
		if (getClass() != obj.getClass())
			return false;
		//Compaaison champ à champ, ie sur les variables d'instances
		//Première opération : rendre la paramètre obj de la casse BanqueHM
		BanqueHM other = (BanqueHM) obj;
		//Comparaison sur la liste de comptes
		//Comparaison sur des listes vides (nullà
		if (comptes == null) {
			if (other.comptes != null)
				//Cas : la liste des comptes est vide et celle passée en param_tre ne l'est pas
				return false;
		//Cas où la liste des comptes n'est pas vide
		//Comparaison des comptes un par un en utilisant EQUALD sur les comptes
		} else if (!comptes.equals(other.comptes))
			//Il y a au moins un compte qui n'est pas identique dans la liste
			return false;
		if (libelle == null) {
			//cas où le libelle de la banqye est null mais pas celui du paramètre
			if (other.libelle != null)
				return false;
			//Comparaison des deux libellés en utilisant de EQUALS défini sur les lchaines de caratères
		} else if (!libelle.equals(other.libelle))
			return false;
		//Toutes les conditions sont réunis, donc les 2 banques sont égales
		return true;
	}
    
    

}
