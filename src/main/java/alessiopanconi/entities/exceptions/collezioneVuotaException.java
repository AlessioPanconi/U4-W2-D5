package alessiopanconi.entities.exceptions;

public class collezioneVuotaException extends RuntimeException {
    public collezioneVuotaException() {
        super("La collezione è vuota");
    }
}
