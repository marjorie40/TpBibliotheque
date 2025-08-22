package model;

import exception.SaisieException;

import java.time.LocalDate;



public class Pret {

    private LocalDate debut;
    private LocalDate fin;
    private Abonne abonne;
    private Livre livre;

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

    public Pret(Abonne abonne, Livre livre, LocalDate debut, LocalDate fin) throws SaisieException {
        this.setAbonne(abonne);
        this.setLivre(livre);
        this.debut = LocalDate.now();
        this.fin = LocalDate.now().plusDays(7);

    }


}
