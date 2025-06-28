package alessiopanconi;

import alessiopanconi.entities.Collezione;
import alessiopanconi.entities.GiocoDaTavolo;
import alessiopanconi.entities.VideoGioco;
import alessiopanconi.entities.enums.Genere;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

//        Collezione collezioneGiochi = new Collezione();
//
//        GiocoDaTavolo g1 = new GiocoDaTavolo("Monopoly", 101, 2000, 31.00, 6, 180);
//        VideoGioco g2 = new VideoGioco("CyberPunk 2077", 303, 2020, 89.99, "PC", 100, Genere.AZIONE);
//        VideoGioco g3 = new VideoGioco("League of Legends", 444, 2009, 0.00, "PC", 3000, Genere.MOBA);
//
//        collezioneGiochi.inserisciGioco(g1);
//        collezioneGiochi.inserisciGioco(g2);
//        collezioneGiochi.inserisciGioco(g3);
//
//        //collezioneGiochi.cercaPerId(101);
//        //collezioneGiochi.cercaPerId(3);
//
//        //collezioneGiochi.cercaPerPrezzo(31.00);
//        //collezioneGiochi.cercaPerPrezzo(89.00);
//
//        //collezioneGiochi.cercaPerNumeroGiocatori(6);
//        //collezioneGiochi.eliminaPerId(101);
//
//        //collezioneGiochi.statisticheCollezione();
//        //collezioneGiochi.stampaCollezione();

        Scanner scan = new Scanner(System.in);
        Collezione collezioneGiochi = new Collezione();
        boolean continua = true;

        System.out.println("Benvenuto nella gestione della collezione giochi!");

        while (continua) {
            System.out.println("\nScegli l'azione che vuoi compiere:\n" +
                    "1 - Aggiungi un gioco\n" +
                    "2 - Cerca gioco per ID\n" +
                    "3 - Cerca gioco per prezzo\n" +
                    "4 - Cerca gioco per numero di giocatori\n" +
                    "5 - Rimuovi un gioco\n" +
                    "6 - Aggiorna un gioco\n" +
                    "7 - Statistiche generali\n" +
                    "0 - Esci");

            try {
                int scelta = Integer.parseInt(scan.nextLine());

                switch (scelta) {
                    case 1 -> {
                        System.out.println("Crea un gioco: 1 per Videogioco, 2 per Gioco da tavolo, altro per tornare indietro");
                        String sceltaGiocoStr = scan.nextLine();
                        int sceltaGioco;

                        try {
                            sceltaGioco = Integer.parseInt(sceltaGiocoStr);
                        } catch (NumberFormatException e) {
                            System.out.println("Input non valido, ritorno al menu principale.");
                            break;
                        }

                        try {
                            if (sceltaGioco == 1) {
                                System.out.println("Inserisci il titolo del videogioco:");
                                String titolo = scan.nextLine();

                                System.out.println("Inserisci l'id del videogioco:");
                                int id = Integer.parseInt(scan.nextLine());

                                System.out.println("Anno di pubblicazione:");
                                int anno = Integer.parseInt(scan.nextLine());

                                System.out.println("Prezzo:");
                                double prezzo = Double.parseDouble(scan.nextLine());

                                System.out.println("Piattaforma:");
                                String piattaforma = scan.nextLine();

                                System.out.println("Durata (in ore):");
                                int durata = Integer.parseInt(scan.nextLine());

                                System.out.println("Scegli il genere: INDIE, AZIONE, AVVENTURA, MOBA");
                                Genere genere;
                                String genereInput = scan.nextLine().toUpperCase();
                                if (genereInput.equals("INDIE") || genereInput.equals("AZIONE") ||
                                        genereInput.equals("AVVENTURA") || genereInput.equals("MOBA")) {
                                    genere = Genere.valueOf(genereInput);
                                } else {
                                    System.out.println("Genere non valido");
                                    break;
                                }

                                VideoGioco nuovoVideogioco = new VideoGioco(titolo, id, anno, prezzo, piattaforma, durata, genere);
                                collezioneGiochi.inserisciGioco(nuovoVideogioco);
                                System.out.println("Videogioco aggiunto correttamente.");

                            } else if (sceltaGioco == 2) {
                                System.out.println("Inserisci il titolo del gioco da tavolo:");
                                String titolo = scan.nextLine();

                                System.out.println("id:");
                                int id = Integer.parseInt(scan.nextLine());

                                System.out.println("Anno di pubblicazione:");
                                int anno = Integer.parseInt(scan.nextLine());

                                System.out.println("Prezzo:");
                                double prezzo = Double.parseDouble(scan.nextLine());

                                System.out.println("Numero giocatori:");
                                int numGiocatori = Integer.parseInt(scan.nextLine());

                                System.out.println("Durata (in minuti):");
                                int durata = Integer.parseInt(scan.nextLine());

                                GiocoDaTavolo nuovoGiocoDaTavolo = new GiocoDaTavolo(titolo, id, anno, prezzo, numGiocatori, durata);
                                collezioneGiochi.inserisciGioco(nuovoGiocoDaTavolo);
                                System.out.println("Gioco da tavolo aggiunto correttamente.");

                            } else {
                                System.out.println("Hai scelto un numero diverso, quindi torniamo indietro.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Input numerico non valido durante l'inserimento. Ritorno al menu principale.");
                        }
                    }
                    case 2 -> {
                        System.out.println("Inserisci l'id del gioco: ");
                        int id = Integer.parseInt(scan.nextLine());
                        collezioneGiochi.cercaPerId(id);
                    }
                    case 3 -> {
                        System.out.println("Inserisci il prezzo: ");
                        double prezzo = Double.parseDouble(scan.nextLine());
                        collezioneGiochi.cercaPerPrezzo(prezzo);
                    }
                    case 4 -> {
                        System.out.println("Inserisci il numero di giocatori: ");
                        int numGiocatori = Integer.parseInt(scan.nextLine());
                        collezioneGiochi.cercaPerNumeroGiocatori(numGiocatori);
                    }
                    case 5 -> {
                        System.out.println("Inserisci l'id del gioco: ");
                        int id = Integer.parseInt(scan.nextLine());
                        collezioneGiochi.eliminaPerId(id);
                    }
                    case 6 -> {
                        System.out.println("Inserisci l'id del gioco: ");
                        int id = Integer.parseInt(scan.nextLine());
                        collezioneGiochi.aggiornaGiocoPerId(id);
                    }
                    case 7 -> collezioneGiochi.statisticheCollezione();
                    case 0 -> {
                        System.out.println("Uscita dal programma!");
                        continua = false;
                    }
                    default -> System.out.println("Scelta non valida, riprova.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Input numerico non valido, inserisci un numero corretto.");
            } catch (IllegalArgumentException e) {
                System.out.println("Errore: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Errore imprevisto: " + e.getMessage());
            }
        }

        scan.close();

    }
