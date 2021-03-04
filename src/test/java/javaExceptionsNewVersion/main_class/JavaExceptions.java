package javaExceptionsNewVersion.main_class;

import java.lang.*;
import javaExceptionsNewVersion.university_organization.*;

class JavaExceptions {
    public static void main(String[] args) {
        University university = new University("Columbia");
        university.addFaculty(new Faculty("Faculty of Biology"));
        university.addFaculty(new Faculty("Faculty of Physics"));

        try {
            university.getFaculty("Faculty of Biology").addGroup(new Group("A1"));
            university.getFaculty("Faculty of Biology").addGroup(new Group("A2"));

            university.getFaculty("Faculty of Physics").addGroup(new Group("B1"));
            university.getFaculty("Faculty of Physics").addGroup(new Group("B2"));

            university.getFaculty("Faculty of Biology").getGroup("A1").addStudent(new Student("Aglay Johns"));
            university.getFaculty("Faculty of Biology").getGroup("A1").addStudent(new Student("Vika Linght"));
            university.getFaculty("Faculty of Biology").getGroup("A1").addStudent(new Student("Victor Krylov"));

            university.getFaculty("Faculty of Biology").getGroup("A2").addStudent(new Student("Lili Smith"));
            university.getFaculty("Faculty of Biology").getGroup("A2").addStudent(new Student("Harvey Spector"));

            university.getFaculty("Faculty of Physics").getGroup("B1").addStudent(new Student("Henry Johns"));
            university.getFaculty("Faculty of Physics").getGroup("B1").addStudent(new Student("Mike Caroll"));

            university.getFaculty("Faculty of Physics").getGroup("B2").addStudent(new Student("Snap Willson"));

            university.getFaculty("Faculty of Biology").getGroup("A1").getStudent("Aglay Johns").addMark(new Mark(7, Subject.BIOLOGY));
            university.getFaculty("Faculty of Biology").getGroup("A1").getStudent("Aglay Johns").addMark(new Mark(8, Subject.PSYCHOLOGY));

            university.getFaculty("Faculty of Biology").getGroup("A1").getStudent("Vika Linght").addMark(new Mark(3, Subject.BIOLOGY));
            university.getFaculty("Faculty of Biology").getGroup("A1").getStudent("Vika Linght").addMark(new Mark(7, Subject.PSYCHOLOGY));

            university.getFaculty("Faculty of Biology").getGroup("A1").getStudent("Victor Krylov").addMark(new Mark(9, Subject.ENGLISH));
            university.getFaculty("Faculty of Biology").getGroup("A1").getStudent("Victor Krylov").addMark(new Mark(2, Subject.PSYCHOLOGY));

            university.getFaculty("Faculty of Biology").getGroup("A2").getStudent("Lili Smith").addMark(new Mark(6, Subject.BIOLOGY));
            university.getFaculty("Faculty of Biology").getGroup("A2").getStudent("Lili Smith").addMark(new Mark(8, Subject.PSYCHOLOGY));

            university.getFaculty("Faculty of Biology").getGroup("A2").getStudent("Harvey Spector").addMark(new Mark(7, Subject.ENGLISH));
            university.getFaculty("Faculty of Biology").getGroup("A2").getStudent("Harvey Spector").addMark(new Mark(9, Subject.BIOLOGY));

            university.getFaculty("Faculty of Physics").getGroup("B1").getStudent("Henry Johns").addMark(new Mark(3, Subject.MATH));
            university.getFaculty("Faculty of Physics").getGroup("B1").getStudent("Henry Johns").addMark(new Mark(1, Subject.PSYCHOLOGY));

            university.getFaculty("Faculty of Physics").getGroup("B1").getStudent("Mike Caroll").addMark(new Mark(5, Subject.PHYSICS));
            university.getFaculty("Faculty of Physics").getGroup("B1").getStudent("Mike Caroll").addMark(new Mark(4, Subject.PSYCHOLOGY));

            university.getFaculty("Faculty of Physics").getGroup("B2").getStudent("Snap Willson").addMark(new Mark(7, Subject.ENGLISH));

            System.out.println("\n-----------------------------" + university.getName() + " University : -----------------------------");
            for (Faculty faculty : university.getFacultyList()) {
                System.out.println("\n" + faculty.getName() + ": ");
                for (Group group : faculty.getGroupList()) {
                    System.out.println("  group " + group.getName() + ": ");
                    for (Student student : group.getStudentsList()) {
                        System.out.format("     student:    | " + "%-20s", student.getNameAndLastName());
                        for (Mark mark : student.getList()) {
                            System.out.format("%-22s", mark.getEverything());
                        }
                        System.out.print("\n");
                    }
                    System.out.print("\n");
                }
            }
            System.out.println(university.getFaculty("Faculty of Physics").getGroup("B1").getAverage("Mike Caroll"));
            System.out.println(university.getFaculty("Faculty of Biology").getAverage("A2", "biology"));
            System.out.println(university.getAverage("psychology"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}