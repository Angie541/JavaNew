package javaExceptionsNewVersion.university_organization;

import java.util.ArrayList;
import java.util.List;
import javaExceptionsNewVersion.exceptions.*;

public class Group {
    private String name;
    private List<Student> studentList;

    public Group(String name) {
        this.name = name;
        this.studentList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Student> getStudentsList() {
        return studentList;
    }

    public Student getStudent(String name) throws MissingUniversityDivisionException {
        for (Student student : this.studentList) {
            if (student.getNameAndLastName().equals(name))
                return student;
        }
        throw new MissingUniversityDivisionException("student", this.name);
    }

    public void addStudent(Student student) {
        this.studentList.add(student);
    }

    public String getAverage(String studentName) {
        int sumOfMarks = 0;
        double averageMark = 0;

        for (Student student : this.getStudentsList()) {
            if (student.getNameAndLastName().equals(studentName)) {
                for (Mark mark : student.getList()) {
                    sumOfMarks = sumOfMarks + mark.getMark();
                }
                averageMark = (double) sumOfMarks / student.getList().size();
            }
        }
        return ("\n\nAverage mark of " + studentName + " = " + "{" + averageMark + "}");
    }
}