package model;

import exception.SaisieException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;

public class PretLivre {

    private int identifiantPret;
    private Abonne abonne;
    private Livre livre;
    private LocalDate debut;
    private LocalDate fin;
    DateTimeFormatter calendar = DateTimeFormatter.ofPattern("dd/MM/yyyy");  //  ?? où le placer et rester public ou private

    public PretLivre(int identifiantPret, Abonne abonne, Livre livre, LocalDate debut, LocalDate fin) throws SaisieException {
        this.setIdentifiantPret(identifiantPret);
        this.setAbonne(abonne);
        this.setLivre(livre);
        this.debut = LocalDate.now();
        this.fin = LocalDate.now().plusDays(7);
    }

    public static ArrayList<PretLivre> pretLivres = new ArrayList<PretLivre>();

    public int getIdentifiantPret() {
        return this.identifiantPret;
    }

    public void setIdentifiantPret(int identifiantPret) throws SaisieException {
        if (identifiantPret <= 0 || identifiantPret > 999999999) {
            throw new SaisieException("L'identifiant du prêt est invalide, " +
                    "veuillez saisir un identifiant correct : une série de 9 chiffres. ");
        } else {
            this.identifiantPret = identifiantPret;
        }
    }

    public Abonne getAbonne() {
        return this.abonne;
    }

    public void setAbonne(Abonne abonne) throws SaisieException {
        if (abonne == null) {
            throw new SaisieException("L'abonné est invalide, merci de le renseigner.");
        } else {
            this.abonne = abonne;
        }
    }

    public Livre getLivre() {
        return this.livre;
    }

    public void setLivre(Livre livre) throws SaisieException {
        if (livre == null) {
            throw new SaisieException("Le livre est invalide, merci de le renseigner.");
        } else {
            this.livre = livre;
        }
    }

    public static ArrayList<PretLivre> getPretLivre() throws SaisieException {
        if (PretLivre.getPretLivre() == null) {
            throw new SaisieException("La liste de prêts n'existe pas. ");
        } else {
            return PretLivre.getPretLivre();
        }
    }

    public LocalDate getDebut() {
        return this.debut;
    }

    public void setDebut(LocalDate debut) throws SaisieException {
        if (debut == null) {
            throw new SaisieException(" La date saisie est invalide, veuillez la resaisir. ");
        } else {
            this.debut = LocalDate.parse(LocalDate.now().format(calendar));
        }
    }


    @Override

    public String toString() {
        return "Prêt  " + getIdentifiantPret() + " : l'abonné : " + getAbonne().getNom() + getAbonne().getPrenom() +
                "est en possession de l'ouvrage : " + getLivre().getTitre() +
                " du " + getDebut() + " jusqu'au *** " + getDebut().plusDays(7) + " ***.";
    }

    //CRUD

    public static void ajouter(PretLivre pretLivre) {

    }
    /* throws SaisieException {
        if ( Livre.getEtat() == false) { // ?? comment interdire le pret d'un livre numériquement indisponible si etatLivre est false
            throw new SaisieException("Le livre est indisponible.");
        } else {
            PretLivre.getPretLivre().add(PretLivre.getPretLivre().size(), pretLivre);
            // ??? IDE ?? Comment ajouter à la liste en exprimant le int index du pret et l'utiliser comme identifiant
        }
    }*/

    public static void supprimer(int identifiantPret) { // integrer des exceptions, ou dans vue-controleur faire des validations ?
    }

    public static void modifier(int identifiantPret) {
    }

    public void modifier(PretLivre pretlivre) {
    }
}



