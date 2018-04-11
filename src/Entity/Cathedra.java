package Entity;

public class Cathedra {
    private Long id;
    private String name;
    private String facilty;

    public Cathedra(String name, String facilty) {
        this.name = name;
        this.facilty = facilty;
    }

    public Cathedra(Long id, String name, String facilty) {
        this.id = id;
        this.name = name;
        this.facilty = facilty;
    }

    public Cathedra() {
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

    public String getFacilty() {
        return facilty;
    }

    public void setFacilty(String facilty) {
        this.facilty = facilty;
    }

    @Override
    public String toString() {
        return "Cathedra{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", facilty='" + facilty + '\'' +
                '}';
    }
}
