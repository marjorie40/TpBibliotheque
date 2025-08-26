package model;

import exception.SaisieException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static controler.Safety.IdGenerator.generateId;


public class Abonne extends Utilisateur {
    private String nom;
    private String prenom;
    private String email;
    private int year;
    private int month ;
    private int day = 1;
    private String pret;
    private String REGEX_Email = "^[a-zA-Z0-9._+-]+[@]+[a-zA-Z0-9.-]+.[a-zA-Z]{2,}$";
    //private String newId = generateId();


    public static ArrayList<Abonne> listAbonnes = new ArrayList<>();

    public static ArrayList<Abonne> getAbonnes() {
            return listAbonnes;
    }

    public Abonne(String nom, String prenom, String email, int day, int month, int year) throws SaisieException {
        super(nom, prenom);
        this.setEmail(email);
        this.setDay(1);  // je propose que les inscriptions sont prises en compte au 1er jour du mois en cours
        this.setMonth(month);  // besoin d'initialiser ICI à 1 pour ne pas rentrer dans l'exception
        this.setYear(year); //LocalDate.parse(dateInscription, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }


    public static void setAbonnes(ArrayList<Abonne> abonnes) {
        Abonne.listAbonnes = abonnes;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) throws SaisieException {
        if (email == null || email.isEmpty() || !email.matches(REGEX_Email)) {
            throw new SaisieException("Votre adresse mail est invalide, votre abonné n'est pas créé, " +
                    " veuillez recréer votre abonné avec un email valide.");
        } else {
            this.email = email.trim().toLowerCase();
        }
    }

    public int getDay() {
        return this.day;
    }
    public void setDay(int day) throws SaisieException {
        if (day != 1  ) {
            throw new SaisieException(" Le jour entré n'est pas valide, votre abonné n'est pas créé, veuillez saisir 1. ");
        } else {
            this.day = day;
        }
    }
    public int getMonth() {
        return this.month;
    }

    public void setMonth(int month) throws SaisieException {
        if (month < 1 || month > 12) {
            throw new SaisieException("La valeur saisie pour le mois n'est pas valide, votre abonné n'est pas créé, " +
                    "veuillez recréer votre abonné et saisir un mois entre 1 et 12. ");
        } else {
            this.month = month;
        }
    }
    public int getYear() {
        return this.year;
    }
    public void setYear(int year) throws SaisieException {
        if (year > 2025 || year < 1950 ) {
            throw new SaisieException("L'année saisie n'est pas valide, votre abonné n'est pas créé, " +
                    "veuillez recréer votre abonné et saisir une année entre 1950 et 2025. ");
        } else {
            this.year = year;
        }
    }

    //public String getDateInscription() {
      //  return dateInscription; }

    public static LocalDate getDateInscription(String dateInscription) throws SaisieException {
        if (dateInscription == null || dateInscription.isEmpty()) {
            throw new SaisieException(" La date d'inscription est incorrecte,  veillez à respecter le format suivant : jj/mm/aaaa. ");
        } else {
            return LocalDate.parse(dateInscription, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }
    }
    /*public void setDateInscription(String dateInscription) throws SaisieException {
        if (dateInscription == null || dateInscription.isEmpty()) {
            throw new SaisieException(" La date d'inscription est incorrecte,  veillez à respecter le format suivant : jj/mm/aaaa. ");
        } else {
            this.dateInscription = dateInscription;
        }
    }*/

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

    public void afficherAbonnes() {
        // foreach : pour chaque objet de la liste
//        for (Abonne abonne : getAbonnes()) {
//            System.out.println(abonne.toString());
//        }

        for (int i = 0; i < getAbonnes().size(); i++) {
            System.out.println(getAbonnes().get(i).toString());
        }
    }

    @Override
    public String toString() {
        return "Nom : " + this.getNom() +
                " . Prénom : " + this.getPrenom() +
                " . Email : " + this.getEmail() +
                " . Date d'inscription : " + day +" / " + this.getMonth() + " / "+ this.getYear() + ".";
    }
}