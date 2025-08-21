package model;

import exception.SaisieException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static controler.Safety.IdGenerator.generateId;


public class Abonne extends Utilisateur {
    private String nom;
    private String prenom;
    private String email;
    private String dateInscription;
    private String pret;
    private String REGEX_Email = "^[a-zA-Z0-9._+-]+[@]+[a-zA-Z0-9.-]+.[a-zA-Z]{2,}$";
    private String newId = generateId();


    private static List<Abonne> abonnes = new ArrayList<>();

    public static List<Abonne> getAbonnes() {
        try {
            return abonnes;
        } catch (Exception e) {
            throw new RuntimeException(e); // genere automatiquement par IDE ... = throw new Saisie Exception ?
        }
    }

    public Abonne(String nom, String prenom, String email, String dateInscription) throws SaisieException {
        super(nom, prenom);
        this.setEmail(email);
        this.setDateInscription(dateInscription);
    }


    public static void setAbonnes(List<Abonne> abonnes) {
        Abonne.abonnes = abonnes;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws SaisieException {
        if (email == null || email.isEmpty() || !email.matches(REGEX_Email)) {
            throw new SaisieException("Votre adresse mail est invalide, veuillez la saisir anouveau.");
        } else {
            this.email = email;

            this.setEmail (generateId());  // possible ??
        }
    }

    public String getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(String dateInscription) throws SaisieException {
        if (dateInscription == null || dateInscription.isEmpty()) {
            throw new SaisieException(" La date d'inscription est incorrecte,  veillez à respecter le format suivant : jj/mm/aaaa. ");
        } else {
            this.dateInscription = dateInscription;
        }
    }

    public static Abonne rechercheParNom(String nom) {
        for (Abonne abonne : getAbonnes()) {
            if (abonne.getNom().equalsIgnoreCase(nom)) {
                return abonne;
            }
        }
        return null;
    }

    public static Abonne rechercheParEmail(String email) {
        for (Abonne abonne : getAbonnes()) {
            if (abonne.getEmail().equalsIgnoreCase(email)) {
                return abonne;
            }
        }
        return null;
    }

    public static void AjouterAbonne(Abonne abonne) {
        getAbonnes().add(abonne);
    }


    public static void supprimerAbonne(Abonne abonne) {
        getAbonnes().remove(abonne);
    }

    public List<Abonne> afficherAbonnes() {
        return getAbonnes();
    }

    @Override
    public String toString() {
        return "Nom : " + this.getNom() + " . Prénom : " + this.getPrenom() +
                " . Email : " + this.getEmail() + " . Date d'inscription : " + this.getDateInscription();
    }
}