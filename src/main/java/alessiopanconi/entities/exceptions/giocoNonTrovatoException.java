package alessiopanconi.entities.exceptions;

public class giocoNonTrovatoException extends RuntimeException {
    public giocoNonTrovatoException() {
        super("Non è stato trovato nessun gioco che rispetti le condizioni della ricerca");
    }
}
