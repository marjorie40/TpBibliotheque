package view;

import model.Abonne;
import model.Livre;
import model.Bibliothecaire;
import model.Pret;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class VueTpBibliotheque {

    public static Scanner sc = new Scanner(System.in);
    private static String titre;
    private static String auteur;
    private static int quantite;
    private static String isbn;

    /**
     * AFFICHER LISTE ABONNES
     * affichage abonnés VueAffichageAbonnes();
     * @param abonnes ArrayList
     */
    public static void vueAffichageAbonnes(ArrayList<Abonne> abonnes) {

        System.out.println("Affichage des abonnés :");
        for (Abonne abonne : abonnes) {
            System.out.println(abonne);
        }

    }

    /**
     * AFFICHER LA LISTE DES LIVRES
     * @param liste ArrayList
     */
    public static void vueAffichageLivres(ArrayList liste){

        System.out.println("Affichage des livres :");

        for (int i = 0; i < Livre.livresList.size(); i++) {

            System.out.println(Livre.livresList.get(i).toString());

        }

    }

    /**
     * AFFICHER LES PRETS
     * @param prets ArrayList
     */
    public static void affichagePret (ArrayList <Pret> prets) {

        System.out.println("Affichage des prêts :");
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

    public static void afficheMessage(String message, int type) {
        if  (type == 0) {
            System.err.println(message);
        } else {
            System.out.println(message);
        }

    }

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

    public static int afficheMenu() {

        System.out.println("Bienvenue");
        System.out.println("1 - Afficher les livres");
        System.out.println("2 - Créer un livre");
        System.out.println("3 - Recherche par isbn");
        System.out.println("0 - Quitter");

        System.out.println("Merci de donner votre choix ? [0-2] ");
        int choix = sc.nextInt();
        sc.nextLine();
        return choix;
    }
}
