package alessiopanconi.entities;

public class GiocoDaTavolo extends Gioco{

    private int numeroGiocatori;
    private int durata;

    public GiocoDaTavolo(String titolo, int id, int annoPubblicazione, double prezzo, int numeroGiocatori, int durata) {
        super(titolo, id, annoPubblicazione, prezzo);
        this.numeroGiocatori=numeroGiocatori;
        this.durata=durata;
    }

    //GETTER
    public int getNumeroGiocatori() {

        return numeroGiocatori;
    }
    public int getDurata() {

        return durata;
    }
    //SETTER
    public void setNumeroGiocatori(int numeroGiocatori) {

        this.numeroGiocatori = numeroGiocatori;
    }
    public void setDurata(int durata) {

        this.durata = durata;
    }

    @Override
    public String toString() {
        return "GiocoDaTavolo{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", prezzo=" + prezzo +
                ", numeroGiocatori=" + numeroGiocatori +
                ", durata=" + durata +
                '}';
    }
}
