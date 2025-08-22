package model;


import exception.SaisieException;

import java.util.ArrayList;
import java.util.List;

public class Livre {

    private String titre;
    private String auteur;
    private int quantite;
    private String isbn;  // ? possible de créer une matrice : int [] isbn = {{000}"-"{0}"-"{000}"-"{00000}"-"{0}};
    private Boolean etatLivre;  //dispo ou indispo

    private String REGEXTitre = "^[A-Za-z0-9\\\\s\\\\-\\\\&\\\\,\\\\.\\\\'\\\\:\\\\é\\\\è\\\\ê\\\\ë\\\\î\\\\ï\\\\ô\\\\ç\\\\ ]+$"; // retestee
    private String REGEXIdentite = "^[A-Za-zÀ-ÖØ-öø-ÿ]+(?:[- ][A-Za-zÀ-ÖØ-öø-ÿ]+)*$";
    private String REGEX_ISBN = "^(?:ISBN(?:-1[03])?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$|97[89][0-9]{10}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)(?:97[89][- ]?)?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$";


    public static ArrayList<Livre> livresList = new ArrayList<>();

    public Livre(String titre, String auteur, int quantite, String ISBN,Boolean etatLivre) throws SaisieException {
        this.setTitre(titre);
        this.setAuteur (auteur);
        this.setQuantite(quantite);
        this.setIsbn(ISBN);
        this.setEtat(etatLivre); // pas clair avec l'enum DIPONIBLE transfo pour faciliter :/
    }

    public String getTitre() {
        return this.titre;
    }
    public void setTitre(String titre) throws SaisieException {
        //if (titre==null ||titre.isEmpty() || !titre.matches(REGEXTitre))  {
        if (titre==null ||titre.isEmpty())  {
            throw new SaisieException(" Veuillez entrer un titre de livre valide. ");
        } else {
            this.titre = titre.trim().toLowerCase();  //est ce judicieux de vouloir nettoyer et convertir le titre (pour facilité la recherche)
        }
    }
    public String getAuteur() {
        return this.auteur;
    }
    public void setAuteur(String auteur) throws SaisieException {
        if (auteur==null || auteur.isEmpty() || !auteur.matches(REGEXIdentite))  {
            throw new SaisieException(" Veuillez entrer le Nom et Prénom de l'auteur. ");
        }else {
            this.auteur = auteur;
        }
    }

    public int getQuantite() {
        return this.quantite;
    }
    public void setQuantite(int quantite) throws SaisieException {
        if(quantite <= 0) {
            throw new SaisieException("La quantité ne peux être négative ou nulle");
        }else{
            this.quantite = quantite;
        }
    }

    public String getIsbn() {
        return this.isbn;
    }
    public void setIsbn(String isbn) throws SaisieException {
        //if( !isbn.matches(REGEX_ISBN)) {  // quelle nommenclature pour dire isbn non conforme a la REGEX
        if (!((isbn.length()) < 50) || isbn.trim().isEmpty() || isbn == null)  {
            throw new SaisieException("L'identification, numéro ISBN du livre, n'est pas valide. Veuillez le resaisir.");
        }
        this.isbn = isbn;
    }

    public Boolean getEtat() {
        return this.etatLivre;
    }
    public void setEtat(Boolean etatLivre) throws SaisieException {
        if (!etatLivre) {
            throw new SaisieException("Veuillez saisir si votre livre est DISPONIBLE ou INDISPONIBLE.");
        }else{
            this.etatLivre = etatLivre ;
        }
    }

    public static Livre rechercheParIsbn(String isbn) {

        for (int index = 0; index < livresList.size(); index++) {
            if (isbn.trim().equals(livresList.get(index).getIsbn().trim())) {
                // ?? se traduit : equals recupere index de l'ISBN nettoyé dans -livresList- ?
                return livresList.get(index);
            }
        }
        return null;
    }
    /*
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

    public static boolean supprimerLivreParIndex(int index) {
        getLivres().remove(index);
        return true;
    }

    public static void ajouterLivre (Livre livre) { //est ce qu'on fait "throws SaisieException"
        getLivres().add(livre.getTitre());
    }

    */
    @Override
    public String toString() {
        return "Titre du livre : " + this.getTitre() + " . Auteur : " + this.getAuteur() +
                " . Quantite : " + this.getQuantite() + " . Numero ISBN : " +this.getIsbn() +
                " . Disponibilité : " + this.getEtat();

    }

}

