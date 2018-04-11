package Entity;

public class Teacher {
    private Long id;
    private String name;
    private String faculty;

    public Teacher() {
    }

    public Teacher(String name, String faculty) {
        this.name = name;
        this.faculty = faculty;
    }

    public Teacher(Long id, String firstName, String faculty) {
        this.id = id;
        this.name = firstName;
        this.faculty = faculty;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", faculty='" + faculty + '\'' +
                '}';
    }
}
