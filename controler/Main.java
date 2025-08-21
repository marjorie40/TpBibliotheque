package controler;

import exception.SaisieException;
import model.Abonne;
import model.Livre;
import model.Pret;

import java.util.ArrayList;
import java.util.Scanner;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SaisieException {

        Scanner sc = new Scanner(System.in);

        Livre livre1 = new Livre ("Mythics","Jean Valjean", 1,978-3-986-74186-1, "INDISPONIBLE");
        Livre livre2 = new Livre ("L'invention","James Pataguel", 1,978-3-196-74186-2, "DISPONIBLE");
        Livre livre3 = new Livre ("Le loup de Stan","Ibrahim Joupe", 1,978-3-986-74186-3, "INDISPONIBLE");
        Livre livre4 = new Livre ("Savoir coder","Céline Pasmoi", 1,978-3-986-74186-4, "DISPONIBLE");
        Livre livre5 = new Livre ("Les Stroumpfs","Jean-Michel Lebleu", 1,978-3-986-74186-5, "INDISPONIBLE");
        Livre livre6 = new Livre ("Les grands classique","Nathalie Chibani", 1,978-3-986-48716-6, "DISPONIBLE");
        Livre livre7 = new Livre ("Idée déco","Léonce Granduc", 1,978-3-986-74186-7, "INDISPONIBLE");
        Livre livre8 = new Livre ("Nancy Plage","Friedrisch Schneider", 1,978-3-986-74186-8, "DISPONIBLE");
        Livre livre9 = new Livre ("Les dictées","Bernard Pivot", 1,978-3-986-28716-9, "INDISPONIBLE");

        ArrayList<Livre> livres = new ArrayList<>();
        livres.add(livre1);
        livres.add(livre2);
        livres.add(livre3);
        livres.add(livre4);
        livres.add(livre5);
        livres.add(livre6);
        livres.add(livre7);
        livres.add(livre8);
        livres.add(livre9);



        Abonne abonne1 = new Abonne ("Jean-Claude", "Boutoin", "jcboutoin@neuf.fr", "12/10/2024");
        Abonne abonne2 = new Abonne ("Josiane", "Testard", "Josi.td@gmail.com","03/05/2024");
        Abonne abonne3 = new Abonne ("Aline", "Salima", "asalima@yahoo.fr","10/07/2024");
        Abonne abonne4 = new Abonne ("John", "Doeuf", "john@hotmail.fr","25/12/2023");

        ArrayList<Abonne> abonnes = new ArrayList<>();
        abonnes.add(abonne1);
        abonnes.add(abonne2);
        abonnes.add(abonne3);
        abonnes.add(abonne4);

        System.out.println(abonnes);

        if (abonnes.contains("Aline")) {
            System.out.println(Abonne.getAbonnes());
        }

        private void controleurChoixMenu() throws SaisieException {



            System.out.println("> Votre Choix [1-6] ou [0] pour quitter :");
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

            // creation d'un livre
        private static void controleur
            controleurRechercheAbonne()
                    controleurRechercheLivre
                            controleurRecherchePret


    }
    }
