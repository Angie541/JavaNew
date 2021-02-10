package javaExceptionsNewVersion;

import java.util.ArrayList;
import java.util.List;

public class University {
    private String name;
    private List <Faculty> facultyList;

    public University (String name){
        this.name = name;
        this.facultyList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Faculty> getFacultyList() {
        return facultyList;
    }

    public Faculty getFaculty(String name) throws EmptyException {
        for(Faculty faculty: this.facultyList){
            if(faculty.getName().equals(name))
                return faculty;
        }
        throw new EmptyException("faculty",this.name);
    }

    public void addFaculty(Faculty faculty) {
            this.facultyList.add(faculty);
    }

    public void getAverageMarkOfTheStudentByAllSubjects(String studentName) {
        double averageMark;
        int sumOfMarks = 0;

        for(Faculty faculty : this.facultyList){
            for(Group group : faculty.getGroupList()){
                for(Student student : group.getStudentsList()){
                    if(student.getNameAndLastName().equals(studentName)){
                        for(Mark mark : student.getList()){
                            sumOfMarks = sumOfMarks + mark.getMark();
                        }
                        averageMark = (double) sumOfMarks / student.getList().size();
                        System.out.println("\n\nAverage mark of " + student.getNameAndLastName() + " = " + "{" +  averageMark + "}" );
                    }
                }
            }
        }
    }

    public void getAverageMarkOfTheGroupByTheSubject(String groupName, String subject){
        double averageMark;
        int sumOfMarks = 0;
        int numberOfMatches = 0;

        for(Faculty faculty : this.facultyList){
            for(Group group : faculty.getGroupList()){
                if(group.getName().equals(groupName)) {
                    for (Student student : group.getStudentsList()) {
                        for (Mark mark : student.getList()) {
                            if((mark.getSubject().toString().equals(subject.toUpperCase()))) {
                                sumOfMarks = sumOfMarks +  mark.getMark();
                                numberOfMatches++;
                            }
                        }
                    }
                }
            }
        }
        averageMark = (double) sumOfMarks / numberOfMatches;
        System.out.println("Average Mark by " + subject + " in group " + groupName +  " = " + "{"
                + averageMark + "}");
    }

    public void getAverageMarkOfTheUniversity(String subject) {
        double averageMark;
        int sumOfMarks = 0;
        int numberOfMatches = 0;

        for(Faculty faculty : this.facultyList){
            for(Group group : faculty.getGroupList()){
                for (Student student : group.getStudentsList()) {
                    for (Mark mark : student.getList()) {
                        if((mark.getSubject().toString().equals(subject.toUpperCase()))) {
                            sumOfMarks = sumOfMarks +  mark.getMark();
                            numberOfMatches++;
                        }
                    }
                }
            }
        }
        averageMark = (double) sumOfMarks / numberOfMatches;
        System.out.println("Average Mark of University by " + subject + ":  {" + averageMark + "}");
    }
}