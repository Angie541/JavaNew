package javaExceptionsNewVersion;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private String name;
    private List<Student> studentList;

    public  Group (String name){
        this.name = name;
        this.studentList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Student> getStudentsList() {
        return studentList;
    }

    public Student getStudent(String name) throws EmptyException {
        for(Student student: this.studentList){
            if(student.getNameAndLastName().equals(name))
                return  student;
        }
        throw new EmptyException("student", this.name);
    }

    public void addStudent(Student student){
        this.studentList.add(student);
    }
}
