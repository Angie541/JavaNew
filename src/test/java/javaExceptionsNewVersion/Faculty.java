package javaExceptionsNewVersion;

import java.util.ArrayList;
import java.util.List;

public class Faculty {
    private String name;
    private List<Group> groupList;

    public  Faculty (String name){
        this.name = name;
        this.groupList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Group> getGroupList() {
        return groupList;
    }

    public Group getGroup(String name) throws EmptyException {
        for(Group group: this.groupList){
            if(group.getName().equals(name))
                return group;
        }
        throw new EmptyException("group", this.name);
    }

    public void addGroup(Group group){
        this.groupList.add(group);
    }
}
