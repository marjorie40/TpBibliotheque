package model;

import exception.SaisieException;
import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.util.ArrayList;

public class Pret {

    private int emprunt = 0; // fonctionne comme un index pour faire incrementation pour identifier chaque pret
    private LocalDate debut;
    private LocalDate fin;
    private Abonne abonne;
    private Livre livre;

    public static ArrayList<Pret> listPrets = new ArrayList<Pret>();

    public Pret(int emprunt, Abonne abonne, Livre livre, LocalDate debut, LocalDate fin) throws SaisieException {
        this.setAbonne(abonne);
        this.setLivre(livre);
        this.debut = LocalDate.now();
        this.fin = LocalDate.now().plusDays(7);
        this.emprunt = ++emprunt;  // le i de la liste pour

    }

    public int getEmprunt() {
        return emprunt;
    }
    public void setEmprunt(int emprunt) {
        this.emprunt = emprunt;
    }

    public LocalDate getDebut() {
        return debut;
    }
    public void setDebut(LocalDate debut) {
        this.debut = debut;
    }

    public LocalDate getFin() {
        return fin;
    }
    public void setFin(LocalDate fin) {
        this.fin = fin;
    }

    public Abonne getAbonne() {
        return abonne;
    }
    public void setAbonne(Abonne abonne) {
        this.abonne = abonne;
    }

    public Livre getLivre() {
        return livre;
    }
    public void setLivre(Livre livre) {
        this.livre = livre;
    }


    @Override
    public String toString() {
        return "  Prêt numero " + this.getEmprunt() + " : l'abonné  " +this.getAbonne().getNom() + " " + this.getAbonne().getPrenom() +
                " , à emprunté l'ouvrage : " + this.getLivre().getTitre() +
                " du " + this.getDebut() +
                " jusqu'au *** " + this.getFin()+ " ***. " ;
    }
}
