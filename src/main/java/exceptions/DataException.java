package exceptions;

public class DataException extends RuntimeException{
    public DataException() {
        super("Переданные параметры не валидны!");
    }
    public DataException(String message) {
        super(message);
    }
}
