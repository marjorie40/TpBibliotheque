package controler;

import exception.SaisieException;
import model.Abonne;
import model.Livre;
import model.Pret;
import model.PretLivre;
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

        //System.out.println(Abonne.rechercheParNom("testard")); METHODE FONCTIONNE 280825

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
                                    VueTpBibliotheque.getDay(),
                                    VueTpBibliotheque.getMonth(),
                                    VueTpBibliotheque.getYear());  // A REVOIR les LocalDate pour une saisie

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
                        // Vue

                        VueTpBibliotheque.demandeCreationLivre();
                        // CONTROLEUR reprend la main - crée l'objet et le stocke
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
                    // CREATION PRET avec recuperation d'OBJET plutot que saisie de STRING -- pas Ops
                    boolean erreur = true;
                    do {
                        VueTpBibliotheque.demandeCreationPret();

                        try {
                            PretLivre pretLivre = new PretLivre(
                                    0, // recuperer l'index+1 en identifiantPret
                                    Abonne.rechercheParNom(""),
                                    Livre.rechercheParTitre(""),
                                    LocalDate.now().parse("dd/MM/yyyy"),
                                    LocalDate.now().plusDays(7));

                            PretLivre.pretLivres.add(pretLivre);
                            erreur = false;
                        } catch (SaisieException e) {
                            VueTpBibliotheque.afficheMessage("Erreur !" + e.getMessage(), 0);
                        }

                    } while (erreur);

                    VueTpBibliotheque.afficheMessage("le prêt de ce livre est bien créé, " +
                            "merci de choisir une nouvelle action [1-6] ou de sortir du programme [0] ", 1);

                    break;
//                    // CREATION PRET avec saisie de STRING plutot que recuperation d'OBJET
//                    VueTpBibliotheque.demandeCreationPret();
//                    // CONTROLEUR
//                    Livre tempo = Livre.rechercheParTitre(VueTpBibliotheque.getTitre());
//                    if (tempo != null) {
//                        VueTpBibliotheque.afficheMessage(tempo.toString(), 1);
//                    } else {
//                        VueTpBibliotheque.afficheMessage("Le livre est inconnu ou indisponible", 0);
//                    }
//
//                    Abonne abo = Abonne.rechercheParNom(VueTpBibliotheque.getNom());
//                    if (abo != null) {
//                        VueTpBibliotheque.afficheMessage(abo.toString(), 1);
//                    } else {
//                        VueTpBibliotheque.afficheMessage("L'abonné est inconnu, " +
//                                "veuillez le créer en selectionnant [1] depuis le menu. ",0);
//                    }
//                    break;
                case 4:
                    VueTpBibliotheque.vueAffichageAbonnes(Abonne.listAbonnes);
                    break;
                case 5:
                    VueTpBibliotheque.vueAffichageLivres(Livre.livresList);
                    break;
                case 6:
                    VueTpBibliotheque.affichePretLivre(PretLivre.getPretLivre());  // affichagePret versus affichePretLivre dans Vue
                    break;
                case 911:  // l'option cachée
                    // VUE
                    VueTpBibliotheque.afficheMessage (" Besoin d'aide ? Knock knock Neo...",0);
                    VueTpBibliotheque.rechercheParIsbn();
                    // CONTROLEUR
                    Livre oeuvre = Livre.rechercheParIsbn(VueTpBibliotheque.getIsbn());
                    if (oeuvre != null) {
                        VueTpBibliotheque.afficheMessage(oeuvre.toString(), 1);
                    } else {
                        VueTpBibliotheque.afficheMessage("Le livre n'existe pas ou votre saisie est incorrecte", 0);
                    }
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

        PretLivre pret1 = new PretLivre (1, abonne1, livre6, LocalDate.now(), LocalDate.now().plusDays(7));
        PretLivre pret2 = new PretLivre (2,abonne3,livre9,LocalDate.now(),LocalDate.now().plusDays(7));
        PretLivre pret3 = new PretLivre (3,abonne4,livre2,LocalDate.now(),LocalDate.now().plusDays(7));

        PretLivre.pretLivres.add(pret1);
        PretLivre.pretLivres.add(pret2);
        PretLivre.pretLivres.add(pret3);
    }
}