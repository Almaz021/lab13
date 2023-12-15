public class InvalidTotalException extends Exception {
    public InvalidTotalException() {
        super("Total should be greater than 0");
    }
}
