package fr.barde.tp7;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BanqueHM {
    /**
     * libell� de la banque
     */
    private String libelle;

    /**
     * 
     */
    private Map<String, CompteBancaire> comptes;

    /**
     * construit une banque vide
     * 
     * @param libell�
     *            de la banque
     */
    public BanqueHM(String libelle) {
        this.libelle = libelle;
        this.comptes = new HashMap<String, CompteBancaire>();
    }

    /**
     * renvoie le libell� d'une banque
     * 
     * @return libell�
     */
    public String getLibell�() {
        return this.libelle;
    }

    /**
     * renvoie le compte d'une banque de num�ro donn�
     * 
     * @param num�ro
     *            num�ro du compte recherch�
     * @return compte bancaire ou null s'il n'existe pas
     */
    private CompteBancaire getCompte(String num�ro) {
    	return this.comptes.get(num�ro);
    }

    /**
     * ouvre un compte dans une banque
     * 
     * @param num�ro
     *            num�ro du compte bancaire � ouvrir
     * @param valeur
     *            d'initialisation du compte
     * @throws IllegalArgumentException
     *             s'il n'y a d�j� un compte associ� � ce num�ro
     */
    public void ouvrir(String num�ro, float valeur) throws IllegalArgumentException{
        if(this.comptes.containsKey(num�ro)){
        	throw new IllegalArgumentException("Ce compte existe d�j�.");
        }
        CompteBancaire cb = new CompteBancaire(num�ro);
        cb.deposer(valeur);
        this.comptes.put(num�ro, cb);
    }

    /**
     * d�pose une valeur sur un compte de la banque
     * 
     * @param num�ro
     *            du compte � cr�diter
     * @param valeur
     *            valeur � cr�diter
     * @throws IllegalArgumentException
     *             s'il n'y a pas de compte associ� � ce num�ro
     */
    public void d�poser(String num�ro, float valeur) throws IllegalArgumentException {
        if(!estCompteExistant(num�ro)){
        	throw new IllegalArgumentException("Compte inexistant.");
        }
        this.getCompte(num�ro).deposer(valeur);
    }

    /**
     * retire une valeur sur un compte de la banque
     * 
     * @param num�ro
     *            du compte � d�biter
     * @param valeur
     *            valeur � cr�diter
     * @throws IllegalArgumentException
     *             s'il n'y a pas de compte associ� � ce num�ro
     */
    public void retirer(String num�ro, float valeur) throws IllegalArgumentException{
        if(!estCompteExistant(num�ro)){
        	throw new IllegalArgumentException("Compte inexistant.");
        }
        this.getCompte(num�ro).retirer(valeur);
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
     * @param num�ro
     *            du compte � fermer
     * @throws IllegalArgumentException
     *             s'il n'y a pas de compte associ� � ce num�ro
     * @throws IllegalArgumentException
     *             si le compte � fermer n'est pas vide
     */
    public void fermer(String num�ro) {
        if(!estCompteExistant(num�ro)){
        	throw new IllegalArgumentException("Compte inexistant.");
        }
        if(this.getCompte(num�ro).getSolde() != 0){
        	throw new IllegalArgumentException("Compte non vide.");
        }
        this.comptes.remove(this.getCompte(num�ro));
    }

    /**
     * affiche la liste de comptes dont le solde est n�gatif
     */
    public void afficherComptesD�biteurs() {
        System.out.println("Liste des comptes d�biteurs");
        Collection <CompteBancaire> listeDeComptes = this.comptes.values();
        for(CompteBancaire cb : listeDeComptes){
        	if(cb.getSolde() < 0.0F){
        		System.out.println(cb);
        	}
        }
    }

    /**
     * v�rifie si un compte appartient � la banque
     * 
     * @param num�ro
     *            num�ro du compte bancaire
     * @return true si le compte existe et false sinon
     */
    boolean estCompteExistant(String num�ro) {
    	return this.getCompte(num�ro) != null;
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
		//Compare la r�ference des 2 objets
		if (this == obj)
			return true;
		//V�rifie si l'objet pass� en param�tre est null (n'a pas de r�f�rence)
		if (obj == null)
			return false;
		//V�rifie que les 2 objets � comparer sont des instances de la m�me classe
		//� savoir BanqueHM
		if (getClass() != obj.getClass())
			return false;
		//Compaaison champ � champ, ie sur les variables d'instances
		//Premi�re op�ration : rendre la param�tre obj de la casse BanqueHM
		BanqueHM other = (BanqueHM) obj;
		//Comparaison sur la liste de comptes
		//Comparaison sur des listes vides (null�
		if (comptes == null) {
			if (other.comptes != null)
				//Cas : la liste des comptes est vide et celle pass�e en param_tre ne l'est pas
				return false;
		//Cas o� la liste des comptes n'est pas vide
		//Comparaison des comptes un par un en utilisant EQUALD sur les comptes
		} else if (!comptes.equals(other.comptes))
			//Il y a au moins un compte qui n'est pas identique dans la liste
			return false;
		if (libelle == null) {
			//cas o� le libelle de la banqye est null mais pas celui du param�tre
			if (other.libelle != null)
				return false;
			//Comparaison des deux libell�s en utilisant de EQUALS d�fini sur les lchaines de carat�res
		} else if (!libelle.equals(other.libelle))
			return false;
		//Toutes les conditions sont r�unis, donc les 2 banques sont �gales
		return true;
	}
    
    

}
