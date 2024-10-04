package exceptions;

public class EmptyDataException extends DataException {
    public EmptyDataException(String message) {
        super(message);
    }
    public EmptyDataException(){
        super("Ошибка! Переданные строки пусты!");
    }
}
