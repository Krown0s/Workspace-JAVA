package fr.barde.tp7;

import java.util.LinkedList;
import java.util.List;

public class BanqueLL {
    /**
     * libell� de la banque
     */
    private String libelle;

    /**
     * ensemble des comptes de la banque
     */
    LinkedList<CompteBancaire> comptes;

    /**
     * construit une banque vide
     * 
     * @param libell�
     *            de la banque
     */
    public BanqueLL(String libelle) {
        this.libelle = libelle;
        this.comptes = new LinkedList<CompteBancaire>();
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
    	for(CompteBancaire cb : this.comptes){
    		if(cb.getNumero().equals(num�ro)) return cb;
    	}
    	return null;
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
        if(this.estCompteExistant(num�ro)){
        	throw new IllegalArgumentException("Ce compte existe d�j�.");
        }
        CompteBancaire cb = new CompteBancaire(num�ro);
        cb.deposer(valeur);
        this.comptes.add(cb);
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
        for(CompteBancaire cb : this.comptes){
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
        for(CompteBancaire cb : this.comptes){
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
        for(CompteBancaire cb : this.comptes){
        	ch += "\n" + cb;
        }
        return ch;
    }

}
