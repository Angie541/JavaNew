package javaExceptions;

class Faculties extends JavaExceptions {
    protected String facultyName;
    
    public Faculties() {
    }
    
    public Faculties(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getFacultyName(){
        return facultyName;
    }
}
