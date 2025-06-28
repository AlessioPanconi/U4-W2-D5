package alessiopanconi.entities;

public abstract class Gioco {

    protected int id;
    protected String titolo;
    protected int annoPubblicazione;
    protected double prezzo;

    public Gioco(String titolo, int id, int annoPubblicazione, double prezzo) {
        this.titolo = titolo;
        this.id = id;
        this.annoPubblicazione = annoPubblicazione;
        this.prezzo = prezzo;
    }

    //GETTER
    public long getId() {

        return id;
    }
    public String getTitolo() {

        return titolo;
    }
    public int getAnnoPubblicazione() {

        return annoPubblicazione;
    }
    public double getPrezzo() {

        return prezzo;
    }

    //SETTER
    public void setId(int id) {
        this.id = id;
    }
    public void setTitolo(String titolo) {

        this.titolo = titolo;
    }
    public void setAnnoPubblicazione(int annoPubblicazione) {

        this.annoPubblicazione = annoPubblicazione;
    }
    public void setPrezzo(double prezzo) {

        this.prezzo = prezzo;
    }


}