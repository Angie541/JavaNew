package javaExceptionsNewVersion.university_organization;

import java.util.ArrayList;
import java.util.List;
import javaExceptionsNewVersion.exceptions.*;

public class Faculty {
    private String name;
    private List<Group> groupList;

    public Faculty(String name) {
        this.name = name;
        this.groupList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Group> getGroupList() {
        return groupList;
    }

    public Group getGroup(String name) throws MissingUniversityDivisionException {
        for (Group group : this.groupList) {
            if (group.getName().equals(name))
                return group;
        }
        throw new MissingUniversityDivisionException("group", this.name);
    }

    public void addGroup(Group group) {
        this.groupList.add(group);
    }

    public String getAverage(String groupName, String subject) {
        int sumOfMarks = 0;
        int numberOfMatches = 0;

        for (Group group : this.getGroupList()) {
            if (group.getName().equals(groupName)) {
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
        return ("Average Mark by " + subject + " in group " + groupName + " = " + "{" + ((double) sumOfMarks / numberOfMatches) + "}");
    }
}
