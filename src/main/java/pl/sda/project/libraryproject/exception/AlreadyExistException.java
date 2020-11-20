package pl.sda.project.libraryproject.exception;

public class AlreadyExistException extends  RuntimeException{
    public AlreadyExistException(String message) {
        super(message);
    }
}
