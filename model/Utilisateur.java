package model;

import exception.SaisieException;

public class Utilisateur {  //  ?? abstract class

    private String nom;
    private String prenom;
    private String REGEX_IDENTITE = "^[A-Za-zÀ-ÖØ-öø-ÿ]+(?:[- ][A-Za-zÀ-ÖØ-öø-ÿ]+)*$";


    public Utilisateur(String nom, String prenom) throws SaisieException {
        this.setNom(nom);
        this.setPrenom(prenom);
    }

    public static String getNom() {
        return nom;
    }

    public void setNom(String nom) throws SaisieException {
        if (nom == null || nom.isEmpty() || !nom.matches(REGEX_IDENTITE)) {
            throw new SaisieException("La saisie du Nom est incorrecte, " +
                    "veuillez recommencer entièrement la saisie de données. ");
        } else {
            this.nom = nom;
        }
    }
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) throws SaisieException {
        if (prenom == null || prenom.isEmpty() || !prenom.matches(REGEX_IDENTITE)) {
            throw new SaisieException("La saisie du Prénom est incorrecte, " +
                    "veuillez recommencer entièrement la saisie de données. ");
        } else {
            this.prenom = prenom;
        }
    }

}