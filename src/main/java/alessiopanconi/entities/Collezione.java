package alessiopanconi.entities;

import alessiopanconi.entities.enums.Genere;
import alessiopanconi.entities.exceptions.collezioneVuotaException;
import alessiopanconi.entities.exceptions.giocoNonTrovatoException;
import alessiopanconi.entities.exceptions.idPresenteException;

import java.util.*;
import java.util.stream.Collectors;

public class Collezione {

    private List<Gioco> collezione = new ArrayList<>();


    //METODI
//    public void stampaCollezione() {
//        if (collezione.isEmpty()) {
//            System.out.println("La collezione è vuota.");
//        } else {
//            System.out.println("Contenuto della collezione:");
//            collezione.forEach(gioco -> System.out.println(gioco));
//        }
//    }
    //1
    public void inserisciGioco(Gioco nuovoGioco) {
        try {
            for (Gioco gioco : collezione) {
                if (gioco.getId() == nuovoGioco.getId()) {
                    throw new idPresenteException();
                }
            }
            collezione.add(nuovoGioco);
            System.out.println("Aggiunta completata.");
        } catch (idPresenteException e) {
            System.out.println(e.getMessage());
        }
    }
    //2
    public void cercaPerId(int id) {
        try {
            Optional<Gioco> trovato = collezione.stream().filter(gioco -> gioco.getId() == id).findFirst();

            if (trovato.isPresent()) {
                System.out.println("Il gioco con id " + id + " è stato trovato e si chiama: " + trovato.get().getTitolo());
            } else {
                throw new giocoNonTrovatoException();
            }
        } catch (giocoNonTrovatoException e) {
            System.out.println(e.getMessage());
        }
    }
    //3
    public void cercaPerPrezzo(double prezzo) {
        try{
            List<Gioco> trovati = collezione.stream().filter(gioco -> gioco.getPrezzo() < prezzo).toList();
            if (trovati.isEmpty()) {
                throw new collezioneVuotaException();
            }else {
                System.out.println("Giochi trovati con prezzo inferiore a: "+ prezzo);
                trovati.forEach(gioco -> System.out.println(gioco));
            }

        } catch (collezioneVuotaException e){
            System.out.println("Non sono stati trovati giochi con prezzo inferiore quindi " + e.getMessage());
        }
    }
    //4
    public void cercaPerNumeroGiocatori(int numeroGiocatori) {
        try {
            List<Gioco> trovati = collezione.stream().filter(gioco -> gioco instanceof GiocoDaTavolo).filter(gioco -> ((GiocoDaTavolo) gioco).getNumeroGiocatori() == numeroGiocatori).toList();

            if (trovati.isEmpty()) {
                throw new giocoNonTrovatoException();
            } else {
                System.out.println("Giochi da tavolo trovati per " + numeroGiocatori + " giocatori:");
                trovati.forEach(gioco -> System.out.println(gioco));
            }
        } catch (giocoNonTrovatoException e) {
            System.out.println(e.getMessage());
        }
    }
    //4
    public void eliminaPerId(int id) {
        try {
            Optional<Gioco> trovato = collezione.stream().filter(gioco -> gioco.getId() == id).findFirst();

            if (trovato.isPresent()) {
                collezione.remove(trovato.get());
                System.out.println("Gioco con id " + id + " eliminato correttamente.");
            } else {
                throw new giocoNonTrovatoException();
            }
        } catch (giocoNonTrovatoException e) {
            System.out.println(e.getMessage());
        }
    }
    //5
    public void aggiornaGiocoPerId(int id) {
        try {
            Optional<Gioco> trovato = collezione.stream().filter(gioco -> gioco.getId() == id).findAny();

            if (trovato.isPresent()) {
                Gioco gioco = trovato.get();
                Scanner scan = new Scanner(System.in);
                String valore;

                System.out.print("Vuoi modificare il titolo? se sì digita s: ");
                valore = scan.nextLine();
                if (valore.equalsIgnoreCase("s")) {
                    System.out.print("Titolo attuale: " + gioco.getTitolo() + " nuovo titolo: ");
                    valore = scan.nextLine();
                    if (!valore.isEmpty()) {
                        gioco.setTitolo(valore);
                    }
                }

                System.out.print("Vuoi modificare l'anno? se sì digita s: ");
                valore = scan.nextLine();
                if (valore.equalsIgnoreCase("s")) {
                    System.out.print("Anno attuale: " + gioco.getAnnoPubblicazione() + " nuovo anno: ");
                    valore = scan.nextLine();
                    if (!valore.isEmpty()) {
                        gioco.setAnnoPubblicazione(Integer.parseInt(valore));
                    }
                }

                System.out.print("Vuoi modificare il prezzo? se sì digita s: ");
                valore = scan.nextLine();
                if (valore.equalsIgnoreCase("s")) {
                    System.out.print("Prezzo attuale: " + gioco.getPrezzo() + " nuovo prezzo: ");
                    valore = scan.nextLine();
                    if (!valore.isEmpty()) {
                        gioco.setPrezzo(Double.parseDouble(valore));
                    }
                }

                if (gioco instanceof VideoGioco) {
                    VideoGioco videoGioco = (VideoGioco) gioco;

                    System.out.print("Vuoi modificare la piattaforma? se sì digita s: ");
                    valore = scan.nextLine();
                    if (valore.equalsIgnoreCase("s")) {
                        System.out.print("Piattaforma attuale: " + videoGioco.getPiattaforma() + " nuova piattaforma: ");
                        valore = scan.nextLine();
                        if (!valore.isEmpty()) {
                            videoGioco.setPiattaforma(valore);
                        }
                    }

                    System.out.print("Vuoi modificare le ore di gioco? se sì digita s: ");
                    valore = scan.nextLine();
                    if (valore.equalsIgnoreCase("s")) {
                        System.out.print("Ore di gioco attuali: " + videoGioco.getDurata() + " nuove ore: ");
                        valore = scan.nextLine();
                        if (!valore.isEmpty()) {
                            videoGioco.setDurata(Integer.parseInt(valore));
                        }
                    }

                    System.out.print("Vuoi modificare il genere? se sì digita s: ");
                    valore = scan.nextLine();
                    if (valore.equalsIgnoreCase("s")) {
                        System.out.print("Genere attuale: " + videoGioco.getGenere() + " nuovo genere (scegli tra: INDIE ; AZIONE ; AVVENTURA ; MOBA): ");
                        valore = scan.nextLine();
                        if (!valore.isEmpty()) {
                            videoGioco.setGenere(Genere.valueOf(valore.toUpperCase()));
                        }
                    }

                } else if (gioco instanceof GiocoDaTavolo) {
                    GiocoDaTavolo giocoDaTavolo = (GiocoDaTavolo) gioco;

                    System.out.print("Vuoi modificare il numero di giocatori? se sì digita s: ");
                    valore = scan.nextLine();
                    if (valore.equalsIgnoreCase("s")) {
                        System.out.print("Numero giocatori attuale: " + giocoDaTavolo.getNumeroGiocatori() + " nuovo numero: ");
                        valore = scan.nextLine();
                        if (!valore.isEmpty()) {
                            giocoDaTavolo.setNumeroGiocatori(Integer.parseInt(valore));
                        }
                    }

                    System.out.print("Vuoi modificare la durata della partita? se sì digita s: ");
                    valore = scan.nextLine();
                    if (valore.equalsIgnoreCase("s")) {
                        System.out.print("Durata partita attuale: " + giocoDaTavolo.getDurata() + " nuova durata: ");
                        valore = scan.nextLine();
                        if (!valore.isEmpty()) {
                            giocoDaTavolo.setDurata(Integer.parseInt(valore));
                        }
                    }
                }

                System.out.println("Hai aggiornato il tuo gioco.");
                System.out.println(gioco);

            } else {
                throw new giocoNonTrovatoException();
            }

        } catch (giocoNonTrovatoException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Hai inserito un valore numerico non valido.");
        } catch (IllegalArgumentException e) {
            System.out.println("Hai inserito un valore non valido.");
        }
    }

    //6
    public void statisticheCollezione() {
        try {
            if (collezione.isEmpty()) {
                throw new collezioneVuotaException();
            }

            int numeroVideoGiochi = 0;
            int numeroGiochiDaTavolo = 0;

            for (Gioco g : collezione) {
                if (g instanceof VideoGioco) {
                    numeroVideoGiochi++;
                } else if (g instanceof GiocoDaTavolo) {
                    numeroGiochiDaTavolo++;
                }
            }

            Gioco giocoPiuCostoso = collezione.stream().sorted(Comparator.comparing(Gioco::getPrezzo).reversed()).findFirst().get();

            double prezzoMedio = collezione.stream().collect(Collectors.averagingDouble(Gioco::getPrezzo));

            System.out.println("Il numero di videogiochi è: " + numeroVideoGiochi);
            System.out.println("Il numero di giochi da tavolo è: " + numeroGiochiDaTavolo);
            System.out.println("Il gioco più costoso è: " + giocoPiuCostoso.getTitolo());
            System.out.println("Il prezzo medio della tua collezione è: " + prezzoMedio);

        } catch (collezioneVuotaException e) {
            System.out.println(e.getMessage());
        }
    }
}