package model;

import exception.SaisieException;

import java.time.LocalDate;



public class Pret {

    LocalDate debut;
    LocalDate fin;



    public Pret(Abonne abonne,Livre livre, LocalDate debut, LocalDate fin) throws SaisieException {
        this.setAbonne(abonne);
        this.setLivre(livre);
        this.debut = LocalDate.now();
        this.fin = LocalDate.now().plusDays(7);


    }


}
