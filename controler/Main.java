package controler;

import exception.SaisieException;
import model.Abonne;
import model.Livre;
import model.Pret;
import view.VueTpBibliotheque;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws SaisieException {
        // le controleur cree le monde
        creationBibliotheque();
        // le controleur demande a la vue d'afficher les livres
        // VueTpBibliotheque.vueAffichageLivres(Livre.livresList);

//        boolean erreur = true;
//        do {
        // appel a la vue
        //VueTpBibliotheque.demandeCreationLivre();
        // controleur reprend la main - crée l'objet et le stocke
//            try {
//                Livre livre = new Livre(
//                        VueTpBibliotheque.getTitre(),
//                        VueTpBibliotheque.getAuteur(),
//                        VueTpBibliotheque.getQuantite(),
//                        VueTpBibliotheque.getIsbn(),
//                        true);
//                Livre.livresList.add(livre);
//                erreur = false;
//            } catch (SaisieException e) {
//                VueTpBibliotheque.afficheMessage("Erreur !" +  e.getMessage());
//            }
//
//        } while (erreur);

        //VueTpBibliotheque.vueAffichageLivres(Livre.livresList);

        // MENU
        boolean fin = false;
        do {
            int choix = VueTpBibliotheque.afficheMenu();

            switch (choix) {
                case 1:
                    boolean pbErreur = true;
                    do {
                        // VUE
                        VueTpBibliotheque.demandeCreationAbonne();
                        try {
                            Abonne abonne = new Abonne(
                                    VueTpBibliotheque.getNom(),
                                    VueTpBibliotheque.getPrenom(),
                                    VueTpBibliotheque.getEmail(),
                                    1,
                                    VueTpBibliotheque.getMonth(),
                                    VueTpBibliotheque.getYear());  // A REVOIR :  les LocalDate pour une saisie

                            Abonne.listAbonnes.add(abonne);
                            pbErreur = false;
                        } catch (SaisieException e) {
                            VueTpBibliotheque.afficheMessage("Erreur !" + e.getMessage(), 0);
                        }

                    } while (pbErreur);
                    VueTpBibliotheque.afficheMessage("L'abonné est bien créé, " +
                            "merci de choisir une nouvelle action [1-6] ou de sortir du programme [0] ", 1);
                    break;
                case 2:
                    boolean saisieErreur = true;
                    do {
                        // VUE

                        VueTpBibliotheque.demandeCreationLivre();
                        // CONTROLEUR
                        // controleur reprend la main - crée l'objet et le stocke
                        try {
                            Livre ouvrage = new Livre(
                                    VueTpBibliotheque.getTitre(),
                                    VueTpBibliotheque.getAuteur(),
                                    VueTpBibliotheque.getQuantite(),
                                    VueTpBibliotheque.getIsbn(),
                                    true);
                            Livre.livresList.add(ouvrage);
                            saisieErreur = false;
                        } catch (SaisieException e) {
                            VueTpBibliotheque.afficheMessage("Erreur !" + e.getMessage(), 0);
                        }

                    } while (saisieErreur);
                    VueTpBibliotheque.afficheMessage("le livre est bien créé, " +
                            "merci de choisir une nouvelle action [1-6] ou de sortir du programme [0] ", 1);
                    break;
                case 3:
                    // VUE
                    VueTpBibliotheque.rechercheParIsbn();
                    // CONTROLEUR
                    Livre tempo = Livre.rechercheParIsbn(VueTpBibliotheque.getIsbn());
                    if (tempo != null) {
                        VueTpBibliotheque.afficheMessage(tempo.toString(), 1);
                    } else {
                        VueTpBibliotheque.afficheMessage("le livre n'existe pas", 0);
                    }
                    break;
                case 4:
                    VueTpBibliotheque.vueAffichageAbonnes(Abonne.listAbonnes);
                    break;
                case 5 :
                    VueTpBibliotheque.vueAffichageLivres(Livre.livresList);
                    break;

                case 0:
                    VueTpBibliotheque.afficheMessage("Merci et à bientôt", 1);
                    fin = true;
                    break;
                default:
                    VueTpBibliotheque.afficheMessage("Erreur ! saisie incorrect ", 0);
                    break;

            }

        } while (!fin);
    }

    /*
    private void controleurChoixMenu() throws SaisieException {
        Scanner sc = new Scanner(System.in);
        System.out.println("> Votre Choix [1-6] ou [0] pour quitter :");

        Boolean fin = false;
        while (fin == false) {
            int selection = sc.nextInt();
            switch (selection) {
                case 0:
                    // fin de l'application.
                    fin = true;
                    System.out.println("Merci et à bientôt");
                    //  System.exit(0);
                    break;
                case 1:
                    // appel de la vue pour la création
                    VueTpBibliotheque.vueCreation();
                    // Création d'une personne
                    controleurCreationPersonnage();

                case 2:
                    // appel de la vue pour la création
                    VueTpBibliotheque.vueRechercheParTitre();
                    // recherche de la personne par son nom
                    Personne p = controleurRecherchePersonne(VueMMORPG.getNom());
                    // appel de la vue pour afficher cette personne
                    VueTpBibliotheque.vueAffichageAbonnes(abonnes);

                case 3:

                case 4:
                    // appel de la vue en lui donnant la liste d'abonnes
                    VueTpBibliotheque.vueAffichageAbonnes(Abonne.getAbonnes());
                    break;

                case 5:
                    // appel de la vue en lui donnant la liste de livres
                    VueTpBibliotheque.vueAffichageLivres(Livre.getLivres());
                    break;

                case 6:
                    // appel de la vue en lui donnant la liste des prets
                    VueTpBibliotheque.vueAffichagePret(Pret.getPrets());
                    break;

                default:
                    // choix en erreur
                    System.err.println("! Choix incorrect ! [0-6] !");
                    break;

            }
        }
    }
    */

    public static void creationBibliotheque() throws SaisieException {

        Livre livre1 = new Livre("Mythics", "Jean Valjean",
                1, "978-3-986-74186-1", true);
        Livre livre2 = new Livre("L'invention", "James Pataguel",
                1, "978-3-196-74186-2", true);
        Livre livre3 = new Livre("Le loup de Stan", "Ibrahim Joupe",
                1, "978-3-986-74186-3", true);
        Livre livre4 = new Livre("Savoir coder", "Céline Pasmoi",
                1, "978-3-986-74186-4", true);
        Livre livre5 = new Livre("Les Stroumpfs", "Jean-Michel Lebleu",
                1, "978-3-986-74186-5", true);
        Livre livre6 = new Livre("Les grands classique", "Nathalie Chibani",
                1, "978-3-986-48716-6", true);
        Livre livre7 = new Livre("Idée déco", "Léonce Granduc",
                1, "978-3-986-74186-7", true);
        Livre livre8 = new Livre("Nancy Plage", "Friedrisch Schneider",
                1, "978-3-986-74186-8", true);
        Livre livre9 = new Livre("Les dictées", "Bernard Pivot",
                1, "978-3-986-28716-9", true);

        Livre.livresList.add(livre1);
        Livre.livresList.add(livre2);
        Livre.livresList.add(livre3);
        Livre.livresList.add(livre4);
        Livre.livresList.add(livre5);
        Livre.livresList.add(livre6);
        Livre.livresList.add(livre7);
        Livre.livresList.add(livre8);
        Livre.livresList.add(livre9);


        Abonne abonne1 = new Abonne("Boutoin", "Jean-Claude", "jcboutoin@neuf.fr", 12,10,2024);
        Abonne abonne2 = new Abonne("Testard", "Josiane", "Josi.td@gmail.com", 03,05,2025);
        Abonne abonne3 = new Abonne("Salima", "Aline", "asalima@yahoo.fr", 10,12,2023);
        Abonne abonne4 = new Abonne("Doeuf", "John", "john@hotmail.fr", 25,01,1998);

        ArrayList<Abonne> listAbonnes = new ArrayList<>();
        Abonne.listAbonnes.add(abonne1);
        Abonne.listAbonnes.add(abonne2);
        Abonne.listAbonnes.add(abonne3);
        Abonne.listAbonnes.add(abonne4);
        /*System.out.println(abonnes);

        if (abonnes.contains("Aline")) {
            System.out.println(Abonne.getAbonnes());

        }*/
    }
}
// creation d'un livre
//        private static void controleur
//            controleurRechercheAbonne()
//                    controleurRechercheLivre
//                            controleurRecherchePret

