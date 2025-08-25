package exception;

public class ExceptionDate extends Exception {

    private int jour;
    private int mois;
    private int annee;

    public ExceptionDate(String message,  int jour, int mois, int annee) {

        super(message); // recupère message de la classe exception (besoin de getter ??)
        this.setJour(jour);
        this.setMois(mois);
        this.setAnnee(annee);
    }

    public int getAnnee() {
        return annee;
    }
    public void setAnnee(int annee) {
        // ?? est ce qu'une throws SaisieException est redondante comme on construit une exception pour date
        // ou est-ce pertinent sur ces attributs ?
        this.annee = annee;
    }

    public int getMois() {
        return mois;
    }
    public void setMois(int mois) {
        this.mois = mois;
    }

    public int getJour(){
        return jour;
    }
    public void setJour(int jour)  {
        this.jour = jour;
    }

}
