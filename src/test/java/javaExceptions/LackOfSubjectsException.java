package javaExceptions;

class LackOfSubjectsException extends Exception {
    public String toString() {
        return "ERROR. The Student doesn't have any subjects!";
    }
}