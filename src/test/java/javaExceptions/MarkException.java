package javaExceptions;

class MarkException extends Exception {
    public String toString() {
        return "ERROR. The Mark cannot be less than 0 or more than 10!";
    }
}