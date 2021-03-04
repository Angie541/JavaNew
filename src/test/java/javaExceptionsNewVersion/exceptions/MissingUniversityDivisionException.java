package javaExceptionsNewVersion.exceptions;

public class MissingUniversityDivisionException extends Exception {
    public MissingUniversityDivisionException(String unit, String nameOfSubdivision) {
        super("There is no such a " + unit + " in " + nameOfSubdivision + "!");
    }
}
