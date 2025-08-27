package model;

import exception.SaisieException;
import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.util.ArrayList;

import static view.VueTpBibliotheque.getNom;

public class Pret {

    private int emprunt = 0; // fonctionne comme un index pour faire incrementation pour identifier chaque pret
    private LocalDate debut;
    private LocalDate fin;
    private String nomAbonne;
    private String titreLivre;

    public static ArrayList<Pret> listPrets = new ArrayList<Pret>();

    public Pret(int emprunt, String nomAbonne, String titreLivre, LocalDate debut, LocalDate fin) throws SaisieException {
        this.setNomAbonne(nomAbonne);
        this.setTitreLivre(titreLivre);
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

    public String getNomAbonne() {
        return nomAbonne;
    }
    public void setNomAbonne(String nomAbonne) {
        this.nomAbonne = nomAbonne;
    }

    public String getTitreLivre() {
        return titreLivre;
    }
    public void setTitreLivre(String titreLivre) {
        this.titreLivre = titreLivre;
    }


    @Override
    public String toString() {
        return "  Prêt numero " + this.getEmprunt() + " : l'abonné  " +this.getNomAbonne()+
                " , à emprunté l'ouvrage : " + this.getTitreLivre() +
                " du " + this.getDebut() +
                " jusqu'au *** " + this.getFin()+ " ***. " ;
    }
}
