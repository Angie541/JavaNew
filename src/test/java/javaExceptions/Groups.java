package javaExceptions;

class Groups extends Faculties {
   protected int groupNumber;

   public Groups() {
        super();
    }

    public Groups(String facultyName, int groupNumber) {
        super(facultyName);
        this.groupNumber = groupNumber;
    }

    public int getGroupNumber(){
        return groupNumber;
    }
}
