package alessiopanconi.entities;

import alessiopanconi.entities.enums.Genere;

public class VideoGioco extends Gioco {

    private String piattaforma;
    private int durata;
    private Genere genere;

    public VideoGioco(String titolo, int id, int annoPubblicazione, double prezzo, String piattaforma, int durata,Genere genere) {
        super(titolo, id, annoPubblicazione, prezzo);
        this.piattaforma=piattaforma;
        this.durata=durata;
        this.genere=genere;
    }

    //GETTER
    public String getPiattaforma() {

        return piattaforma;
    }
    public int getDurata() {

        return durata;
    }
    public Genere getGenere() {

        return genere;
    }

    //SETTER
    public void setPiattaforma(String piattaforma) {

        this.piattaforma = piattaforma;
    }
    public void setDurata(int durata) {

        this.durata = durata;
    }
    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "VideoGioco{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", prezzo=" + prezzo +
                ", piattaforma='" + piattaforma + '\'' +
                ", durata=" + durata +
                ", genere=" + genere +
                '}';
    }
}
