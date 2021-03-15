package javaExceptionsNewVersion.university_organization;

import javaExceptionsNewVersion.exceptions.*;

public class Mark {
    private int mark;
    private Subject subject;

    public Mark(int mark, Subject subject) throws IllegalMarkException, AbsenceOfSubjectsException {
        this.mark = mark;
        if (10 < mark || mark < 0)
            throw new IllegalMarkException("The Mark cannot be less than 0 or more than 10!");
        this.subject = subject;
        if (subject == null)
            throw new AbsenceOfSubjectsException("The Student doesn't have any subjects!");
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