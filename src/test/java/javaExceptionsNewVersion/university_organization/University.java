package javaExceptionsNewVersion.university_organization;

import java.util.ArrayList;
import java.util.List;
import javaExceptionsNewVersion.exceptions.*;

public class University {
    private String name;
    private List<Faculty> facultyList;

    public University(String name) {
        this.name = name;
        this.facultyList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Faculty> getFacultyList() {
        return facultyList;
    }

    public Faculty getFaculty(String name) throws MissingUniversityDivisionException {
        for (Faculty faculty : this.facultyList) {
            if (faculty.getName().equals(name))
                return faculty;
        }
        throw new MissingUniversityDivisionException("faculty", this.name);
    }

    public void addFaculty(Faculty faculty) {
        this.facultyList.add(faculty);
    }

    public String getAverage(String subject) {
        int sumOfMarks = 0;
        int numberOfMatches = 0;

        for (Faculty faculty : this.facultyList) {
            for (Group group : faculty.getGroupList()) {
                for (Student student : group.getStudentsList()) {
                    for (Mark mark : student.getList()) {
                        if ((mark.getSubject().toString().equals(subject.toUpperCase()))) {
                            sumOfMarks = sumOfMarks + mark.getMark();
                            numberOfMatches++;
                        }
                    }
                }
            }
        }
        return ("Average Mark of University by " + subject + " = {" + ((double) sumOfMarks / numberOfMatches) + "}");
    }
}