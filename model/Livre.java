package model;


import exception.SaisieException;

import java.util.ArrayList;
import java.util.List;

public class Livre {

    private String titre;
    private String auteur;
    private int quantite;
    private int isbn;  // ? possible de créer une matrice : int [] isbn = {{000}"-"{0}"-"{000}"-"{00000}"-"{0}};
    private String etatLivre = "dispo";  //dispo ou indispo

    private String REGEXTitre = "/^[A-Za-z0-9\\\\s\\\\-\\\\&\\\\,\\\\.\\\\'\\\\:\\\\é\\\\è\\\\ê\\\\ë\\\\î\\\\ï\\\\ô\\\\ç\\\\ ]+$/gm;";
    private String REGEXIdentite = "^[A-Za-zÀ-ÖØ-öø-ÿ]+(?:[- ][A-Za-zÀ-ÖØ-öø-ÿ]+)*$";
    private String REGEX_ISBN = "^(?:ISBN(?:-1[03])?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$|97[89][0-9]{10}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)(?:97[89][- ]?)?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$";


    public static List<Livre> livres = new ArrayList<>();

    public static List<Livre> getLivres() {
        return livres;
    }
    public static void setLivres(List<Livre> livres) {
        Livre.livres = livres;
    }


    public Livre(String titre, String auteur, int quantite, int ISBN,String etatLivre) throws SaisieException {
        this.setTitre(titre);
        this.setAuteur (auteur);
        this.setQuantite(quantite);
        this.setIsbn(isbn);
        this.setEtat (etatLivre); // pas clair avec l'enum DIPONIBLE transfo pour faciliter :/
    }

    Livre(String titre, String auteur) throws SaisieException {
        this.setTitre(titre);
        this.setAuteur (auteur);
    }

    public String getTitre() {
        return titre;
    }
    public void setTitre(String titre) throws SaisieException {
        if (titre==null ||titre.isEmpty() || !titre.matches(REGEXTitre))  {
            throw new SaisieException(" Veuillez entrer un titre de livre valide. ");
        } else {
            this.titre = titre.trim().toLowerCase();  //est ce judicieux de vouloir nettoyer et convertir le titre (pour facilité la recherche)
        }
    }
    public String getAuteur() {
        return auteur;
    }
    public void setAuteur(String auteur) throws SaisieException {
        if (auteur==null || !auteur.matches(REGEXIdentite))  {
            throw new SaisieException(" Veuillez entrer le Nom et Prénom de l'auteur. ");
        }
        this.auteur = auteur;
    }
    public int getQuantite() {
        return quantite;
    }
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    public int getIsbn() {
        return isbn;
    }
    public void setIsbn(int isbn) throws SaisieException {
        if( !isbn.matches(REGEX_ISBN)) {  // quelle nommenclature pour dire isbn non conforme a la REGEX
            throw new SaisieException("L'identification, numéro ISBN du livre, n'est pas valide. Veuillez le resaisir.");
        }
        this.isbn = isbn;
    }
    public String getEtat() {
        return etatLivre;
    }
    public void setEtat(String etatLivre) throws SaisieException {
        if (etatLivre ==null || etatLivre.isEmpty()) {
            throw new SaisieException("Veuillez saisir si votre livre est DISPONIBLE ou INDISPONIBLE.");
        }
        this.etatLivre = etatLivre ;
    }


    public static int rechercheParTitre(String titre) {
        int index =0;
        for (index = 0; index < livres.size(); index++) {
            if (titre.equalsIgnoreCase(titre)) {
                index = Livre.getLivres().indexOf(livres);
                break;
            }
        }
                return index;
    }
    public static int rechercheParAuteur(String auteur) {
        int index =0;
        for (index = 0; index < auteur.length(); index++) {
            if (auteur.charAt(index)==' ') {  // teste tous les char 1 par 1 ?
                index = Livre.getLivres().indexOf(auteur);
                break;

            }
        }
        return index; // retourne quel index ? tous les bons ?

    }
    /* public static int rechercheParIsbn(String isbn) {
        int index =0;
        for (index = 0; index < isbn.length(); index++) {
            if (isbn.trim()== livres.getIsbn ()) {
                index = Livre.getLivres().indexOf(isbn);
                break;
            }
        }
        return index;
    }*/
    public static boolean supprimerLivreParIndex(int index) {
        getLivres().remove(index);
        return true;
    }

    public static void ajouterLivre (Livre livre) { //est ce qu'on fait "throws SaisieException"
        getLivres().add(livre.getTitre());
    }


    @Override
    public String toString() {
        return "Titre du livre : " + this.getTitre() + " . Auteur : " + this.getAuteur() +
                " . Quantite : " + this.getQuantite() + " . Numero ISBN : " +this.getIsbn() +
                " . Disponibilité : " + this.getEtat();

    }
}

