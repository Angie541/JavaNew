package javaExceptions;

import java.util.ArrayList;

class Students extends Groups {
    protected String nameAndLastName;
    protected String subject1;
    protected int mark1;
    protected String subject2;
    protected int mark2;
    int numberOfSubjects = 2;

    public Students() {
        super();
    }

    public Students(String facultyName, int groupNumber, String nameAndLastName, String subject1, int mark1, String subject2, int mark2)
            throws MarkException, LackOfSubjectsException {
        super(facultyName, groupNumber);
        this.nameAndLastName = nameAndLastName;
        this.subject1 = subject1;
        this.mark1 = mark1;
        this.subject2 = subject2;
        this.mark2 = mark2;

        if (subject1 == "" && subject2 == "")
            throw new LackOfSubjectsException();
        if (10 < mark1 || mark1 < 0)
            throw new MarkException();
        if (10 < mark2 || mark2 < 0)
            throw new MarkException();
    }

    public String getName() {
        return nameAndLastName;
    }

    public String getSubject1() {
        return subject1;
    }

    public String getSubject2() {
        return subject2;
    }

    public int getMark1() {
        return mark1;
    }

    public int getMark2() {
        return mark2;
    }

    public String getEverything() {
        return "       (f." + facultyName  + ",  gr." +  groupNumber  + ")  :      " + nameAndLastName + ":    |" + subject1 + ", " + mark1 + ", " + subject2 + ", " + mark2 + "|";
    }

    public int getAverageMarkOfAStudent() {
        int averageMarkOfAStudent = (mark1 + mark2) / numberOfSubjects;
        return averageMarkOfAStudent;
    }

    // Calculating the average mark of a student
    public void getAverageMarkOfSomeStudentsByAllSubjects(ArrayList<Students> nameOfTheGroup) {
        System.out.println("\nAverage mark of a student: ");
        for (Students averageMark : nameOfTheGroup) {
            System.out.println("Average mark of " + averageMark.getName() + " = " + "{"
                    + averageMark.getAverageMarkOfAStudent() + "}");
        }
    }

    // Calculating average mark by a subgject of a group
    public void getAverageMarkOfAGroup(ArrayList<Students> nameOfTheGroup, String subj) {
        int sum = 0;
        int numberOfStudents = nameOfTheGroup.size();
        for (Students averageMark : nameOfTheGroup) {
            if (averageMark.getSubject1() == subj) {
                sum += averageMark.getMark1();
            } else if (averageMark.getSubject2() == subj) {
                sum += averageMark.getMark2();
            }
        }
        System.out.println("\nAverage Mark of Group (" + nameOfTheGroup.get(nameOfTheGroup.size()-1).groupNumber + ")  by " + subj + " = " + "{"
                + (sum / numberOfStudents) + "}");
    }

    // Calculating the University's average mark by the subject + Checking for
    // absence of empty groups, faculties and University
    public void getAverageMarkOfUniversity(ArrayList<ArrayList<ArrayList<Students>>> nameOfTheUniversity, String subj)
            throws EmptyException {
        int sum = 0;
        int numberOfStudents = 0;
        
       if (nameOfTheUniversity.isEmpty())
            throw new EmptyException("ERROR. The University doesn't have any faculties!");

            for (ArrayList<ArrayList<Students>> faculty : nameOfTheUniversity) {
                if (faculty.isEmpty())
                    throw new EmptyException("ERROR. The Faculty doesn't have any groups!");

                for (ArrayList<Students> group : faculty) {
                    if (group.isEmpty())
                        throw new EmptyException("ERROR. The Group doesn't have any students!");

                    for (Students students : group) {
                        if (students.getSubject1() == subj) {
                            numberOfStudents += 1;
                            sum += students.getMark1();
                        } else if (students.getSubject2() == subj) {
                            numberOfStudents += 1;
                            sum += students.getMark2();
                        }
                    }
                }
            }
        System.out.println("\nAverage Mark of University by " + subj + ":  {" + (sum / numberOfStudents) + "}");
    }
}
