package model;

import exception.SaisieException;

import java.util.ArrayList;
import java.util.List;

public class Bibliothecaire extends Utilisateur{
    private String nom;
    private String prenom;
    private int identifiant;  // peut on faire un truc genre HashMap pour 1 nom associé a 1 int identifiant
    private String REGEX_IDENTITE;

    public static List<Bibliothecaire> listeBibliothecaire =  new ArrayList<>();

    public Bibliothecaire(String nom, String prenom, int identifiant) throws SaisieException {
        super (nom, prenom);
        this.setIdentifiant(identifiant);

    }

    /*public String getNom() {
        return nom;
    }
    public void setNom(String nom) throws SaisieException {
        if (nom == null || nom.isEmpty() || !nom.matches(REGEX_IDENTITE)) {
            throw new SaisieException("Le nom est incorrecte, veuillez réessayer. ");
        } else {
            this.nom = nom;
        }
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) throws SaisieException {
        if (prenom == null || prenom.isEmpty() || !prenom.matches(REGEX_IDENTITE)) {
            throw new SaisieException("La saisie du Prénom est incorrecte, veuillez réessayer. ");
        } else {
            this.prenom = prenom;
        }
    }*/

    public int getIdentifiant() {
        return identifiant;
    }
    public void setIdentifiant(int identifiant) throws SaisieException {
        if (identifiant < 0 || identifiant > 999999999 ) {
            throw new SaisieException("Votre identifiant n'est pas valide, veuillez resaisir votre numéro identifiant.");
        } else {
            this.identifiant = identifiant;
        }
    }
    public static void afficherListeBibliothecaire() throws SaisieException {
        if (listeBibliothecaire.isEmpty()||listeBibliothecaire.size()==0) {
            throw new SaisieException("La liste est vide, veuillez ajouter un agent à la liste. ");
        } else {
            for (int i = 0; i < listeBibliothecaire.size()-1; i++) {
                System.out.println(listeBibliothecaire.get(i).toString());
            }
        }
    }
}
