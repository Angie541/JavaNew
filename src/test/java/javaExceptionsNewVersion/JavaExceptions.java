package javaExceptionsNewVersion;

import java.lang.*;

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

                        System.out.println("\n-----------------------------"+ university.getName() +" University : -----------------------------");
                        for(int i = 0; i < university.getFacultyList().size(); i++){
                                System.out.println("\n" + university.getFacultyList().get(i).getName() + ": ");

                                for(int j = 0; j < university.getFacultyList().get(i).getGroupList().size(); j++) {
                                        System.out.println(" group " + university.getFacultyList().get(i).getGroupList().get(j).getName() + ": ");

                                        for (int k = 0; k < university.getFacultyList().get(i).getGroupList().get(j).getStudentsList().size(); k++){
                                                System.out.format("    student:  " + "%15s", university.getFacultyList().get(i).getGroupList().get(j).getStudentsList().get(k).getNameAndLastName());

                                                for (int l = 0; l < university.getFacultyList().get(i).getGroupList().get(j).getStudentsList().get(k).getList().size(); l++){
                                                        System.out.format("%26s", university.getFacultyList().get(i).getGroupList().get(j).getStudentsList().get(k).getList().get(l).getEverything());
                                                }
                                                System.out.print("\n");
                                        }
                                }
                        }
                        university.getAverageMarkOfTheStudentByAllSubjects("Mike Caroll");
                        university.getAverageMarkOfTheGroupByTheSubject("A2", "biology");
                        university.getAverageMarkOfTheUniversity( "psychology");

                } catch (Exception e) {
                        e.printStackTrace();
                }
        }
}