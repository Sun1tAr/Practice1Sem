package exceptions;

public class UnknownCharacterException extends DataException {
    public UnknownCharacterException(String message) {
        super(message);
    }
    public UnknownCharacterException(){
        super("Ошибка! Символы должны быть английскими или в формате цифр!");
    }
}
