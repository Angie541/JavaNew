package javaExceptionsNewVersion;

public class Mark {
    private int mark;
    private Subject subject;

    public Mark(int mark, Subject subject) throws EmptyException {
        this.mark = mark;
        if (10 < mark || mark < 0)
            throw new EmptyException("ERROR. The Mark cannot be less than 0 or more than 10!", (Throwable) null);
        this.subject = subject;
        if (subject == null)
            throw new  EmptyException("ERROR. The Student doesn't have any subjects!");
    }

    public int getMark() {
        return mark;
    }

    public Subject getSubject() {
        return subject;
    }

    public String getEverything() {
        return " |" + subject + " - " + mark + "|";
    }
}