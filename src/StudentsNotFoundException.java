public class StudentsNotFoundException extends Exception{
    public StudentsNotFoundException() {
        super();
    }

    public StudentsNotFoundException(String message) {
        super(message);
    }

    public StudentsNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentsNotFoundException(Throwable cause) {
        super(cause);
    }
}
