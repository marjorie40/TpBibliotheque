package view;

import model.Abonne;
import model.Livre;
import model.Bibliothecaire;
import model.Pret;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class VueTpBibliotheque {
    String email;
    String nom;
    String prenom;
    int identifiant;
    int isbn;


    public static Scanner sc = new Scanner(System.in);


    //affichage abonnés VueAffichageAbonnes();

    public static void vueAffichageAbonnes(List<Abonne> abonnes) {

        System.out.println("Affichage des abonnés :");
        for (Abonne abonne : abonnes) {
            System.out.println(abonne);
        }

    }
    //affichage livres VueAffichageLivres();

    public static void vueAffichageLivres(ArrayList liste){

        System.out.println("Affichage des livres :");
        liste.toString();

    }

    // affichage prets VueAffichagePret ();

    public static void vueAffichageLivres (List <Pret> prets) {

        System.out.println("Affichage des prêts :");
        for (Pret pret : prets) {
            System.out.println(pret);
        }
    }

    // recherche par email pour abonne
    public static void vueRechercheParEmail() {

        System.out.println("Rechercher par email");
        System.out.println("Saisir l'email : ");
        String email = sc.nextLine().trim().toLowerCase(); // appliquer minuscule et nettoyage
    }

    // recherche par nom pour abonne, auteur, bibliothecaire
    public static void vueRechercheParNom() {

        System.out.println("Rechercher par nom");
        System.out.println("Saisir le nom : ");
        nom = sc.nextLine().toLowerCase().trim();
    }
    // recherche par titre pour livre
    public static void vueRechercheParTitre() {

        System.out.println("Rechercher par titre");
        System.out.println("Saisir le titre de l'ouvrage : ");
        titre = sc.nextLine().toLowerCase().trim();
    }

    // recherche par ISBN pour livre
    public static void vueRechercheParIsbn() {

        System.out.println("Rechercher par n°ISBN ");
        System.out.println("Saisir l'ISBN du livre : ");
        isbn = sc.nextInt();

    }

}
