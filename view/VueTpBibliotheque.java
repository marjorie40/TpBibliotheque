package view;

import exception.ExceptionDate;
import model.Abonne;
import model.Livre;
import model.Bibliothecaire;
import model.Pret;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;


public class VueTpBibliotheque {

    public static Scanner sc = new Scanner(System.in);

    private static String titre;
    private static String auteur;
    private static int quantite;
    private static String isbn;
    private static String nom;
    private static String prenom;
    private static String email;
    private static int day;
    private static int month;
    private static int year;

    //public static LocalDate dateInscription = LocalDate.now(ZoneId.of("dd-MM-yyyy"));
    //LocalDate inscription = new LocalDate (int year, int month, int year);


    public static String getTitre() {
        return titre;
    }

    public static String getAuteur() {
        return auteur;
    }

    public static int getQuantite() {
        return quantite;
    }

    public static String getIsbn() {
        return isbn;
    }
    public static String getNom() {
        return nom;
    }
    public static String getPrenom() {
        return prenom;
    }
    public static String getEmail() {
        return email;
    }
    public static int getDay () {
        return day = 1;
    }

    public static int getMonth () {
        return month;
    }

    public static int getYear () {
        return year;
    }

    //public static LocalDate getDateInscription() {
        //return getDateInscription (); }   // généré par IDE : correct ????



    /**
     * AFFICHER LISTE ABONNES
     * affichage abonnés VueAffichageAbonnes();
     * @param listAbonnes ArrayList
     */
    public static void vueAffichageAbonnes(ArrayList<Abonne> listAbonnes) {

        System.out.println("******** Affichage des abonnés : ********");
        for (int i = 0; i< Abonne.listAbonnes.size(); i++) {
            System.out.println(Abonne.listAbonnes.get(i).toString());
        }

    }

    /**
     * AFFICHER LA LISTE DES LIVRES
     * @param liste ArrayList
     */
    public static void vueAffichageLivres(ArrayList liste){

        System.out.println("******** Affichage des livres : ********");

        for (int i = 0; i < Livre.livresList.size(); i++) {

            System.out.println(Livre.livresList.get(i).toString());

        }

    }

    /**
     * AFFICHER LES PRETS
     * @param prets ArrayList
     */
    public static void affichagePret (ArrayList <Pret> prets) {

        System.out.println("******** Affichage des prêts : ********");
        for (Pret pret : prets) {
            System.out.println(pret);
        }
    }

    /**
     * RECHERCHER UN ABONNE PAR EMAIL
     */
    public static void rechercheAbonneParEmail() {

        System.out.println("Rechercher par email");
        System.out.println("Saisir l'email : ");
        String email = sc.nextLine().trim().toLowerCase(); // appliquer minuscule et nettoyage
    }

    /**
     * RECHERCHER PAR NOM UN ABONNE,UNE BIBLIOTHECAIRE, UN AUTEUR
     */
    public static void rechercheParNom() {
        String nom;

        System.out.println("Rechercher par nom");
        System.out.println("Saisir le nom : ");
        nom = sc.nextLine().toLowerCase().trim();
    }

    /**
     * RECHERCHER UN TITRE DE LIVRE
     */
    public static void rechercheParTitre() {
        String titre;

        System.out.println("Rechercher par titre");
        System.out.println("Saisir le titre de l'ouvrage : ");
        titre = sc.nextLine().toLowerCase().trim();
    }

    /**
     * RECHERCHER UN ISBN
     */
    public static void rechercheParIsbn() {

        System.out.println("Rechercher par n°ISBN ");
        System.out.println("Saisir l'ISBN du livre : ");
        isbn = sc.nextLine();
    }

    /**
     * DEMANDE DE CREATION D'UN LIVRE
     */
    public static void demandeCreationLivre() {
        System.out.println("Création d'un livre :");
        System.out.println("Merci de saisir le titre ?");
        titre = sc.nextLine();
        System.out.println("Merci de saisir l'auteur ?");
        auteur  = sc.nextLine();
        System.out.println("Merci de saisir l'isbn ?");
        isbn = sc.nextLine();
        afficheMessage("Merci de saisir la quantité ?", 1);
        quantite = sc.nextInt();
        sc.nextLine(); // vider le buffer
    }

    /**
     * DEMANDE DE CREATION D'UN ABONNE
     */
    public static void demandeCreationAbonne() {
        System.out.println("Création d'un abonné :");
        System.out.println("Merci de saisir le nom. ");
        nom = sc.nextLine();
        System.out.println("Merci de saisir le prénom. ");
        prenom  = sc.nextLine();
        System.out.println("Merci de saisir l'email. ");
        email = sc.nextLine();
        //System.out.println("Merci de saisir la date de l'inscription. Tout d'abord, le jour (de 1 à 31) : "); // a revoir logique type,methode pour la date inscription
        //int day = sc.nextInt();
        System.out.println("Merci de saisir le mois (de 1 à 12) : ");
        int month = sc.nextInt();
        System.out.println("Merci de saisir l'année (accepté jusqu'à 2025) : ");
        int year = sc.nextInt();
        System.out.println("La date d'inscription de l'abonné est : " + day +  "/" + month + "/" + year + " ? ");
        sc.nextLine(); // vider le buffer
    }

    /**
     * AFFICHAGE MESSAGE ERREUR EN ROUGE
     * @param message
     * @param type
     */
    public static void afficheMessage(String message, int type) {
        if  (type == 0) {
            System.err.println(message);
        } else {
            System.out.println(message);
        }

    }
    /**
     * AFFICHER LE MENU DE SELECTION ET CAPTER LE CHOIX DE L'UTILISATEUR
     * @return choix utilisateur
     */
    public static int afficheMenu() {

        System.out.println("***********************************************************");
        System.out.println("*****   Bienvenue dans le menu de la Bibliothèque    ******");
        System.out.println("***********************************************************");
        System.out.println("1 - Créer un abonné");
        System.out.println("2 - Créer un livre");
        System.out.println("3 - Recherche par isbn");
        System.out.println("4 - Afficher la liste d'abonnees");
        System.out.println("5 - Afficher les livres");
        System.out.println("0 - Quitter");

        System.out.println("Merci de donner votre choix ? [0-5] ");
        int choix = sc.nextInt();
        sc.nextLine();
        return choix;
    }

    /* public static int saisieDateInscription() {
        int jour =1;
        int mois;
        int annee;
        boolean dateOk = false;

        while (!dateOk) {
            try {
                System.out.println("Entrez l'année : ");
                annee = sc.nextInt();
                if (annee < 1800 || annee > 2026) {
                    throw new ExceptionDate("L'année est invalide, elle doit etre comprise entre 1800 et 2025. ", -1, -1, annee);
                }
                System.out.println("Entrez le mois (entre 1 et 12) : ");
                mois = sc.nextInt();
                if (mois < 1 || mois > 12) {
                    throw new ExceptionDate("Le mois est invalide, veuillez entrer un mois entre 1 et 12 ", -1, mois, annee);
                }
                System.out.println("Entrez le jour : ");
                jour = sc.nextInt();

                int dateJ = 1;
                //int dernierJour = dateJ.lastDayOfTheMonth(mois, annee);
                // une methode qui connait le dernier jour du mois selon le mois et l'année entrees

                if (jour < 1 || jour > 12) {
                    throw new ExceptionDate("Le jour n'est pas valide, vérifiez la date du jour et resaisir les données. ", jour, mois, annee);
                }
                dateOk = true;
                System.out.println("La date saisie est valide : " + jour + "/" + mois + "/" + annee + " ! ");
            } catch (ExceptionDate e) {
                System.out.println("Erreur : " + e.getMessage());
                System.out.println("Veuillez saisir une date");
            }
        }
        return jour; // ??*/

}
