package javaExceptions;

import java.util.*;
import java.lang.*;

class JavaExceptions {
        public static void main(String[] args) throws MarkException, LackOfSubjectsException, EmptyException {
                ArrayList<Students> groupA1 = new ArrayList<>();
                groupA1.add(new Students("Aglay Johns", "biology", 3, "psychology", 9));
                groupA1.add(new Students("Vika Linght", "biology", 2, "psychology", 5));
                groupA1.add(new Students("Victor Krylov", "psychology", 7, "biology", 6));

                ArrayList<Students> groupA2 = new ArrayList<>();
                groupA2.add(new Students("Lili Smith", "biology", 4, "biology", 7));
                groupA2.add(new Students("Harvey Spector", "psychology", 9, "biology", 5));

                ArrayList<ArrayList<Students>> facultyOfBiology = new ArrayList<>(Arrays.asList(groupA1, groupA2));

                ArrayList<Students> groupB1 = new ArrayList<>();
                groupB1.add(new Students("Henry Johns", "math", 7, "physics", 5));
                groupB1.add(new Students("Mike Caroll", "", 0, "math", 5));

                ArrayList<Students> groupB2 = new ArrayList<>();

                ArrayList<ArrayList<Students>> facultyOfPhysics = new ArrayList<>(Arrays.asList(groupB1, groupB2));

                ArrayList<ArrayList<ArrayList<Students>>> university = new ArrayList<>(
                                Arrays.asList(facultyOfBiology, facultyOfPhysics));

                System.out.println("\n---------------University: ---------------");
                for (ArrayList<ArrayList<Students>> u : university) {
                        System.out.println("Faculty : ");
                        for (int i = 0; i < u.size(); i++) {
                                if (i == 0) {
                                        System.out.println("   Group1 : ");
                                } else {
                                        System.out.println("   Group2 : ");
                                }
                                for (int j = 0; j < u.get(i).size(); j++) {

                                        System.out.println(u.get(i).get(j).getEverything());
                                }
                        }
                }

                Students calculating = new Students();
                calculating.getAverageMarkOfSomeStudentsByAllSubjects(groupB1);
                calculating.getAverageMarkOfAGroup(groupB1, "physics");
                calculating.getAverageMarkOfUniversity(university, "psychology");
        }
}