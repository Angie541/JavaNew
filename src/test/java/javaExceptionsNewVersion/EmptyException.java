package javaExceptionsNewVersion;

class EmptyException extends Exception {

    public EmptyException(String unit, String nameOfSubdivision) {
        super("There is no such a " + unit + " in " + nameOfSubdivision + "!");
    }

    public EmptyException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyException(String message) {
        super(message);
    }
}