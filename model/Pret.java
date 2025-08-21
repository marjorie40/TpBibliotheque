package model;


import java.time.LocalDate;
import java.util.HashMap;


public class Pret {

    LocalDate debut;
    LocalDate fin;
    String email;
    int ISBN;
    String titre;


    HashMap<Integer, String > prets;   //lier (key :ISBN, value: email)

    public Pret(String email, int ISBN, String titre, LocalDate debut, LocalDate fin) {

        this.email = email;
        this.ISBN = ISBN;
        this.titre = titre;
        this.debut = LocalDate.now();
        this.fin = LocalDate.now().plusDays(7);


    }


}
