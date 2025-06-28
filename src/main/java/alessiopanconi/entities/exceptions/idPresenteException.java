package alessiopanconi.entities.exceptions;

public class idPresenteException extends RuntimeException {
    public idPresenteException() {super("Un gioco con questo ID è già presente");}
}
