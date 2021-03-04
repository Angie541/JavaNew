package javaExceptionsNewVersion.university_organization;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String nameAndLastName;
    private List<Mark> markList;

    public Student(String nameAndLastName) {
        this.nameAndLastName = nameAndLastName;
        this.markList = new ArrayList<>();
    }

    public String getNameAndLastName() {
        return nameAndLastName;
    }

    public List<Mark> getList() {
        return markList;
    }

    public void addMark(Mark mark) {
        this.markList.add(mark);
    }
}